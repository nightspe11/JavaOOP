package kursach2.storage.suppliers;

import kursach2.storage.Storable;
import java.util.*;

public class Stocks implements Storable<Object, Stock>, Iterable {
    private List<Stock> stocks = new ArrayList<>();

    @Override
    public Map select(String s) throws NullPointerException { //Sorted by price TODO NullPointerException
        Map<Integer, StockItem> ret = new TreeMap<>();
        for (Stock stock : stocks) {
            if (stock.select(s).getPartNumber().equals(s)) ret.put(stock.select(s).getPrice(), stock.select(s));
        }
        return ret;
    }

    @Override
    public Stocks insert(Stock stock) {
        stocks.add(stock);
        return this;
    }

    @Override
    public Stocks delete(Stock stock) {
        stocks.remove(stock);
        return this;
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "stocks=" + stocks +
                '}';
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return stocks.contains(stocks.get(index++));
            }

            @Override
            public Object next() {
                return stocks.get(index);
            }
        };
    }
}
