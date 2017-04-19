package com.term_project.cards;

/**
 * Interface that outlines what methods an event needs.
 *
 * @author Zachary Hoffman
 */
public interface Event {
  /** Return's the description of the event.
   * @return A description of the event.
   *
   */
  String getDescription();

  /** Produces the effect described in the description
   * on a character/die amount/gamestate.
   *
   */
   void apply(int roll);
}
