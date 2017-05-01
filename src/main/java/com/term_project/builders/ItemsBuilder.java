package com.term_project.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.term_project.items.Bottle;
import com.term_project.items.Cat;
import com.term_project.items.Item;
import com.term_project.items.ItemFour;
import com.term_project.items.MysticCoin;
import com.term_project.items.Rock;

public class ItemsBuilder implements Builder<Item> {

  @Override
  public Queue<Item> build() {
    List<Item> itemList = new ArrayList<>();

    itemList.add(new MysticCoin());
    itemList.add(new Cat());
    itemList.add(new Rock());
    itemList.add(new ItemFour());
    itemList.add(new Bottle());

    Collections.shuffle(itemList);
    Queue<Item> itemDeck = new LinkedList<>(itemList);

    return itemDeck;
  }
}
