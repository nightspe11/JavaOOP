package kursach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarItem extends GeneralItem {
    private ItemType itemType;
    private List<Parameter> parameters = new ArrayList<>();
    private String description;


    public CarItem(String partNumber, int quantity, ItemType itemType, List<Parameter> parameters, String description) {
        super(partNumber, quantity);
        this.itemType = itemType;
        this.parameters = parameters;
        this.description = description;
    }

    public CarItem(String partNumber, int quantity, ItemType itemType) {
        this(partNumber, quantity, itemType, new ArrayList<>(), "");
    }

    public CarItem(String partNumber, int quantity) {
        this(partNumber, quantity, ItemType.GENERAL, Arrays.asList(new Parameter()), "");//check parameters
    }

    public CarItem(String partNumber) {
        this(partNumber, 1, ItemType.GENERAL, Arrays.asList(new Parameter()), "");
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

    @Override
    public String toString() {
        return "CarItem{" + super.toString() +
                ", itemType=" + itemType +
                ", parameters=" + parameters +
                ", description='" + description + '\'' +
                '}';
    }
}
