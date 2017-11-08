package kursach3.storage.cars.tolerances;

import kursach3.io.Settings;
import kursach3.storage.cars.Parameter;
import java.io.Serializable;

public class DescriptionMatch implements Tolerance<String>, Serializable {
    private static final long serialVersionUID = Settings.version;
    @Override
    public String getMaxValue(Parameter parameter) {
        return parameter.getDescription();
    }

    @Override
    public String getMinValue(Parameter parameter) {
        return parameter.getDescription();
    }
}
