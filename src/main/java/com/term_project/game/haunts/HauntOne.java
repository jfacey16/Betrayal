package com.term_project.game.haunts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.game.actions.Mover;
import com.term_project.house.Tile;
import com.term_project.system.MemorySlot;

import spark.QueryParamsMap;

public class HauntOne implements GamePhase {

  private MemorySlot memory;

  private String mode;
  private Integer phase;

  private Mover move;
  Map<String, Integer> remaining;

  private List<String> toResolve;

  public HauntOne(MemorySlot memory) {
    this.memory = memory;
    mode = "start";
    phase = 0;

    move = new Mover(memory);
    remaining = new HashMap<>();
    toResolve = new ArrayList<>();
  }

  @Override
  public void run(String name, QueryParamsMap qm, GameChar character,
      Map<String, Object> variables) {

  }

  @Override
  public void addActions(GameChar character,
      Map<String, Object> variables) {
    List<String> actions = new ArrayList<>();
    Tile tile = character.getTile();

    if (tile.getEvents().size() > 0) {
      actions.add("event");
    }

    if (tile.getItems().size() > 0) {
      actions.add("pickup item");
    }

    if (tile.getOmens().size() > 0) {
      actions.add("pickup omen");
    }

    if (character.getItems().size() > 0) {
      actions.add("drop item");
      actions.add("use item");
    }

    if (character.getOmens().size() > 0) {
      actions.add("drop omen");
      actions.add("use omen");
    }

    if (remaining.get("move") > 0) {
      actions.add("move");
    }

    variables.put("actions", actions);
  }

  @Override
  public String getExplorersDescription() {
    return "";
  }

  @Override
  public String getTraitorDescription() {
    return "";
  }

  @Override
  public String getDescription() {
    return "";
  }
}
