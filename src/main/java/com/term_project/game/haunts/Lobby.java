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

import spark.QueryParamsMap;

public class Lobby implements GamePhase {
  private MemorySlot memory;

  private int phase;

  public PreHaunt(MemorySlot memory) {
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
      Map<String, GameChar> playersCharacters = new HashMap<>();
      List<String> ids = memory.getStringList();

      for (int i = 0; i < ids.size(); i++) {
        String id = ids.get(i);
        playersCharacters.put(id, CharacterGen.getCharactersByName(qm.value(id)));
      }
      //set turn order
      memory.getGameState().setPlayersCharacters(playersCharacters);

      //set starting tiles:
      /*do we have the starting tiles made yet*/

      //switch game phase
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
