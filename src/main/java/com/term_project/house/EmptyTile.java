package com.term_project.house;
import com.term_project.cards.Event;
import com.term_project.cards.Item;
import com.term_project.cards.Omen;
import com.term_project.character.GameChar;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
/**
 * Tile representing open slot for a tile to be placed.
 *
 * @author Zachary Hoffman
 */

public class EmptyTile implements Tile {
  private String name;
  private Pos pos;
  private Map<Direction, Tile> connectedTiles;
  private List<Item> items;
  private List<Omen> omens;
  private List<Event> events;
  private List<Floor> availableFloors;

  public EmptyTile() {
    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.ATTIC);
    availableFloors.add(Floor.GROUND);
    availableFloors.add(Floor.BASEMENT);
  }

  @Override
  public String getName() {
    return "Empty";
  }

  @Override
  public String getDescription() {
    return "Nothing here yet";
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
    return null;
  }

  @Override
  public List<Item> getItems() {
    return null;
  }

  @Override
  public List<Event> getEvents() {
    return null;
  }

  @Override
  public Pos getPos() {
    return null;
  }

  @Override
  public Tile getNorth() {
    return null;
  }

  @Override
  public Tile getSouth() {
    return null;
  }

  @Override
  public Tile getEast() {
    return null;
  }

  @Override
  public Tile getWest() {
    return null;
  }

  @Override
  public void setNorth(Tile newTile) {
    return;
  }

  @Override
  public void setSouth(Tile newTile) {
    return;
  }

  @Override
  public void setEast(Tile newTile) {
    return;
  }

  @Override
  public void setWest(Tile newTile) {
    return;
  }

  @Override
  public void setPos(Pos newPos) {
    return;
  }

  @Override
  public List<Floor> getAvailableFloors() {
    return availableFloors;
  }
}
