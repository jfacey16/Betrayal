package com.term_project.omens;

import java.util.List;
import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.game.Dice;
import com.term_project.system.MemorySlot;

public class CrystalBall implements Omen {

  private String name;
  private String description;
  private String function;

  public CrystalBall() {
    name = "Crystal Ball";
    description = "Hazy images appear in the glass.";
    function = "Once during your turn, you can attempt a "
        + "Knowledge roll to peer into the Crystal Ball"
        + ":\n4+ You see the truth. Gain 1 Sanity.\n1-3 "
        + "You avert your eyes. Lose 1 Sanity.\n0 You "
        + "stare into hell. Lose 2 Sanity.";
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
    character.addOmen(this);
  }

  @Override
  public void use(GameChar character, MemorySlot memory,
      Map<String, Object> variables) {
    List<Integer> rolls = Dice.roll(character.getKnowlege());

    int roll = Dice.sum(rolls);

    if (roll >= 4) {
      character.modSanity(1);
    } else if (roll < 4 && roll > 0) {
      character.modSanity(-1);
    } else {
      character.modSanity(-2);
    }
    variables.put("rolls", rolls);
  }

  @Override
  public void loss(GameChar character) {
    character.removeOmen(this);
    character.getTile().addOmen(this);
  }
}
