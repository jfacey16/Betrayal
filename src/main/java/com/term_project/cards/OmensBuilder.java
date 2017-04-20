package com.term_project.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OmensBuilder implements Builder<Omen> {

private static int DECK_LENGTH = 10;
	
	@Override
	public List<Omen> buildDeck() {
		List<Omen> omenDeck = new ArrayList<>();
		List<Integer> range = IntStream.rangeClosed(0, DECK_LENGTH)
			    .boxed().collect(Collectors.toList());
		Collections.shuffle(range);
		
		for (int i = 0; i < DECK_LENGTH; i++) {
			// TODO: build each omen and add to deck
		}
		return omenDeck;
	}
}
