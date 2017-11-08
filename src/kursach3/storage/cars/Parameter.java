package kursach3.storage.cars;

import kursach3.io.Settings;
import kursach3.storage.cars.tolerances.AbsoluteTolerance;
import kursach3.storage.cars.tolerances.Tolerance;

import java.io.Serializable;

public class Parameter implements Serializable {
    private static final long serialVersionUID = Settings.version;
    private final String title;
    private final int value;
    private int increment;
    private int derement;
    private String description;
    private Tolerance tolerance;

    public Parameter(String title, int value, int increment, int derement, String description, Tolerance tolerance) {
        this.title = title;
        this.value = value;
        this.increment = increment;
        this.derement = derement;
        this.description = description;
        this.tolerance = tolerance;
    }

    public Parameter(String title, int value, String description) {
        this(title, value, 0, 0, description, null);
    }

    public Parameter(String title, int value) {
        this(title, value, 0, 0, "", null);
    }

    public Parameter(String title, String description) {
        this(title, -1, 0, 0, description, null);
    }

    public String getTitle() {
        return title;
    }

    public int getIncrement() {
        return increment;
    }

    public int getDerement() {
        return derement;
    }

    public int getValue() {
        return value;
    }

    public String getToleranceValue() {
        return tolerance.equals(new AbsoluteTolerance()) ?
                value + "+" + tolerance.getMaxValue(this) + "-" + tolerance.getMinValue(this)
                : value + "+" + tolerance.getMaxValue(this) + "%" + "-" + tolerance.getMinValue(this) + "%";
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Parameter{" +
                "title='" + title + '\'' +
                ", value=" + value +
                ", increment=" + increment +
                ", derement=" + derement +
                ", description='" + description + '\'' +
                '}';
    }
}
