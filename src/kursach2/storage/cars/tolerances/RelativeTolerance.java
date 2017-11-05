package kursach2.storage.cars.tolerances;

import kursach2.storage.cars.Parameter;

public class RelativeTolerance implements Tolerance<Integer> {
    @Override
    public Integer getMaxValue(Parameter parameter) {
        return (parameter.getValue() + parameter.getIncrement() * parameter.getValue());
    }

    @Override
    public Integer getMinValue(Parameter parameter) {
        return (parameter.getValue() - parameter.getIncrement() * parameter.getValue());
    }
}
