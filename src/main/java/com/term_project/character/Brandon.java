package com.term_project.character;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jfacey
 *
 */
public class Brandon extends AbstractChar implements GameChar {

  /**
   *
   */
  public Brandon() {
    this.setMight(3);
    this.setSpeed(2);
    this.setKnowlege(2);
    this.setSanity(3);
    // scales are of size 8. Death when index falls below 0
    this.setMightScale(buildMightScale());
    this.setSpeedScale(buildSpeedScale());
    this.setKnowledgeScale(buildKnowledgeScale());
    this.setSanityScale(buildSanityScale());
  }

  private List<Integer> buildMightScale() {
    List<Integer> mightList = new ArrayList<>();
    mightList.add(2);
    mightList.add(3);
    mightList.add(3);
    mightList.add(4);
    mightList.add(5);
    mightList.add(6);
    mightList.add(6);
    mightList.add(7);
    return mightList;
  }

  private List<Integer> buildSpeedScale() {
    List<Integer> speedList = new ArrayList<>();
    speedList.add(3);
    speedList.add(4);
    speedList.add(4);
    speedList.add(4);
    speedList.add(5);
    speedList.add(6);
    speedList.add(7);
    speedList.add(8);
    return speedList;
  }

  private List<Integer> buildKnowledgeScale() {
    List<Integer> knowledgeList = new ArrayList<>();
    knowledgeList.add(1);
    knowledgeList.add(3);
    knowledgeList.add(3);
    knowledgeList.add(5);
    knowledgeList.add(5);
    knowledgeList.add(6);
    knowledgeList.add(6);
    knowledgeList.add(7);
    return knowledgeList;
  }

  private List<Integer> buildSanityScale() {
    List<Integer> sanityList = new ArrayList<>();
    sanityList.add(3);
    sanityList.add(3);
    sanityList.add(3);
    sanityList.add(4);
    sanityList.add(5);
    sanityList.add(6);
    sanityList.add(7);
    sanityList.add(8);
    return sanityList;
  }

  @Override
  public String getName() {
    return "Brandon Jaspers";
  }

  @Override
  public String getDescription() {
    // TODO Auto-generated method stub
    return null;
  }
}