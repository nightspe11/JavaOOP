package kursach3.storage.cars;

import kursach3.io.Settings;

import java.io.Serializable;

public enum ItemType implements Serializable {
    GENERAL,
    BRAKES,
    SERVICE,
    CHASIS,
    ELECTRICS,
    ENGINE,
    TRANSMISSION,
    SUSPENSION,
    STEARLING;

    private static final long serialVersionUID = Settings.version;
}

