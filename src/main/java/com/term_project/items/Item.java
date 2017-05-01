package com.term_project.items;

import java.util.Map;

import com.term_project.character.GameChar;
import com.term_project.system.MemorySlot;

/**
 * Interface that outlines what methods an item needs.
 *
 * @author Zachary Hoffman
 */
public interface Item {
  /**
   * Return's the description of the item.
   *
   * @return A description of the item.
   *
   */
  String getDescription();

  /**
   * Return's the name of the item.
   *
   * @return the name of the item
   */
  String getName();

  /**
   * Called on the pickup of an item, producing the effect of the item
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
   * Called on loss of an item, lossing the effect of that item
   *
   */
  void loss(GameChar character, Map<String, Object> variables);
}
