package com.term_project.game.actions;

import com.term_project.character.Character;
import com.term_project.system.MemorySlot;
import com.term_project.house.Tile;

public interface Action {
	/**
	 * Moves a player.
	 */
	public void execute(MemorySlot memory, Character character, String specs)
			throws RuntimeException {
		assert (specs.equals("NORTH")
						|| specs.equals("SOUTH")
						|| specs.equals("EAST")
						|| specs.equals("WEST"));

		int movement = character.getMovement();
		Tile current = character.getTile();

		if (movement <= 0) {
			throw new RuntimeException("No more movement available.");
		}

		switch (specs) {
			case "NORTH":
				try {
					Tile newTile = tile.getNorth();
					character.setTile(newTile);
					newTile.enter(character);
				} catch(NullPointerException e) {
					throw new RuntimeException("No available tile to the north.");
				}
			break;

			case "SOUTH":
				try {
					Tile newTile = tile.getSouth();
					character.setTile(newTile);
					newTile.enter(character);
				} catch(NullPointerException e) {
					throw new RuntimeException("No available tile to the south.");
				}
			break;

			case "EAST":
				try {
					Tile newTile = tile.getEast();
					character.setTile(newTile);
					newTile.enter(character);
				} catch(NullPointerException e) {
					throw new RuntimeException("No available tile to the east.");
				}
			break;

			case "WEST":
				try {
					Tile newTile = tile.getWest();
					character.setTile(newTile);
					newTile.enter(character);
				} catch(NullPointerException e) {
					throw new RuntimeException("No available tile to the west.");
				}
			break;
		}

		character.setMovement(movement - 1);
	}
}
