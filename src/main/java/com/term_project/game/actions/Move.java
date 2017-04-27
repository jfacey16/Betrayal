package com.term_project.game.actions;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;
import com.term_project.house.Tile;
import com.term_project.house.EmptyTile;
import com.term_project.house.Floor;
import com.term_project.house.Pos;

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


	private void addTile(MemorySlot memory, Tile currentTile, String specs) {
		//takes the first tile off the poll.
		Tile toAdd = memory.getTiles().poll();
		Pos curPos = currentTile.getPos();
		Floor currentFloor = curPos.getFloor();
		Pos newPos;
		while(true) {
			//if we can place toAdd on the current floor break loop
			if(toAdd.getAvailableFloors().contains(currentFloor)) {
				break;
			} else {
				memory.getTiles().add(toAdd);
				toAdd = memory.getTiles().poll();
			}
		}
		switch (specs) {

			case "NORTH":
				assert (currentTile.getNorth() instanceof EmptyTile);
				newPos = new Pos(curPos.getX(),
														 curPos.getY() + 1,
														 currentFloor);
        toAdd.setPos(newPos);
			break;

			case "SOUTH":
				assert (currentTile.getSouth() instanceof EmptyTile);
				newPos = new Pos(curPos.getX(),
														 curPos.getY() + 1,
														 currentFloor);
				toAdd.setPos(newPos);
			break;

			case "EAST":
				assert (currentTile.getSouth() instanceof EmptyTile);
				newPos = new Pos(curPos.getX(),
														 curPos.getY() + 1,
														 currentFloor);
				toAdd.setPos(newPos);
			break;

			case "WEST":
				assert (currentTile.getEast() instanceof EmptyTile);
				newPos = new Pos(curPos.getX(),
														 curPos.getY() + 1,
														 currentFloor);
				toAdd.setPos(newPos);
			break;
		}
	}

	private void addTileHelper(Tile toAdd) {
		return;
	}
}
