package kursach;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stocks {
    private List<Stock> stocks = new ArrayList<>();

    public Stocks addStock(Stock stock) {
        stocks.add(stock);
        return this;
    }

    public List<StockItem> checkAllStocks(String partNumber) {
        List<StockItem> items = new ArrayList<>();
        //items.addAll(stocks.stream().filter(stock ->CarItem.)); //TODO
        return items;
    }

    @Override
    public String toString() {
        for (Stock s : stocks) {
            System.out.println(s.toString());
        }
        return "";
    }
}
