package com.term_project.game.haunts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.events.Event;
import com.term_project.game.Dice;
import com.term_project.game.actions.Mover;
import com.term_project.house.Tile;
import com.term_project.house.TileBean;
import com.term_project.items.Item;
import com.term_project.omens.Omen;
import com.term_project.system.MemorySlot;

public class HauntOne implements GamePhase {

  private MemorySlot memory;

  private String mode;
  private Integer phase;

  private Mover move;
  Map<String, Integer> remaining;

  private List<String> toResolve;

  public HauntOne(MemorySlot memory) {
    this.memory = memory;
    mode = "start";
    phase = 0;

    move = new Mover(memory);
    remaining = new HashMap<>();
    toResolve = new ArrayList<>();
  }

  @Override
  public void run(String name, Map<String, String> qm, GameChar character,
      Map<String, Object> variables) {
    // if person is starting turn reset available actions
    if (mode.equals("start")) {
      remaining.put("move", character.getSpeed());
      mode = "idle";
      phase = 0;
    }

    // make sure backend matches frontend
    if (!mode.equals("idle")) {
      if (!name.equals(mode)) {
        System.out.println(
            "NAME DOESN'T EQUAL MODE. NAME:" + name + " MODE:" + mode);
        return;
      }
    } else if (toResolve.size() > 0 && !toResolve.contains(name)) {
      System.out.println(
          "STILL NEED TO RESOLVE " + toResolve.toString() + "NOT " + name);
      return;
    }

    // make sure player has enough actions
    if (remaining.containsKey(name) && remaining.get(name) <= 0) {
      variables.put("Error",
          "Cannot perform action as no more are remaining.");
      addActions(character, variables);
      return;
    }

    System.out.println(name);
    System.out.println(character.getName());

    switch (name) {
    case "move":
      if (phase == 0) {
        mode = "move";
        phase = 1;

        // get the direction the player is trying to move in
        String direction = qm.get("direction");

        // try to move in given direction
        // fails if no door exists
        try {
          move.run(direction, character, variables);

          // use up one movement
          remaining.put("move", remaining.get("move") - 1);
        } catch (NullPointerException e) {
          mode = "idle";
          phase = 0;
          variables.put("Error", e.getMessage());
          return;
        }
        System.out.println("phase now " + phase);
        if (move.getFinished()) {
          System.out.println("move finished");
          mode = "idle";
          phase = 0;

          List<Tile> tiles = new ArrayList<Tile>(
              memory.getTileMap().values());
          List<TileBean> tileBeans = new ArrayList<>();
          for (Tile tile : tiles) {
            tileBeans.add(tile.getBean());
          }
          variables.put("tiles", tileBeans);
          variables.put("characters", memory.getCharBeans());
          addActions(character, variables);
          return;
        }

        return;
      }

      if (phase == 1) {
        try {
          System.out.println("why am i here?");
          move.addTile(character, Integer.parseInt(qm.get("rotations")),
              memory.getTileMap());

          // send frontend tile map
          variables.put("tiles", memory.getTileBeans());

          // send frontend character
          variables.put("characters", memory.getCharBeans());

          // send frontend newly added tile
          variables.put("newTile", character.getTile().getBean());

          phase = 0;

          /* This adding method doesn't really make a ton of sense to me. */
          /*
           * classes are supposed to encapsulate an idea, why would the idea of
           * an item take in the variable map
           */
          /*
           * furthermore aren't we adding the item to the character -> character
           * should have an additem method not the other way round.
           */
          List<Event> eventList = new ArrayList<>();
          List<Item> itemList = new ArrayList<>();
          List<Omen> omenList = new ArrayList<>();
          // force character to pick up items/omens/events
          for (int i = 0; i < character.getTile().getItemCount(); i++) {
            Item item = memory.getItems().poll();
            item.add(character);
            itemList.add(item);
          }

          for (int i = 0; i < character.getTile().getEventCount(); i++) {
            // TODO: do event things
            Event event = memory.getEvents().poll();
            toResolve.add("event");
            phase = 1;
            eventList.add(event);

            // ADD EVENTS TO TILE HASHMAP
          }

          for (int i = 0; i < character.getTile().getOmenCount(); i++) {
            Omen omen = memory.getOmens().poll();
            omen.add(character);
            toResolve.add("haunt");
            omenList.add(omen);
          }
          // push to front end
          variables.put("toResolve", toResolve);
          variables.put("item", itemList);
          variables.put("omen", omenList);
          variables.put("event", eventList);
          variables.put("character", character.getCharBean());
          addActions(character, variables);
        } catch (RuntimeException e) {
          variables.put("Error", e.getMessage());
          return;
        }
      }
      break;

    case "event":
      if (phase == 0) {
        String eventName = qm.get("event");
        Event event = character.getTile().getEvent(eventName);
        variables.put("event", event);
        phase = 1;
        return;
      } else if (phase == 1) {
        String eventName = qm.get("event");
        Event event = character.getTile().getEvent(eventName);
        String statToUse = qm.get("stat");

        // make sure valid stat is being used
        if (!event.getUsableAsString().contains(statToUse)) {
          variables.put("Error", "Invalid stat for event.");
          return;
        }

        // get the players relevant stat
        int statVal;
        try {
          statVal = character.getStatByName(statToUse);
        } catch (NullPointerException e) {
          variables.put("Error", e.getMessage());
          return;
        }

        // roll for that stat and add to qm
        List<Integer> rolls = Dice.roll(statVal);
        variables.put("rolls", rolls);

        // apply and return the results of event
        Integer rollSum = Dice.sum(rolls);
        String result = event.apply(rollSum, character);
        variables.put("result", result);

        // send to frontend remaining actions.
        addActions(character, variables);
        mode = "idle";
        phase = 0;

        // we have resolved this event
        toResolve.remove("event");
        return;
      }
      break;

    case "use item":
      String useItemS = qm.get("item");
      Item useItem = character.getItem(useItemS);
      useItem.use(character, variables);
      variables.put("character", character.getCharBean());
      variables.put("item", useItem);
      mode = "idle";
      break;

    case "use omen":
      String useOmenS = qm.get("omen");
      Omen useOmen = character.getOmen(useOmenS);
      useOmen.use(character, variables);
      variables.put("character", character.getCharBean());
      variables.put("omen", useOmen);
      mode = "idle";
      break;

    case "pickup item":
      String pickupItemS = qm.get("item");
      Item pickupItem = character.getItem(pickupItemS);
      pickupItem.add(character);
      variables.put("character", character.getCharBean());
      variables.put("item", pickupItem);
      mode = "idle";
      break;

    case "drop item":
      String dropItemS = qm.get("item");
      Item dropItem = character.getItem(dropItemS);
      dropItem.loss(character);
      variables.put("character", character.getCharBean());
      variables.put("item", dropItem);
      mode = "idle";
      break;

    case "pickup omen":
      String pickupOmenS = qm.get("omen");
      Omen pickupOmen = character.getOmen(pickupOmenS);
      pickupOmen.add(character);
      variables.put("character", character.getCharBean());
      variables.put("omen", pickupOmen);
      mode = "idle";
      break;

    case "drop omen":
      String dropOmenS = qm.get("omen");
      Omen dropOmen = character.getOmen(dropOmenS);
      dropOmen.loss(character);
      variables.put("character", character.getCharBean());
      variables.put("omen", dropOmen);
      mode = "idle";
      break;

    case "end":
      mode = "start";
      memory.getGameState().endTurn();
      break;

    case "attack":
      break;

    case "paint":
      break;

    case "sacrifice":
      break;

    case "":
      break;
    }
  }

