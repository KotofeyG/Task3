package com.kotov.shape.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileValidator {
    public static Logger logger = LogManager.getLogger();

    public static boolean isFileValid(String pathToFile) {
        boolean result = false;
        if (pathToFile != null) {
            Path path = Paths.get(pathToFile);
            try {
                if (Files.exists(path) && !Files.isDirectory(path) && Files.isReadable(path) && Files.size(path) != 0) {
                    result = true;
                }
            } catch (IOException e) {
                logger.log(Level.WARN, "Error reading file " + pathToFile);
            }
        }
        return result;
    }
}