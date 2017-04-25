package com.term_project.game;

public interface GamePhase {

	public void action(Character character, String action);

	public boolean win();
}
