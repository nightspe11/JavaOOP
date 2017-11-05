package kursach2.storage.cars.tolerances;

import kursach2.storage.cars.Parameter;

public interface Tolerance <T>{
    T getMaxValue(Parameter parameter);
    T getMinValue(Parameter parameter);
}
