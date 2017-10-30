package kursach;

import java.math.BigDecimal;

public class StockItem extends GeneralItem {
    private BigDecimal price;

    public StockItem(String partNumber, int quantity, int price) {
        super(partNumber, quantity);
        this.price = BigDecimal.valueOf(price);
    }

    public StockItem(String partNumber, int price) {
        super(partNumber);
        this.price = BigDecimal.valueOf(price);
    }

    public BigDecimal getPrice() {
        return price;
    }


    public StockItem setNewQuantity(int quantity) { //TODO check total stock avaliability
        StockItem tmp = (StockItem) this.clone();
        tmp.setQuantity(quantity);
        return tmp;
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
        return "StockItem \t" + super.toString() +
                ", price=" + price;
    }
}
