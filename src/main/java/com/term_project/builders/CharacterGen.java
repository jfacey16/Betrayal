package com.term_project.builders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.term_project.character.Brandon;
import com.term_project.character.Darrin;
import com.term_project.character.GameChar;
import com.term_project.character.Heather;
import com.term_project.character.Jenny;
import com.term_project.character.Longfellow;
import com.term_project.character.Missy;
import com.term_project.character.Ox;
import com.term_project.character.Peter;
import com.term_project.character.Rhinehardt;
import com.term_project.character.Vivian;
import com.term_project.character.Zoe;
import com.term_project.character.Zostra;

public class CharacterGen {

  private List<List<GameChar>> characters;
  private Map<String, GameChar> charMap;

  public CharacterGen() {
    characters = new ArrayList<List<GameChar>>();
    charMap = this.buildCharMap();

  }

  private Map<String, GameChar> buildCharMap() {
    Map<String, GameChar> map = new HashMap<>();
    map.put("Brandon Jaspers", new Brandon());
    map.put("Darrin 'Flash' Williams", new Darrin());
    map.put("Heather Granville", new Heather());
    map.put("Jenny LeClerc", new Jenny());
    map.put("Professor Longfellow", new Longfellow());
    map.put("Missy Dubourde", new Missy());
    map.put("Ox Bellows", new Ox());
    map.put("Peter Akimoto", new Peter());
    map.put("Father Rhinehardt", new Rhinehardt());
    map.put("Vivian Lopez", new Vivian());
    map.put("Zoe Ingstrom", new Zoe());
    map.put("Madame Zostra", new Zostra());

    return map;
  }

  public List<List<GameChar>> build() {

    List<GameChar> red = new ArrayList<>();
    red.add(new Ox());
    red.add(new Darrin());

    List<GameChar> blue = new ArrayList<>();
    red.add(new Zostra());
    red.add(new Vivian());

    List<GameChar> green = new ArrayList<>();
    red.add(new Brandon());
    red.add(new Peter());

    List<GameChar> yellow = new ArrayList<>();
    red.add(new Missy());
    red.add(new Zoe());

    List<GameChar> white = new ArrayList<>();
    red.add(new Longfellow());
    red.add(new Rhinehardt());

    List<GameChar> purple = new ArrayList<>();
    red.add(new Jenny());
    red.add(new Heather());

    characters.add(red);
    characters.add(blue);
    characters.add(green);
    characters.add(yellow);
    characters.add(white);
    characters.add(purple);

    return characters;
  }

  public GameChar getCharactersByName(String name) {
    return charMap.get(name);
  }
}
