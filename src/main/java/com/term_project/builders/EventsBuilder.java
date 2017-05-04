package com.term_project.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.term_project.events.AngryBeing;
import com.term_project.events.BloodyVision;
import com.term_project.events.BurningMan;
import com.term_project.events.CreepyCrawlies;
import com.term_project.events.Debris;
import com.term_project.events.Event;
import com.term_project.events.Footsteps;
import com.term_project.events.Funeral;
import com.term_project.events.HideousShriek;
import com.term_project.events.Mist;
import com.term_project.events.NightView;
import com.term_project.events.PhoneCall;
import com.term_project.events.Rotten;
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

    name = "Phone Call";
    description = "A phone rings in the room. You feel compelled to answer it.";
    function = "Roll 2 dice. A sweet little granny voice says:\n4 'Tea and cakes"
        + "!' Gain 1 Sanity.\n3 'I'm always here for you. Watching...' Gain "
        + "1 Knowledge.\n1-2 I'm here! Give us a kiss! Take 1 Sanity damage.\n"
        + "0 'Bad little children must be punished!' Take 1 Might and 1 Speed damage.";
    eventList.add(new PhoneCall(name, description, function, stats));

    name = "Debris";
    description = "Plaster falls from the walls and ceiling";
    function = "You must attempt a Speed roll:\n3+ You dodge "
        + "the plaster. Gain 1 Speed.\n1-2 You're buried in "
        + "debris. Take 1 Might Damage.\n0 You're buried in "
        + "debris. Take 2 Might Damage.";
    stats.add(Stats.SPEED);
    eventList.add(new Debris(name, description, function, stats));

    Collections.shuffle(eventList);

    name = "Bloody Vision";
    description = "The walls of this room are damp with blood. The blood drips "
        + "from the ceiling, down the walls, over the furniture, and onto your "
        + "shoes. In a blink, it is gone.";
    function = "You must attempt a Sanity roll:\n4+ You steel yourself. Gain 1 "
        + "Sanity.\n2-3 Lose 1 Sanity.\n0-1 Lose 2 Sanity.";
    stats = new ArrayList<>();
    stats.add(Stats.SANITY);
    eventList.add(new BloodyVision(name, description, function, stats));

    name = "Angry Being";
    description = "It emerges from the slime on the wall next to you.";
    function = "You must attempt a Speed roll:\n5+ You get away. Gain "
        + "1 Speed.\n2-4 Take 1 Sanity damage.\n0-1 Take 1 Sanity "
        + "damage and 1 Speed damage.";
    stats = new ArrayList<>();
    stats.add(Stats.SPEED);
    eventList.add(new AngryBeing(name, description, function, stats));

    name = "Night View";
    description = "You see a vision of a ghostly couple walking the "
        + "grounds silently strolling in their wedding best.";
    function = "You must attempt a Knowledge roll:\n5+ You recognize the "
        + "ghosts as former inhabitants of the house. "
        + "You call their names, and they turn to you, whispering dark "
        + "secrets of the house. Gain 1 Knowledge.\n0-4 You pull back "
        + "in horror, unable to watch";
    stats = new ArrayList<>();
    stats.add(Stats.KNOWLEGE);
    eventList.add(new NightView(name, description, function, stats));

    name = "Rotten";
    description = "The smell in this room, it's horrible. "
        + "Smells like death, like blood. A slaughterhouse smell.";
    function = "You must attempt a Sanity roll:\n5+ Troubling odors, "
        + "nothing more. Gain 1 Sanity.\n2-4 Lose 1 Might.\n1 Lose "
        + "1 Might and 1 Speed.\n0 You double over with nausea. "
        + "Lose 1 Might, 1 Speed, 1 Sanity, and 1 Knowledge.";
    stats = new ArrayList<>();
    stats.add(Stats.SANITY);
    eventList.add(new Rotten(name, description, function, stats));

    name = "Hideous Shriek";
    description = "It starts like a whisper, but ends in a soul-rending shriek.";
    function = "You must attempt a Sanity roll:\n4+ You resist the sound.\n1-3"
        + " Take 1 Sanity damage.\n0 Take 2 Sanity damage.";
    eventList.add(new HideousShriek(name, description, function, stats));

    name = "Footsteps";
    description = "The footsteps slowly creak. Dust rises. Footprints appear "
        + "on the dirty flor. And then, as they reach you, they are gone.";
    function = "Roll 2 dice.\n3-4 Gain 1 Might.\n2 Lose 1 Sanity.\n1 Lose 1 Speed.\n0 Lose 1 Might.";
    stats = new ArrayList<>();
    eventList.add(new Footsteps(name, description, function, stats));

    name = "Mist From the Walls";
    description = "Mists pour out from the walls. There are faces in the mist, human and ... inhuman. ";
    function = "You must attempt a Sanity roll:\n4+ The faces are tricks of light and shadow. "
        + "All is well.\n1-3 Take 1 Sanity damage.\n0 Take 2 Sanity damage.";
    stats.add(Stats.SANITY);
    eventList.add(new Mist(name, description, function, stats));

    Queue<Event> eventDeck = new LinkedList<>(eventList);
    return eventDeck;
  }
}
