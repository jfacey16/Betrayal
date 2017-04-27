package com.term_project.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ItemsBuilder implements Builder<Item> {

	@Override
	public Queue<Item> buildDeck() {
		List<Item> itemList = new ArrayList<>();
		
		itemList.add(new ExampleItem());
		
		Collections.shuffle(itemList);
		Queue<Item> itemDeck = new LinkedList<>(itemList);
		
		return itemDeck;
	}
}
