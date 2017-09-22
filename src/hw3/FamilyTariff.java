package hw3;

public class FamilyTariff implements TaxiTarif {
    public long calculatePrice(TaxiRide ride) {
        return 50 + 20 * ride.getDistance()/ride.getPasCount();
    }
}
