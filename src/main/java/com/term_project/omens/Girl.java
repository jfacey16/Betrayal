package com.term_project.omens;

import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;

public class Girl implements Omen {

  private String name;
  private String description;
  private String function;

  public Girl() {
    name = "Girl";
    description = "Companion.\nA girl.\nTrapped.\nAlone.\nYou free her!";
    function = "Gain 1 Sanity and 1 Knowledge now.\nLose 1 Sanity "
        + "and 1 Knowledge if you lose custody of the Girl.\nThis "
        + "omen can't be dropped, traded, or stolen.";
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getFunction() {
    return function;
  }

  @Override
  public void add(GameChar character) {
    character.modSanity(1);
    character.modKnowlege(1);
    character.addOmen(this);
  }

  @Override
  public void use(GameChar character, MemorySlot memory,
      Map<String, Object> variables) {
    return;
  }

  @Override
  public void loss(GameChar character) {
    character.modSanity(-1);
    character.modKnowlege(-1);
    character.removeOmen(this);
    character.getTile().addOmen(this);
  }
}
