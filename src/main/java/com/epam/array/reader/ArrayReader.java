package com.epam.array.reader;

import com.epam.array.exception.ArrayException;
import com.epam.array.validator.StringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArrayReader {

    private final static Logger logger = LogManager.getLogger(ArrayReader.class);

    public String readArrayLineFromFile(String path) throws ArrayException {
        String result = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
                if (StringValidator.isArray(line)) {
                    result = line;
                    logger.info("string " + line + " is read");
                    return result;
                } else {
                    logger.error("line " + line + " is invalid");
                    result = null;
                    line = reader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            logger.error("file " + path + " not found in read from file method");
            throw new ArrayException("file not found in read from file method");
        } catch (IOException e) {
            logger.error("IOException in read from file method");
            throw new ArrayException("IOException in read from file method");
        }
        return result;
    }
}
