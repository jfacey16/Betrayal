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

  /** Uses the item producing the effect described in the description
   * on a character/die amount/gamestate.
   *
   */
   void use();
   
   /** Called on loss of an omen, producing the effect of that omen
   *
   */
   void loss();
}
