package com.term_project.items;

import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;

public class Rock implements Item {

  public Rock() {

  }

  @Override
  public String getDescription() {
    return "Its a pretty nice rock";
  }

  @Override
  public void add(GameChar character, Map<String, Object> variables) {
    character.modKnowlege(2);
    character.addItem(this);
    variables.put("item", "rock");
    variables.put("description", this.getDescription());
    variables.put("knowledge", character.getKnowlege());
    variables.put("might", character.getMight());
    variables.put("sanity", character.getSanity());
    variables.put("speed", character.getSpeed());
  }

  @Override
  public void use(GameChar character, MemorySlot memory,
      Map<String, Object> variables) {
    return;
  }

  @Override
  public void loss(GameChar character, Map<String, Object> variables) {
    character.modKnowlege(-2);
    character.removeItem(this);
    character.getTile().addItem(this);
    variables.put("item", "rock");
    variables.put("description", this.getDescription());
    variables.put("knowledge", character.getKnowlege());
    variables.put("might", character.getMight());
    variables.put("sanity", character.getSanity());
    variables.put("speed", character.getSpeed());
  }

  @Override
  public String getName() {
    return "Rock";
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