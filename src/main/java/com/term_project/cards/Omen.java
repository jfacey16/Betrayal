package com.term_project.cards;

import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;

/**
 * Interface that outlines what methods an omen needs.
 *
 * @author Zachary Hoffman
 *
 */
public interface Omen {
  /**
   * Return's the description of the omen.
   *
   * @return A description of the omen.
   *
   */
  String getDescription();

  /**
   * Return's the name of the omen.
   *
   * @return the name of the omen
   */
  String getName();

  /**
   * Called on the pickup of an omen, producing the effect of the omen
   */
  void add(GameChar character, Map<String, Object> variables);

  /**
   * Uses the item producing the effect described in the description on a
   * character/die amount/gamestate.
   *
   */
  void use(GameChar character, MemorySlot memory,
      Map<String, Object> variables);

  /**
   * Called on loss of an omen, losing the effect of that omen
   *
   */
  void loss(GameChar character, Map<String, Object> variables);
}
