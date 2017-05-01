package com.term_project.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.term_project.house.Direction;
import com.term_project.house.Floor;
import com.term_project.house.GenericTile;
import com.term_project.house.Tile;
import com.term_project.system.MemorySlot;

public class TileBuilder implements Builder<Tile> {
  MemorySlot memory;
  public TileBuilder(MemorySlot memory) {
    this.memory = memory;
  }
  @Override
  public Queue<Tile> build() {
    List<Tile> tileList = new ArrayList<>();
    // start of all floors
    List<Direction> connectedTiles = new ArrayList<>();
    connectedTiles.add(Direction.NORTH);
    connectedTiles.add(Direction.SOUTH);
    connectedTiles.add(Direction.EAST);
    connectedTiles.add(Direction.WEST);

    List<Floor> availableFloors = new ArrayList<>();
    availableFloors.add(Floor.ATTIC);
    availableFloors.add(Floor.BASEMENT);
    availableFloors.add(Floor.GROUND);

    Tile junkRoom = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors, memory);
    junkRoom.setName("Junk Room");
    tileList.add(junkRoom);

    connectedTiles.remove(Direction.WEST);
    Tile gameRoom = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors, memory);
    gameRoom.setName("Game Room");
    tileList.add(gameRoom);

    connectedTiles.add(Direction.WEST);
    connectedTiles.remove(Direction.NORTH);
    connectedTiles.remove(Direction.EAST);
    Tile organRoom = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors, memory);
    organRoom.setName("Organ Room");
    tileList.add(organRoom);

    connectedTiles.add(Direction.NORTH);
    connectedTiles.remove(Direction.WEST);
    Tile statuaryCorridor = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors, memory);
    statuaryCorridor.setName("Statuary Corridor");
    tileList.add(statuaryCorridor);

    connectedTiles.add(Direction.WEST);
    connectedTiles.add(Direction.EAST);
    Tile creakyHallway = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors, memory);
    creakyHallway.setName("Creaky Hallway");
    tileList.add(creakyHallway);

    Tile dustyHallway = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors, memory);
    dustyHallway.setName("Dusty Hallway");
    tileList.add(dustyHallway);
    // start of upper
    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.ATTIC);

    connectedTiles.remove(Direction.WEST);
    connectedTiles.remove(Direction.EAST);
    Tile balcony = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors, memory);
    balcony.setName("Balcony");
    tileList.add(balcony);

    connectedTiles.remove(Direction.NORTH);
    Tile gallery = new GenericTile(connectedTiles, 1, 0, 0,
        availableFloors, memory);
    gallery.setName("Gallery");
    tileList.add(gallery);

    Tile attic = new GenericTile(connectedTiles, 0, 1, 0, availableFloors, memory);
    attic.setName("Attic");
    tileList.add(attic);

    connectedTiles.remove(Direction.SOUTH);
    connectedTiles.add(Direction.WEST);
    connectedTiles.add(Direction.NORTH);
    Tile masterBedroom = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors, memory);
    masterBedroom.setName("Master Bedroom");
    tileList.add(masterBedroom);

    connectedTiles.remove(Direction.NORTH);
    connectedTiles.add(Direction.EAST);
    Tile bedroom = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors, memory);
    bedroom.setName("Bedroom");
    tileList.add(bedroom);

    Tile tower = new GenericTile(connectedTiles, 0, 1, 0, availableFloors, memory);
    tower.setName("Tower");
    tileList.add(tower);

    // start of ground
    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.GROUND);

    connectedTiles.remove(Direction.WEST);
    connectedTiles.add(Direction.NORTH);
    Tile diningRoom = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors, memory);
    diningRoom.setName("Dining Room");
    tileList.add(diningRoom);

    connectedTiles.remove(Direction.EAST);
    Tile coalChute = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors, memory);
    coalChute.setName("Coal Chute");
    tileList.add(coalChute);

    connectedTiles.remove(Direction.NORTH);
    connectedTiles.add(Direction.SOUTH);
    Tile graveyard = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors, memory);
    graveyard.setName("Graveyard");
    tileList.add(graveyard);

    connectedTiles.add(Direction.NORTH);
    Tile gardens = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors, memory);
    gardens.setName("Gardens");
    tileList.add(gardens);

    connectedTiles.add(Direction.WEST);
    Tile patio = new GenericTile(connectedTiles, 0, 1, 0, availableFloors, memory);
    patio.setName("Patio");
    tileList.add(patio);

    connectedTiles.add(Direction.EAST);
    Tile ballroom = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors, memory);
    ballroom.setName("Ballroom");
    tileList.add(ballroom);

    // start of basement
    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.BASEMENT);

    connectedTiles.remove(Direction.WEST);
    connectedTiles.remove(Direction.EAST);
    Tile stairsFromBasement = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors, memory);
    stairsFromBasement.setName("Stairs From Basement");
    tileList.add(stairsFromBasement);

    connectedTiles.remove(Direction.SOUTH);
    connectedTiles.remove(Direction.NORTH);
    connectedTiles.add(Direction.EAST);
    Tile pentagramChamber = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors, memory);
    pentagramChamber.setName("Pentagram Chamber");
    tileList.add(pentagramChamber);

    connectedTiles.remove(Direction.EAST);
    connectedTiles.add(Direction.NORTH);
    connectedTiles.add(Direction.SOUTH);
    Tile larder = new GenericTile(connectedTiles, 1, 0, 0,
        availableFloors, memory);
    larder.setName("Larder");
    tileList.add(larder);

    connectedTiles.remove(Direction.NORTH);
    connectedTiles.remove(Direction.SOUTH);
    connectedTiles.add(Direction.EAST);
    connectedTiles.add(Direction.WEST);
    Tile chasm = new GenericTile(connectedTiles, 0, 0, 0, availableFloors, memory);
    chasm.setName("Chasm");
    tileList.add(chasm);

    connectedTiles.remove(Direction.WEST);
    connectedTiles.remove(Direction.EAST);
    connectedTiles.add(Direction.NORTH);
    Tile crypt = new GenericTile(connectedTiles, 0, 1, 0, availableFloors, memory);
    crypt.setName("Crypt");
    tileList.add(crypt);

    connectedTiles.add(Direction.SOUTH);
    Tile catacombs = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors, memory);
    catacombs.setName("Catacombs");
    tileList.add(catacombs);

    connectedTiles.add(Direction.WEST);
    Tile furnaceRoom = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors, memory);
    furnaceRoom.setName("Furnace Room");
    tileList.add(furnaceRoom);

    connectedTiles.add(Direction.EAST);
    connectedTiles.remove(Direction.WEST);
    connectedTiles.remove(Direction.SOUTH);
    Tile undergroundLake = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors, memory);
    undergroundLake.setName("Underground Lake");
    tileList.add(undergroundLake);

    connectedTiles.add(Direction.SOUTH);
    connectedTiles.remove(Direction.EAST);
    Tile wineCellar = new GenericTile(connectedTiles, 1, 0, 0,
        availableFloors, memory);
    wineCellar.setName("Wine Cellar");
    tileList.add(wineCellar);

    // start of upper/basement
    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.BASEMENT);
    availableFloors.add(Floor.ATTIC);

    Tile researchLabratory = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors, memory);
    researchLabratory.setName("Research Labratory");
    tileList.add(researchLabratory);

    connectedTiles.add(Direction.EAST);
    connectedTiles.remove(Direction.NORTH);
    Tile operatingLabratory = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors, memory);
    operatingLabratory.setName("Operating Labratory");
    tileList.add(operatingLabratory);

    Tile gymnasium = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors, memory);
    gymnasium.setName("Gymnasium");
    tileList.add(gymnasium);

    connectedTiles.add(Direction.NORTH);
    connectedTiles.remove(Direction.EAST);
    connectedTiles.remove(Direction.SOUTH);
    Tile vault = new GenericTile(connectedTiles, 0, 1, 0, availableFloors, memory);
    vault.setName("Vault");
    tileList.add(vault);

    Tile storeroom = new GenericTile(connectedTiles, 1, 0, 0,
        availableFloors, memory);
    storeroom.setName("Storeroom");
    tileList.add(storeroom);

    connectedTiles.add(Direction.WEST);
    connectedTiles.add(Direction.EAST);
    connectedTiles.add(Direction.SOUTH);
    Tile serventsQuarters = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors, memory);
    serventsQuarters.setName("Servents Quarters");
    tileList.add(serventsQuarters);

    // start of upper/ground
    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.GROUND);
    availableFloors.add(Floor.ATTIC);

    connectedTiles.remove(Direction.EAST);
    connectedTiles.remove(Direction.NORTH);
    Tile library = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors, memory);
    library.setName("Library");
    tileList.add(library);

    connectedTiles.add(Direction.EAST);
    connectedTiles.add(Direction.NORTH);
    Tile collapsedRoom = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors, memory);
    collapsedRoom.setName("Collapsed Room");
    tileList.add(collapsedRoom);

    Tile charredRoom = new GenericTile(connectedTiles, 1, 0, 0,
        availableFloors, memory);
    charredRoom.setName("Charred Room");
    tileList.add(charredRoom);

    Tile bloodyRoom = new GenericTile(connectedTiles, 1, 0, 0,
        availableFloors, memory);
    bloodyRoom.setName("Bloody Room");
    tileList.add(bloodyRoom);

    connectedTiles.remove(Direction.EAST);
    connectedTiles.remove(Direction.SOUTH);
    connectedTiles.remove(Direction.WEST);
    Tile conservatory = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors, memory);
    conservatory.setName("Conservatory");
    tileList.add(conservatory);

    Tile chapel = new GenericTile(connectedTiles, 0, 1, 0,
        availableFloors, memory);
    chapel.setName("Chapel");
    tileList.add(chapel);

    // start of ground/basement
    availableFloors = new ArrayList<>();
    availableFloors.add(Floor.GROUND);
    availableFloors.add(Floor.BASEMENT);

    Tile kitchen = new GenericTile(connectedTiles, 0, 0, 0,
        availableFloors, memory);
    kitchen.setName("Kitchen");
    tileList.add(kitchen);

    connectedTiles.add(Direction.WEST);
    connectedTiles.add(Direction.SOUTH);
    connectedTiles.add(Direction.EAST);
    Tile abandonedRoom = new GenericTile(connectedTiles, 0, 0, 1,
        availableFloors, memory);
    abandonedRoom.setName("Abandoned Room");
    tileList.add(abandonedRoom);

    Collections.shuffle(tileList);
    Queue<Tile> tileDeck = new LinkedList<>(tileList);
    return tileDeck;
  }
}
