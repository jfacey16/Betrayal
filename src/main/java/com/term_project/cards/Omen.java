package com.term_project.cards;

/**
 * Interface that outlines what methods an omen needs.
 *
 * @author Zachary Hoffman

 */
public interface Omen {
  /** Return's the description of the omen.
   * @return A description of the omen.
   *
   */
  String getDescription();

  /** Produces the effect described in the description
   * on a character/die amount/gamestate.
   *
   */
   void apply();

   /** Called on loss of an omen, producing the effect of that omen
    *
    */
    void loss();
}
