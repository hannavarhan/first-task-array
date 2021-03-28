package com.epam.array.reader;

import com.epam.array.entity.ArrayEntity;
import com.epam.array.exception.ArrayException;
import com.epam.array.exception.ArrayValidatorException;
import com.epam.array.validator.StringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArrayReader {

    private final static Logger logger = LogManager.getLogger(ArrayReader.class);

    public ArrayEntity readArrayFromFile(String path) throws FileNotFoundException {
        ArrayEntity result = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                try {
                    result = StringValidator.validate(line);
                    logger.info("string " + line + " is read");
                    return result;
                } catch (ArrayValidatorException e) {
                    result = null;
                    line = reader.readLine();
                    logger.info("line is " + line);
                    logger.error("Invalid line");
                }
            }
        } catch (FileNotFoundException e) {
            logger.error("file " + path + " not found in read from file method");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("IOException in read from file method");
            e.printStackTrace();
        } catch (ArrayException e) {
            logger.error("array exception in read from file method");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                logger.error("problems with thread reader close in read from file method");
                e.printStackTrace();
            }
        }
        return result;
    }
}
