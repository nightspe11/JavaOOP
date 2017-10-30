package kursach;

import java.util.UUID;

public abstract class GeneralItem implements IItem {
    private String ID;
    private String partNumber;
    private int quantity;

    public GeneralItem(String partNumber, int quantity) {
        this.ID = UUID.randomUUID().toString();
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

    @Override
    public String getPartNumber() {
        return partNumber;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "partNumber='" + partNumber + '\'' +
                ", quantity=" + quantity;
    }
}