  @Override
  public void addActions(GameChar character,
      Map<String, Object> variables) {
    List<String> actions = new ArrayList<>();
    Tile tile = character.getTile();

    if (tile.getEvents().size() > 0) {
      actions.add("event");
    }

    if (tile.getItems().size() > 0) {
      actions.add("pickup item");
    }

    if (tile.getOmens().size() > 0) {
      actions.add("pickup omen");
    }

    if (character.getItems().size() > 0) {
      actions.add("drop item");
      actions.add("use item");
    }

    if (character.getOmens().size() > 0) {
      actions.add("drop omen");
      actions.add("use omen");
    }

    if (remaining.get("move") > 0) {
      actions.add("move");
    }

    variables.put("actions", actions);
  }

  @Override
  public List<String> getExplorersDescription() {
    List<String> stringsExplorer = new ArrayList<>();

    String lore = "The bookshelves of this old mansion are packed with"
        + " sinister tomes. Horrible titles speak of evil, death, madness, "
        + "and the names of Things That Should Not Be. Why did your "
        + "companion bring you to this macabre collection? What forbidden "
        + "knowledge would she hope to gain?\nYour questions are answered "
        + "when rhythmic chanting echoes through the corridors. The cult that "
        + "inhabits this house is shouting to summon an ancient creature-and the "
        + "loudest voice is that of your traitorous companion. The traitor "
        + "is here to complete the ritual by bringing the cultists everything "
        + "they need...including human sacrifices.";
    stringsExplorer.add(lore);
    String rightNow = "Right Now:\nPaint tokens equal to the number "
        + "of players will be randomly distributed through the house.";
    stringsExplorer.add(rightNow);
    String whatYouKnow = "What You Know About the Bad Guys:\nThe traitor "
        + "is working with a fanatic cult. The Cultists are trying to summon "
        + "their god by bringing sacrifices into the Pentagram Chamber. They "
        + "can sacrifice items and a few specific omens-along with the explorers'"
        + " You don't know how many sacrifices are needed, so you must stop the "
        + "Cultists as quickly as possible.";
    stringsExplorer.add(whatYouKnow);
    String youWin = "You Win When...\n...you desecrate the pentagram before the"
        + " god is summoned.";
    stringsExplorer.add(youWin);
    String how = "How to Desecrate the Pentagram:\nYou can desecrate the "
        + "pentagram by finding cans of paint (Paint tokens) and throwing them "
        + "on the floor of the Pentagram Chamber.\nPick up the Paint tokens "
        + "scattered around the house. You can carry only one Paint token at"
        + " a time.\nYou can throw a Paint token into the Pentagram Chamber from an "
        + "adjacent room with a connecting door. Doing this counts as 1 space of movement."
        + "\nYou must throw every Paint token in the house into the Pentagram "
        + "Chamber to desecrate the pentagram.";
    stringsExplorer.add(how);
    String special = "Special Attack Rules:\nIf your explorer is killed, tip that figure "
        + "over in its room to mark his or her corpse. A Cultist or the traitor can then "
        + "pick up your explorer's corpse like an item and carry it. While the traitor "
        + "or a Cultist is carrying your corpse, it uses 2 spaces of movement to enter a room.";
    stringsExplorer.add(special);
    String win = "If You Win...\nThe house shakes, and you hear glass shattering around "
        + "you. The walls sweat as the cultists' dread god draws near.\nJust as your world "
        + "is about to be torn away from you, paint splashes acoress the wooden floor, "
        + "desecrating the pentagram. You stop the horrible ritual. The world is safe, for "
        + "now, but the echoes of the cultists' chant still burn in your mind. Clutching "
        + "at your head, you feel blood dripping steadily from your damaged ears.\nIn time "
        + "your body will heal...but will your soul?";
    stringsExplorer.add(win);

    return stringsExplorer;
  }

