package kursach2.storage.cars.tolerances;

import kursach2.storage.cars.Parameter;

public class AbsoluteTolerance implements Tolerance<Integer> {
    @Override
    public Integer getMaxValue(Parameter parameter) {
        return parameter.getValue() + parameter.getIncrement();
    }

    @Override
    public Integer getMinValue(Parameter parameter) {
        return (parameter.getValue() - parameter.getDerement()) < parameter.getValue()
                ? (parameter.getValue() - parameter.getDerement())
                : (parameter.getValue() + parameter.getDerement());
    }
}
