package lib;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Runner {
  public int run(ElevatorControl control) {
    Map<Integer, List<Person>> people = new HashMap<>();
    people.put(0, Arrays.asList(new Person(200, 1)));

    Building building = new Building(100, people);
    Elevator elevator = new Elevator(1500, 5, building, 0);

    int n = 0;
    while (!elevator.isEmpty() || !elevator.building().isEmpty()) {
      switch (control.getInstruction(elevator)) {
        case UP -> elevator.moveUp();
        case DOWN -> elevator.moveDown();
        case OPEN -> elevator.openDoors();
      }
    }
    return n;
  }
}
