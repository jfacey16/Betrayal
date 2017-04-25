package com.term_project.house;

import java.util.ArrayList;
import java.util.List;

import com.term_project.cards.Event;
import com.term_project.cards.Item;
import com.term_project.cards.Omen;

/**
 *
 * @author jfacey
 *
 */
public class ExampleTile implements Tile {

	private Pos pos;
	private Tile northTile;
	private Tile southTile;
	private Tile westTile;
	private Tile eastTile;
	private List<Item> items;
	private List<Omen> omens;
	private List<Event> events;

	/**
	 *
	 */
	public ExampleTile() {
		pos = new Pos(0,0);
		//TODO: maybe make more example tiles so these aren't all null
		northTile = null;
		southTile = null;
		westTile = null;
		eastTile = null;

		//TODO: add examples that we want to use
		items = new ArrayList<>();
		omens = new ArrayList<>();
		events = new ArrayList<>();
	}

	@Override
	public String getDescription() {
		return "This is an example tile";
	}

	@Override
	public void enter(Character effected) {
		// TODO how to we do this for entering vs leaving room

	}

	@Override
	public void exit(Character effected) {
		// TODO how to we do this for entering vs leaving room

	}

	@Override
	public void apply(Character effected) {
		// TODO how to we do this for entering vs leaving room

	}

	@Override
	public List<Omen> getOmens() {
		return omens;
	}

	@Override
	public List<Item> getItems() {
		return items;
	}

	@Override
	public List<Event> getEvents() {
		return events;
	}

	@Override
	public Pos getPos() {
		return pos;
	}

	@Override
	public Tile getNorth() {
		return northTile;
	}

	@Override
	public Tile getSouth() {
		return southTile;
	}

	@Override
	public Tile getEast() {
		return eastTile;
	}

	@Override
	public Tile getWest() {
		return westTile;
	}

	@Override
	public void setNorth(Tile newTile) {
		northTile = newTile;

	}

	@Override
	public void setSouth(Tile newTile) {
		southTile = newTile;

	}

	@Override
	public void setEast(Tile newTile) {
		eastTile = newTile;

	}

	@Override
	public void setWest(Tile newTile) {
		westTile = newTile;

	}
}
