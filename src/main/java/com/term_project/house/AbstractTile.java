package com.term_project.house;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.term_project.events.Event;
import com.term_project.items.Item;
import com.term_project.omens.Omen;
import com.term_project.system.MemorySlot;

/**
 * Generic tile with no entry and exit events
 *
 * @author Zachary Hoffman
 */

public abstract class AbstractTile implements Tile {
  private Pos pos;
  private Map<Direction, Pos> doors;
  private List<Direction> availableDoors;
  private int itemCount;
  private int omenCount;
  private int eventCount;
  private Map<String, Item> items;
  private Map<String, Omen> omens;
  private Map<String, Event> events;
  private List<Floor> availableFloors;
  private MemorySlot memory;
  private String name;

  public AbstractTile(List<Direction> availableDoors, int items,
      int events, int omens, List<Floor> availableFloors,
      MemorySlot memory) {

    this.items = new ConcurrentHashMap<>();
    this.omens = new ConcurrentHashMap<>();
    this.events = new ConcurrentHashMap<>();

    this.itemCount = items;
    this.omenCount = omens;
    this.eventCount = events;

    this.pos = null;
    this.availableDoors = availableDoors;
    this.availableFloors = availableFloors;
    this.memory = memory;
    this.doors = new ConcurrentHashMap<>();
  }

  @Override
  public synchronized Tile setName(String newName) {
    name = newName;
    return this;
  }

  @Override
  public synchronized String getName() {
    return name;
  }

  @Override
  public synchronized Map<String, Omen> getOmens() {
    return omens;
  }

  @Override
  public synchronized Map<String, Item> getItems() {
    return items;
  }

  @Override
  public synchronized Map<String, Event> getEvents() {
    return events;
  }

  @Override
  public synchronized Event getEvent(String name) {
    return events.get(name);
  }

  @Override
  public synchronized void setItems(Map<String, Item> items) {
    this.items = items;
  }

  @Override
  public synchronized void addEvent(String name, Event event) {
    events.put(name, event);
  }

  @Override
  public synchronized void setOmens(Map<String, Omen> omens) {
    this.omens = omens;
  }

  @Override
  public synchronized int getItemCount() {
    return itemCount;
  }

  @Override
  public synchronized int getOmenCount() {
    return omenCount;
  }

  @Override
  public synchronized int getEventCount() {
    return eventCount;
  }

  @Override
  public synchronized Pos getPos() {
    return pos;
  }

  @Override
  public synchronized Tile getNorth() throws NullPointerException {
    if (!this.hasNorth()) {
      throw new NullPointerException(
          "There is no door/tile to the north.");
    }
    Tile north = memory.getTileMap().get(doors.get(Direction.NORTH));
    return north;
  }

  @Override
  public synchronized Tile getSouth() throws NullPointerException {
    if (!hasSouth()) {
      throw new NullPointerException(
          "There is no door/tile to the south.");
    }
    Tile south = memory.getTileMap().get(doors.get(Direction.SOUTH));
    return south;
  }

  @Override
  public synchronized Tile getEast() throws NullPointerException {
    if (!hasEast()) {
      throw new NullPointerException(
          "There is no door/tile to the south.");
    }
    Tile east = memory.getTileMap().get(doors.get(Direction.EAST));
    System.out.println("doorx: " + doors.get(Direction.EAST).getX());
    System.out.println("doory: " + doors.get(Direction.EAST).getY());
    return east;
  }

  @Override
  public synchronized Tile getWest() throws NullPointerException {
    if (!hasWest()) {
      throw new NullPointerException(
          "There is no door/tile to the south.");
    }
    Tile west = memory.getTileMap().get(doors.get(Direction.WEST));
    return west;
  }

  @Override
  public synchronized Tile getUp() throws NullPointerException {
    if (!hasUp()) {
      throw new NullPointerException("There is no door/tile to above.");
    }
    Tile up = memory.getTileMap().get(doors.get(Direction.UP));
    return up;
  }

  @Override
  public synchronized Tile getDown() throws NullPointerException {
    if (!hasDown()) {
      throw new NullPointerException("There is no door/tile below.");
    }
    Tile down = memory.getTileMap().get(doors.get(Direction.DOWN));
    return down;
  }

  @Override
  public synchronized boolean hasNorth() {
    return availableDoors.contains(Direction.NORTH);
  }

  @Override
  public synchronized boolean hasSouth() {
    return availableDoors.contains(Direction.SOUTH);
  }

  @Override
  public synchronized boolean hasEast() {
    return availableDoors.contains(Direction.EAST);
  }

  @Override
  public synchronized boolean hasWest() {
    return availableDoors.contains(Direction.WEST);
  }

  @Override
  public synchronized boolean hasDown() {
    return availableDoors.contains(Direction.DOWN);
  }

  @Override
  public synchronized boolean hasUp() {
    return availableDoors.contains(Direction.UP);
  }

  @Override
  public synchronized void addNorth() {
    assert(hasNorth());

    doors.put(Direction.NORTH,
        new Pos(pos.getX(), pos.getY() - 1, pos.getFloor()));

  }

  @Override
  public synchronized void addSouth() {
    assert(hasSouth());

    doors.put(Direction.SOUTH,
        new Pos(pos.getX(), pos.getY() + 1, pos.getFloor()));
  }

  @Override
  public synchronized void addEast() {
    assert(hasEast());

    doors.put(Direction.EAST,
        new Pos(pos.getX() + 1, pos.getY(), pos.getFloor()));

  }

