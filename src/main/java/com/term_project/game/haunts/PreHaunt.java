package com.term_project.game.haunts;

import com.term_project.game.actions.Action;
import com.term_project.game.actions.Mover;
import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;
import com.term_project.house.Tile;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import spark.QueryParamsMap;

public class PreHaunt implements GamePhase {
	private MemorySlot memory;

	private String mode;
	private Integer phase;

	private Mover move;
	Map<String, Integer> remaining;


	public PreHaunt(MemorySlot memory) {
		this.memory = memory;
		mode = "start";
		phase = 0;
		move = new Mover(memory);

		remaining = new HashMap<>();
	}
	/**
	 * Runs
	 */
	public void run(String name, QueryParamsMap qm, GameChar character, Map<String, Object> variables) {
		//if person is starting turn reset available actions
		if (mode == "start") {
			remaining.put("move", character.getSpeed());
			mode = "idle";
			phase = 0;
		}

		//make sure backend matches frontend
		if(mode != "idle") {
			if(name != mode) {
				System.out.println("NAME DOESN'T EQUAL MODE");
				return;
			}
		}

		//make sure player has enough actions
		if (remaining.get(name) <= 0) {
			variables.put("Error", "Cannot perform action as no more are remaining.");
			return;
		}

		switch (name) {
      case "move":
				if(phase == 0) {
					mode = "move";
					phase = 1;

					//get the direction the player is trying to move in
					String direction = qm.value("direction");

					//try to move in given direction
					//fails if no door exists
					try {
						move.run(direction, character);

						//use up one movement
						remaining.put("move", remaining.get("move") - 1);
					} catch(NullPointerException e) {
						mode = "idle";
						phase = 0;
						variables.put("Error", "No door in given direction.");
						return;
					}

					if(move.getFinished()) {
						mode = "idle";
						phase = 0;
						variables.put("tiles", new ArrayList<Tile>(memory.getTileMap().values()));
						variables.put("characters", memory.getGameCharacters());
						return;
					}
				}

				if (phase == 1) {
					try {
						move.addTile(character,
										 		 Integer.parseInt(qm.value("rotations")),
										 	 	 memory.getTileMap());

						variables.put("tiles", new ArrayList<Tile>(memory.getTileMap().values()));
						variables.put("characters", memory.getGameCharacters());

						mode = "idle";
						phase = 0;
					} catch (RuntimeException e) {
						variables.put("Error", e.getMessage());
						return;
					}
				}
      break;

			case "end":
				mode = "start";
			break;
    }
	}
}
