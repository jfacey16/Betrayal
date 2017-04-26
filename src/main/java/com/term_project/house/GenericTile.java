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

public class GenericTile implements Tile {
  private String name;
  private Pos pos;
  private Map<Direction, Tile> connectedTiles;
  private List<Item> items;
  private List<Omen> omens;
  private List<Event> events;
  private List<Floor> availableFloors;

  public GenericTile(
    String name,
    Map<Direction, Tile> connectedTiles,
    List<Item> items,
    List<Omen> omens,
    List<Event> events,
    List<Floor> availableFloors) {
    this.name = name;
    this.pos = null;
    this.connectedTiles = connectedTiles;
    this.items = items;
    this.omens = omens;
    this.events = events;
    this.availableFloors = availableFloors;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return "A generic tile with no entry exit effects.";
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
  public List<Omen> getOmens() {
    return omens;
  }

  @Override
  public List<Item> getItems() {
    return items;
  }

  @Override
  public List<Event> getEvents() {
    return events;
  }

  @Override
  public Pos getPos() {
    return pos;
  }

  @Override
  public Tile getNorth() {
    return connectedTiles.get(Direction.NORTH);
  }

  @Override
  public Tile getSouth() {
    return connectedTiles.get(Direction.SOUTH);
  }

  @Override
  public Tile getEast() {
    return connectedTiles.get(Direction.EAST);
  }

  @Override
  public Tile getWest() {
    return connectedTiles.get(Direction.WEST);
  }

  @Override
  public void setNorth(Tile newTile) {
    connectedTiles.put(Direction.NORTH, newTile);
  }

  @Override
  public void setSouth(Tile newTile) {
    connectedTiles.put(Direction.SOUTH, newTile);
  }

  @Override
  public void setEast(Tile newTile) {
    connectedTiles.put(Direction.EAST, newTile);
  }

  @Override
  public void setWest(Tile newTile) {
    connectedTiles.put(Direction.WEST, newTile);
  }

  @Override
  public void setPos(Pos newPos) {
    pos = newPos;
  }

  @Override
  public List<Floor> getAvailableFloors() {
    return availableFloors;
  }
}
