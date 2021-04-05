package com.epam.array.main;

import com.epam.array.entity.ArrayEntity;
import com.epam.array.exception.ArrayException;
import com.epam.array.parser.StringParser;
import com.epam.array.reader.ArrayReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;

public class MainClass {

    private final static Logger logger = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {
        ClassLoader loader = MainClass.class.getClassLoader();
        URL resource = loader.getResource("file/array2.txt");
        String path = new File(resource.getFile()).getAbsolutePath();
        try {
            ArrayReader reader = new ArrayReader();
            String arrayLine = reader.readArrayLineFromFile(path);
            StringParser parser = new StringParser();
            int[] array = parser.parseStringIntoArray(arrayLine);
            ArrayEntity entity = new ArrayEntity(array);
            logger.info("Main result is " + entity);
        } catch (ArrayException exception) {
            logger.error("Exception in main");
        }
    }
}
