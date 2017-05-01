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
import com.term_project.omens.Omen;
import com.term_project.system.MemorySlot;

import spark.QueryParamsMap;

public class PreHaunt implements GamePhase {
  private MemorySlot memory;

  private String mode;
  private Integer phase;

  private Integer omenCount;

  private Mover move;
  Map<String, Integer> remaining;

  private List<String> toResolve;

  public PreHaunt(MemorySlot memory) {
    this.memory = memory;
    mode = "start";
    phase = 0;

    omenCount = 0;

    move = new Mover(memory);
    remaining = new HashMap<>();
    toResolve = new ArrayList<>();
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
  public void run(String name, QueryParamsMap qm, GameChar character,
      Map<String, Object> variables) {
    // if person is starting turn reset available actions
    if (mode == "start") {
      remaining.put("move", character.getSpeed());
      mode = "idle";
      phase = 0;
    }

    // make sure backend matches frontend
    if (mode != "idle") {
      if (name != mode) {
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

    switch (name) {
    case "move":
      if (phase == 0) {
        mode = "move";
        phase = 1;

        // get the direction the player is trying to move in
        String direction = qm.value("direction");

        // try to move in given direction
        // fails if no door exists
        try {
          move.run(direction, character, variables);

          // use up one movement
          remaining.put("move", remaining.get("move") - 1);
        } catch (NullPointerException e) {
          mode = "idle";
          phase = 0;
          variables.put("Error", "No door in given direction.");
          return;
        }

        if (move.getFinished()) {
          mode = "idle";
          phase = 0;

          List<Tile> tiles = new ArrayList<Tile>(
              memory.getTileMap().values());
          List<TileBean> tileBeans = new ArrayList<>();
          for (Tile tile : tiles) {
            tileBeans.add(tile.getBean());
          }
          variables.put("tiles", tileBeans);
          variables.put("characters", memory.getGameCharacters());
          addActions(character, variables);
          return;
        }

        return;
      }

      if (phase == 1) {
        try {
          move.addTile(character, Integer.parseInt(qm.value("rotations")),
              memory.getTileMap());

          // send frontend tile map
          variables.put("tiles",
              new ArrayList<Tile>(memory.getTileMap().values()));

          // send frontend character
          variables.put("characters", memory.getGameCharacters());

          // send frontend newly added tile
          variables.put("newTile", character.getTile());

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
          variables.put("character", character);
          addActions(character, variables);
        } catch (RuntimeException e) {
          variables.put("Error", e.getMessage());
          return;
        }
      }
      break;

    case "event":
      if (phase == 0) {
        String eventName = qm.value("event");
        Event event = character.getTile().getEvent(eventName);
        variables.put("event", event);
        phase = 1;
        return;
      } else if (phase == 1) {
        String eventName = qm.value("event");
        Event event = character.getTile().getEvent(eventName);
        String statToUse = qm.value("stat");

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

        // roll for that stat and add to QueryParamsMap
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

    case "haunt":
      omenCount += 1;
      List<Integer> rolls = Dice.roll(6);
      variables.put("rolls", rolls);

      // apply and return the results of event
      Integer rollSum = Dice.sum(rolls);

      if (rollSum > omenCount) {
        // generate a random haunt
        /*
         * Gamphase haunt = ? memory.getGameState().setPhase(haunt);
         * variables.put("description", haunt.getDescription());
         * variables.put("traitor", haunt.getTraitorDescription());
         * variables.put("explorers", haunt.getExplorersDescription());
         */
      }
      toResolve.remove("haunt");

      mode = "idle";
      phase = 0;
      break;

    case "use item":
      String useItemS = qm.value("item");
      Item useItem = character.getItem(useItemS);
      useItem.use(character, variables);
      variables.put("character", character);
      variables.put("item", useItem);
      break;

    case "use omen":
      String useOmenS = qm.value("omen");
      Omen useOmen = character.getOmen(useOmenS);
      useOmen.use(character, variables);
      variables.put("character", character);
      variables.put("omen", useOmen);
      break;

    case "pickup item":
      String pickupItemS = qm.value("item");
      Item pickupItem = character.getItem(pickupItemS);
      pickupItem.add(character);
      variables.put("character", character);
      variables.put("item", pickupItem);
      break;

    case "drop item":
      String dropItemS = qm.value("item");
      Item dropItem = character.getItem(dropItemS);
      dropItem.loss(character);
      variables.put("character", character);
      variables.put("item", dropItem);
      break;

    case "pickup omen":
      String pickupOmenS = qm.value("omen");
      Omen pickupOmen = character.getOmen(pickupOmenS);
      pickupOmen.add(character);
      variables.put("character", character);
      variables.put("omen", pickupOmen);
      break;

    case "drop omen":
      String dropOmenS = qm.value("omen");
      Omen dropOmen = character.getOmen(dropOmenS);
      dropOmen.loss(character);
      variables.put("character", character);
      variables.put("omen", dropOmen);
      break;

    case "end":
      mode = "start";
      memory.getGameState().endTurn();
      break;
    }
  }

  @Override
  public String getDescription() {
    return "Explore the house, search for items, and find omens!";
  }

  @Override
  public String getTraitorDescription() {
    return "Nothing in this phase.";
  }

  @Override
  public String getExplorersDescription() {
    return "Nothing in this phase.";
  }
}
