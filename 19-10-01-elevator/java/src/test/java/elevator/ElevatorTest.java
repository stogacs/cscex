package elevator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.HashSet;
import java.util.Set;

/**
 * Test class specifically for testing the speed of
 * Building::run implementations.
 * Students should only be allowed to use the
 * following methods:
 * Building::get[*]
 * Elevator::up
 * Elevator::down
 * Elevator::openDoors
 * Elevator::get[*]
 * Passenger::get[*]
 * Students are not permitted to use setter methods.
 * I don't have the energy to figure out a way to
 * implement internal methods without allowing
 * outside access to manual set functions.
 */
public class ElevatorTest {

    @Test
    public void testNoPassengers() {
        test(new HashSet<>());
    }

    @Test
    public void testNoMovement() {
        test(createPassengersFromArray(new int[][]{{1, 1}, {2, 2}, {2, 2}, {3, 3}, {5, 5}, {6, 6}}));
    }

    @Test
    public void testFewPassengers() {
        test(createPassengersFromArray(new int[][]{{1, 2}, {1, 3}, {2, 5}}));
        test(createPassengersFromArray(new int[][]{{1, 2}, {1, 3}, {2, 5}, {2, 8}, {3, 1}, {3, 3}, {3, 4}, {4, 9}}));
    }

    @Test
    public void testManyPassengers() {
        test(createPassengersFromArray(
                new int[][]{{23, 25}, {20, 18}, {15, 13}, {0, 13}, {6, 6}, {16, 28}, {4, 25}, {13, 25}, {0, 18},
                            {11, 26}, {11, 16}, {10, 20}, {21, 12}}));
        test(createPassengersFromArray(
                new int[][]{{17, 17}, {16, 13}, {18, 25}, {0, 26}, {13, 16}, {13, 5}, {18, 16}, {2, 8}, {22, 20},
                            {28, 21}, {13, 16}, {11, 2}, {26, 18}, {12, 4}, {29, 11}}));
        test(createPassengersFromArray(
                new int[][]{{18, 4}, {27, 17}, {0, 11}, {5, 25}, {12, 23}, {27, 13}, {16, 29}, {12, 20}, {1, 19},
                            {14, 20}, {20, 11}, {2, 9}, {14, 11}, {6, 26}, {27, 25}, {0, 9}, {1, 27}, {17, 12}}));
        test(createPassengersFromArray(
                new int[][]{{17, 26}, {0, 28}, {26, 1}, {29, 14}, {19, 29}, {4, 28}, {6, 28}, {15, 29}, {26, 9},
                            {29, 10}, {17, 15}, {22, 20}}));
        test(createPassengersFromArray(
                new int[][]{{20, 24}, {19, 18}, {22, 20}, {10, 6}, {2, 12}, {25, 23}, {21, 9}, {25, 24}, {18, 8},
                            {23, 19}, {15, 24}, {4, 12}, {3, 8}, {22, 17}, {16, 0}, {12, 17}, {23, 7}, {13, 7},
                            {14, 6}}));
    }

    @Test
    public void testNegativeFloors() {
        test(createPassengersFromArray(new int[][]{{-3, 2}, {-2, -1}, {-1, 6}, {3, -5}, {3, 6}, {3, 1}, {5, -4}, {6, -9}}));
    }

    // Test the implementation of Building::run with the given passengers
    private void test(Set<Passenger> passengers) {
        System.out.println("Testing with " + passengers.size() + " passengers...");
        Building building = new Building(passengers);

        // First run is always slower by a wide margin, maybe some
        // runtime optimization going on?
        building.run();

//        // Average times for 5 trials
        int trials = 5;
        long sum = 0;
        for (int i = 0; i < trials; i++) {
            // Measure CPU time to minimize error due to other processes
            long time = measureCPUTime(building::run);
            sum += time;
//            System.out.println(time);
        }

        // Only output average time if assertions succeed
        for (Passenger p : passengers) {
            Assertions.assertEquals(p.getDestinationFloor(), p.getCurrentFloor());
        }

        System.out.printf("Time taken: %f ms \n", sum / trials / 1000000.0);
        System.out.println("Traveled: " + building.getElevator().getTotalTime() + " floors");
    }

    // Convenience method for creating Set of Passengers from nested arrays
    // Nested array should always be a pair of values
    private Set<Passenger> createPassengersFromArray(int[][] floors) {
        Set<Passenger> passengers = new HashSet<>();
        for (int[] floor : floors) {
            if (floor.length != 2) {
                throw new IllegalArgumentException("Nested arrays should be pairs");
            }
            passengers.add(new Passenger(floor[0], floor[1]));
        }
        return passengers;
    }

    private long measureCPUTime(Runnable function) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        if (!threadMXBean.isThreadCpuTimeSupported()) {
            throw new UnsupportedOperationException("JVM does not support measuring thread CPU time");
        }

        long startTime = threadMXBean.getThreadCpuTime(Thread.currentThread().getId());
        function.run();
        long endTime = threadMXBean.getThreadCpuTime(Thread.currentThread().getId());

        return endTime - startTime;
    }

}
