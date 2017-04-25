package com.term_project.game.actions;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;
import com.term_project.house.Tile;

import java.util.Map;

public class Move implements Action{

	@Override
	public String getName() {
		return "Move";
	}

	@Override
	public String getDescription() {
		String description = "Moves character in specified direction.";
		return description;
	}

	/**
	 * Moves a player.
	 */
	@Override
	public void execute(MemorySlot memory,
											GameChar character,
											String specs,
											Map<String, Integer> remaining)
			throws RuntimeException {
		assert (specs.equals("NORTH")
						|| specs.equals("SOUTH")
						|| specs.equals("EAST")
						|| specs.equals("WEST"));

		int movement = remaining.get(getName());
		Tile currentTile = character.getTile();

		if (movement <= 0) {
			throw new RuntimeException("No more movement available.");
		}

		switch (specs) {
			case "NORTH":
				try {
					Tile newTile = currentTile.getNorth();
					character.setTile(newTile);
					newTile.enter(character);
				} catch(NullPointerException e) {
					throw new RuntimeException("No available tile to the north.");
				}
			break;

			case "SOUTH":
				try {
					Tile newTile = currentTile.getSouth();
					character.setTile(newTile);
					newTile.enter(character);
				} catch(NullPointerException e) {
					throw new RuntimeException("No available tile to the south.");
				}
			break;

			case "EAST":
				try {
					Tile newTile = currentTile.getEast();
					character.setTile(newTile);
					newTile.enter(character);
				} catch(NullPointerException e) {
					throw new RuntimeException("No available tile to the east.");
				}
			break;

			case "WEST":
				try {
					Tile newTile = currentTile.getWest();
					character.setTile(newTile);
					newTile.enter(character);
				} catch(NullPointerException e) {
					throw new RuntimeException("No available tile to the west.");
				}
			break;
		}

		remaining.put(getName(), movement - 1);
	}
}
