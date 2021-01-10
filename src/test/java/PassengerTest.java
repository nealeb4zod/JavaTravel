import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;
    Plane plane1;
    Flight flight1;

    @Before
    public void before() {
        passenger = new Passenger("Neale", 2);
        plane1 = new Plane(PlaneType.BOEING747);
        flight1 = new Flight(plane1, "NJ1234", "EDI", "GLA", "1730");
    }

    @Test
    public void canGetName() {
        assertEquals("Neale", passenger.getName());
    }

    @Test
    public void canGetNoOfBags() {
        assertEquals(2, passenger.getNoOfBags());
    }

    @Test
    public void canSetGetFlight() {
        passenger.setFlight(flight1);
        assertEquals(flight1, passenger.getFlight());
    }

    @Test
    public void canSetGetSeatNo() {
        passenger.setSeatNumber(1);
        assertEquals(1, passenger.getSeatNumber());
    }
}
