package com.term_project.items;

import java.util.List;

import com.term_project.character.GameChar;
import com.term_project.game.Dice;
import com.term_project.system.MemorySlot;

public class Bottle implements Item {

  private String name;
  private String description;
  private String function;

  public Bottle() {
    name = "Bottle";
    description = "An opaque vial containing a black liquid";
    function = "Once during your turn while the haunt is revealed, "
        + "you can roll 3 dice and drink from the Bottle:\n6 "
        + "Gain 2 Might and 3 Speed.\n5 Gain 2 Might and 2 "
        + "Speed.\n4 Gain 2 Knowledge and 2 Sanity.\n3 Gain "
        + "1 Knowledge and lose 1 Might.\n2 Lose 2 Knowledge "
        + "and 2 Sanity.\n1 Lose 2 Might and 2 Speed.\n0 Lose "
        + "2 from each trait.";
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
  public void use(GameChar character, MemorySlot memory) {

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
  }

  @Override
  public void loss(GameChar character) {
    character.removeItem(this);
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
