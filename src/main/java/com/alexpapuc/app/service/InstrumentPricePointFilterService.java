package com.alexpapuc.app.service;

import com.alexpapuc.app.model.InstrumentPricePoint;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;

@Service
public class InstrumentPricePointFilterService {

    public boolean filterNonBusinessDate(InstrumentPricePoint instrumentPricePoint) {

        DayOfWeek dayOfWeek = instrumentPricePoint.date().getDayOfWeek();

        return dayOfWeek != DayOfWeek.SUNDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }
}
