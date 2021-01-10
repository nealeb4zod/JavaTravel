import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    Plane plane1;
    Plane plane2;
    Flight flight1;
    Flight flight2;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    ArrayList<Passenger> listOfPassengers;
    FlightManager flightManager;

    @Before
    public void before() {
        plane1 = new Plane(PlaneType.BOEING747);
        plane2 = new Plane(PlaneType.BOEING111);
        flight1 = new Flight(plane1, "NJ1234", "EDI", "GLA", "17:30");
        flight2 = new Flight(plane2, "NJ1234", "EDI", "GLA", "17:30");
        passenger1 = new Passenger("Neale", 2);
        passenger2 = new Passenger("Rosie", 4);
        passenger3 = new Passenger("Emilia", 3);
        passenger4 = new Passenger("Tom", 1);
        listOfPassengers = new ArrayList<Passenger>();
        listOfPassengers.add(passenger2);
        listOfPassengers.add(passenger3);
        listOfPassengers.add(passenger4);
        flight1.bookPassengersOnToFlight(listOfPassengers);
        flightManager = new FlightManager();
    }

    @Test
    public void canGetWeightAllocatedToBaggage() {
        assertEquals(500, flightManager.getWeightAllocatedToBaggage(flight1));
    }

    @Test
    public void canGetWeightAllowedPerPassenger(){
        assertEquals(2, flightManager.getWeightAllowedPerPassenger(flight1));
    }

    @Test
    public void canGetBaggageWeightBookedByPassengers() {
        assertEquals(6, flightManager.getBaggageWeightBookedByPassengers(flight1));
    }

    @Test
    public void canGetBaggageWeightRemaining() {
        assertEquals(494, flightManager.getBaggageWeightRemaining(flight1));
    }
}
