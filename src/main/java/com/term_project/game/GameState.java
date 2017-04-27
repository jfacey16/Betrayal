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
import java.util.Queue;

public class GameState {
	// maps ids to respective character
	private Map<String, GameChar> playersCharacters;

	// ordered list representing turnorder
	private List<String> idTurnOrder;

	// integer representing the index in idTurnOrder of whose turn it is
	private Integer currentTurn;

	private GamePhase phase;
	private MemorySlot memory;

	//decks of these items
	private Set<Action> actions;
	private Queue<Item> items;
	private Queue<Omen> omens;
	private Queue<Event> events;
	private Queue<Tile> tiles;

	//tiles placed on the map
	private Map<Pos, Tile> tileMap;

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
		this.memory = memory;
		phase =  new PreHaunt(memory);
		actions = phase.getActions();

		//initiate decks
		items =  new ItemsBuilder().buildDeck();
		omens = new OmensBuilder().buildDeck();
		events = new EventsBuilder().buildDeck();
		tiles = new TileBuilder().buildDeck();
	}

	public boolean isTurn(String id) {
		return idTurnOrder.get(currentTurn).equals(id);
	}

	public void action(GameChar character, String action, String specs) {

	}

	public List<String> getActions() {
		// change string to action?
		return null;
	}

	public boolean win() {
		return phase.win();
	}

	public boolean endTurn() {
		//end current players turn
		GameChar curr = playersCharacters.get(idTurnOrder.get(currentTurn));
		phase.endTurn(curr);

		//increment turn
		currentTurn = (currentTurn + 1) % idTurnOrder.size();

		//start next player's turn
		curr = playersCharacters.get(idTurnOrder.get(currentTurn));
		phase.startTurn(curr);

    return win();
	}
	// what do we want to do here.
	// adding requires first player getting tile, then adding it where it is viable
	public void addTile() {
		// add new tile from deck if viable,
		if (!tiles.isEmpty()) {
			Tile tile = tiles.remove();
		}
	}

	public Tile getTile(Pos position) {
		return null;
	}
}
