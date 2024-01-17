package com.alexpapuc.app.service;

import com.alexpapuc.app.model.InstrumentPricePoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Stream;

@Service
@Slf4j
public class InstrumentFileReaderService {

    private final InstrumentParserService instrumentParserService;
    private BufferedReader bufferedReader;
    private Iterator<String> fileIterator;

    public InstrumentFileReaderService(InstrumentParserService instrumentParserService) {
        this.instrumentParserService = instrumentParserService;
    }

    public Stream<String> openFile(String fileName) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(fileName));
        return bufferedReader.lines();
//        fileIterator = bufferedReader.lines().iterator();
    }

    public boolean hasNext() {
        return fileIterator.hasNext();
    }

    public InstrumentPricePoint nextInstrument() {
        if (hasNext()) {
            String line = fileIterator.next();
            return instrumentParserService.parse(line);
        }
        return null;
    }

    public void close() {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}