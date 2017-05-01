package com.term_project.omens;

import java.util.List;
import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.game.Dice;
import com.term_project.system.MemorySlot;

public class Mask implements Omen {

  private String name;
  private String description;
  private String function;
  // if this is true the mask is off
  // i know this is confusing but i had to cause future
  private boolean maskOff;

  public Mask() {
    name = "Mask";
    description = "A somber mask to hide your intentions.";
    function = "Once during your turn, you can attempt a "
        + "Sanity roll to use the Mask:\n4+ You can put on or"
        + "take off the Mask.\nIf you put on the Mask, gain "
        + "2 Knowledge and lose 2 Sanity.\nIf you take off "
        + "the Mask, gain 2 Sanity and lose 2 Knowledge.\n0-3 "
        + "You can't use the Mask this turn.";
    maskOff = true;
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
    character.addOmen(this);
  }

  @Override
  public void use(GameChar character, MemorySlot memory,
      Map<String, Object> variables) {

    List<Integer> rolls = Dice.roll(character.getSanity());

    int roll = Dice.sum(rolls);

    if (roll >= 4) {
      if (maskOff) {
        character.modKnowlege(2);
        character.modSanity(-2);
        maskOff = false;
      } else {
        character.modKnowlege(-2);
        character.modSanity(2);
        maskOff = true;
      }
    }
    variables.put("rolls", rolls);
  }

  @Override
  public void loss(GameChar character) {
    character.removeOmen(this);
    character.getTile().addOmen(this);
  }

  @Override
  public boolean equals(Object object) {
    if (object == this)
      return true;
    if (!(object instanceof Mask)) {
      return false;
    }

    return this.getName().equals(((Mask) object).getName());
  }

  @Override
  public int hashCode() {
    return this.getName().hashCode();
  }
}