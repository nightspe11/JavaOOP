package kursach3;

import kursach3.delivery.*;
import kursach3.io.*;
import kursach3.storage.cars.*;
import kursach3.storage.cars.tolerances.AbsoluteTolerance;
import kursach3.storage.cars.tolerances.Tolerance;
import kursach3.storage.offices.*;
import kursach3.storage.suppliers.*;
import kursach3.user.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RunTest {
    public static void main(String[] args) {
        Client regClient = new Client();
        Offices offices = new Offices();
        Stocks stocks = new Stocks();
        Cars cars = new Cars();

        /**Offices*/
        Office o1 = new Office("Main", "Location1", "9-20");
        Office o2 = new Office("Location 2");
        offices.insert(o1).insert(o2);
        System.out.println(offices); //All offices


        /**Delivery NP*/ //TODO
        NovaPoshta np = new NovaPoshta();
        np.insert(new Office("NPLoc1")).insert(new Office("NPLoc2"));
        //System.out.println(np.toString()); //All NP departments
        //System.out.println(np.getAddress(regClient, 1)); //Selected department

        /**Check suppliers*/
        Stock s1 = new Stock("supl1");
        StockItem i1 = new StockItem("MR12345678", 10, 97);
        s1.insert(i1);
        Stock s2 = new Stock("supl2");
        s2.insert(new StockItem("MR12345678", 90)).insert(new StockItem("MZ928686", 8, 252));
        s1.setDeliveryTime(1);
        s1.insert(new StockItem("Mobil5W40", 1000, 1530));
        stocks.insert(s1).insert(s2);
        //System.out.println(stocks.toString()); //All items in stocks
        System.out.println("Single stock search " + s1.select("Mobil5W40")); //Single stock search
        System.out.println("All stocks search " + stocks.select("MR12345678").values()); //All stocks search

        /**Check Car classes + IO binary*/
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
        try {
            System.out.println(c11.getStocksPrices(stocks).values());
        } catch (NullPointerException e) {
            System.out.println("Not found");
        }
        System.out.println(car2.select("0A88666F")); //Check car for part
        /**IO binary*/
        try {
            cars = BinaryFilesConverter.restoreFromFile(Settings.path + "cars.dat", Cars.class);
        } catch (ClassNotFoundException e) {
            System.out.println("No such class or incorect file! " + e.getStackTrace());
        } catch (IOException e) {
            System.out.println("Unable to read data! " + e.getMessage());
        }
        try {
            BinaryFilesConverter.convertIntoFile(cars, Settings.path + "cars.dat");
        } catch (IOException e) {
            System.out.println("Unable to write file! " + e.getStackTrace());
        }
        //System.out.println(cars.toString());    //All cars

        /**Client*/
        regClient.registation("Ivan", "Ivanov", "098765432", "1", offices);
        //System.out.println(regClient.searchByPartNumber("MR12345678", stocks).values());
        //System.out.println(regClient.searchByCar("MR12345678", "MitsubishiLancer2007", cars).getStocksPrices(stocks).values());
        //regClient.getCart().addStockItem(i1, 13);    //Generates notification
        //System.out.println(regClient.getCart());
        //regClient.getCart().toOrder(regClient);
        //System.out.println(regClient.getOrders());
        //regClient.getOrders().get(0).setOrderStatus(OrderStatus.COMPLETE);
        ////System.out.println(regClient.searchOrders(OrderStatus.COMPLETE));

        /**Output text*/
        try {
            StocksWriter.StocksToFile(stocks, Settings.path + "stocks.txt", Settings.delimiters);
        } catch (IOException e) {
            System.out.println("Unable to write file! " + e.getStackTrace());
        }
        /**Input text*/
        try {
            System.out.println(StocksReader.readLinesFromFile(Settings.path + "stocks.txt", stocks, Settings.delimiters));
        } catch (FileNotFoundException e) {
            System.out.println("No such file " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Something went wrong while reading file " + e.getStackTrace());
        }
    }
}
