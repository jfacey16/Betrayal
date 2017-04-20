package com.term_project.system;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
/**
 * This is a class that will be used to hold a peice of information.
 * It is used to store different types of information in the Environment's
 * hashmap.
 *
 * @author ZacharyHoffman
 */
public final class MemorySlot {
  private HashMap<String, Boolean> bools;
  private HashMap<String, Integer> ints;
  private List<String> stringList;
  private DB database;

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

}
