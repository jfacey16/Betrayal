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

public abstract class AbstractTile implements Tile {
  private Pos pos;
  private Map<Direction, Tile> connectedTiles;
  private List<Item> items;
  private List<Omen> omens;
  private List<Event> events;
  private List<Floor> availableFloors;
  private getFLoor;

  public AbstractTile(
    Map<Direction, Tile> connectedTiles,
    List<Item> items,
    List<Omen> omens,
    List<Event> events,
    List<Floor> availableFloors) {
    this.pos = null;
    this.connectedTiles = connectedTiles;
    this.items = items;
    this.omens = omens;
    this.events = events;
    this.availableFloors = availableFloors;
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
  public Tile getNorth() throws NullPointerException {
    Tile north = connectedTiles.get(Direction.NORTH);
    if (north != null) {
      return north;
    } else {
      throw new NullPointerException("There is no door/tile to the north.");
    }
  }

  @Override
  public Tile getSouth() throws NullPointerException {
    Tile south = connectedTiles.get(Direction.SOUTH);
    if (south != null) {
      return south;
    } else {
      throw new NullPointerException("There is no door/tile to the south.");
    }
  }

  @Override
  public Tile getEast() throws NullPointerException {
    Tile east = connectedTiles.get(Direction.EAST);
    if (east != null) {
      return east;
    } else {
      throw new NullPointerException("There is no door/tile to the east.");
    }
  }

  @Override
  public Tile getWest() throws NullPointerException {
    Tile west = connectedTiles.get(Direction.WEST);
    if (west != null) {
      return west;
    } else {
      throw new NullPointerException("There is no door/tile to the west.");
    }
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

  @Override
  public void rotateClockwise() {
    //will be placement will switching tiles
    Tile holderOne;
    Tile holderTwo;

    //make north value the eastern value
    holderOne = connectedTiles.get(Direction.EAST);
    connectedTiles.put(Direction.EAST, connectedTiles.get(Direction.NORTH));

    //make south value the eastern value
    holderTwo = connectedTiles.get(Direction.SOUTH);
    connectedTiles.put(Direction.SOUTH, holderOne);

    //Make west value the south value
    holderOne = connectedTiles.get(Direction.WEST);
    connectedTiles.put(Direction.WEST, holderTwo);

    //Make north value the west value
    connectedTiles.put(Direction.NORTH, holderOne);
  }

  @Override
  public Tile getFloor() {
    return floor;
  }

  @Override
  public void setFloor(Floor newFloor) {
    assert(availableFloors.contains(newFloor));
    floor = newFloor;
  }
}
