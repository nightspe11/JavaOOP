package kursach;


public class RunTest {
    public static void main(String[] args) {
        /**Check Car classes */
        Car car1 = new Car("Mitsubishi", "Lancer", "2.0", "CS9A", "2007");
        Car car2 = new Car("VW", "Golf");
        CarItem c11 = new CarItem("MR12345678", 2, ItemType.BRAKES);
        CarItem c12 = new CarItem("Mobil5W40", 5, ItemType.SERVICE);
        CarItem c21 = new CarItem("0A88666F");
        car1.addAllParts(c11, c12);
        car2.addPart(c21);
        //System.out.println(car1.toString());
        //System.out.println(car2.toString());

        /**Check Stock related classes*/
        Stocks stocks = new Stocks();
        Stock s1 = new Stock("supl1");
        StockItem i1 = new StockItem("MR12345678", 10, 100);
        s1.addItem(i1);
        Stock s2 = new Stock("supl2");
        s2.addItem(new StockItem("MR12345678", 90)).addItem(new StockItem("MZ928686", 8, 252));
        stocks.addStock(s1).addStock(s2);

        //s2.inStock(i1);
        //stocks.checkAllStocks(i1);
        // System.out.println(stocks.toString());


        /**Check client functions */
        Client client = new Client();
        client.registation("Ivan", "Ivanov", "0998765432", 2);
        client.getCart().addStockItem(i1,20);
        System.out.println(client);
        System.out.println(s1.toString());

    }
}
