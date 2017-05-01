package com.term_project.omens;

import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;

public class Dog implements Omen {

  private String name;
  private String description;
  private String function;

  public Dog() {
    name = "Dog";
    description = "Companian.\nThis mangy dog seems friendly. At least you hope it is.";
    function = "Gain 1 Might and 1 Sanity now.\nLose 1 "
        + "Might and 1 Sanity if you lose custody of the Dog.\nThis "
        + "omen can't be dropped, traded, or stolen.";
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
    character.modMight(1);
    character.modSanity(1);
    character.addOmen(this);
  }

  @Override
  public void use(GameChar character, MemorySlot memory,
      Map<String, Object> variables) {
    return;
  }

  @Override
  public void loss(GameChar character) {
    character.modMight(-1);
    character.modSanity(-1);
    character.removeOmen(this);
    character.getTile().addOmen(this);
  }

  @Override
  public boolean equals(Object object) {
    if (object == this)
      return true;
    if (!(object instanceof Dog)) {
      return false;
    }

    return this.getName().equals(((Dog) object).getName());
  }

  @Override
  public int hashCode() {
    return this.getName().hashCode();
  }
}
