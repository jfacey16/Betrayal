package com.term_project.character;

import java.util.List;
import java.util.Map;

import com.term_project.house.Tile;
import com.term_project.items.Item;
import com.term_project.omens.Omen;

public class Cultist implements GameChar {

  private int might;
  private int speed;
  private int knowledge;
  private int sanity;
  private Tile currentTile;
  private Map<String, Item> items;
  private Map<String, Omen> omens;

  public Cultist() {

  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getDescription() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Tile getTile() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Item getItem(String item) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Omen getOmen(String omen) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getMight() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getSpeed() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getKnowlege() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getSanity() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void setMight(int might) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setSpeed(int speed) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setKnowlege(int knowledge) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setSanity(int sanity) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setTile(Tile newTile) {
    // TODO Auto-generated method stub

  }

  @Override
  public int modMight(int mightModifier) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int modSpeed(int speedModifier) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int modKnowlege(int knowledgeModifier) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int modSanity(int sanityModifier) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void addItem(Item item) {
    // TODO Auto-generated method stub

  }

  @Override
  public void addOmen(Omen omen) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removeItem(Item item) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removeOmen(Omen omen) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setMightScale(List<Integer> mightScale) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setSpeedScale(List<Integer> speedScale) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setKnowledgeScale(List<Integer> knowledgeScale) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setSanityScale(List<Integer> sanityScale) {
    // TODO Auto-generated method stub

  }

  @Override
  public int getStatByName(String name) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public CharBean getCharBean() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Map<String, Item> getItems() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Map<String, Omen> getOmens() {
    // TODO Auto-generated method stub
    return null;
  }
}
