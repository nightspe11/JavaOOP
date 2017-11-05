package kursach2.user;

import kursach2.storage.suppliers.StockItem;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {
    private final String cartId;
    private List<StockItem> items;

    public Cart() {
        this.cartId = UUID.randomUUID().toString();
        this.items = new ArrayList<>();
    }

    public Cart addStockItem(StockItem item, int count) {
        items.add(item.setNewQuantity(count));
        return this;
    }

    public int getTotalAmount() {
        int ret = 0;
        for (StockItem si : items) {
            ret= ret+si.getPrice()*si.getQuantity();
        }
        return ret;
    }

    public void toOrder(Client client) {
        if (client.getClientType().equals(ClientType.REGISTRED)) {
            client.getOrders().add(new Order(this));
        } else new Order(this);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }
}
