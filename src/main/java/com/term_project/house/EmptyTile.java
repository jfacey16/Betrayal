package com.term_project.house;

import java.util.ArrayList;
import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.events.Event;

/**
 * Tile representing open slot for a tile to be placed.
 *
 * @author Zachary Hoffman
 */

public class EmptyTile extends AbstractTile implements Tile {

  private String name;
  private String description;

  public EmptyTile(Map<Direction, Tile> connectedTiles) {
    super(connectedTiles, 0, 0, 0, new ArrayList<>());
    name = "Empty";
    description = "Nothing here yet";
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
  public Tile setName(String newName) {
    name = newName;
    return this;
  }

  @Override
  public Tile setDescription(String newDescription) {
    description = newDescription;
    return this;
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

  @Override
  public void addEvent(String name, Event event) {
    return;
  }
}
