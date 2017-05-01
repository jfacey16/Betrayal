package com.term_project.items;

import java.util.List;

import com.term_project.character.GameChar;
import com.term_project.game.Dice;
import com.term_project.system.MemorySlot;

public class MysticCoin implements Item {

  private String name;
  private String description;
  private String function;

  public MysticCoin() {
    name = "Mystic Coin";
    description = "Heads or Tails?";
    function = "Once during your turn, you can roll 1 die to flip the "
        + "coin:\n2 It's heads. Gain 1 point in Might.\n1 It's tails. "
        + "Gain 1 point in Knowledge.\n0 It landed on its edge! Lose "
        + "1 point in Might and 1 in Knowledge.";
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
  public void add(GameChar character) {
    character.addItem(this);
  }

  @Override
  public void use(GameChar character, MemorySlot memory) {
    List<Integer> rolls = Dice.roll(1);

    int roll = rolls.get(0);

    if (roll == 2) {

      character.modMight(1);

    } else if (roll == 1) {

      character.modKnowlege(1);

    } else if (roll == 0) {

      character.modMight(-1);
      character.modKnowlege(-1);
    }
  }

  @Override
  public void loss(GameChar character) {
    character.removeItem(this);
    character.getTile().addItem(this);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object object) {
    if (object == this)
      return true;
    if (!(object instanceof MysticCoin)) {
      return false;
    }

    return this.getName().equals(((MysticCoin) object).getName());
  }

  @Override
  public int hashCode() {
    return this.getName().hashCode();
  }
}
