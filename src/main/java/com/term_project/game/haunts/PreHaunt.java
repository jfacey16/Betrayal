package com.term_project.game.haunts;

import com.term_project.game.actions.Action;
import com.term_project.character.Character;
import com.term_project.system.MemorySlot;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;

public class PreHaunt implements GamePhase {
	private MemorySlot gameMemory;
	private Map<String, Action> actions;
	public PreHaunt(MemorySlot gameMemory) {
		this.gameMemory = gameMemory;
	}

	@Override
	public void action(Character character, String action, String specs)
			throws RuntimeException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean win() {
		// TODO Auto-generated method stub
		return false;
	}

}
