package com.term_project.cards;

import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;

public class Cat implements Item {

  public Cat() {

  }

  @Override
  public String getDescription() {
    return "The cat meows. Why is it here?";
  }

  @Override
  public void add(GameChar character, Map<String, Object> variables) {
    character.modSanity(2);
    character.addItem(this);
    variables.put("item", "cat");
    variables.put("description", this.getDescription());
    variables.put("knowledge", character.getKnowlege());
    variables.put("might", character.getMight());
    variables.put("sanity", character.getSanity());
    variables.put("speed", character.getSpeed());
  }

  @Override
  public void use(GameChar character, MemorySlot memory,
      Map<String, Object> variables) {
    // TODO Auto-generated method stub

  }

  @Override
  public void loss(GameChar character, Map<String, Object> variables) {
    character.modSanity(-2);
    character.removeItem(this);
    character.getTile().addItem(this);
    variables.put("item", "cat");
    variables.put("description", this.getDescription());
    variables.put("knowledge", character.getKnowlege());
    variables.put("might", character.getMight());
    variables.put("sanity", character.getSanity());
    variables.put("speed", character.getSpeed());
  }

  @Override
  public String getName() {
    return "Cat";
  }
}
