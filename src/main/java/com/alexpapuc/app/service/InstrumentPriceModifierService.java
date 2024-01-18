package com.alexpapuc.app.service;

import com.alexpapuc.app.entity.InstrumentPriceModifierEntity;
import com.alexpapuc.app.model.Instrument;
import com.alexpapuc.app.repository.InstrumentPriceModifierRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.alexpapuc.app.model.Instrument.INSTRUMENT_1;
import static com.alexpapuc.app.model.Instrument.INSTRUMENT_2;

@Service
@Slf4j
public class InstrumentPriceModifierService {

    private final InstrumentPriceModifierRepository repository;

    public InstrumentPriceModifierService(InstrumentPriceModifierRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        log.info("Initializing INSTRUMENT_PRICE_MODIFIER with dummy data");
        repository.save(new InstrumentPriceModifierEntity(INSTRUMENT_1.name, 1.0));
        repository.save(new InstrumentPriceModifierEntity(INSTRUMENT_2.name, 1.235));
        repository.save(new InstrumentPriceModifierEntity(Instrument.INSTRUMENT_3.name, 2.5));
    }

    public double getMultiplier(String name) {
        return repository.findByName(name)
                .map(InstrumentPriceModifierEntity::getMultiplier)
                .orElse(1.0);
    }
}
