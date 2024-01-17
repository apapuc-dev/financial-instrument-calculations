package com.alexpapuc.app;

import com.alexpapuc.app.service.CalculationsService;
import com.alexpapuc.app.service.InstrumentFileReaderService;
import com.alexpapuc.app.service.InstrumentParserService;
import com.alexpapuc.app.service.InstrumentPricePointFilterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
@AutoConfiguration
@Slf4j
public class FinancialInstrumentCalculationsApplication implements CommandLineRunner {

    private final InstrumentFileReaderService instrumentFileReader;
    private final InstrumentParserService instrumentParser;
    private final CalculationsService calculationsService;
    private final InstrumentPricePointFilterService instrumentFilter;

    public FinancialInstrumentCalculationsApplication(InstrumentFileReaderService instrumentFileReader, InstrumentParserService instrumentParser, CalculationsService calculationsService, InstrumentPricePointFilterService instrumentFilter) {
        this.instrumentFileReader = instrumentFileReader;
        this.instrumentParser = instrumentParser;
        this.calculationsService = calculationsService;
        this.instrumentFilter = instrumentFilter;
    }

    public static void main(String[] args) {
        SpringApplication.run(FinancialInstrumentCalculationsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (args.length > 0) {

            try {
                instrumentFileReader.openFile(args[0])
                    .map(instrumentParser::parse)
                    .filter(instrumentFilter::filterNonBusinessDate)
                    .forEach(calculationsService::addDataPoint);

                calculationsService.logFinalResults();
                instrumentFileReader.close();


            } catch (FileNotFoundException e) {
                log.error(e.getMessage(), e);
            }
        } else {
            log.warn("Please provide the file name as input");
        }
    }
}
