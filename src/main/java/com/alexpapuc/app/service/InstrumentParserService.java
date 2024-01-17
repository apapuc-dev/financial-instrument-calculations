package com.alexpapuc.app.service;

import com.alexpapuc.app.model.InstrumentPricePoint;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class InstrumentParserService {
    private final String DATE_PATTERN = "dd-MMM-yyyy";
    public InstrumentPricePoint parse(String line) {
        String[] args = line.split(",");

        if (args.length != 3) {
            throw new IllegalArgumentException(String.format("'%s' is not a valid instrument price data", line));
        }
        String instrumentName = args[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN, Locale.ENGLISH);;
        LocalDate date = LocalDate.parse(args[1], formatter);
        Double price = Double.parseDouble(args[2]);

        return new InstrumentPricePoint(instrumentName, date, price);
    }
}
