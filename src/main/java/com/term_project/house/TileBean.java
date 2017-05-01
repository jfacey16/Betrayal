package com.term_project.house;

import java.util.List;
import java.util.Map;

/**
 * Generic tile with no entry and exit events
 *
 * @author Zachary Hoffman
 */

public class TileBean {
  private Pos pos;
  private Map<Direction, Pos> doors;
  private List<Direction> availableDoors;
  private int itemCount;
  private int omenCount;
  private int eventCount;

  public TileBean(List<Direction> availableDoors, int items, int events,
      int omens, Pos pos) {
    this.itemCount = items;
    this.omenCount = omens;
    this.eventCount = events;

    this.availableDoors = availableDoors;
    this.pos = pos;
  }
}
