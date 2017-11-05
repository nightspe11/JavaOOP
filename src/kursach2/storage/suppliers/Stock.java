package kursach2.storage.suppliers;

import kursach2.storage.Storable;
import java.util.ArrayList;
import java.util.List;

public class Stock implements Storable<Object, StockItem> {
    private static int count;
    private final int stockID;
    private final String title;
    private int deliveryTime;
    private List<StockItem> items;

    public Stock(String title, int deliveryTime, List<StockItem> items) {
        this.stockID = count;
        count++;
        this.title = title;
        this.deliveryTime = deliveryTime;
        this.items = items;
    }

    public Stock(String title) {
        this(title, 14, new ArrayList<>());
    }

    public Stock() {
        this("Stock" + count);
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public List<StockItem> getItems() {
        return items;
    }

    @Override
    public StockItem select(String s) {
        StockItem ret = null;
        for (StockItem si: items) {
            if(si.getPartNumber().equals(s)) ret = si;
        }
        return ret;
    }

    @Override
    public Stock insert(StockItem stockItem) {
        this.items.add(stockItem);
        return this;
    }

    @Override
    public Object delete(StockItem stockItem) {
        this.items.remove(stockItem);
        return this;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockID=" + stockID +
                ", title='" + title + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (stockID != stock.stockID) return false;
        if (deliveryTime != stock.deliveryTime) return false;
        if (title != null ? !title.equals(stock.title) : stock.title != null) return false;
        return items != null ? items.equals(stock.items) : stock.items == null;
    }

    @Override
    public int hashCode() {
        int result = stockID;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + deliveryTime;
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }
}
