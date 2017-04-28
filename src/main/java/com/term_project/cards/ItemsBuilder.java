package com.term_project.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ItemsBuilder implements Builder<Item> {

  @Override
  public Queue<Item> buildDeck() {
    List<Item> itemList = new ArrayList<>();

    itemList.add(new MysticCoin());
    itemList.add(new Cat());
    itemList.add(new Rock());
    itemList.add(new ItemFour());
    itemList.add(new ItemFive());

    Collections.shuffle(itemList);
    Queue<Item> itemDeck = new LinkedList<>(itemList);

    return itemDeck;
  }
}
