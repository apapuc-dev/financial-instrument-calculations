package com.alexpapuc.app.calculation.impl;

import com.alexpapuc.app.calculation.InstrumentCalculatorWithSupport;
import com.alexpapuc.app.model.Instrument;
import com.alexpapuc.app.model.InstrumentPricePoint;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;

@Service
public class Instrument3Calculator implements InstrumentCalculatorWithSupport {
    private double priceSum = 0;
    private int instrumentsCount = 0;

    @Override
    public Instrument getSupportedInstrument() {
        return Instrument.INSTRUMENT_3;
    }

    @Override
    public void addDataPoint(InstrumentPricePoint instrumentPricePoint) {
        LocalDate date = instrumentPricePoint.date();

        if (date.getMonth().equals(Month.SEPTEMBER) && date.getYear() == 2014) {
            priceSum += instrumentPricePoint.price();
            instrumentsCount++;
        }
    }

    @Override
    public double getFinalResult() {
        return priceSum / instrumentsCount;
    }
}