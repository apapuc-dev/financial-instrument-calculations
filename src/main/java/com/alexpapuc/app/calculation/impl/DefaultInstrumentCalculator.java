package com.alexpapuc.app.calculation.impl;

import com.alexpapuc.app.calculation.InstrumentCalculator;
import com.alexpapuc.app.model.InstrumentPricePoint;

import java.time.LocalDate;
import java.time.Month;

public class DefaultInstrumentCalculator implements InstrumentCalculator {
    private double priceSum = 0;
    private int instrumentsCount = 0;

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