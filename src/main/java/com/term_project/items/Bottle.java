package com.term_project.items;

import java.util.List;
import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.game.Dice;
import com.term_project.system.MemorySlot;

public class Bottle implements Item {

  public Bottle() {

  }

  @Override
  public String getDescription() {
    return "An opaque vial containing a black liquid";
  }

  @Override
  public String getName() {
    return "Bottle";
  }

  @Override
  public void add(GameChar character, Map<String, Object> variables) {
    character.addItem(this);
    variables.put("item", "bottle");
    variables.put("description", this.getDescription());
  }

  @Override
  public void use(GameChar character, MemorySlot memory,
      Map<String, Object> variables) {

    List<Integer> rolls = Dice.roll(3);

    int sum = Dice.sum(rolls);

    if (sum == 6) {
      // changing for ease of use
      character.modSpeed(3);
      character.modMight(2);
    } else if (sum == 5) {
      character.modSpeed(2);
      character.modMight(2);
    } else if (sum == 4) {
      character.modKnowlege(2);
      character.modSanity(2);
    } else if (sum == 3) {
      character.modKnowlege(1);
      character.modMight(-1);
    } else if (sum == 2) {
      character.modKnowlege(-2);
      character.modSanity(-2);
    } else if (sum == 1) {
      character.modSpeed(-2);
      character.modMight(-2);
    } else {
      character.modSpeed(-2);
      character.modMight(-2);
      character.modKnowlege(-2);
      character.modSanity(-2);
    }
    variables.put("item", "bottle");
    variables.put("description", this.getDescription());
    variables.put("knowledge", character.getKnowlege());
    variables.put("might", character.getMight());
    variables.put("sanity", character.getSanity());
    variables.put("speed", character.getSpeed());
  }

  @Override
  public void loss(GameChar character, Map<String, Object> variables) {
    character.removeItem(this);
    variables.put("item", "bottle");
    variables.put("description", this.getDescription());
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
