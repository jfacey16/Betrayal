package com.term_project.items;

import java.util.List;
import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.game.Dice;
import com.term_project.system.MemorySlot;

public class MysticCoin implements Item {

  public MysticCoin() {

  }

  @Override
  public String getDescription() {
    return "Heads or Tails?";
  }

  @Override
  public void add(GameChar character, Map<String, Object> variables) {
    character.addItem(this);
    variables.put("item", "mystic coin");
    variables.put("description", this.getDescription());
    variables.put("knowledge", character.getKnowlege());
    variables.put("might", character.getMight());
    variables.put("sanity", character.getSanity());
    variables.put("speed", character.getSpeed());
  }

  @Override
  public void use(GameChar character, MemorySlot memory,
      Map<String, Object> variables) {
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

    variables.put("roll", roll);
    variables.put("might", character.getMight());
    variables.put("knowlege", character.getKnowlege());
  }

  @Override
  public void loss(GameChar character, Map<String, Object> variables) {
    character.removeItem(this);
    character.getTile().addItem(this);
    variables.put("item", "mystic coin");
    variables.put("description", this.getDescription());
    variables.put("knowledge", character.getKnowlege());
    variables.put("might", character.getMight());
    variables.put("sanity", character.getSanity());
    variables.put("speed", character.getSpeed());
  }

  @Override
  public String getName() {
    return "Mystic Coin";
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
