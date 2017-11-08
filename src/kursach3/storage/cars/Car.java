package kursach3.storage.cars;

import kursach3.io.Settings;
import kursach3.storage.Storable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Car implements Storable<Object, CarItem>, Serializable {
    private static final long serialVersionUID = Settings.version;
    private final String make;
    private final String model;
    private final String modification;
    private final String modelCode;
    private final String year;
    private List<CarItem> parts;

    public Car(String make, String model, String modification, String modelCode, String year, List<CarItem> parts) {
        this.make = make;
        this.model = model;
        this.modification = modification;
        this.modelCode = modelCode;
        this.year = year;
        this.parts = parts;
    }

    public Car(String make, String model, String modification, String modelCode, String year) {
        this(make, model, modification, modelCode, year, new ArrayList<>());
    }

    public Car(String make, String model) {
        this(make, model, "", "", "", new ArrayList<>());
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getModification() {
        return modification;
    }

    public String getModelCode() {
        return modelCode;
    }

    public String getYear() {
        return year;
    }

    public List<CarItem> getParts() {
        return parts;
    }

    @Override
    public CarItem select(String s) {
        CarItem ret = null;
        for (CarItem ci : parts) {
            if (ci.getPartNumber().equals(s)) ret = ci;
        }
        return ret;
    }

    @Override
    public Car insert(CarItem carItem) {
        this.parts.add(carItem);
        return this;
    }

    public Car addAllParts(CarItem... parts) {
        for (CarItem item : parts) {
            this.insert(item);
        }
        return this;
    }

    @Override
    public Car delete(CarItem carItem) {
        this.parts.remove(carItem);
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", modification='" + modification + '\'' +
                ", modelCode='" + modelCode + '\'' +
                ", year=" + year +
                ", parts=" + parts +
                '}';
    }
}
