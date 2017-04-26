package com.term_project.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EventsBuilder implements Builder<Event> {
	
	private static int DECK_LENGTH = 10;
	
	@Override
	public Queue<Event> buildDeck() {
		Queue<Event> eventDeck = new LinkedList<>();
		List<Integer> range = IntStream.rangeClosed(0, DECK_LENGTH)
			    .boxed().collect(Collectors.toList());
		Collections.shuffle(range);
		
		for (int i = 0; i < DECK_LENGTH; i++) {
			// TODO: build each event and add to deck
		}
		return eventDeck;
	}
}
