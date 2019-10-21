package elevator;

import java.util.HashSet;
import java.util.Set;

public class Elevator {

    private int floor;
    private int totalTime;

    private Building building;
    private Set<Passenger> passengers;

    public Elevator(Building building) {
        if (building == null) {
            throw new IllegalArgumentException("Building must not be null");
        }

        floor = 0;
        this.building = building;
        passengers = new HashSet<>();
    }

    public void up() {
        if (floor == Integer.MAX_VALUE) {
            return;
        }
        floor++;
        totalTime++;

        changePassengerFloors();
    }

    public void down() {
        if (floor == Integer.MIN_VALUE) {
            return;
        }
        floor--;
        totalTime++;

        changePassengerFloors();
    }

    public void openDoors() {
        totalTime++;

        addPassengers();
        removePassengers();
    }

    private void addPassengers() {
        for (Passenger p : building.getPassengersOnFloor(floor)) {
            if (p.getCurrentFloor() != p.getDestinationFloor()) {
                passengers.add(p);
            }
        }
    }

    private void removePassengers() {
        passengers.removeIf(Passenger::arrived);
    }

    private void changePassengerFloors() {
        for (Passenger p : passengers) {
            p.setCurrentFloor(floor);
        }
    }

    public int getFloor() {
        return floor;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

}
