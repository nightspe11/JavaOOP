package kursach2.storage.suppliers;

import kursach2.storage.GeneralItem;
import kursach2.user.Client;

public class StockItem extends GeneralItem implements Cloneable {
    private final int price;

    public StockItem(String partNumber, int quantity, int price) {
        super(partNumber, quantity);
        this.price = price;
    }

    public StockItem(String partNumber, int price) {
        super(partNumber);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public StockItem setNewQuantity(int quantity) {
        StockItem tmp = (StockItem) this.clone();
        if (this.getQuantity() < quantity) System.out.println("Only " + this.getQuantity() + " items avaliable!");
        else tmp.setQuantity(quantity);
        return tmp;
    }

    public void addtoCart(Client client, int count) {
        client.getCart().addStockItem(this, count);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Unable to clone!");
            return null;
        }
    }

    @Override
    public String toString() {
        return "StockItem{" + super.toString() + ", " +
                "price=" + price +
                '}';
    }
}
