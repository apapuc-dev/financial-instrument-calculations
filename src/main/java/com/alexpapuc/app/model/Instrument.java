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
}
