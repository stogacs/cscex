package lib;

import java.util.*;

public class Elevator {
  private final int weightCapacity;
  private final int numCapacity;
  private final Building building;
  private final List<Person> passengers;
  private int currentFloor;

  public Elevator(int weightCapacity, int numCapacity, Building building, int currentFloor) {
    if (currentFloor >= building.totalFloors() || currentFloor < 0) {
      throw new IllegalArgumentException("currentFloor must be at least 0 and less than the number of floors of the building");
    }

    this.weightCapacity = weightCapacity;
    this.numCapacity = numCapacity;
    this.building = building;
    this.currentFloor = currentFloor;

    this.passengers = new ArrayList<>();
  }

  protected boolean moveUp() {
    if (this.currentFloor != this.building.totalFloors()) {
      this.currentFloor += 1;
      return true;
    } else {
      return false;
    }
  }

  protected boolean moveDown() {
    if (this.currentFloor != 1) {
      this.currentFloor -= 1;
      return true;
    } else {
      return false;
    }
  }

  protected void openDoors() {
    this.passengers.stream()
                   .filter(p -> p.dest() == this.currentFloor)
                   .forEach(this.passengers::remove);
    List<Person> waiting = this.building.people().remove(this.currentFloor);
    waiting.sort(Comparator.comparingInt(Person::weight));

    boolean first = false;
    for (Person p : waiting) {
      boolean added = this.addPerson(p);
      if (added) {
        if (first) {
          this.building.people().put(this.currentFloor, Collections.singletonList(p));
          first = true;
        } else {
          this.building.people().get(this.currentFloor).add(p);
        }
      } else {
        break;
      }
    }
  }

  protected boolean addPerson(Person p) {
    if (this.passengers.size() == this.numCapacity ||
        this.totalWeight() + p.weight() > this.weightCapacity) {
      return false;
    } else {
      this.passengers.add(p);
      return true;
    }
  }

  private int totalWeight() {
    return this.passengers.stream()
                          .map(p -> p.weight())
                          .mapToInt(Integer::valueOf)
                          .sum();
  }

  public boolean isEmpty() {
    return this.passengers.isEmpty();
  }

  public int weightCapacity() {
    return this.weightCapacity;
  }

  public int numCapacity() {
    return this.numCapacity;
  }

  public Building building() {
    return this.building;
  }

  public List<Person> passengers() {
    return this.passengers;
  }

  public int currentFloor() {
    return this.currentFloor;
  }
}
