package com.term_project.game;

import java.util.List;

import com.term_project.house.Tile;

public class GameState {

	public boolean isTurn(String id) {
		return true;
	}
	
	public void action(Character character, String action) {
		
	}
	
	public List<String> getActions() {
		// change string to action?
		return null;
	}
	
	public boolean win() {
		return false;
	}
	
	public void endTurn() {
		
	}
	
	public void addTile() {
		
	}
	
	public Tile getTile() {
		return null;
	}
}
