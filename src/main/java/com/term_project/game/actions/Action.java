package com.term_project.game.actions;

import com.term_project.character.Character;
import com.term_project.system.MemorySlot;

public interface Action {
	/**
	 * Executes this action's effects.
	 */
	public void execute(MemorySlot gameMemory, Character character, String specs);
}
