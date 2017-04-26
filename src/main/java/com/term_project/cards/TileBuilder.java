package com.term_project.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.term_project.house.Tile;

public class TileBuilder implements Builder<Tile> {

private static int DECK_LENGTH = 10;
	
	@Override
	public Queue<Tile> buildDeck() {
		Queue<Tile> tileDeck = new LinkedList<>();
		List<Integer> range = IntStream.rangeClosed(0, DECK_LENGTH)
			    .boxed().collect(Collectors.toList());
		Collections.shuffle(range);
		
		for (int i = 0; i < DECK_LENGTH; i++) {
			// TODO: build each tile and add to deck
		}
		return tileDeck;
	}
}