  @Override
  public List<String> getTraitorDescription() {
    List<String> stringsTraitor = new ArrayList<>();

    String lore = "Seperating yourself from your friends, or victims as you like "
        + "to think of them, you greet the zealous followers of your cult. Slowly, "
        + "rhythmically, you begin to stamp your feet and chant. The others join in."
        + " Louder and louder your voices grow, praying to all that is evil and unholy "
        + "that your sacrifices will be accepted tonight. The cult is praying that your "
        + "dread god will appear before you...and bathe in the blood of your friends.";
    stringsTraitor.add(lore);
    String rightNow = "Right Now:\nYour explorer is still in the game but has turned traitor.\n"
        + "A number of small purple monster tokens are placed in the Pentagram Chamber equal to the"
        + " number of other players (representing Cultists).";
    stringsTraitor.add(rightNow);
    String youWin = "Your Win When...\n...either all the heros are dea or you summon your god.";
    stringsTraitor.add(youWin);
    String whatYouKnow = "What You Know About the Heroes:\nThe only way they can stop you "
        + "from summoning your god is by desecrating the Pentagram Chamber. To do so, they will use"
        + " the cans of paint (represented by Paint tokens) that are hidden throughout the house.";
    stringsTraitor.add(whatYouKnow);
    String how = "How to Summon the God:\nYou must make sacrifices to summon your god. Build up"
        + " a total of 13 sacrifice points by bringing the following sacrifices into the Pentagram "
        + "Chamber.\nSacrifice, Points\nExplorer's Corpse: 4\nGirl, Madman, or Dog: 2\nAny other "
        + "tradable omen or item: 1\nItem and omen cards that you sacrifice are removed from the game "
        + "and kept in a seperate pile. Keep track of sacrifice points on a piece of paper. You can "
        + "sacrifice the Girl, Madman, or Dog when you have that card and are in the Pentagram Chamber."
        + " You can't steal, carry, or sacrifice Paint tokens.\nCultists can carry items and explorers'"
        + " corpses. Any items they carry do not affect their traits or give them abilities. They cannot "
        + "carry Paint tokens.";
    stringsTraitor.add(how);
    String cultists = "Cultists:\n Speed 4, Might 4, Sanity 4";
    stringsTraitor.add(cultists);
    String attack = "Special Attack Rules:\nA cultist can steal an item from an explorer, "
        + "just like explorers can.\nIf an explorer is killed, tip that figure over "
        + "in its room to mark his or her corpse.\nA Cultist can pick up a corpse and carry it like an item, "
        + "but while it's doing this, it uses 2 spaces of movement to enter a room. You can also carry "
        + "corpses with the same restriction as Cultists. Take an explorer's figure when you're carrying its corpse.";
    stringsTraitor.add(attack);
    String win = "If You Win...\nThe house shakes and glass shatters as the universe screams. A wound rips through "
        + "time and space, and through it, your god is reborn. Drenched in the blood of your friends, your god "
        + "is beautiful and terrrible, a wonder and a blight. The world is laid bare before him, and all within it "
        + "are his children, his blood...his sacrifices.";
    stringsTraitor.add(win);
    return stringsTraitor;
  }

  @Override
  public String getDescription() {
    return "The Stars are Right";
  }
}
