package com.term_project.game.haunts;

import com.term_project.game.actions.Action;
import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;

public class PreHaunt implements GamePhase {
	private MemorySlot gameMemory;
	private Map<String, Action> actions;
	private Map<String, Integer> remaining;
	public PreHaunt(MemorySlot gameMemory) {
		this.gameMemory = gameMemory;
	}

	@Override
	public void action(GameChar character, String action, String specs)
			throws RuntimeException {

		Action toExecute = actions.get(action);
		toExecute.execute(gameMemory, character, specs, remaining);
	}

	@Override
	public boolean win() {
		return false;
	}

	@Override
	public List<Action> getActions() {
		return new ArrayList<>();
	}
}
