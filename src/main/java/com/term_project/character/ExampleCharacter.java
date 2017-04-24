package com.term_project.character;

import java.util.ArrayList;
import java.util.List;

import com.term_project.cards.Item;
import com.term_project.cards.Omen;
import com.term_project.house.Pos;
import com.term_project.house.Tile;
/**
 * 
 * @author jfacey
 *
 */
public class ExampleCharacter implements Character {
	
	private int might;
	private int speed;
	private int knowledge;
	private int sanity;
	private List<Integer> mightScale;
	private List<Integer> speedScale;
	private List<Integer> knowledgeScale;
	private List<Integer> sanityScale;
	private Tile currentTile;
	private Pos currentPos;
	private List<Item> items;
	private List<Omen> omens;
	/**
	 * 
	 */
	public ExampleCharacter() {
		might = 2;
		speed = 2;
		knowledge = 4;
		sanity = 2;
		// scales are of size 8. Death when index falls below 0
		mightScale = buildMightScale();
		speedScale = buildSpeedScale();
		knowledgeScale = buildKnowledgeScale();
		sanityScale = buildSanityScale();
		
		currentPos = new Pos(0,0);
		//need an example tile
		currentTile = null;
		items = new ArrayList<>();
		omens = new ArrayList<>();
	}
	
	private List<Integer> buildMightScale() {
		List<Integer> mightList = new ArrayList<>();
		mightList.add(3);
		mightList.add(3);
		mightList.add(3);
		mightList.add(4);
		mightList.add(5);
		mightList.add(6);
		mightList.add(7);
		mightList.add(8);
		return mightList;
	}
	
	private List<Integer> buildSpeedScale() {
		List<Integer> speedList = new ArrayList<>();
		speedList.add(3);
		speedList.add(3);
		speedList.add(4);
		speedList.add(5);
		speedList.add(6);
		speedList.add(6);
		speedList.add(7);
		speedList.add(8);
		return speedList;
	}
	
	private List<Integer> buildKnowledgeScale() {
		List<Integer> knowledgeList = new ArrayList<>();
		knowledgeList.add(2);
		knowledgeList.add(3);
		knowledgeList.add(3);
		knowledgeList.add(4);
		knowledgeList.add(5);
		knowledgeList.add(6);
		knowledgeList.add(7);
		knowledgeList.add(8);
		return knowledgeList;
	}
	
	private List<Integer> buildSanityScale() {
		List<Integer> sanityList = new ArrayList<>();
		sanityList.add(3);
		sanityList.add(3);
		sanityList.add(3);
		sanityList.add(4);
		sanityList.add(5);
		sanityList.add(6);
		sanityList.add(6);
		sanityList.add(6);
		return sanityList;
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
		return currentPos;
	}

	@Override
	public Tile getTile() {
		return currentTile;
	}

	@Override
	public int getMight() {
		return mightScale.get(might);
	}

	@Override
	public int getSpeed() {
		return speedScale.get(speed);
	}

	@Override
	public int getKnowlege() {
		return knowledgeScale.get(knowledge);
	}

	@Override
	public int getSanity() {
		return sanityScale.get(sanity);
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
		might = might + mightModifier;
		// cap of might
		if (might > 7) {
			might = 7;
		}
		if (might < 0) {
			might = 0;
		}
		return mightScale.get(might);
	}

	@Override
	public int modSpeed(int speedModifier) {
		speed = speed + speedModifier;
		// cap of speed
		if (speed > 7) {
			speed = 7;
		}
		if (speed < 0) {
			speed = 0;
		}
		return speedScale.get(speed);
	}

	@Override
	public int modKnowlege(int knowledgeModifier) {
		knowledge = knowledge + knowledgeModifier;
		// cap of knowledge
		if (knowledge > 7) {
			knowledge = 7;
		}
		if (knowledge < 0) {
			knowledge = 0;
		}
		return knowledgeScale.get(knowledge);
	}

	@Override
	public int modSanity(int sanityModifier) {
		sanity = sanity + sanityModifier;
		// cap of sanity
		if (sanity > 7) {
			sanity = 7;
		}
		if (sanity < 0) {
			sanity = 0;
		}
		return sanityScale.get(sanity);
	}

	@Override
	public void addItem(Item item) {
		items.add(item);
	}

	@Override
	public void addOmen(Omen omen) {
		omens.add(omen);
	}

	@Override
	public void dropItem(Item item) {
		items.remove(item);
	}

	@Override
	public void dropOmen(Omen omen) {
		omens.remove(omen);
	}
}
