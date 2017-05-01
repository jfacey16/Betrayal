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
    // start of all floors
    Map<Direction, Tile> connectedTiles = new HashMap<>();
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));

    List<Floor> availableFloors = new ArrayList<>();
    availableFloors.add(Floor.ATTIC);
    availableFloors.add(Floor.BASEMENT);
    availableFloors.add(Floor.GROUND);

    Tile junkRoom = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors);
    junkRoom.setName("Junk Room");
    tileList.add(junkRoom);

    connectedTiles.remove(Direction.WEST);
    Tile gameRoom = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors);
    gameRoom.setName("Game Room");
    tileList.add(gameRoom);

    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.remove(Direction.NORTH);
    connectedTiles.remove(Direction.EAST);
    Tile organRoom = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors);
    organRoom.setName("Organ Room");
    tileList.add(organRoom);

    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.remove(Direction.WEST);
    Tile statuaryCorridor = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors);
    statuaryCorridor.setName("Statuary Corridor");
    tileList.add(statuaryCorridor);

    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    Tile creakyHallway = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors);
    creakyHallway.setName("Creaky Hallway");
    tileList.add(creakyHallway);

    Tile dustyHallway = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors);
    dustyHallway.setName("Dusty Hallway");
    tileList.add(dustyHallway);
    // start of upper
    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.ATTIC);

    connectedTiles.remove(Direction.WEST);
    connectedTiles.remove(Direction.EAST);
    Tile balcony = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors);
    balcony.setName("Balcony");
    tileList.add(balcony);

    connectedTiles.remove(Direction.NORTH);
    Tile gallery = new GenericTile(connectedTiles, 1, 0, 0,
        availableFloors);
    gallery.setName("Gallery");
    tileList.add(gallery);

    Tile attic = new GenericTile(connectedTiles, 0, 1, 0, availableFloors);
    attic.setName("Attic");
    tileList.add(attic);

    connectedTiles.remove(Direction.SOUTH);
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    Tile masterBedroom = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors);
    masterBedroom.setName("Master Bedroom");
    tileList.add(masterBedroom);

    connectedTiles.remove(Direction.NORTH);
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    Tile bedroom = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors);
    bedroom.setName("Bedroom");
    tileList.add(bedroom);

    Tile tower = new GenericTile(connectedTiles, 0, 1, 0, availableFloors);
    tower.setName("Tower");
    tileList.add(tower);

    // start of ground
    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.GROUND);

    connectedTiles.remove(Direction.WEST);
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    Tile diningRoom = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors);
    diningRoom.setName("Dining Room");
    tileList.add(diningRoom);

    connectedTiles.remove(Direction.EAST);
    Tile coalChute = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors);
    coalChute.setName("Coal Chute");
    tileList.add(coalChute);

    connectedTiles.remove(Direction.NORTH);
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    Tile graveyard = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors);
    graveyard.setName("Graveyard");
    tileList.add(graveyard);

    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    Tile gardens = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors);
    gardens.setName("Gardens");
    tileList.add(gardens);

    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    Tile patio = new GenericTile(connectedTiles, 0, 1, 0, availableFloors);
    patio.setName("Patio");
    tileList.add(patio);

    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    Tile ballroom = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors);
    ballroom.setName("Ballroom");
    tileList.add(ballroom);

    // start of basement
    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.BASEMENT);

    connectedTiles.remove(Direction.WEST);
    connectedTiles.remove(Direction.EAST);
    Tile stairsFromBasement = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors);
    stairsFromBasement.setName("Stairs From Basement");
    tileList.add(stairsFromBasement);

    connectedTiles.remove(Direction.SOUTH);
    connectedTiles.remove(Direction.NORTH);
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    Tile pentagramChamber = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors);
    pentagramChamber.setName("Pentagram Chamber");
    tileList.add(pentagramChamber);

    connectedTiles.remove(Direction.EAST);
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    Tile larder = new GenericTile(connectedTiles, 1, 0, 0,
        availableFloors);
    larder.setName("Larder");
    tileList.add(larder);

    connectedTiles.remove(Direction.NORTH);
    connectedTiles.remove(Direction.SOUTH);
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    Tile chasm = new GenericTile(connectedTiles, 0, 0, 0, availableFloors);
    chasm.setName("Chasm");
    tileList.add(chasm);

    connectedTiles.remove(Direction.WEST);
    connectedTiles.remove(Direction.EAST);
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    Tile crypt = new GenericTile(connectedTiles, 0, 1, 0, availableFloors);
    crypt.setName("Crypt");
    tileList.add(crypt);

    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    Tile catacombs = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors);
    catacombs.setName("Catacombs");
    tileList.add(catacombs);

    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    Tile furnaceRoom = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors);
    furnaceRoom.setName("Furnace Room");
    tileList.add(furnaceRoom);

    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.remove(Direction.WEST);
    connectedTiles.remove(Direction.SOUTH);
    Tile undergroundLake = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors);
    undergroundLake.setName("Underground Lake");
    tileList.add(undergroundLake);

    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.remove(Direction.EAST);
    Tile wineCellar = new GenericTile(connectedTiles, 1, 0, 0,
        availableFloors);
    wineCellar.setName("Wine Cellar");
    tileList.add(wineCellar);

    // start of upper/basement
    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.BASEMENT);
    availableFloors.add(Floor.ATTIC);

    Tile researchLabratory = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors);
    researchLabratory.setName("Research Labratory");
    tileList.add(researchLabratory);

    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.remove(Direction.NORTH);
    Tile operatingLabratory = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors);
    operatingLabratory.setName("Operating Labratory");
    tileList.add(operatingLabratory);

    Tile gymnasium = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors);
    gymnasium.setName("Gymnasium");
    tileList.add(gymnasium);

    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    connectedTiles.remove(Direction.EAST);
    connectedTiles.remove(Direction.SOUTH);
    Tile vault = new GenericTile(connectedTiles, 0, 1, 0, availableFloors);
    vault.setName("Vault");
    tileList.add(vault);

    Tile storeroom = new GenericTile(connectedTiles, 1, 0, 0,
        availableFloors);
    storeroom.setName("Storeroom");
    tileList.add(storeroom);

    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    Tile serventsQuarters = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors);
    serventsQuarters.setName("Servents Quarters");
    tileList.add(serventsQuarters);

    // start of upper/ground
    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.GROUND);
    availableFloors.add(Floor.ATTIC);

    connectedTiles.remove(Direction.EAST);
    connectedTiles.remove(Direction.NORTH);
    Tile library = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors);
    library.setName("Library");
    tileList.add(library);

    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.NORTH, new EmptyTile(new HashMap<>()));
    Tile collapsedRoom = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors);
    collapsedRoom.setName("Collapsed Room");
    tileList.add(collapsedRoom);

    Tile charredRoom = new GenericTile(connectedTiles, 1, 0, 0,
        availableFloors);
    charredRoom.setName("Charred Room");
    tileList.add(charredRoom);

    Tile bloodyRoom = new GenericTile(connectedTiles, 1, 0, 0,
        availableFloors);
    bloodyRoom.setName("Bloody Room");
    tileList.add(bloodyRoom);

    connectedTiles.remove(Direction.EAST);
    connectedTiles.remove(Direction.SOUTH);
    connectedTiles.remove(Direction.WEST);
    Tile conservatory = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors);
    conservatory.setName("Conservatory");
    tileList.add(conservatory);

    Tile chapel = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors);
    chapel.setName("Chapel");
    tileList.add(chapel);

    // start of ground/basement
    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.GROUND);
    availableFloors.add(Floor.BASEMENT);

    Tile kitchen = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors);
    kitchen.setName("Kitchen");
    tileList.add(kitchen);

    connectedTiles.put(Direction.WEST, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.SOUTH, new EmptyTile(new HashMap<>()));
    connectedTiles.put(Direction.EAST, new EmptyTile(new HashMap<>()));
    Tile abandonedRoom = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors);
    abandonedRoom.setName("Abandoned Room");
    tileList.add(abandonedRoom);

    Collections.shuffle(tileList);
    Queue<Tile> tileDeck = new LinkedList<>(tileList);
    return tileDeck;
  }
}
