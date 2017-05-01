package com.term_project.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.term_project.house.Direction;
import com.term_project.house.EmptyTile;
import com.term_project.house.Floor;
import com.term_project.house.GenericTile;
import com.term_project.house.Tile;

public class TileBuilder implements Builder<Tile> {

  @Override
  public Queue<Tile> build() {
    List<Tile> tileList = new ArrayList<>();

    Map<Direction, Tile> connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));

    List<Floor> availableFloors = new ArrayList<>();
    availableFloors.add(Floor.ATTIC);
    availableFloors.add(Floor.BASEMENT);
    availableFloors.add(Floor.GROUND);

    tileList.add(new GenericTile(connectedTiles, 2, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 2, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 2, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);

    tileList.add(new GenericTile(connectedTiles, 2, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 2, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 2, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 2, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 2, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 2, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 2, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.NORTH, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));

    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.ATTIC);
    availableFloors.add(Floor.BASEMENT);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 2, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 2, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 2, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 2, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 2, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.NORTH, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));

    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.ATTIC);
    availableFloors.add(Floor.GROUND);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 2, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.NORTH, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));

    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.GROUND);
    availableFloors.add(Floor.BASEMENT);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, null);

    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.NORTH, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 1, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));

    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.BASEMENT);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 1, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 1, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));

    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.GROUND);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 1, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 1, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));

    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.ATTIC);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 1, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));
    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.EAST, null);

    tileList.add(new GenericTile(connectedTiles, 0, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 0, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, null);
    connectedTiles.put(Direction.NORTH, null);

    tileList.add(new GenericTile(connectedTiles, 1, 1, 0, availableFloors));

    connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, null);
    connectedTiles.put(Direction.EAST, null);
    connectedTiles.put(Direction.SOUTH, null);

    tileList.add(new GenericTile(connectedTiles, 0, 0, 0, availableFloors));

    Collections.shuffle(tileList);
    Queue<Tile> tileDeck = new LinkedList<>(tileList);
    return tileDeck;
  }
}
