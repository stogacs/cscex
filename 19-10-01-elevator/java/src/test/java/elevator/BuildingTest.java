package elevator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BuildingTest {

    @Test
    public void testGetPassengersOnFloor() {
        Set<Passenger> passengers = new HashSet<>(Arrays.asList(new Passenger(1, 5),
                                                                new Passenger(2, 4),
                                                                new Passenger(2, 4),
                                                                new Passenger(3, 6),
                                                                new Passenger(3, 8),
                                                                new Passenger(5, 9)));
        Building building = new Building(passengers);
        Assertions.assertEquals(Arrays.asList(new Passenger(3, 6),
                                              new Passenger(3, 8)),
                                building.getPassengersOnFloor(3));
    }

}
