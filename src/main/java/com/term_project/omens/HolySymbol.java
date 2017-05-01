package com.term_project.omens;

import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;

public class HolySymbol implements Omen {

  private String name;
  private String description;
  private String function;

  public HolySymbol() {
    name = "Holy Symbol";
    description = "A symbol of calm in an unsettling world.";
    function = "Gain 2 Sanity now.\nLose 2 Sanity if you lose the Holy Symbol.";
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public String getFunction() {
    return function;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void add(GameChar character) {
    character.addOmen(this);
    character.modSanity(2);
  }

  @Override
  public void use(GameChar character, MemorySlot memory,
      Map<String, Object> variables) {
    return;
  }

  @Override
  public void loss(GameChar character) {
    character.modSanity(-2);
    character.removeOmen(this);
    character.getTile().addOmen(this);
  }
}