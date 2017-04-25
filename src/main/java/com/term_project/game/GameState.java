package com.term_project.game;

import com.term_project.system.MemorySlot;
import com.term_project.house.Tile;
import com.term_project.house.Pos;
import com.term_project.game.actions.Action;
import com.term_project.game.haunts.GamePhase;
import com.term_project.game.haunts.PreHaunt;
import com.term_project.character.GameChar;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class GameState {
	// maps ids to respective character
	private Map<String, GameChar> playersCharacters;

	// ordered list representing turnorder
	private List<String> idTurnOrder;

	// integer representing the index in idTurnOrder of whose turn it is
	private Integer currentTurn;

	private final Integer NUMPLAYERS;
	private GamePhase phase;
	private MemorySlot memory;
	private Set<Action> actions;

	public GameState(List<String> ids,
						       Map<String, GameChar> playersCharacters,
									 Integer numPlayers,
									 MemorySlot memory){
		//Randomize turn order
		idTurnOrder = new ArrayList(ids);
		Collections.shuffle(idTurnOrder);

		this.playersCharacters = playersCharacters;
		NUMPLAYERS = numPlayers;
		currentTurn = 0;
		this.memory = memory;
		phase =  new PreHaunt(memory);
		actions = phase.getActions();
	}

	public boolean isTurn(String id) {
		return idTurnOrder.get(currentTurn).equals(id);
	}

	public void action(GameChar character, String action) {

	}

	public List<String> getActions() {
		// change string to action?
		return null;
	}

	public boolean win() {
		return phase.win();
	}

	public void endTurn() {
		//end current players turn
		GameChar curr = playersCharacters.get(idTurnOrder.get(currentTurn));
		phase.endTurn(curr);

		//increment turn
		currentTurn = (currentTurn + 1) % NUMPLAYERS;

		//start next player's turn
		curr = playersCharacters.get(idTurnOrder.get(currentTurn));
		phase.startTurn(curr);

	}

	public void addTile(Tile tile) {

	}

	public Tile getTile(Pos position) {
		return null;
	}
}
