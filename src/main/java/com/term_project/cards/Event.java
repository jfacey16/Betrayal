package com.term_project.cards;


/**
 * Interface that outlines what methods an event needs.
 *
 * @author Zachary Hoffman
 * @param <Effected> What the event must modify or effect.
 */
public interface Event<Effected> {
  /** Return's the description of the event.
   * @return A description of the event.
   *
   */
  String getDescription();

  /** Produces the effect described in the description
   * on a character/die amount/gamestate.
   *
   */
   void apply(int roll, Effected effected);
}
