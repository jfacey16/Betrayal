package com.term_project.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OmensBuilder implements Builder<Omen> {

	@Override
	public Queue<Omen> buildDeck() {
		List<Omen> omenList = new ArrayList<>();
		
		omenList.add(new ExampleOmen());
		
		Collections.shuffle(omenList);
		Queue<Omen> omenDeck = new LinkedList<>(omenList);
		return omenDeck;
	}
}
