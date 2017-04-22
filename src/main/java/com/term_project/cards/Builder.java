package com.term_project.cards;

import java.util.List;
/**
 * Interface for building a random ordered deck of the type of card passed in.
 * 
 * @author jfacey
 *
 * @param <V> what type is being built in the deck
 */
public interface Builder<V> {

	/**
	 * Method to build a random ordered deck and return it.
	 * 
	 * @return the deck of the type passed in as a list
	 */
	List<V> buildDeck();
}