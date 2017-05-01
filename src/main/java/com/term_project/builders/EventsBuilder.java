package com.term_project.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.term_project.events.Event;

public class EventsBuilder implements Builder<Event> {

  @Override
  public Queue<Event> build() {
    List<Event> eventList = new ArrayList<>();
    /*
     * eventList.add(new ExampleEvent()); eventList.add(new EventTwo());
     * eventList.add(new EventThree()); eventList.add(new EventFour());
     * eventList.add(new EventFive());
     */

    Collections.shuffle(eventList);
    Queue<Event> eventDeck = new LinkedList<>(eventList);
    return eventDeck;
  }
}
