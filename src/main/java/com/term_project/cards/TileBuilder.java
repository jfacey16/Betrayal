package com.term_project.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.term_project.house.Direction;
import com.term_project.house.EmptyTile;
import com.term_project.house.Floor;
import com.term_project.house.GenericTile;
import com.term_project.house.Tile;

public class TileBuilder implements Builder<Tile> {

private static int DECK_LENGTH = 10;
	
	@Override
	public Queue<Tile> buildDeck() {
		List<Tile> tileList = new ArrayList<>();
		
		Map<Direction, Tile> connectedTiles = new HashMap<>();
		connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
		connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
		
		List<Floor> availableFloors = new ArrayList<>();
		availableFloors.add(Floor.ATTIC);
		availableFloors.add(Floor.BASEMENT);
		availableFloors.add(Floor.GROUND);
		
		tileList.add(new GenericTile(connectedTiles, availableFloors));
		
		connectedTiles = new HashMap<>();
		connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
		connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
		
		availableFloors = new ArrayList<>();
		availableFloors.add(Floor.ATTIC);
		availableFloors.add(Floor.BASEMENT);
		availableFloors.add(Floor.GROUND);
		
		tileList.add(new GenericTile(connectedTiles, availableFloors));
		
		
		Collections.shuffle(tileList);
		Queue<Tile> tileDeck = new LinkedList<>(tileList);
		return tileDeck;
	}
}
