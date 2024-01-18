package com.alexpapuc.app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

@Service
@Slf4j
public class InstrumentFileReaderService {
    private BufferedReader bufferedReader;

    /**
     * Opens a file and returns a Stream the elements of which are lines read from the file
     *
     * @param fileName the file path of the file to be opened
     * @return a Stream, the elements of which are lines read from the file
     * @throws FileNotFoundException
     */
    public Stream<String> openFileStream(String fileName) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(fileName));
        return bufferedReader.lines();
    }

    /**
     * Closes the file opened via openFileStream(String) method
     */
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