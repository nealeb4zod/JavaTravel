public class Passenger {

    String name;
    int noOfBags;
    Flight flight;
    int seatNumber;

    public Passenger(String name, int noOfBags) {
        this.name = name;
        this.noOfBags = noOfBags;
    }

    public String getName() {
        return name;
    }

    public int getNoOfBags() {
        return noOfBags;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
