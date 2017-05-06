package com.term_project.game.haunts;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.character.CharBean;
import com.term_project.builders.CharacterGen;
import com.term_project.events.Event;
import com.term_project.game.actions.Mover;
import com.term_project.house.Tile;
import com.term_project.house.TileBean;
import com.term_project.omens.Omen;
import com.term_project.system.MemorySlot;
import com.term_project.game.Dice;
import com.term_project.house.Floor;
import com.term_project.house.Direction;
import com.term_project.house.Pos;
import com.term_project.house.GenericTile;

import spark.QueryParamsMap;
import com.google.gson.Gson;

public class Lobby implements GamePhase {
  private MemorySlot memory;

  private int phase;
  private CharacterGen charGen;
  private Gson GSON = new Gson();

  public Lobby(MemorySlot memory) {
    this.memory = memory;
    phase = 0;
    charGen = new CharacterGen();
  }

  @Override
  public void addActions(GameChar character, Map<String, Object> variables) {
    return;
  }

  @Override
  public void run(String name, QueryParamsMap qm, GameChar character,
      Map<String, Object> variables) {
    int numPlayers = memory.getGameState().getNumPlayers();

    // in this phase we send frontend character choices
    if(phase == 0) {
      /*we want a character generator that generates a list of pairs of characters. */
      List<List<GameChar>> characters = charGen.build().subList(0, numPlayers);
      variables.put("characterChoices", characters);
      phase = 1;
      return;
    }

    //in this phase we modify backend to match frontend choices of characters
    if(phase == 1) {
      //set starting tiles
      //tile where players start
      List<Direction> frontDoorConnected = new ArrayList<>();
      List<Floor> frontDoorAvailable = new ArrayList<>();
      frontDoorAvailable.add(Floor.GROUND);
      Tile frontDoor = new GenericTile(frontDoorConnected,
                                       0, 0, 0,
                                       frontDoorAvailable,
                                       memory);
      frontDoor.setPos(new Pos(0, 0, Floor.GROUND));
      frontDoor.setName("Entrance Hall");

      //between door and stairs
      List<Direction> midConnected = new ArrayList<>();
      List<Floor> midAvailable = new ArrayList<>();
      midAvailable.add(Floor.GROUND);
      Tile mid = new GenericTile(midConnected, 0, 0, 0, midAvailable, memory);
      mid.setPos(new Pos(1, 0, Floor.GROUND));
      mid.setName("Foyer");

      //stairs
      List<Direction> stairsConnected = new ArrayList<>();
      List<Floor> stairsAvailable = new ArrayList<>();
      stairsAvailable.add(Floor.GROUND);
      Tile stairs = new GenericTile(stairsConnected, 0, 0, 0, stairsAvailable, memory);
      stairs.setPos(new Pos(2, 0, Floor.GROUND));
      stairs.setName("Grand Staircase");

      //upper landing
      List<Direction>  upperConnected = new ArrayList<>();
      List<Floor> upperAvailable = new ArrayList<>();
      upperAvailable.add(Floor.ATTIC);
      Tile upper = new GenericTile(upperConnected, 0, 0, 0, upperAvailable, memory);
      upper.setPos(new Pos(0, 0, Floor.ATTIC));
      upper.setName("Upper Landing");

      //basement
      List<Direction> basementConnected = new ArrayList<>();
      List<Floor> basementAvailable = new ArrayList<>();
      basementAvailable.add(Floor.BASEMENT);
      Tile basement = new GenericTile(basementConnected, 0, 0, 0, basementAvailable, memory);
      basement.setPos(new Pos(0, 0, Floor.BASEMENT));
      basement.setName("Basement Landing");

      //connect front door
      frontDoorConnected.add(Direction.NORTH);
      frontDoorConnected.add(Direction.SOUTH);
      frontDoorConnected.add(Direction.EAST);

      //connect mid door
      midConnected.add(Direction.NORTH);
      midConnected.add(Direction.SOUTH);
      midConnected.add(Direction.EAST);
      midConnected.add(Direction.WEST);

      //connect stairs
      stairsConnected.add(Direction.WEST);
      stairsConnected.add(Direction.UP);

      //connect upper
      upperConnected.add(Direction.NORTH);
      upperConnected.add(Direction.SOUTH);
      upperConnected.add(Direction.EAST);
      upperConnected.add(Direction.WEST);
      upperConnected.add(Direction.DOWN);

      //connect basement
      basementConnected.add(Direction.NORTH);
      basementConnected.add(Direction.SOUTH);
      basementConnected.add(Direction.EAST);
      basementConnected.add(Direction.WEST);


      //add tiles to tileMap
      Map<Pos, Tile> tileMap = memory.getTileMap();
      tileMap.put(frontDoor.getPos(), frontDoor);
      tileMap.put(mid.getPos(), mid);
      tileMap.put(stairs.getPos(), stairs);
      tileMap.put(upper.getPos(), upper);
      tileMap.put(basement.getPos(), basement);


      //set list of playersCharacters
      Map<String, GameChar> playersCharacters = new HashMap<>();
      //gets list of id from memory
      List<String> ids = memory.getStringList();

      //loops through and sets characters
      for (int i = 0; i < ids.size(); i++) {
        String id = ids.get(i);
        GameChar namedCharacter = charGen.getCharactersByName(qm.value(id));
        playersCharacters.put(id, namedCharacter);
        namedCharacter.setTile(frontDoor);
      }
      //set playersCharacters
      memory.getGameState().setPlayersCharacters(playersCharacters);
      memory.setGameCharacters(new ArrayList<>(playersCharacters.values()));


      //send frontend tiles and characters
      List<TileBean> guiAble = new ArrayList<>();
      List<Tile> theTiles =  new ArrayList<Tile>(memory.getTileMap().values());
      for(Tile tile : theTiles) {
        guiAble.add(tile.getBean());
      }

      List<CharBean> charBeans = new ArrayList<>();
      List<GameChar> memChar = memory.getGameCharacters();
      for(int i = 0; i < memChar.size(); i++) {
        charBeans.add(memChar.get(i).getCharBean());
      }
      variables.put("tiles", guiAble);
      variables.put("characters", charBeans);

      //switch game phases
      System.out.println("phase being set");
      memory.getGameState().setPhase(new PreHaunt(memory));
    }
  }

  @Override
  public String getDescription() {
    return "Choose your character.";
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
