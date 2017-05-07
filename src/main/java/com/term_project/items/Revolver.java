package com.term_project.items;

import java.util.Map;

import com.term_project.character.GameChar;

public class Revolver implements Item {

  private String name;
  private String description;
  private String function;

  public Revolver() {
    name = "Revolver";
    description = "An old, potent-looking weapon.";
    function = "You can use the Revolver to attack "
        + "with Speed instead of Might.  Roll 1 "
        + "additional die on your Speed attack "
        + "roll (maximum 8 dice).";
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
    if (!(object instanceof Revolver)) {
      return false;
    }

    return this.getName().equals(((Revolver) object).getName());
  }

  @Override
  public int hashCode() {
    return this.getName().hashCode();
  }

}
