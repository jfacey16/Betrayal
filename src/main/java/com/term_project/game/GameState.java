package com.term_project.game;

import com.term_project.system.MemorySlot;
import com.term_project.house.Tile;
import com.term_project.house.Pos;
import com.term_project.game.actions.Action;
import com.term_project.game.haunts.GamePhase;
import com.term_project.game.haunts.PreHaunt;
import com.term_project.cards.Event;
import com.term_project.cards.EventsBuilder;
import com.term_project.cards.Item;
import com.term_project.cards.ItemsBuilder;
import com.term_project.cards.Omen;
import com.term_project.cards.OmensBuilder;
import com.term_project.cards.TileBuilder;
import com.term_project.character.GameChar;

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
						       Map<String, GameChar> playersCharacters,
									 MemorySlot memory){
		//Randomize turn order
		idTurnOrder = new ArrayList<>(ids);
		Collections.shuffle(idTurnOrder);

		this.playersCharacters = playersCharacters;
		currentTurn = 0;

		//initiate memory
		this.memory = memory;
		memory.setGameState(this);

		phase = new PreHaunt(memory);
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
		return;
	}

	public void setPhase(GamePhase newPhase) {
		phase = newPhase;
	}
}
