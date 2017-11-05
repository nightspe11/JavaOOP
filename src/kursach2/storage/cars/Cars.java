package kursach2.storage.cars;

import kursach2.storage.Storable;
import java.util.ArrayList;
import java.util.List;

public class Cars implements Storable<Object, Car> {
    List<Car> cars = new ArrayList<>();

    public Cars insert(Car car) {
        if (!cars.contains(car)) cars.add(car);
        return this;
    }

    @Override
    public Car select(String s) {
        Car ret = null;
        for (Car c : cars) {
            if ((c.getMake() + c.getModel() + c.getModelCode()).equals(s) || (c.getMake() + c.getModel() + c.getYear()).equals(s))
                ret = c;
        }
        return ret;
    }

    @Override
    public Cars delete(Car car) {
        cars.remove(car);
        return this;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
