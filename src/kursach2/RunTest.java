package kursach2;

import kursach2.delivery.NovaPoshta;
import kursach2.storage.cars.*;
import kursach2.storage.cars.tolerances.AbsoluteTolerance;
import kursach2.storage.cars.tolerances.Tolerance;
import kursach2.storage.offices.Office;
import kursach2.storage.offices.Offices;
import kursach2.storage.suppliers.Stock;
import kursach2.storage.suppliers.StockItem;
import kursach2.storage.suppliers.Stocks;
import kursach2.user.Client;
import kursach2.user.OrderStatus;

public class RunTest {
    public static void main(String[] args) {

        /**Offices*/
        Offices offices = new Offices();
        Office o1 = new Office("Main", "Location1", "9-20");
        Office o2 = new Office("Location 2");
        offices.insert(o1).insert(o2);
        //System.out.println(offices); //All offices

        /**Delivery NP*/ //TODO
        Client defaultClient = new Client();
        NovaPoshta np = new NovaPoshta();
        np.insert(new Office("NPLoc1")).insert(new Office("NPLoc2"));
        //System.out.println(np.toString()); //All NP departments
        System.out.println(np.getAddress(defaultClient,1)); //Selected department

        /**Check suppliers*/
        Stocks stocks = new Stocks();
        Stock s1 = new Stock("supl1");
        StockItem i1 = new StockItem("MR12345678", 10, 97);
        s1.insert(i1);
        Stock s2 = new Stock("supl2");
        s2.insert(new StockItem("MR12345678", 90)).insert(new StockItem("MZ928686", 8, 252));
        s1.setDeliveryTime(1);
        s1.insert(new StockItem("Mobil5W40", 1000, 1530));
        stocks.insert(s1).insert(s2);
        //System.out.println(stocks.toString()); //All items in stocks
        //System.out.println(s1.select("Mobil5W40")); //Single stock search
        //System.out.println(stocks.select("MR12345678").values()); //All stocks search

        /**Check Car classes */
        Cars cars = new Cars();
        Tolerance t = new AbsoluteTolerance();
        Car car1 = new Car("Mitsubishi", "Lancer", "2.0", "CS9A", "2007");
        Car car2 = new Car("VW", "Golf");
        CarItem c11 = new CarItem("MR12345678", 1, ItemType.ENGINE, "Alternator belt");
        c11.insert(new Parameter("Length", 1640, 5, 5, "6rib", t));
        CarItem c12 = new CarItem("Mobil5W40", ItemType.SERVICE);
        CarItem c21 = new CarItem("0A88666F");
        car1.addAllParts(c11, c12);
        car2.insert(c21);
        cars.insert(car1).insert(car2);
        /*try {
            System.out.println(c11.getStocksPrices(stocks).values());
        } catch (NullPointerException e) {
            System.out.println("Not found");
        }*/
        //System.out.println(cars.toString());    //All cars
        //System.out.println(car2.select("0A88666F")); //Check car for part

        /**Client*/
        Client regClient = new Client();
        regClient.registation("Ivan", "Ivanov", "098765432", "1", offices);
        //System.out.println(regClient.searchByPartNumber("MR12345678", stocks).values());
        //System.out.println(regClient.searchByCar("MR12345678", "MitsubishiLancer2007", cars).getStocksPrices(stocks).values());
        regClient.getCart().addStockItem(i1, 13);    //Generates notification
        //System.out.println(regClient.getCart());
        regClient.getCart().toOrder(regClient);
        //System.out.println(regClient.getOrders());
        regClient.getOrders().get(0).setOrderStatus(OrderStatus.COMPLETE);
        System.out.println(regClient.searchOrders(OrderStatus.COMPLETE));


    }
}
