package hw3;

public class RunTaxiRide {
    public static void main(String[] args) {
        TaxiTarif ride1 = new StandardTariff();
        TaxiTarif ride2 = new FamilyTariff();

        TaxiRides rides = new TaxiRides();
        rides.addNewRide(new TaxiRide(200, 245, 4));
        rides.addNewRide(new TaxiRide(57, 23, 1));
        rides.addNewRide(new TaxiRide(17, 8, 2));

        System.out.println("Total Standard Tarif: " + rides.getPrice(ride1));
        System.out.println("Total Family Tarif: " + rides.getPrice(ride2));
    }
}
