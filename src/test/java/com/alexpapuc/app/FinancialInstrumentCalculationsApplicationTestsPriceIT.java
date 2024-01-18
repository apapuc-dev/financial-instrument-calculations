package com.alexpapuc.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
class FinancialInstrumentCalculationsApplicationTestsPriceIT {

    @Autowired
    private FinancialInstrumentCalculationsApplication application;

    @Test
    public void testRunWithValidFile(CapturedOutput output) {
        application.run("example_input.txt");


        assertThat(output).contains("INSTRUMENT1: 3.36");
        assertThat(output).contains("INSTRUMENT2: 11.43");
        assertThat(output).contains("INSTRUMENT3: 268.16");
        assertThat(output).contains("INSTRUMENT4: 20.0");
    }

    @Test
    public void testRunWithMissingFile(CapturedOutput output) {
        application.run();

        assertThat(output).contains("Please provide the file name as input");
    }

}
