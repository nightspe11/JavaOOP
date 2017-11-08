package kursach3.delivery;

import kursach3.storage.Storable;
import kursach3.storage.offices.Office;
import kursach3.user.Client;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NovaPoshta implements Delivery, Storable<Object, Office> {

    private final BigDecimal minPrice = BigDecimal.valueOf(25);
    private List<Office> departments = new ArrayList<>();

    @Override
    public BigDecimal getPrice() {
        return minPrice;
    }

    @Override
    public String getAddress(Client client, int index) {
        return this.departments.get(index).getAddress();
    }

    @Override
    public String getDatails(Client client) {
        return "Price may by greater than specified!";
    }

    @Override
    public String toString() {
        return "NovaPoshta{" +
                "minPrice=" + minPrice +
                ", departmentsWithAddress=" + departments +
                '}';
    }

    @Override
    public NovaPoshta select(String s) {
        return this;
    }

    @Override
    public NovaPoshta insert(Office office) {
        departments.add(office);
        return this;
    }

    @Override
    public NovaPoshta delete(Office office) {
        departments.remove(office);
        return this;
    }
}
