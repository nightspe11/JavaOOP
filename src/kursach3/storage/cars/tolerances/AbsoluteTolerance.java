package kursach3.storage.cars.tolerances;

import kursach3.io.Settings;
import kursach3.storage.cars.Parameter;
import java.io.Serializable;

public class AbsoluteTolerance implements Tolerance<Integer>, Serializable {
    private static final long serialVersionUID = Settings.version;
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
