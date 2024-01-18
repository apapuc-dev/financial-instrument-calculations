package com.alexpapuc.app.repository;

import com.alexpapuc.app.entity.InstrumentPriceModifierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstrumentPriceModifierRepository extends JpaRepository<InstrumentPriceModifierEntity, Long> {
    Optional<InstrumentPriceModifierEntity> findByName(String name);
}
