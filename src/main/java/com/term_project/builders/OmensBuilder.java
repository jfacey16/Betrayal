package com.term_project.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.term_project.omens.ExampleOmen;
import com.term_project.omens.Omen;
import com.term_project.omens.OmenFive;
import com.term_project.omens.OmenFour;
import com.term_project.omens.OmenThree;
import com.term_project.omens.OmenTwo;

public class OmensBuilder implements Builder<Omen> {

  @Override
  public Queue<Omen> build() {
    List<Omen> omenList = new ArrayList<>();

    omenList.add(new ExampleOmen());
    omenList.add(new OmenTwo());
    omenList.add(new OmenThree());
    omenList.add(new OmenFour());
    omenList.add(new OmenFive());

    Collections.shuffle(omenList);
    Queue<Omen> omenDeck = new LinkedList<>(omenList);
    return omenDeck;
  }
}
