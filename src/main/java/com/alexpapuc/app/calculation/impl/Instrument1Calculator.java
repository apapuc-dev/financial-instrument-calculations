package com.alexpapuc.app.calculation.impl;

import com.alexpapuc.app.calculation.InstrumentCalculatorWithSupport;
import com.alexpapuc.app.model.Instrument;
import com.alexpapuc.app.model.InstrumentPricePoint;
import org.springframework.stereotype.Service;

@Service
public class Instrument1Calculator implements InstrumentCalculatorWithSupport {
    private double priceSum = 0;
    private int instrumentsCount = 0;

    @Override
    public Instrument getSupportedInstrument() {
        return Instrument.INSTRUMENT_1;
    }

    @Override
    public void addDataPoint(InstrumentPricePoint instrumentPricePoint) {
        priceSum += instrumentPricePoint.price();
        instrumentsCount++;
    }

    @Override
    public double getFinalResult() {
        return priceSum / instrumentsCount;
    }
}
