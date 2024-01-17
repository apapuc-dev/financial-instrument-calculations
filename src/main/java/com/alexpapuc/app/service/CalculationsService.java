package com.alexpapuc.app.service;

import com.alexpapuc.app.calculation.InstrumentCalculator;
import com.alexpapuc.app.calculation.InstrumentCalculatorWithSupport;
import com.alexpapuc.app.calculation.impl.DefaultInstrumentCalculator;
import com.alexpapuc.app.model.InstrumentPricePoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CalculationsService {

    private final Map<String, InstrumentCalculator> instrumentCalculatorMap;

    public CalculationsService(List<InstrumentCalculatorWithSupport> instrumentCalculatorList) {
        instrumentCalculatorMap = instrumentCalculatorList.stream()
                .collect(Collectors.toMap(
                        instrument -> instrument.getSupportedInstrument().name, x -> x));
    }

    public void addDataPoint(InstrumentPricePoint pricePoint) {

        String name = pricePoint.instrumentName();
        InstrumentCalculator instrumentCalculator = instrumentCalculatorMap.get(name);

        if (Objects.isNull(instrumentCalculator)) {
            instrumentCalculator = new DefaultInstrumentCalculator();
            instrumentCalculatorMap.put(name, instrumentCalculator);
        }
        instrumentCalculator.addDataPoint(pricePoint);
    }

    public void logFinalResults() {
        log.info("Results:");
        instrumentCalculatorMap.entrySet().forEach(this::logFinalResult);
    }

    private void logFinalResult(Map.Entry<String, InstrumentCalculator> entry) {
        log.info("{}: {}", entry.getKey(), entry.getValue().getFinalResult());
    }
}
