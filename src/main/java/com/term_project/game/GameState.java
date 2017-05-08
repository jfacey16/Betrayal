package com.term_project.game;

import com.term_project.system.MemorySlot;
import com.term_project.house.Tile;
import com.term_project.items.Item;
import com.term_project.omens.Omen;
import com.term_project.house.Pos;
import com.term_project.game.actions.Action;
import com.term_project.game.haunts.GamePhase;
import com.term_project.game.haunts.PreHaunt;
import com.term_project.game.haunts.Lobby;
import com.term_project.builders.EventsBuilder;
import com.term_project.builders.ItemsBuilder;
import com.term_project.builders.OmensBuilder;
import com.term_project.builders.TileBuilder;
import com.term_project.character.GameChar;
import com.term_project.events.Event;
import com.term_project.builders.CharacterGen;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;

public class GameState {
	// maps ids to respective character
	private Map<String, GameChar> playersCharacters;

	// ordered list representing turnorder
	private List<String> idTurnOrder;

	// integer representing the index in idTurnOrder of whose turn it is
	private Integer currentTurn;

	//data storage for gameState
	private MemorySlot memory;

	private GamePhase phase;

	//character gen
	private List<List<GameChar>> characters;
	private CharacterGen charGen;

	// The current state of the gamestate that is currently being displayed
	// private Display curr;

	public GameState(List<String> ids,
					MemorySlot memory){
		//Randomize turn order
		playersCharacters = new HashMap<>();

		Collections.shuffle(idTurnOrder);

		currentTurn = 0;

		//initiate character
		characters = new ArrayList<>();


		//initiate memory
		this.memory = memory;
		memory.setGameState(this);
		memory.setGameCharacters(new ArrayList<>());
		memory.setStringList(ids);
		memory.setTileMap(new HashMap<>());

		phase = new Lobby(memory);

		charGen = new CharacterGen();
		characters = charGen.build().subList(0, getNumPlayers());
		Collections.shuffle(characters);
	}

	public Map<String, Object> buildMap(Map<String, String> qm) {
		Map<String, Object> variables = new HashMap<>();
		System.out.println("MAP BUILDING");
		phase.run(null, null, null, variables);
		System.out.println(phase.getDescription());
		return variables;
	}

	public synchronized Map<String, Object> update(Map<String, String> qm) {
		Map<String, Object> variables = new HashMap<>();

		String currentId = idTurnOrder.get(currentTurn);
		System.out.println("name: " + qm.get("name"));
		System.out.println(playersCharacters.get(currentId).getTile().getPos().getX());
		System.out.println(playersCharacters.get(currentId).getTile().getPos().getY());
		System.out.println(phase.getDescription());
		// assert(phase instanceof PreHaunt);
		phase.run(qm.get("name"), qm, playersCharacters.get(currentId), variables);

		if(qm.get("name").equals("end")){
			endTurn();
		}
		return variables;
	}

	public void endTurn() {
		currentTurn = (currentTurn + 1) % getNumPlayers();
	}

	public void setPhase(GamePhase newPhase) {
		phase = newPhase;
	}

	public int getNumPlayers() {
		return idTurnOrder.size();
	}

	public int getCurrentTurn() {
		return currentTurn;
	}

	public boolean setPlayersCharacter(String id, String charName) {
		GameChar theCharacter = charGen.getCharactersByName(charName);
		playersCharacters.put(id, theCharacter);
		memory.addGameCharacter(theCharacter);
		if(playersCharacters.keySet().size() == idTurnOrder.size()) {
			return true;
		}
		return false;
	}

	public List<GameChar> getCharacterChoice() {
		return characters.remove(0);
	}

	public List<String> getTurnOrder() {
		return idTurnOrder;
	}
}
