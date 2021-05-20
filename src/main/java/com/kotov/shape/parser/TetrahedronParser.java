package com.kotov.shape.parser;

import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.validator.TetrahedronValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TetrahedronParser {
    public static Logger logger = LogManager.getLogger();
    private final static String DELIMITER_PATTERN = "\\s+";

    public List<Double> parseTetrahedronParameters(String data) throws TetrahedronException {
        if (data == null || data.isEmpty()) {
            throw new TetrahedronException("Unable to parse parameters. Argument contains null");
        }
        String[] splitData = data.split(DELIMITER_PATTERN);
        if (!TetrahedronValidator.areParametersValid(splitData)) {
            logger.log(Level.ERROR, "Unable to parse parameters. Argument contains invalid data: "
                    + Arrays.toString(splitData));
            return new ArrayList<>();
        }
        List<Double> parameters = Arrays.stream(splitData)
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        logger.log(Level.INFO, "Tetrahedron parameters are parsed successfully: " + parameters);
        return parameters;
    }

    public List<Double[]> parseTetrahedronsParameters(List<String> data) throws TetrahedronException {
        if (data == null || data.isEmpty()) {
            throw new TetrahedronException("Unable to parse parameters. Argument contains null or empty");
        }
        List<Double[]> parameters = data.stream()
                .map(line -> line.split(DELIMITER_PATTERN))
                .filter(TetrahedronValidator::areParametersValid)
                .map(numericStrings -> Arrays.stream(numericStrings)
                        .map(Double::parseDouble)
                        .toArray(Double[]::new))
                .collect(Collectors.toList());
        if (parameters.isEmpty()) {
            logger.log(Level.ERROR, "Unable to parse parameters. Argument contains invalid data: " + data);
        } else {
            logger.log(Level.INFO, "Tetrahedrons parameters are parsed successfully: " + data);
        }
        return parameters;
    }
}