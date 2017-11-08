package kursach3.io;

import kursach3.storage.suppliers.Stock;
import kursach3.storage.suppliers.StockItem;
import kursach3.storage.suppliers.Stocks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static kursach3.io.ParseInt.parseInt;

public class StocksReader {
    public static Stocks readLinesFromFile(String file, Stocks stocks, String... sep) throws IOException {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                stocks.insert(StockFromCsv(line, sep));
            }
        }
        return stocks;
    }

    public static Stock StockFromCsv(String s, String... sep) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        String[] tokens = s.split(sep[0]);
        String title = tokens[0];
        int deliveryTime = parseInt(tokens[1]);
        List<StockItem> items = new ArrayList<>();
        String[] tokens2 = tokens[2].split(sep[2]);
        for (int i = 0; i < tokens2.length; i++) {
            String[] tokens3 = tokens2[i].split(sep[1]);
            String pn = tokens3[0];
            int q = parseInt(tokens3[1]);
            int p = parseInt(tokens3[2]);
            items.add(new StockItem(pn, q, p));
        }
        return new Stock(title, deliveryTime, items);
    }
}
