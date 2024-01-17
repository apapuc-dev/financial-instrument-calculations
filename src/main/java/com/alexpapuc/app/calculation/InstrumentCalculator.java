package com.alexpapuc.app.calculation;

import com.alexpapuc.app.model.InstrumentPricePoint;

public interface InstrumentCalculator {

    void addDataPoint(InstrumentPricePoint instrumentPricePoint);
    double getFinalResult();
}
