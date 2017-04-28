package com.term_project.cards;

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
}
