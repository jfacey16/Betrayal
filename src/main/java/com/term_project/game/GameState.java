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

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;

import spark.QueryParamsMap;

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

	// The current state of the gamestate that is currently being displayed
	// private Display curr;

	public GameState(List<String> ids,
									 MemorySlot memory){
		//Randomize turn order
		idTurnOrder = new ArrayList<>(ids);
		Collections.shuffle(idTurnOrder);

		currentTurn = 0;

		//initiate memory
		this.memory = memory;
		memory.setGameState(this);
		memory.setStringList(ids);
		memory.setTileMap(new HashMap<>());

		phase = new Lobby(memory);
	}

	public Map<String, Object> start() {
		Map<String, Object> variables = new HashMap<>();
		phase.run(null, null, null, variables);
		return variables;
	}

	public Map<String, Object> buildMap(QueryParamsMap qm) {
		Map<String, Object> variables = new HashMap<>();
		phase.run(qm, null, null, variables);
		return variables;
	}

	public Map<String, Object> update(QueryParamsMap qm) {
		Map<String, Object> variables = new HashMap<>();

		String currentId = idTurnOrder.get(currentTurn);
		phase.run(qm.value("name"), qm, playersCharacters.get(currentId), variables);

		if(qm.value("name").equals("end")){
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

	public void setPlayersCharacters(Map<String, GameChar> newCharacters) {
		playersCharacters = newCharacters;
	}
}
