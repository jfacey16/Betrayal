package com.term_project.omens;

import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;

public class Book implements Omen {

  private String name;
  private String description;
  private String function;

  public Book() {
    name = "Book";
    description = "A diary or lab notes? Ancient script or modern ravings?";
    function = "Gain 2 Knowledge now.\nLose 2 Knowledge if you lose the Book.";
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
    character.modKnowlege(2);
    character.addOmen(this);
  }

  @Override
  public void use(GameChar character, MemorySlot memory,
      Map<String, Object> variables) {
    return;
  }

  @Override
  public void loss(GameChar character) {
    character.modKnowlege(-2);
    character.removeOmen(this);
    character.getTile().addOmen(this);
  }
}
