package com.term_project.character;

import com.term_project.cards.Item;
import com.term_project.cards.Omen;
import com.term_project.house.Pos;
import com.term_project.house.Tile;

/**
 * Interface that outlines what methods a character needs.
 *
 * @author Zachary Hoffman
 */
public interface Character {
  /** Return's the character's name.
   * 
   * @return The character's name.
   *
   */
  String getName();

  /** Return's the description of a character.
   * 
   * @return A description of a character.
   *
   */
  String getDescription();

  /** Return's the character's position.
   * 
   * @return A Pos object representing the character's position.
   *
   */
  Pos getPos();

  /** Return's the tile the Character is residing on.
   * 
   * @return A Tile object representing the tile the character is on.
   *
   */
  Tile getTile();

  /** Gets the character's might.
   * 
   * @return An integer representing the Character's might.
   */
  int getMight();

  /** Gets the character's speed.
   * 
   * @return An integer representing the Character's speed.
   */
  int getSpeed();

  /** Gets the character's knowledge.
   * 
   * @return An integer representing the Character's knowledge.
   */
  int getKnowlege();

  /** Gets the character's sanity.
   * 
   * @return An integer representing the Character's sanity.
   */
  int getSanity();
  
  /** Changes the characters position to the input position.
   * 
   * @param posModifier the position to move it to
   * @return the new position
   */
  void setPos(Pos newPos);
  
  /** Changes the characters tile to the input tile.
   * 
   * @param newTile the tile to move it to
   * @return the new tile
   */
  void setTile(Tile newTile);

  /** Changes the characters might by the inputted amount.
   * 
   * @param mightModifier the amount to change might by.
   * @return An integer representing the Character's might.
   */
  int modMight(int mightModifier);

  /** Changes the characters speed by the inputted amount.
   * 
   * @param mightModifier the amount to change speed by
   * @return An integer representing the Character's speed.
   */
  int modSpeed(int speedModifier);

  /** Changes the characters knowledge by the inputted amount.
   * 
   * @param mightModifier the amount to change knowledge by.
   * @return An integer representing the Character's knowledge.
   */
  int modKnowlege(int knowledgeModifier);

  /** Changes the characters sanity by the inputted amount.
   * 
   * @param mightModifier the amount to change sanity by.
   * @return An integer representing the character's sanity.
   */
  int modSanity(int sanityModifier);
  
  /**
   * Adds the input item to a character.
   * 
   * @param item the item to add
   */
  void addItem(Item item);
  
  /**
   * Adds the input omen to a character.
   * 
   * @param omen the omen to add
   */
  void addOmen(Omen omen);
  
  /**
   * Drops the input item, removing it from the character.
   * 
   * @param item the item to drop
   */
  void dropItem(Item item);
  
  /**
   * Drops the input item, removing it from the character.
   * 
   * @param omen the omen to drop
   */
  void dropOmen(Omen omen);
}
