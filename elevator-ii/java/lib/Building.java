package lib;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Building {
  private Map<Integer, List<Person>> people;
  private int floors;

  public Building(int floors, Map<Integer, List<Person>> people) {
    this.floors = floors;
    this.people = people;
  }

  public Map<Integer, List<Person>> people() {
    return this.people;
  }

  public int totalFloors() {
    return this.floors;
  }

  public boolean isEmpty() {
    return this.people.isEmpty();
  }
}
