package com.term_project.cards;

import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;

/*PUT ITEM INSTANCES INTO THE ITEM FOLDER*/
public class ItemFive implements Item {

  public ItemFive() {

  }

  @Override
  public String getDescription() {
    return "this is an example item";
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void add(GameChar character, Map<String, Object> variables) {
    // TODO Auto-generated method stub

  }

  @Override
  public void use(GameChar character, MemorySlot memory,
      Map<String, Object> variables) {
    // TODO Auto-generated method stub

  }

  @Override
  public void loss(GameChar character, Map<String, Object> variables) {
    // TODO Auto-generated method stub

  }
}
