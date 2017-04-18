package com.term_project.house;
import com.term_project.cards.Event;
import com.term_project.cards.Item;
import com.term_project.cards.Omen;

import java.util.List;
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

  /** Returns a list of events on this tile.
   * @return A list of Omen.
  */
  List<Omen> getOmens();

  /** Returns a list of items on this tile.
   * @return A list of items.
  */
  List<Item> getItems();

  /** Returns a list of omens on this tile.
   * @return A list of Event.
  */
  List<Event> getEvents();

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
