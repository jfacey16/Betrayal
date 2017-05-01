package com.term_project.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.term_project.events.BurningMan;
import com.term_project.events.CreepyCrawlies;
import com.term_project.events.Event;
import com.term_project.events.Funeral;
import com.term_project.events.ShriekingWind;
import com.term_project.events.Silence;
import com.term_project.events.SomethingSlimey;
import com.term_project.events.Spider;
import com.term_project.game.Stats;

public class EventsBuilder implements Builder<Event> {

  @Override
  public Queue<Event> build() {
    List<Event> eventList = new ArrayList<>();

    String name = "Spider";
    String description = "A spider the size of a fist lands "
        + "on your shoulder and crawls into your hair.";
    String function = "You must attempt a Speed roll to brush "
        + "it away or a Sanity roll to stand still:\n4+ It's "
        + "gone. Gain 1 Speed.\n1-3 It bites you. Take 1 "
        + "Speed damage.\n0 It takes a chunk out of you. Take 2 Speed damage.";
    List<Stats> stats = new ArrayList<>();
    stats.add(Stats.SPEED);
    stats.add(Stats.SANITY);
    eventList.add(new Spider(name, description, function, stats));

    name = "Burning Man";
    description = "A man on fire runs through the room. His skin bubbles and cracks, "
        + "falling away from him and leaving a fiery skull that clatters to the "
        + "ground, bounces, rolls, and disappears.";
    function = "You must attempt a Sanity roll:\n4+ You feel a little "
        + "hot under the collar, but otherwise fine. Gain 1 Sanity.\n2-3The "
        + "fire burns, but you can stand the heat.\n0-1 You burst into flames! "
        + "Take 2 Sanity damage.";
    stats = new ArrayList<>();
    stats.add(Stats.SANITY);
    eventList.add(new BurningMan(name, description, function, stats));

    name = "Creepy Crawlies";
    description = "A thousand bugs spill out on your skin, under your clothes, and in your hair.";
    function = "You must attempt a Sanity roll:\n5+ You blink and they're gone. Gain 1 Sanity."
        + "\n1-4 Lose 1 Sanity.\n0 Lose 2 Sanity.";
    eventList.add(new CreepyCrawlies(name, description, function, stats));

    name = "Funeral";
    description = "You see an open coffin. You're inside it.";
    function = "You must attempt a Sanity roll:\n4+ You blink and its gone. "
        + "Gain 1 Sanity.\n2-3 The vision disturbs you. Lose 1 Sanity.\n0-1 "
        + "You're really in that coffin. Lose 1 Sanity and 1 Might.";
    eventList.add(new Funeral(name, description, function, stats));

    name = "ShriekingWind";
    description = "The wind picks up, a slow crescendo to a screeching howl.";
    function = "You must attempt a Might roll:\n5+ You keep your footing.\n3-4 "
        + "The wind knocks you down. Take 1 Might damage\n0-2 The wind chills "
        + "your soul. Take 1 Sanity damage.";
    stats = new ArrayList<>();
    stats.add(Stats.MIGHT);
    eventList.add(new ShriekingWind(name, description, function, stats));

    name = "Silence";
    description = "Underground, everything goes silent. Even the sound of breathing is gone.";
    function = "You must attempt a Sanity roll:\n4+ You wait calmly for your hearing to "
        + "return.\n1-3 You scream a silent scream. Take 1 Knowledge damage.\n0 You freak out. "
        + "Take 2 Knowledge damage.";
    stats = new ArrayList<>();
    stats.add(Stats.SANITY);
    eventList.add(new Silence(name, description, function, stats));

    name = "Something Slimey";
    description = "What's around your ankle? A bug? A tentacle? A dead hand clawing?";
    function = "You must attempt a Speed roll:\n4+ You break free. Gain 1 Speed"
        + ".\n1-3 Lose 1 Might.\n0 Lose 1 Might and 1 Speed.";
    stats = new ArrayList<>();
    eventList.add(new SomethingSlimey(name, description, function, stats));

    Collections.shuffle(eventList);
    Queue<Event> eventDeck = new LinkedList<>(eventList);
    return eventDeck;
  }
}
