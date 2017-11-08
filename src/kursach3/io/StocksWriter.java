package kursach3.io;

import kursach3.storage.suppliers.Stock;
import kursach3.storage.suppliers.StockItem;
import kursach3.storage.suppliers.Stocks;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StocksWriter {

    public static void StocksToFile(Stocks stocks, String file, String... sep) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.print(StocksToString(stocks, sep));
        }
    }

    public static String StocksToString(Stocks stocks, String... sep) {
        String ret = "";
        for (Stock s : stocks) {
            ret += s.getTitle() + sep[0] + s.getDeliveryTime() + sep[0];
            for (StockItem si : s) {
                ret += si.getPartNumber() + sep[1] + si.getQuantity() + sep[1] + si.getPrice() + sep[2];
            }
            ret = ret.substring(0, ret.length() - 1) + "\n";
        }
        return ret;
    }
}
