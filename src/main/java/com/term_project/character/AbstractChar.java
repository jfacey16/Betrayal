package com.term_project.character;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.term_project.cards.Item;
import com.term_project.cards.Omen;
import com.term_project.house.Tile;

public abstract class AbstractChar implements GameChar {
  private int might;
  private int speed;
  private int knowledge;
  private int sanity;
  private List<Integer> mightScale;
  private List<Integer> speedScale;
  private List<Integer> knowledgeScale;
  private List<Integer> sanityScale;
  private Tile currentTile;
  private Map<String, Item> items;
  private Map<String, Omen> omens;

  public AbstractChar() {

    // need an example tile
    currentTile = null;
    items = new HashMap<>();
    omens = new HashMap<>();
  }

  @Override
  public Tile getTile() {
    return currentTile;
  }

  @Override
  public int getMight() {
    return mightScale.get(might);
  }

  @Override
  public int getSpeed() {
    return speedScale.get(speed);
  }

  @Override
  public int getKnowlege() {
    return knowledgeScale.get(knowledge);
  }

  @Override
  public int getSanity() {
    return sanityScale.get(sanity);
  }

  @Override
  public void setMight(int might) {
    this.might = might;
  }

  @Override
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  @Override
  public void setKnowlege(int knowledge) {
    this.knowledge = knowledge;
  }

  @Override
  public void setSanity(int sanity) {
    this.sanity = sanity;
  }

  @Override
  public void setTile(Tile newTile) {
    currentTile = newTile;
  }

  @Override
  public int modMight(int mightModifier) {
    might = might + mightModifier;
    // cap of might
    if (might > 7) {
      might = 7;
    }
    int tempMight = might;
    if (might < 0) {
      might = 0;
    }
    if (tempMight < 0) {
      return tempMight;
    } else {
      return mightScale.get(might);
    }

  }

  @Override
  public int modSpeed(int speedModifier) {
    speed = speed + speedModifier;
    // cap of speed
    if (speed > 7) {
      speed = 7;
    }
    int tempSpeed = 0;
    if (speed < 0) {
      speed = 0;
    }
    if (tempSpeed < 0) {
      return tempSpeed;
    } else {
      return speedScale.get(speed);
    }
  }

  @Override
  public int modKnowlege(int knowledgeModifier) {
    knowledge = knowledge + knowledgeModifier;
    // cap of knowledge
    if (knowledge > 7) {
      knowledge = 7;
    }
    int tempKnowledge = 0;
    if (knowledge < 0) {
      knowledge = 0;
    }
    if (tempKnowledge < 0) {
      return tempKnowledge;
    } else {
      return knowledgeScale.get(knowledge);
    }
  }

  @Override
  public int modSanity(int sanityModifier) {
    sanity = sanity + sanityModifier;
    // cap of sanity
    if (sanity > 7) {
      sanity = 7;
    }
    int tempSanity = sanity;
    if (sanity < 0) {
      sanity = 0;
    }
    if (tempSanity < 0) {
      return tempSanity;
    } else {
      return sanityScale.get(sanity);
    }
  }

  @Override
  public void addItem(Item item) {
    items.put(item.getName(), item);
  }

  @Override
  public void addOmen(Omen omen) {
    omens.put(omen.getName(), omen);
  }

  @Override
  public void removeItem(Item item) {
    items.remove(item);
  }

  @Override
  public void removeOmen(Omen omen) {
    omens.remove(omen);
  }

  @Override
  public Item getItem(String itemName) {
    return items.get(itemName);
  }

  @Override
  public Omen getOmen(String omenName) {
    return omens.get(omenName);
  }

  @Override
  public void setMightScale(List<Integer> mightScale) {
    this.mightScale = mightScale;
  }

  @Override
  public void setSpeedScale(List<Integer> speedScale) {
    this.speedScale = speedScale;
  }

  @Override
  public void setKnowledgeScale(List<Integer> knowledgeScale) {
    this.knowledgeScale = knowledgeScale;
  }

  @Override
  public void setSanityScale(List<Integer> sanityScale) {
    this.sanityScale = sanityScale;
  }

  @Override
	public int getStatByName(String name) {
		switch (name) {
			case "MIGHT":
				return getMight();

			case "SPEED":
        return getSpeed();

			case "SANITY":
        return getSanity();

			case "KNOWLEDGE":
        return getKnowlege();

			default:
				throw new NullPointerException("Given stat " + name + " doesn't exist.");
		}
	}
}
