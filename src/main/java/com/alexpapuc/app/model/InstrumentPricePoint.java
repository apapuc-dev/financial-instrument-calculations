package com.alexpapuc.app.model;

import java.time.LocalDate;

public record InstrumentPricePoint(String instrumentName, LocalDate date, Double price) {
}
