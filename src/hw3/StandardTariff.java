package hw3;

public class StandardTariff implements TaxiTarif{
    public long calculatePrice(TaxiRide ride) {
        return 30 + 5 * ride.getDistance() + 2 * ride.getDuration();
    }
}
