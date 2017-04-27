package com.term_project.house;
import com.term_project.cards.Event;
import com.term_project.cards.Item;
import com.term_project.cards.Omen;
import com.term_project.character.GameChar;

import java.util.List;
import java.util.Map;
/**
 * Generic tile with no entry and exit events
 *
 * @author Zachary Hoffman
 */

public class GenericTile extends AbstractTile implements Tile {
  private String name;
  private String description;

  public GenericTile(
    Map<Direction, Tile> connectedTiles,
    List<Item> items,
    List<Omen> omens,
    List<Event> events,
    List<Floor> availableFloors) {
    super(connectedTiles, items, omens, events, availableFloors);
  }

  /**
   * Sets the tiles name.
   * @return The tile object that the function is being called on.
   */
  public GenericTile setName(String newName) {
    name = newName;
    return this;
  }

  /**
   * Sets the tiles description.
   * @return The tile object that the function is being called on.
   */
  public GenericTile setDescription(String newDescription) {
    description = newDescription;
    return this;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public void enter(GameChar affected) {
    return;
  }

  @Override
  public void exit(GameChar affected) {
    return;
  }

  @Override
  public void apply(GameChar affected) {
    return;
  }
}
