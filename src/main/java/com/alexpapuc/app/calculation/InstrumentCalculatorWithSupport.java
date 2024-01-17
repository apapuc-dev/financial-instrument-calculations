package com.alexpapuc.app.calculation;

import com.alexpapuc.app.model.Instrument;

public interface InstrumentCalculatorWithSupport extends InstrumentCalculator {

    Instrument getSupportedInstrument();
}
