public class FlightManager {

    public int getWeightAllocatedToBaggage(Flight flight) {
        return (flight.getPlane().getPlaneType().getTotalWeight() / 2);
    }


    public int getWeightAllowedPerPassenger(Flight flight) {
        return getWeightAllocatedToBaggage(flight) / flight.getPlane().getPlaneType().getCapacity();
    }


    public int getBaggageWeightBookedByPassengers(Flight flight) {
        return flight.getManifestSize() * getWeightAllowedPerPassenger(flight);
    }


    public int getBaggageWeightRemaining(Flight flight) {
        return getWeightAllocatedToBaggage(flight) - getBaggageWeightBookedByPassengers(flight);
    }
}
