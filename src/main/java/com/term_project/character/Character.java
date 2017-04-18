package com.term_project.character;

/**
 * Interface that outlines what methods a character needs.
 *
 * @author Zachary Hoffman
 */
public interface Characters {
  /** Return's the description of a character
   * @return A description of a character.
   *
   */
  String getDescription();

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
