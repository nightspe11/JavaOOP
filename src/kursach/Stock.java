package kursach;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private static int count;
    private int stockID;
    private String title;
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

    public Stock addItem(IItem item) {
        items.add((StockItem) item);
        return this;
    }

    public void removeAllItem(IItem item) {
        items.remove(item);
    }

    public StockItem inStock(IItem item) {
        try {
            for (IItem i : items)
                if (i.getPartNumber().equals(item.getPartNumber())) return (StockItem) items.get(items.indexOf(item));
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        String out = "Stock ID=" + stockID + ", title=" + title + ", items:\n";
        for (IItem i : items) {
            out += i.toString() + "\n";
        }
        return out;
    }

    public Stock updateStock() {
        /*
        update from file
         */
        return this;
    }
}
