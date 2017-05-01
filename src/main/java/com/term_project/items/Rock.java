package com.term_project.items;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;

public class Rock implements Item {

  private String name;
  private String description;
  private String function;

  public Rock() {
    name = "Rock";
    description = "Its a pretty nice rock.";
    function = "Gain 2 Knowledge now.\nLose 2 Knowledge when you lose the Rock.";
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
  public void add(GameChar character) {
    character.modKnowlege(2);
    character.addItem(this);
  }

  @Override
  public void use(GameChar character, MemorySlot memory) {
    return;
  }

  @Override
  public void loss(GameChar character) {
    character.modKnowlege(-2);
    character.removeItem(this);
    character.getTile().addItem(this);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object object) {
    if (object == this)
      return true;
    if (!(object instanceof Rock)) {
      return false;
    }

    return this.getName().equals(((Rock) object).getName());
  }

  @Override
  public int hashCode() {
    return this.getName().hashCode();
  }
}
