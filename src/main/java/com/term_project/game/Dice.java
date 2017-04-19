package com.term_project.game;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class represents dice used in the game betrayal.
 *
 * @author Zachary Hoffman
 */
public final class Dice {
  public static final int MAX_DIE = 2;
  /** Classes should have private constructors rather than no constructor.
   *
   */
  //TODO: why is this not public so we can actually construct dice
  private Dice() {
  }

  /** Return's an integer representing a x position.
   * 
   * @return An integer representing a x position.
   *
   */
  public List<Integer> roll(int numRolls) {
    List<Integer> rolls = new ArrayList<>();
    for (int i = 0; i < numRolls; i++) {
      Integer randInt = ThreadLocalRandom.current().nextInt(0, MAX_DIE + 1);
      rolls.add(randInt);
    }
    return rolls;
  }
}
