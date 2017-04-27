package com.term_project.house;
import com.term_project.cards.Event;
import com.term_project.cards.Item;
import com.term_project.cards.Omen;
import com.term_project.character.GameChar;

import java.util.List;
/**
 * Interface that outlines what methods a tile needs.
 *
 * @author Zachary Hoffman
 */
public interface Tile {
  /** Returns the name of the tile.
   *
   * @return A description of the tile.
   *
   */
  String getName();

  /** Returns the description of the tile.
   *
   * @return A description of the tile.
   *
   */
  String getDescription();

  /** Produces the effect described in the description
   * on a character on entry.
   * @param affected The affected character.
   */
  void enter(GameChar affected);

  /** Produces the effect described in the description
   * on a character on exit.
   * @param affected The affected character.
   */
  void exit(GameChar affected);

  /** Produces an effect on the given character. Used for duration effects in
   * rooms.
   * @param affected The affected character.
   */
  void apply(GameChar affected);

  /** Returns a list of events on this tile.
   *
   * @return A list of Omen.
  */
  List<Omen> getOmens();

  /** Returns a list of items on this tile.
   *
   * @return A list of items.
  */
  List<Item> getItems();

  /** Returns a list of omens on this tile.
   *
   * @return A list of Event.
  */
  List<Event> getEvents();

  /** Returns the Tile's position.
   *
   * @return The tile's position
  */
  Pos getPos();

  /** Returns the tile that is linked to this tile in the North.
   *
   * @return the tile that is linked to this tile in the North.
   */
  Tile getNorth() throws NullPointerException;

  /** Returns the tile that is linked to this tile in the South.
   *
   *
   * @return the tile that is linked to this tile in the South.
   */
  Tile getSouth() throws NullPointerException;

  /** Returns the tile that is linked to this tile in the East.
   *
   * @return the tile that is linked to this tile in the East.
   */
  Tile getEast() throws NullPointerException;

  /** Returns the tile that is linked to this tile in the West.
   *
   * @return the tile that is linked to this tile in the West.
   */
  Tile getWest() throws NullPointerException;

  /** Sets the tile that is linked to this tile in the North.
   *
   */
  void setNorth(Tile newTile);

  /** Sets the tile that is linked to this tile in the South.
   *
   */
  void setSouth(Tile newTile);

  /** Sets the tile that is linked to this tile in the East.
   *
   */
  void setEast(Tile newTile);

  /** Sets the tile that is linked to this tile in the West.
   *
   */
  void setWest(Tile newTile);

  /** Sets the tile's position.
   *
   */
  void setPos(Pos newPos);

  /** Returns the floors that this tile can be placed in.
   * @return The floors that this tile can be placed in.
   */
  List<Floor> getAvailableFloors();

  /** Rotates the tile clockwise by 90 degrees.
  */
  void rotateClockwise();
  
  void generate();
}
