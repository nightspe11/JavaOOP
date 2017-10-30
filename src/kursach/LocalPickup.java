package kursach;

import java.math.BigDecimal;

public class LocalPickup implements Delivery {

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(0);
    }

    @Override
    public String getAddress() {
        return Offices.DEFAULT_MAIN.toString();
    }

    @Override
    public String getDatails() {
        return "*Some additional info";
    }
}
