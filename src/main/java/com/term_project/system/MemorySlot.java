package com.term_project.system;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

import com.term_project.cards.Event;
import com.term_project.cards.Item;
import com.term_project.cards.Omen;
import com.term_project.house.Tile;
import com.term_project.house.Pos;

/**
 * This is a class that will be used to hold a peice of information.
 * It is used to store different types of information in the Environment's
 * hashmap.
 *
 * @author ZacharyHoffman
 */
public final class MemorySlot {
  private Map<String, Boolean> bools;
  private Map<String, Integer> ints;
  private List<String> stringList;
  private DB database;
  private Queue<Item> items;
	private Queue<Omen> omens;
	private Queue<Event> events;
	private Queue<Tile> tiles;
  private Map<Pos, Tile> tileMap;

  /**
   * Initializes a MemorySlot.
   */
  public MemorySlot() {
    bools = new HashMap<String, Boolean>();
    ints = new HashMap<String, Integer>();
    stringList = new ArrayList<>();
  }

  /**
   * Stores a boolean associated with the given key.
   * @param key The key to associate the bool with.
   * @param newBool The boolean to store.
   * @return The MemorySlot that was just modified.
   */
  public MemorySlot setBool(String key, Boolean newBool) {
    bools.put(key, newBool);
    return this;
  }

  /**
   * Stores a integer associated with the given key.
   * @param key The key to associate the integer with.
   * @param newInt The integer to store.
   * @return The MemorySlot that was just modified.
   */
  public MemorySlot setInt(String key, Integer newInt) {
    ints.put(key, newInt);
    return this;
  }

  /**
   * Stores a list of strings.
   * @param list The list to store.
   * @return The MemorySlot that was just modified.
   */
  public MemorySlot setStringList(List<String> list) {
    stringList = list;
    return this;
  }

  /**
   * Stores a database DB.
   * @param db The database to store.
   * @return The MemorySlot that was just modified.
   */
  public MemorySlot setDatabase(DB db) {
    database = db;
    return this;
  }

  /**
   * Stores the items deck
   * @param itemsQueue The items deck.
   * @return The MemorySlot that was just modified.
   */
  public MemorySlot setItems(Queue<Item> itemsQueue) {
    items = itemsQueue;
    return this;
  }

  /**
   * Stores the omens deck
   * @param omensQueue The omens deck.
   * @return The MemorySlot that was just modified.
   */
  public MemorySlot setOmens(Queue<Omen> omensQueue) {
    omens = omensQueue;
    return this;
  }

  /**
   * Stores the events deck
   * @param eventsQueue The events deck.
   * @return The MemorySlot that was just modified.
   */
  public MemorySlot setEvents(Queue<Event> eventsQueue) {
    events = eventsQueue;
    return this;
  }

  /**
   * Stores the tiles deck
   * @param tilesQueue The tiles deck.
   * @return The MemorySlot that was just modified.
   */
  public MemorySlot setTiles(Queue<Tile> tilesQueue) {
    tiles = tilesQueue;
    return this;
  }

  /**
   * Stores the current game map of tiles.
   * @param houseMap The current tiles making up the house.
   * @return The MemorySlot that was just modified.
   */
  public MemorySlot setTileMap(Map<Pos, Tile> houseMap) {
    tileMap = houseMap;
    return this;
  }

  /** Gets the list of strings this object stores.
   * @return The list of strings this object stores.
   */
  public List<String> getStringList() {
    return stringList;
  }

  /** Gets the boolean associated with the given key.
   * @param key The key associated with the boolean.
   * @return The boolean this object stores or null if not found.
   */
  public boolean getBool(String key) {
    return bools.get(key);
  }

  /** Gets the integer associated with the given key.
   * @param key The key associated with the int.
   * @return The boolean this object stores or null if not found.
   */
  public int getInt(String key) {
    return ints.get(key);
  }

  /** Gets the database this object stores.
   * @return The database this object stores.
   */
  public DB getDatabase() {
    return database;
  }

  /**
   * Gets the items deck being stored in memory.
   * @return The items deck being stored in memory.
   */
  public Queue<Item> getItems() {
    return items;
  }

  /**
   * Gets the omen deck being stored in memory.
   * @return The omen deck being stored in memory.
   */
  public Queue<Omen> getOmens() {
    return omens;
  }

  /**
    * Gets the event deck being stored in memory.
    * @return The event deck being stored in memory.
   */
  public Queue<Event> getEvents() {
    return events;
  }

  /**
   * Gets the tile deck being stored in memory.
   * @return The tile deck being stored in memory.
   */
  public Queue<Tile> getTiles() {
    return tiles;
  }

  /**
   * Gets the tileMap being stored in memory.
   * @return The tileMap being stored in memory.
   */
  public Map<Pos, Tile> getTileMap() {
    return tileMap;
  }

}
