package com.term_project.house;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  private List<Item> items;
  private List<Omen> omens;
  private Map<String, Event> events;
  private List<Floor> availableFloors;
  private MemorySlot memory;
  private String name;

  public AbstractTile(List<Direction> availableDoors, int items,
      int events, int omens, List<Floor> availableFloors, MemorySlot memory) {

    this.items = new ArrayList<>();
    this.omens = new ArrayList<>();
    this.events = new HashMap<>();

    this.itemCount = items;
    this.omenCount = omens;
    this.eventCount = events;

    this.pos = null;
    this.availableDoors = availableDoors;
    this.availableFloors = availableFloors;
    this.memory = memory;
    this.doors = new HashMap<>();
  }

  @Override
  public Tile setName(String newName) {
    name = newName;
    return this;
  }

  @Override
  public String getName() {
    return name;
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
  public Map<String, Event> getEvents() {
    return events;
  }

  @Override
  public Event getEvent(String name) {
    return events.get(name);
  }

  @Override
  public void setItems(List<Item> items) {
    this.items = items;
  }

  @Override
  public void addEvent(String name, Event event) {
    events.put(name, event);
  }

  @Override
  public void setOmens(List<Omen> omens) {
    this.omens = omens;
  }

  @Override
  public int getItemCount() {
    return itemCount;
  }

  @Override
  public int getOmenCount() {
    return omenCount;
  }

  @Override
  public int getEventCount() {
    return eventCount;
  }

  @Override
  public Pos getPos() {
    return pos;
  }

  @Override
  public Tile getNorth() throws NullPointerException {
    if(!this.hasNorth()) {
      throw new NullPointerException(
          "There is no door/tile to the north.");
    }
    Tile north = memory.getTileMap().get(doors.get(Direction.NORTH));
    return north;
  }

  @Override
  public Tile getSouth() throws NullPointerException {
    if(!hasSouth()) {
      throw new NullPointerException(
          "There is no door/tile to the south.");
    }
    Tile south = memory.getTileMap().get(doors.get(Direction.SOUTH));
    return south;
  }

  @Override
  public Tile getEast() throws NullPointerException {
    if(!hasEast()) {
      throw new NullPointerException(
          "There is no door/tile to the south.");
    }
    Tile east = memory.getTileMap().get(doors.get(Direction.EAST));
    return east;
  }

  @Override
  public Tile getWest() throws NullPointerException {
    if(!hasWest()) {
      throw new NullPointerException(
          "There is no door/tile to the south.");
    }
    Tile west = memory.getTileMap().get(doors.get(Direction.WEST));
    return west;
  }

  @Override
  public Tile getUp() throws NullPointerException {
    if(!hasUp()) {
      throw new NullPointerException(
          "There is no door/tile to above.");
    }
    Tile up = memory.getTileMap().get(doors.get(Direction.UP));
    return up;
  }

  @Override
  public Tile getDown() throws NullPointerException {
    if(!hasDown()) {
      throw new NullPointerException(
          "There is no door/tile below.");
    }
    Tile down = memory.getTileMap().get(doors.get(Direction.DOWN));
    return down;
  }

  @Override
  public boolean hasNorth() {
    return availableDoors.contains(Direction.NORTH);
  }

  @Override
  public boolean hasSouth() {
    return availableDoors.contains(Direction.SOUTH);
  }

  @Override
  public boolean hasEast() {
    return availableDoors.contains(Direction.EAST);
  }

  @Override
  public boolean hasWest() {
    return availableDoors.contains(Direction.WEST);
  }

  @Override
  public boolean hasDown() {
    return availableDoors.contains(Direction.DOWN);
  }


  @Override
  public boolean hasUp() {
    return availableDoors.contains(Direction.UP);
  }


  @Override
  public void addNorth() {
    assert(hasNorth());
    doors.put(Direction.NORTH, new Pos(pos.getX(), pos.getY() + 1, pos.getFloor()));
  }

  @Override
  public void addSouth() {
    assert(hasSouth());
    doors.put(Direction.NORTH, new Pos(pos.getX(), pos.getY() - 1, pos.getFloor()));
  }

  @Override
  public void addEast() {
    assert(hasEast());
    doors.put(Direction.NORTH, new Pos(pos.getX() + 1, pos.getY(), pos.getFloor()));
  }

  @Override
  public void addWest() {
    assert(hasWest());
    doors.put(Direction.NORTH, new Pos(pos.getX() - 1, pos.getY(), pos.getFloor()));
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
    // will be placement will switching tiles
    Pos holderOne;
    Pos holderTwo;

    // make east value the northern value
    holderOne = doors.get(Direction.EAST);
    doors.put(Direction.EAST,
        doors.get(Direction.NORTH));

    // make south value the eastern value
    holderTwo = doors.get(Direction.SOUTH);
    doors.put(Direction.SOUTH, holderOne);

    // Make west value the south value
    holderOne = doors.get(Direction.WEST);
    doors.put(Direction.WEST, holderTwo);

    // Make north value the west value
    doors.put(Direction.NORTH, holderOne);
    int rem = availableDoors.size();

    if (availableDoors.contains(Direction.NORTH)) {
      availableDoors.remove(Direction.NORTH);
      availableDoors.add(Direction.EAST);
      rem--;
    }
    if (availableDoors.contains(Direction.EAST) && rem > 0) {
      availableDoors.remove(Direction.EAST);
      availableDoors.add(Direction.SOUTH);
      rem--;
    }
    if (availableDoors.contains(Direction.SOUTH) && rem > 0) {
      availableDoors.remove(Direction.SOUTH);
      availableDoors.add(Direction.WEST);
      rem--;
    } 
    if (availableDoors.contains(Direction.WEST) && rem > 0) {
      availableDoors.remove(Direction.WEST);
      availableDoors.add(Direction.NORTH);
      rem--;
    }
  }

  @Override
  public void rotateCounterClockwise() {
    // will be placement will switching tiles
    Pos holderOne;
    Pos holderTwo;

    // make east value the southern value
    holderOne = doors.get(Direction.EAST);
    doors.put(Direction.EAST,
        doors.get(Direction.SOUTH));

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
  public void addItem(Item item) {
    items.add(item);
  }

  @Override
  public void addOmen(Omen omen) {
    omens.add(omen);
  }

  @Override
  public boolean equals(Object object) {
    if (object == this)
      return true;
    if (!(object instanceof Tile)) {
      return false;
    }

    return this.getName().equals(((Tile) object).getName());
  }

  @Override
  public int hashCode() {
    return this.getName().hashCode();
  }

  @Override
  public TileBean getBean(){
    return new TileBean(availableDoors, itemCount, eventCount , omenCount, pos, name);
  }
}
