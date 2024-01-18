package com.alexpapuc.app.calculation.impl;

import com.alexpapuc.app.calculation.InstrumentCalculatorWithSupport;
import com.alexpapuc.app.model.Instrument;
import com.alexpapuc.app.model.InstrumentPricePoint;
import org.springframework.stereotype.Service;

@Service
public class Instrument3Calculator implements InstrumentCalculatorWithSupport {
    private double squaredPriceSum = 0;
    private int instrumentsCount = 0;

    @Override
    public Instrument getSupportedInstrument() {
        return Instrument.INSTRUMENT_3;
    }

    @Override
    public void addDataPoint(InstrumentPricePoint instrumentPricePoint) {
        squaredPriceSum += Math.pow(instrumentPricePoint.price(), 2);
        instrumentsCount++;
    }

    @Override
    public double getFinalResult() {
        return Math.sqrt(squaredPriceSum / instrumentsCount);
    }
}