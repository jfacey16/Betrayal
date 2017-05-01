package com.term_project.omens;

import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;

public class Madman implements Omen {

  private String name;
  private String description;
  private String function;

  public Madman() {
    name = "Madman";
    description = "Companian.\nA raving, frothing madman.";
    function = "Gain 2 Might and lose 1 Sanity now.\nLose "
        + "2 Might and gain 1 Sanity if you lose custody "
        + "of the Madman.\nThis omen can't be dropped, traded, or stolen.";
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
    character.modSanity(-1);
    character.modMight(2);
  }

  @Override
  public void use(GameChar character, MemorySlot memory,
      Map<String, Object> variables) {
    return;
  }

  @Override
  public void loss(GameChar character) {
    character.modSanity(1);
    character.modMight(-2);
    character.removeOmen(this);
    character.getTile().addOmen(this);
    ;
  }
}
