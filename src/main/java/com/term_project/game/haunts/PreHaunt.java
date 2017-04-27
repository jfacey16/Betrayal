package com.term_project.game.haunts;

import com.term_project.game.actions.Action;
import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import spark.QueryParamsMap;

public class PreHaunt implements GamePhase {
	private MemorySlot gameMemory;

	private String mode;
	private Integer phase;

	private Mover move;


	public PreHaunt(MemorySlot gameMemory) {
		this.gameMemory = gameMemory;
		mode = "idle";
		phase = 0;
		move = new Mover();
	}
	/**
	 * Runs
	 */
	public run(String name, QueryParamsMap qm, GameChar character) {
		if(mode != "idle") {
			name == mode;
		}
		switch (name) {
      case "move":
				if(phase == 0) {
					mode = "move";
					phase = 1;

					String direction = qm.value("direction");
					move.run(direction, character, memory);

					if(move.getFinished()) {
						mode = "idle";
						phase = 0;	
					}
				}
      break;
    }
}
