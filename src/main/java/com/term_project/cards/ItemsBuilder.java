package com.term_project.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ItemsBuilder implements Builder<Item> {

private static int DECK_LENGTH = 10;
	
	@Override
	public Queue<Item> buildDeck() {
		Queue<Item> itemDeck = new LinkedList<>();
		itemDeck.add(new ExampleItem());
		return itemDeck;
	}
}
