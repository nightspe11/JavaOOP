package kursach2.storage.cars;

import kursach2.storage.GeneralItem;
import kursach2.storage.suppliers.Stocks;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarItem extends GeneralItem {
    private final ItemType itemType;
    private List<Parameter> parameters = new ArrayList<>();
    private final String description;


    public CarItem(String partNumber, int quantity, ItemType itemType, List<Parameter> parameters, String description) {
        super(partNumber, quantity);
        this.itemType = itemType;
        this.parameters = parameters;
        this.description = description;
    }

    public CarItem(String partNumber, int quantity, ItemType itemType, String description) {
        this(partNumber, quantity, itemType, new ArrayList<>(), description);
    }

    public CarItem(String partNumber, int quantity) {
        this(partNumber, quantity, ItemType.GENERAL, null, "");
    }

    public CarItem(String partNumber, ItemType itemType) {
        this(partNumber, 1, ItemType.GENERAL, null, "");
    }

    public CarItem(String partNumber) {
        this(partNumber, 1, ItemType.GENERAL, null, "");
    }

    public ItemType getItemType() {
        return itemType;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public String getDescription() {
        return description;
    }

    public Map getStocksPrices(Stocks stocks) {
        if (stocks != null) return stocks.select(super.getPartNumber());
        else return null;
    }

    @Override
    public String toString() {
        return "CarItem{" + super.toString() +
                ", itemType=" + itemType +
                ", parameters=" + parameters +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public Parameter select(String s) {
        Parameter ret = null;
        for (Parameter p : parameters) {
            if (p.getTitle().equals(s)) ret = p;
        }
        return ret;
    }

    @Override
    public CarItem insert(Object o) {
        if (!parameters.contains(o)) parameters.add((Parameter) o);
        return this;
    }

    @Override
    public CarItem delete(Object o) {
        parameters.remove(o);
        return this;
    }
}
