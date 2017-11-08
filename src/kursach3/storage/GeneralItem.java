package kursach3.storage;

import kursach3.io.Settings;
import java.io.Serializable;
import java.util.UUID;

public abstract class GeneralItem implements Storable, Serializable {
    private static final long serialVersionUID = Settings.version;
    private final String id;
    private final String partNumber;
    private int quantity;

    public GeneralItem(String partNumber, int quantity) {
        this.id = UUID.randomUUID().toString();
        this.partNumber = partNumber;
        this.quantity = quantity;
    }

    public GeneralItem(String partNumber) {
        this(partNumber, 1);
    }

    public GeneralItem setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "partNumber='" + partNumber + '\'' +
                ", quantity=" + quantity;
    }

    @Override
    public Object select(String s) {
        return null;
    }

    @Override
    public Object insert(Object o) {
        return null;
    }

    @Override
    public Object delete(Object o) {
        return null;
    }
}
