package elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Building {

    private final Set<Passenger> allPassengers;
    private final Elevator elevator;

    public Building(Set<Passenger> allPassengers) {
        if (allPassengers == null) {
            throw new IllegalArgumentException("Passengers must not be null");
        }

        elevator = new Elevator(this);
        this.allPassengers = allPassengers;
    }

    public void run() {
        // Students would implement this method

        // A really dumb implementation that opens the
        // elevator doors on every floor
        if (allPassengers.size() == 0 || allArrived()) {
            return;
        }

        openDoors();

        int minStart = Integer.MAX_VALUE;
        int maxStart = Integer.MIN_VALUE;
        int minDest = Integer.MAX_VALUE;
        int maxDest = Integer.MIN_VALUE;
        for (Passenger p : allPassengers) {
            int pStart = p.getCurrentFloor();
            int pDest = p.getDestinationFloor();
            minStart = Math.min(minStart, pStart);
            maxStart = Math.max(maxStart, pStart);
            minDest = Math.min(minDest, pDest);
            maxDest = Math.max(maxDest, pDest);
        }

        if (minStart < elevator.getFloor()) {
            for (int i = elevator.getFloor(); i > minStart; i--) {
                elevator.down();
                openDoors();
            }
        }

        if (allArrived()) {
            return;
        }

        for (int i = elevator.getFloor(); i < maxStart; i++) {
            elevator.up();
            openDoors();
        }

        if (allArrived()) {
            return;
        }

        if (elevator.getFloor() < maxDest) {
            for (int i = elevator.getFloor(); i < maxDest; i++) {
                elevator.up();
                openDoors();
            }
        }

        if (allArrived()) {
            return;
        }

        for (int i = elevator.getFloor(); i > minDest; i--) {
            elevator.down();
            openDoors();
        }

    }

    public void openDoors() {
        if (elevator.getPassengers().stream().anyMatch(Passenger::arrived) ||
                getPassengersOnFloor(elevator.getFloor()).stream().anyMatch(p -> !p.arrived())) {
            elevator.openDoors();
        }
    }

    public boolean allArrived() {
        return allPassengers.stream().allMatch(Passenger::arrived);
    }

    public List<Passenger> getPassengersOnFloor(int floor) {
        List<Passenger> floorPassengers = new ArrayList<>();
        for (Passenger p : allPassengers) {
            if (p.getCurrentFloor() == floor) {
                floorPassengers.add(p);
            }
        }
        return floorPassengers;
    }

    public Set<Passenger> getAllPassengers() {
        return allPassengers;
    }

    public Elevator getElevator() {
        return elevator;
    }

}
