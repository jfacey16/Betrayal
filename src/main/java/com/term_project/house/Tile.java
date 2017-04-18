package com.term_project.house;
/**
 * Interface that outlines what methods a tile needs.
 *
 * @author Zachary Hoffman
 */
public interface Tile {
  /** Return's the description of the event.
   * @return A description of the event.
   *
   */
  String getDescription();

  /** Produces the effect described in the description
   * on a character.
   *
  */
  void apply(Character effected);

  /** Returns the Tile's position.
   * @return The tile's position
  */
  Pos getPos();

  /** Returns the tile that is linked to this tile in the North.
   * @return the rile that is linked to this tile in the North.
   */
  Tile getNorth();

  /** Returns the tile that is linked to this tile in the South.
   * @return the rile that is linked to this tile in the South.
   */
  Tile getSouth();

  /** Returns the tile that is linked to this tile in the East.
   * @return the rile that is linked to this tile in the East.
   */
  Tile getEast();

  /** Returns the tile that is linked to this tile in the West.
   * @return the rile that is linked to this tile in the West.
   */
  Tile getWest();
}
