package hw3;

import java.util.ArrayList;

public class TaxiRides {
    private ArrayList<TaxiRide> rides = new ArrayList<>();

    public void addNewRide(TaxiRide ride) {
        rides.add(ride);
    }

    public long getPrice(TaxiTarif taxi){
        long totalPrice = 0;
        for (TaxiRide taxiRide : rides) {
            totalPrice += taxi.calculatePrice(taxiRide);
        }
        return totalPrice;
    }
}
