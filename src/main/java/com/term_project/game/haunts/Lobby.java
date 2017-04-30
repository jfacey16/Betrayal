package com.term_project.game.haunts;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.game.actions.Mover;
import com.term_project.house.Tile;
import com.term_project.system.MemorySlot;
import com.term_project.cards.Event;
import com.term_project.game.Dice;
import com.term_project.cards.Omen;
import com.term_project.house.Floor;
import com.term_project.house.Direction;
import com.term_project.house.EmptyTile;
import com.term_project.house.Pos;
import com.term_project.house.GenericTile;

import spark.QueryParamsMap;

public class Lobby implements GamePhase {
  private MemorySlot memory;

  private int phase;

  public Lobby(MemorySlot memory) {
    this.memory = memory;
    phase = 0;
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
      /*
      List<List<GameChar>> characters = CharacterGen.genList(numplayers);
      variables.out("characterChoices", characters);
      */
      return;
    }

    //in this phase we modify backend to match frontend choices of characters
    if(phase == 1) {
      //set starting tiles
      //tile where players start
      Map<Direction, Tile> frontDoorConnected = new HashMap<>();
      List<Floor> frontDoorAvailable = new ArrayList<>();
      frontDoorAvailable.add(Floor.GROUND);
      Tile frontDoor = new GenericTile(frontDoorConnected,
                                       0, 0, 0,
                                       frontDoorAvailable);
      frontDoor.setPos(new Pos(0, 0, Floor.GROUND));

     //between door and stairs
     Map<Direction, Tile> midConnected = new HashMap<>();
     List<Floor> midAvailable = new ArrayList<>();
     midAvailable.add(Floor.GROUND);
     Tile mid = new GenericTile(midConnected, 0, 0, 0, midAvailable);
     mid.setPos(new Pos(-1, 0, Floor.GROUND));

     //stairs
     Map<Direction, Tile> stairsConnected = new HashMap<>();
     List<Floor> stairsAvailable = new ArrayList<>();
     stairsAvailable.add(Floor.GROUND);
     Tile stairs = new GenericTile(stairsConnected, 0, 0, 0, stairsAvailable);
     stairs.setPos(new Pos(-2, 0, Floor.GROUND));

     //upper landing
     Map<Direction, Tile> upperConnected = new HashMap<>();
     List<Floor> upperAvailable = new ArrayList<>();
     upperAvailable.add(Floor.ATTIC);
     Tile upper = new GenericTile(upperConnected, 0, 0, 0, upperAvailable);
     upper.setPos(new Pos(-2, 0, Floor.ATTIC));

     //basement
     Map<Direction, Tile> basementConnected = new HashMap<>();
     List<Floor> basementAvailable = new ArrayList<>();
     basementAvailable.add(Floor.BASEMENT);
     Tile basement = new GenericTile(basementConnected, 0, 0, 0, basementAvailable);
     basement.setPos(new Pos(0, 0, Floor.BASEMENT));

     //connect front door
     frontDoorConnected.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
     frontDoorConnected.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
     frontDoorConnected.put(Direction.WEST, mid);

     //connect mid door
     midConnected.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
     midConnected.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
     midConnected.put(Direction.EAST, frontDoor);

     //connect stairs
     stairsConnected.put(Direction.EAST, mid);
     stairsConnected.put(Direction.UP, upper);

     //connect upper
     upperConnected.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
     upperConnected.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
     upperConnected.put(Direction.EAST, new EmptyTile(new HashMap<>()));
     upperConnected.put(Direction.WEST, new EmptyTile(new HashMap<>()));
     upperConnected.put(Direction.DOWN, stairs);

     //connect basment
     basementConnected.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
     basementConnected.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
     basementConnected.put(Direction.EAST, new EmptyTile(new HashMap<>()));
     basementConnected.put(Direction.WEST, new EmptyTile(new HashMap<>()));


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
       // GameChar character = CharacterGen.getCharactersByName(qm.value(id));
       //playersCharacters.put(id, character);
       //character.setTile(frontDoor);
     }
     //set turn order
     memory.getGameState().setPlayersCharacters(playersCharacters);

      //switch game phases
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
