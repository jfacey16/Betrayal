package com.term_project.character;

import java.util.ArrayList;
import java.util.List;

import com.term_project.cards.Item;
import com.term_project.cards.Omen;
import com.term_project.house.Pos;
import com.term_project.house.Tile;

public class ExampleCharacter implements Character {
	
	private int might;
	private int speed;
	private int knowledge;
	private int sanity;
	private Tile currentTile;
	private Pos currentPos;
	private List<Item> items;
	private List<Omen> omens;
	
	public ExampleCharacter() {
		might = 4;
		speed = 5;
		knowledge = 3;
		sanity = 6;
		currentPos = new Pos(0,0);
		//need an example tile
		currentTile = null;
		items = new ArrayList<>();
		omens = new ArrayList<>();
	}

	@Override
	public String getName() {
		return "character 1";
	}

	@Override
	public String getDescription() {
		return "This is an example character";
	}

	@Override
	public Pos getPos() {
		// TODO Auto-generated method stub
		return currentPos;
	}

	@Override
	public Tile getTile() {
		// TODO Auto-generated method stub
		return currentTile;
	}

	@Override
	public int getMight() {
		// TODO Auto-generated method stub
		return might;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	@Override
	public int getKnowlege() {
		// TODO Auto-generated method stub
		return knowledge;
	}

	@Override
	public int getSanity() {
		// TODO Auto-generated method stub
		return sanity;
	}
	
	@Override
	public void setPos(Pos newPos) {
		currentPos = newPos;
	}
	
	@Override
	public void setTile(Tile newTile) {
		currentTile = newTile;
	}

	@Override
	public int modMight(int mightModifier) {
		// TODO use modifier
		return might;
	}

	@Override
	public int modSpeed(int speedModifier) {
		// TODO use modifier
		return speed;
	}

	@Override
	public int modKnowlege(int knowledgeModifier) {
		// TODO use modifier
		return knowledge;
	}

	@Override
	public int modSanity(int sanityModifier) {
		// TODO use modifier
		return sanity;
	}

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		items.add(item);
	}

	@Override
	public void addOmen(Omen omen) {
		// TODO Auto-generated method stub
		omens.add(omen);
	}
}
