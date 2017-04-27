package com.term_project.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EventsBuilder implements Builder<Event> {
	
	@Override
	public Queue<Event> buildDeck() {
		Queue<Event> eventDeck = new LinkedList<>();
		eventDeck.add(new ExampleEvent());
		return eventDeck;
	}
}