  @Override
  public synchronized void addWest() {
    assert(hasWest());
    doors.put(Direction.WEST,
        new Pos(pos.getX() - 1, pos.getY(), pos.getFloor()));
  }

  @Override
  public synchronized void addUp() {
    assert(hasUp());
    doors.put(Direction.UP,
        new Pos(pos.getX() - 2, pos.getY(), Floor.ATTIC));
  }

  @Override
  public synchronized void addDown() {
    assert(hasDown());
    doors.put(Direction.DOWN,
        new Pos(pos.getX() + 2, pos.getY(), Floor.GROUND));
  }

  @Override
  public synchronized void setPos(Pos newPos) {
    pos = newPos;
  }

  @Override
  public synchronized List<Floor> getAvailableFloors() {
    return availableFloors;
  }

  @Override
  public synchronized void rotateClockwise() {
    // will be placement will switching tiles
    Pos holderOne;
    Pos holderTwo;
    
    // make east value the northern value
    holderOne = doors.get(Direction.EAST);
    doors.put(Direction.EAST, doors.get(Direction.NORTH));

    // make south value the eastern value
    holderTwo = doors.get(Direction.SOUTH);
    doors.put(Direction.SOUTH, holderOne);

    // Make west value the south value
    holderOne = doors.get(Direction.WEST);
    doors.put(Direction.WEST, holderTwo);

    // Make north value the west value
    doors.put(Direction.NORTH, holderOne);
    // int rem = availableDoors.size();

    // if (availableDoors.contains(Direction.NORTH) && rem > 0) {
    // availableDoors.remove(Direction.NORTH);
    // availableDoors.add(Direction.EAST);
    // rem--;
    // }
    // if (availableDoors.contains(Direction.EAST) && rem > 0) {
    // availableDoors.remove(Direction.EAST);
    // availableDoors.add(Direction.SOUTH);
    // rem--;
    // }
    // if (availableDoors.contains(Direction.SOUTH) && rem > 0) {
    // availableDoors.remove(Direction.SOUTH);
    // availableDoors.add(Direction.WEST);
    // rem--;
    // }
    // if (availableDoors.contains(Direction.WEST) && rem > 0) {
    // availableDoors.remove(Direction.WEST);
    // availableDoors.add(Direction.NORTH);
    // rem--;
    // }
    int rem = 0;
    int av = availableDoors.size();
    while (true) {
      if (availableDoors.contains(Direction.NORTH)) {
        rem++;
        if (rem == av) {
          availableDoors.clear();
          if (av == 3)
            availableDoors.add(Direction.WEST);
          availableDoors.add(Direction.EAST);
          availableDoors.add(Direction.NORTH);
          break;
        }
      } else
        rem = 0;
      if (availableDoors.contains(Direction.EAST)) {
        rem++;
        if (rem == av) {
          availableDoors.clear();
          if (av == 3)
            availableDoors.add(Direction.NORTH);
          availableDoors.add(Direction.SOUTH);
          availableDoors.add(Direction.EAST);
          break;
        }
      } else
        rem = 0;
      if (availableDoors.contains(Direction.SOUTH)) {
        rem++;
        if (rem == av) {
          availableDoors.clear();
          if (av == 3)
            availableDoors.add(Direction.EAST);
          availableDoors.add(Direction.WEST);
          availableDoors.add(Direction.SOUTH);
          break;
        }
      } else
        rem = 0;
      if (availableDoors.contains(Direction.WEST)) {
        rem++;
        if (rem == av) {
          availableDoors.clear();
          if (av == 3)
            availableDoors.add(Direction.SOUTH);
          availableDoors.add(Direction.NORTH);
          availableDoors.add(Direction.WEST);
          break;
        }
      } else
        rem = 0;
    }
  }

  @Override
  public synchronized void rotateCounterClockwise() {
    // will be placement will switching tiles
    Pos holderOne;
    Pos holderTwo;

    // make east value the southern value
    holderOne = doors.get(Direction.EAST);
    doors.put(Direction.EAST, doors.get(Direction.SOUTH));

    // make north value the eastern value
    holderTwo = doors.get(Direction.NORTH);
    doors.put(Direction.NORTH, holderOne);

    // Make west value the north value
    holderOne = doors.get(Direction.WEST);
    doors.put(Direction.WEST, holderTwo);

    // Make north value the west value
    doors.put(Direction.SOUTH, holderOne);
  }

  @Override
  public synchronized void addItem(Item item) {
    items.put(item.getName(), item);
  }

  @Override
  public synchronized void addOmen(Omen omen) {
    omens.put(omen.getName(), omen);
  }

  @Override
  public synchronized boolean equals(Object object) {
    if (object == this)
      return true;
    if (!(object instanceof Tile)) {
      return false;
    }

    return this.getName().equals(((Tile) object).getName());
  }

  @Override
  public synchronized int hashCode() {
    return this.getName().hashCode();
  }

  @Override
  public synchronized TileBean getBean() {
    return new TileBean(availableDoors, itemCount, eventCount, omenCount,
        pos, name);
  }

  @Override
  public synchronized Item getItem(String item) {
    return items.get(item);
  }

  @Override
  public synchronized Omen getOmen(String omen) {
    return omens.get(omen);
  }

  @Override
  public synchronized Item removeItem(Item item) {
    return items.remove(item.getName());
  }

  @Override
  public synchronized Omen removeOmen(Omen omen) {
    return omens.remove(omen.getName());
  }
}
