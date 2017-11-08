package kursach3.delivery;

import kursach3.user.Client;
import java.math.BigDecimal;

public class LocalPickup implements Delivery {

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(0);
    }

    @Override
    public String getAddress(Client client, int index) {
        return client.getOffice().getAddress();
    }

    @Override
    public String getDatails(Client client) {
        return client.getOffice().getwHours();
    }

    @Override
    public String toString() {
       return  "LocalPickup";
    }
}
