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
        // Jeffery Tan
//        int max = 0;
//        int min = Integer.MAX_VALUE;
//        int superMin = Integer.MAX_VALUE;
//
//        List<Integer> destArray = new ArrayList<Integer>();
//
//        if (openDoor()) {
//            elevator.openDoors();
//        }
//
//        for (Passenger pass : allPassengers) {
//            if (pass.getDestinationFloor() > max) {
//                max = pass.getDestinationFloor();
//            }
//            if (pass.getCurrentFloor() > max) {
//                max = pass.getCurrentFloor();
//            }
//        }
//
//        for (Passenger pass : allPassengers) {
//            if (pass.getDestinationFloor() < min) {
//                min = pass.getDestinationFloor();
//            }
//        }
//
//        for (Passenger pass : allPassengers) {
//            if (pass.getCurrentFloor() < superMin) {
//                superMin = pass.getCurrentFloor();
//            }
//            if (pass.getDestinationFloor() < superMin) {
//                superMin = pass.getDestinationFloor();
//            }
//        }
//
//        for (int i = elevator.getFloor(); i > min; i--) {
//            elevator.down();
//            if (openDoor()) {
//                elevator.openDoors();
//            }
//        }
//
//        for (int i = elevator.getFloor(); i < max; i++) {
//            elevator.up();
//            if (openDoor()) {
//                elevator.openDoors();
//            }
//        }
//
//        for (int i = elevator.getFloor(); i > superMin; i--) {
//            elevator.down();
//            if (openDoor()) {
//                elevator.openDoors();
//            }
//        }

        // Eric Zhao
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

//    private Boolean openDoor() {
//        for (Passenger pass : allPassengers) {
//            if (pass.arrived() && pass.getCurrentFloor() == elevator.getFloor()) {
//                return true;
//            } else if (!elevator.getPassengers().contains(pass) && pass.getCurrentFloor() == elevator
//                    .getFloor() && !pass.arrived()) {
//                return true;
//            }
//        }
//        return false;
//    }

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
