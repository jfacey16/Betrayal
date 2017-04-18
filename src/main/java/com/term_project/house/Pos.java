package com.term_project.house;

/**
 * This class represents a position in the house.
 *
 * @author Zachary Hoffman
 */
public class Pos {
  private int x;
  private int y;

  Pos(int x, int y) {
      this.x = x;
      this.y = y;
  }

  /** Return's an integer representing a x position.
   * @return An integer representing a x position.
   *
   */
  int getX() {
    return x;
  }

  /** Return's an integer representing a y position.
   * @return An integer representing a y position.
   */
   int getY() {
     return y;
   }

   /** Sets this position's x value.
    * @param newX The new x position.
    * @return The position being set.
    *
    */
   Pos setX(int newX) {
     x = newX;
     return this;
   }

   /** Sets this position's y value.
    * @param newY The new y position.
    * @return The position being set.
    */
    Pos setY(int newY) {
      y = newY;
      return this;
    }
}
