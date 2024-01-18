package com.alexpapuc.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "INSTRUMENT_PRICE_MODIFIER")
@Getter
@Setter
@NoArgsConstructor
public class InstrumentPriceModifierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "MULTIPLIER")
    private Double multiplier;

    public InstrumentPriceModifierEntity(String name, Double multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }
}
