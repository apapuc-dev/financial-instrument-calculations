package com.alexpapuc.app.model;

public enum Instrument {
    INSTRUMENT_1("INSTRUMENT1"),
    INSTRUMENT_2("INSTRUMENT2"),
    INSTRUMENT_3("INSTRUMENT3"),
    OTHER_INSTRUMENT(null);

    public final String name;
    Instrument(String name) {
        this.name = name;
    }

    public static Instrument fromName(String name) {
        if (INSTRUMENT_1.name.equals(name)) {
            return INSTRUMENT_1;
        } else if (INSTRUMENT_2.name.equals(name)) {
            return INSTRUMENT_2;
        } else if (INSTRUMENT_3.name.equals(name)) {
            return INSTRUMENT_3;
        }
        return OTHER_INSTRUMENT;
    }
}
