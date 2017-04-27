package com.term_project.house;
import com.term_project.cards.Event;
import com.term_project.cards.Item;
import com.term_project.cards.Omen;
import com.term_project.character.GameChar;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
/**
 * Tile representing open slot for a tile to be placed.
 *
 * @author Zachary Hoffman
 */

public class EmptyTile extends AbstractTile implements Tile {
  public EmptyTile(Map<Direction, Tile> connectedTiles) {
    super(connectedTiles,
    	  0,
    	  0,
    	  0,
          new ArrayList<>());
  }

  @Override
  public String getName() {
    return "Empty";
  }

  @Override
  public String getDescription() {
    return "Nothing here yet";
  }

  @Override
  public void enter(GameChar affected) {
    return;
  }

  @Override
  public void exit(GameChar affected) {
    return;
  }

  @Override
  public void apply(GameChar affected) {
    return;
  }
}
