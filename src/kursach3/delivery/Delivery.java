package kursach3.delivery;

import kursach3.user.Client;
import java.math.BigDecimal;

public interface Delivery {
    BigDecimal getPrice();
    String getAddress(Client client, int index);
    String getDatails(Client client);
}
