package kursach2.storage.cars.tolerances;

import kursach2.storage.cars.Parameter;

public class DescriptionMatch implements Tolerance<String> {
    @Override
    public String getMaxValue(Parameter parameter) {
        return parameter.getDescription();
    }

    @Override
    public String getMinValue(Parameter parameter) {
        return parameter.getDescription();
    }
}
