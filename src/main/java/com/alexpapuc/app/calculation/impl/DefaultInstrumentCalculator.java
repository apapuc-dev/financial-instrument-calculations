package com.alexpapuc.app.calculation.impl;

import com.alexpapuc.app.calculation.InstrumentCalculator;
import com.alexpapuc.app.model.InstrumentPricePoint;
import com.alexpapuc.app.model.PricePoint;
import com.alexpapuc.app.model.SortedLinkedList;

import java.time.LocalDate;
import java.util.LinkedList;

public class DefaultInstrumentCalculator implements InstrumentCalculator {

    private final LinkedList<PricePoint> newest10ElementsList;

    public DefaultInstrumentCalculator() {
        this.newest10ElementsList = new SortedLinkedList<>();
    }

    @Override
    public void addDataPoint(InstrumentPricePoint instrumentPricePoint) {
        LocalDate date = instrumentPricePoint.date();

        if (newest10ElementsList.getFirst().date().isBefore(date)) {
            newest10ElementsList.add(new PricePoint(date, instrumentPricePoint.price()));

            if (newest10ElementsList.size() > 10) {
                newest10ElementsList.removeFirst();
            }
        }
    }

    @Override
    public double getFinalResult() {
        return newest10ElementsList.stream()
                .mapToDouble(PricePoint::price)
                .sum();
    }
}