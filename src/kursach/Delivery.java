package kursach;

import java.math.BigDecimal;

public interface Delivery {
    BigDecimal getPrice();
    String getAddress();
    String getDatails();
}
