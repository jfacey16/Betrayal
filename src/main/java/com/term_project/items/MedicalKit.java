package com.term_project.items;

import java.util.List;
import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.game.Dice;
import com.term_project.system.MemorySlot;

public class MedicalKit implements Item {

  private String name;
  private String description;
  private String function;

  public MedicalKit() {
    name = "Medical Kit";
    description = "A doctor's bag, depleted in some critical resources.";
    function = "Once during your turn, you can attempt a Knowledge roll "
        + "to heal yourself.\n8+ Gain 1 Might and 1 Speed.\n6-7 Gain 1 "
        + "Might.\n4-5 Gain 1 Speed.\n0-3 Nothing happens.";
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
  public void use(GameChar character, MemorySlot memory,
      Map<String, Object> variables) {
    List<Integer> rolls = Dice.roll(character.getKnowlege());

    int roll = Dice.sum(rolls);

    if (roll >= 8) {
      character.modMight(1);
      character.modSpeed(1);
    } else if (roll < 8 && roll > 5) {
      character.modMight(1);
    } else if (roll < 5 && roll > 3) {
      character.modSpeed(1);
    }
    variables.put("rolls", rolls);
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
    if (!(object instanceof MedicalKit)) {
      return false;
    }

    return this.getName().equals(((MedicalKit) object).getName());
  }

  @Override
  public int hashCode() {
    return this.getName().hashCode();
  }
}
