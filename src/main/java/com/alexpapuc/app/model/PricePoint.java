package com.alexpapuc.app.model;

import java.time.LocalDate;

public record PricePoint(LocalDate date, Double price) implements Comparable<PricePoint> {
    @Override
    public int compareTo(PricePoint o) {
        return this.date.compareTo(o.date);
    }
}