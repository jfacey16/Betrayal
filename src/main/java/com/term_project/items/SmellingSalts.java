package com.term_project.items;

import java.util.Map;

import com.term_project.character.GameChar;

public class SmellingSalts implements Item {

  private String name;
  private String description;
  private String function;

  public SmellingSalts() {
    name = "Smelling Salts";
    description = "Whew, that's a lungful.";
    function = "If your Knowledge value is below 3, raise the value by 1";
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
    if (character.getKnowlege() < 3) {
      character.modKnowlege(1);
    }
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
    if (!(object instanceof SmellingSalts)) {
      return false;
    }

    return this.getName().equals(((SmellingSalts) object).getName());
  }

  @Override
  public int hashCode() {
    return this.getName().hashCode();
  }
}
