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
		List<Event> eventList = new ArrayList<>();
		/*
		eventList.add(new ExampleEvent());
		eventList.add(new EventTwo());
		eventList.add(new EventThree());
		eventList.add(new EventFour());
		eventList.add(new EventFive());
		*/

		Collections.shuffle(eventList);
		Queue<Event> eventDeck = new LinkedList<>(eventList);
		return eventDeck;
	}
}
