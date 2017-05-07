package com.term_project.items;

import java.util.Map;

import com.term_project.character.GameChar;

public class SacrificialDaggar implements Item {

  private String name;
  private String description;
  private String function;

  public SacrificialDaggar() {
    name = "Sacrificial Daggar";
    description = "A twisted shard of iron covered in mysterious symbols and stained with blood.";
    function = "When making a Might attack with this weapon,"
        + " you roll 3 extra dice, but you must make a Knowledge "
        + "roll first:\n6+ No effect.\n3-5 Lose 1 from a mental "
        + "trait.\n0-2 The daggar twists in your hand! Take "
        + "1 Might damage and 1 Speed damage. You can't attack this turn.";
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
    character.addItem(this);
  }

  @Override
  public void use(GameChar character, Map<String, Object> variables) {
    return;
  }

  @Override
  public void loss(GameChar character) {
    character.removeItem(this);
    character.getTile().addItem(this);
  }

  @Override
  public boolean equals(Object object) {
    if (object == this)
      return true;
    if (!(object instanceof SacrificialDaggar)) {
      return false;
    }

    return this.getName().equals(((SacrificialDaggar) object).getName());
  }

  @Override
  public int hashCode() {
    return this.getName().hashCode();
  }
}
