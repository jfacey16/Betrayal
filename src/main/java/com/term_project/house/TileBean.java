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

public class TileBean {
  private Pos pos;
  private Map<Direction, Pos> doors;
  private List<Direction> availableDoors;
  private int itemCount;
  private int omenCount;
  private int eventCount;

  public TileBean(List<Direction> availableDoors, int items,
      int events, int omens, Pos pos) {
    this.itemCount = items;
    this.omenCount = omens;
    this.eventCount = events;

    this.availableDoors = availableDoors;
    this.pos = pos;
  }

}
