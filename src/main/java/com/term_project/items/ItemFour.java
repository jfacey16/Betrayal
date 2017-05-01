package com.term_project.items;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;

public class ItemFour implements Item {

  public ItemFour() {

  }

  @Override
  public String getDescription() {
    return "this is an example item";
  }

  @Override
  public String getFunction() {
    return null;

  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void add(GameChar character) {
    // TODO Auto-generated method stub

  }

  @Override
  public void use(GameChar character, MemorySlot memory) {
    // TODO Auto-generated method stub

  }

  @Override
  public void loss(GameChar character) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean equals(Object object) {
    if (object == this)
      return true;
    if (!(object instanceof Bottle)) {
      return false;
    }

    return this.getName().equals(((Bottle) object).getName());
  }

  @Override
  public int hashCode() {
    return this.getName().hashCode();
  }
}
