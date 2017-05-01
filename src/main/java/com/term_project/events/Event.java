package com.term_project.events;
import com.term_project.character.GameChar;
import com.term_project.game.Stats;

import java.util.List;

/**
 * Interface that outlines what methods an event needs.
 *
 * @author Zachary Hoffman
 */
public interface Event {

	/** Return's the description of the event.
   * @return The event's name.
   *
   */
  String getName();

  /** Return's the description of the event.
   * @return A description of the event.
   *
   */
  String getDescription();

  /** Return's the usable stats for this event.
   * @return List of usable stats.
   *
   */
  List<Stats> getUsable();

  /** Return's the usable stats for this event.
   * @return List of usable stats as strings.
   *
   */
  List<String> getUsableAsString();

  /** Produces the effect described in the description
   * on a character/die amount/gamestate.
   * @return The result of the event.
   */
   String apply(int roll, GameChar character);
}
