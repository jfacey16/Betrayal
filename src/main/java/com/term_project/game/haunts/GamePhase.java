package com.term_project.game.haunts;

import com.term_project.character.GameChar;
import com.term_project.game.actions.Action;
import java.util.List;
import java.util.Set;

public interface GamePhase {

	/**
	 * Executes an action by the specified character.
	 * @param character The character doing the specified action.
	 * @param action The action to be executed.
	 * @param specs Special specifications for said action.
	 */
	public void action(GameChar character, String action, String specs)
			throws RuntimeException;

	public boolean win();

	public Set<Action> getActions();

	/**
	 * Starts character's turn.
	 * @param character Character turn will start.
	 */
	void startTurn(GameChar character);

	/**
	 * Ends character's turn.
	 * @param character Character whose turn it is now.
	 */
	void endTurn(GameChar character);
}
