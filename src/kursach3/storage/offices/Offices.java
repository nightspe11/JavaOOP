package kursach3.storage.offices;

import kursach3.io.Settings;
import kursach3.storage.Storable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Offices implements Storable<Object, Office> , Serializable{
    private static final long serialVersionUID = Settings.version;
    List<Office> offices = new ArrayList<>();

    @Override
    public Offices insert(Office o) {
        offices.add((Office) o);
        return this;
    }

    @Override
    public Offices delete(Office o) {
        offices.remove(o);
        return this;
    }

    @Override
    public Office select(String s) {
        //return offices.stream().filter(o -> o.getTitle().equals(s) || o.getOfficeID().equals(s)).collect(Collectors.toList());
        Office ret = null;
        for (Office o : offices) {
            if (o.getTitle().equals(s) || o.getOfficeID().equals(s)) ret = o;
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Offices{" +
                "offices=" + offices +
                '}';
    }
}

