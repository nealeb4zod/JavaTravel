import java.util.ArrayList;
import java.util.Random;

public class Flight {
    
    ArrayList<Passenger> manifest;
    Plane plane;
    String flightNo;
    String destinationAirport;
    String departureAirport;
    String departureTime;
    
    public Flight(Plane plane, String flightNo, String destinationAirport, String departureAirport, String departureTime){
        this.manifest = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNo = flightNo;
        this.destinationAirport = destinationAirport;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
    }

    public ArrayList<Passenger> getManifest() {
        return manifest;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public int getCapacity() {
        return plane.getPlaneType().getCapacity();
    }

    public int getManifestSize() {
        return manifest.size();
    }

    public void addPassengerToManifest(Passenger passenger) {
        manifest.add(passenger);
    }

    public int getNoOfAvailableSeats() {
        return getCapacity() - getManifestSize();
    }


    public void bookPassengersOnToFlight(ArrayList<Passenger> listOfPassengers) {
        if (listOfPassengers.size() <= getNoOfAvailableSeats()){
            for (Passenger passenger: listOfPassengers) {
                assignSeatNumber(passenger);
                addPassengerToManifest(passenger);
            }
        }
    }

    public ArrayList<Integer> getBookedSeatNumbers() {
        ArrayList<Integer> bookedSeats = new ArrayList<Integer>();
        for (Passenger passenger : manifest) {
            bookedSeats.add(passenger.getSeatNumber());
        }
        return bookedSeats;
    }

    public int getValidSeatNumberForFlight() {
        Random r = new Random();
        return r.nextInt((getCapacity() - 1) +1) +1;
    }

    public void assignSeatNumber(Passenger passenger) {
        int seatNumber = getValidSeatNumberForFlight();
        if (getBookedSeatNumbers().contains(seatNumber)) {
            assignSeatNumber(passenger);
        } else {
            passenger.setSeatNumber(seatNumber);
        }



    }
}
