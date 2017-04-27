package com.term_project.game.haunts;

import com.term_project.character.GameChar;
import com.term_project.game.actions.Action;
import java.util.List;
import java.util.Set;
import spark.QueryParamsMap;

public interface GamePhase {
	/**
	 * Executes an action by the specified character.
	 * @param character The character doing the specified action.
	 * @param action The action to be executed.
	 * @param specs Special specifications for said action.
	 */
	public void run(String name, QueryParamsMap qm);
}
