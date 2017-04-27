package com.term_project.cards;

/**
 * Interface that outlines what methods an item needs.
 *
 * @author Zachary Hoffman
 */
public interface Item {
  /** Return's the description of the item.
   * @return A description of the item.
   *
   */
  String getDescription();
  
  /**
   * Called on the pickup of an item, producing the effect of the item
   */
   void add();
   
  /** Uses the item producing the effect described in the description
   * on a character/die amount/gamestate.
   *
   */
   void use();
   
   /** Called on loss of an item, lossing the effect of that omen
   *
   */
   void loss();
}
