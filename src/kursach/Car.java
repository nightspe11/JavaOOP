package kursach;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String make;
    private String model;
    private String modification;
    private String modelCode;
    private String year;
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

    public Car addPart(CarItem part) {
        parts.add(part);
        return this;
    }

    public Car addAllParts(CarItem... parts) {
        for (CarItem item : parts) {
            this.addPart(item);
        }
        return this;
    }

    public List<CarItem> getParts() {
        return parts;
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

    public Car updateCar() {
        /*
        update from file
         */
        return this;
    }
}
