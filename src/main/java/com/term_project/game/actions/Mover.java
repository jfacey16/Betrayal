package com.term_project.game.actions;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;
import com.term_project.house.Tile;
import com.term_project.house.EmptyTile;
import com.term_project.house.Floor;
import com.term_project.house.Pos;

import java.util.Map;

public class Mover {
	Boolean finished;

	public Mover() {
		finished = true;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void run(String direction, GameChar character, MemorySlot memory) throws NullPointerException {
		finished = false;

		assert (direction.equals("NORTH")
						|| direction.equals("SOUTH")
						|| direction.equals("EAST")
						|| direction.equals("WEST"));

		Tile currentTile = character.getTile();

		switch (specs) {
			case "NORTH":
				try {
					Tile newTile = currentTile.getNorth();
					character.setTile(newTile);
					newTile.enter(character);
				} catch(NullPointerException e) {
					throw new NullPointerException("No available tile to the north.");
				}
			break;

			case "SOUTH":
				try {
					Tile newTile = currentTile.getSouth();
					character.setTile(newTile);
					newTile.enter(character);
				} catch(NullPointerException e) {
					throw new NullPointerException("No available tile to the south.");
				}
			break;

			case "EAST":
				try {
					Tile newTile = currentTile.getEast();
					character.setTile(newTile);
					newTile.enter(character);
				} catch(NullPointerException e) {
					throw new NullPointerException("No available tile to the east.");
				}
			break;

			case "WEST":
				try {
					Tile newTile = currentTile.getWest();
					character.setTile(newTile);
					newTile.enter(character);
				} catch(NullPointerException e) {
					throw new NullPointerException("No available tile to the west.");
				}
			break;
		}
	}
}
