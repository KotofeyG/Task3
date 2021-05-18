package com.kotov.shape.reader;

import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.validator.FileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {
    public static Logger logger = LogManager.getLogger();

    public List<String> readDataFromFile(String pathToFile) throws TetrahedronException {
        if (!FileValidator.isFileValid(pathToFile)) {
            logger.log(Level.ERROR, "Wrong argument. Unable to read data from " + pathToFile);
            throw new TetrahedronException("Wrong argument. Unable to read data from " + pathToFile);
        }
        Path path = Paths.get(pathToFile);
        try (Stream<String> lineStream = Files.lines(path)) {
            List<String> data = lineStream.collect(Collectors.toList());
            return data;
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error reading data in " + pathToFile);
            throw new TetrahedronException("Error reading data in " + pathToFile);
        }
    }
}