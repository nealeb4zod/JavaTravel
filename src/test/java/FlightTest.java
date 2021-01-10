import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FlightTest {

    Plane plane1;
    Plane plane2;
    Flight flight1;
    Flight flight2;
    Flight flight3;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    ArrayList<Passenger> listOfPassengers;
    ArrayList<Passenger> secondListOfPassengers;
    ArrayList<Passenger> thirdListOfPassengers;

    @Before
    public void before(){
        plane1 = new Plane(PlaneType.BOEING747);
        plane2 = new Plane(PlaneType.BOEING111);
        flight1 = new Flight(plane1, "NJ1234", "EDI", "GLA", "1730");
        flight2 = new Flight(plane2, "NJ1234", "EDI", "GLA", "1730");
        flight3 = new Flight(plane2, "NJ1234", "EDI", "GLA", "1730");
        passenger1 = new Passenger("Neale", 2);
        passenger2 = new Passenger("Rosie", 4);
        passenger3 = new Passenger("Emilia", 3);
        passenger4 = new Passenger("Tom", 1);
        listOfPassengers = new ArrayList<Passenger>();
        listOfPassengers.add(passenger2);
        listOfPassengers.add(passenger3);
        listOfPassengers.add(passenger4);
        secondListOfPassengers = new ArrayList<Passenger>();
        secondListOfPassengers.add(passenger1);
        thirdListOfPassengers = new ArrayList<Passenger>();
        thirdListOfPassengers.add(passenger2);
    }

    @Test
    public void canGetFlightCapacity(){
        assertEquals(250, flight1.getCapacity());
    }

    @Test
    public void canGetFlightNo(){
        assertEquals("NJ1234", flight1.getFlightNo());
    }

    @Test
    public void canGetDestinationAirport(){
        assertEquals("EDI", flight1.getDestinationAirport());
    }

    @Test
    public void canGetDepartureAirport(){
        assertEquals("GLA", flight1.getDepartureAirport());
    }

    @Test
    public void canGetDepartureTime(){
        assertEquals("1730", flight1.getDepartureTime());
    }

    @Test
    public void canGetSizeOfManifest(){
        assertEquals(0, flight1.getManifestSize());
    }

    @Test
    public void canAddPassengerToManifest(){
        flight1.addPassengerToManifest(passenger1);
        assertEquals(1, flight1.getManifestSize());
    }

    @Test
    public void canGetAvailableSeats(){
        flight1.addPassengerToManifest(passenger1);
        assertEquals(249, flight1.getNoOfAvailableSeats());
    }

    @Test
    public void canBookPassengerOntoFlightAvailableSeats(){
        flight1.bookPassengersOnToFlight(listOfPassengers);
        assertEquals(3, flight1.getManifestSize());
    }

    @Test
    public void canBookPassengersOntoFlightNoAvailableSeats(){
        flight2.bookPassengersOnToFlight(listOfPassengers);
        assertEquals(0, flight2.getManifestSize());
    }

    @Test
    public void canAssignSeatNumberToPassenger(){
        flight3.bookPassengersOnToFlight(secondListOfPassengers);
        flight3.bookPassengersOnToFlight(thirdListOfPassengers);
        ArrayList<Integer> possibleSeatNumbers = new ArrayList<Integer>();
        possibleSeatNumbers.add(1);
        possibleSeatNumbers.add(2);
        assertTrue(possibleSeatNumbers.contains(passenger1.getSeatNumber()));
        assertTrue(possibleSeatNumbers.contains(passenger2.getSeatNumber()));
        assertNotEquals(passenger1.getSeatNumber(), passenger2.getSeatNumber());
    }


}
