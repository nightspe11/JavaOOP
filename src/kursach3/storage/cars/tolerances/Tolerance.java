package kursach3.storage.cars.tolerances;

import kursach3.storage.cars.Parameter;
import java.io.Serializable;

public interface Tolerance <T>  extends Serializable{
    T getMaxValue(Parameter parameter);
    T getMinValue(Parameter parameter);
}
