package com.term_project.character;
import com.term_project.house.Pos;
import com.term_project.house.Tile;

/**
 * Interface that outlines what methods a character needs.
 *
 * @author Zachary Hoffman
 */
public interface Character {
  /** Return's the character's name.
   * @return The character's name.
   *
   */
  String getName();

  /** Return's the description of a character.
   * @return A description of a character.
   *
   */
  String getDescription();

  /** Return's the character's position.
   * @return A Pos object representing the character's position.
   *
   */
  Pos getPos();

  /** Return's the tile the Character is residing on.
   * @return A Tile object representing the tile the character is on.
   *
   */
  Tile getTile();

  /** Gets the character's might.
   * @return An integer representing the Character's might.
   */
  int getMight();

  /** Gets the character's speed
   * @return An integer representing the Character's speed.
   */
  int getSpeed();

  /** Gets the character's knowlege.
   * @return An integer representing the Character's knowlege.
   */
  int getKnowlege();

  /** Gets the character's sanity.
   * @return An integer representing the Character's sanity.
   */
  int getSanity();

  /** Changes the characters might by the inputted amount.
   * @return An integer representing the Character's might.
   */
  int modMight(int mightModifier);

  /** Changes the characters speed by the inputted amount.
   * @return An integer representing the Character's speed.
   */
  int modSpeed();

  /** Changes the characters knowlege by the inputted amount.
   * @return An integer representing the Character's knowlege.
   */
  int modKnowlege();

  /** Changes the characters sanity by the inputted amount.
   * @return An integer representing the Character's sanity.
   */
  int modSanity();
}
