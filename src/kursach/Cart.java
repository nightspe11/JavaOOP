package kursach;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {
    private String cartID;
    private List<StockItem> items;

    public Cart() {
        this.cartID = UUID.randomUUID().toString();
        this.items = new ArrayList<>();
    }

    public Cart addStockItem(StockItem item, int count) {
        items.add(item.setNewQuantity(count));
        return this;
    }

    @Override
    public String toString() {
        return "Cart{" + "cartID='" + cartID + '\'' +
                ", items=" + items +
                '}';
    }

    public Order toOrder() {
        return new Order(this);
    }

}
