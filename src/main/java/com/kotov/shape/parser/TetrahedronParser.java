package com.kotov.shape.parser;

import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.validator.TetrahedronValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TetrahedronParser {
    public static Logger logger = LogManager.getLogger();
    private final static String DELIMITER_PATTERN = "\\s+";

    public List<Double> parseTetrahedronParameters(String data) throws TetrahedronException {
        if (data == null) {
            throw new TetrahedronException("Argument contains null");
        }
        String[] splitData = data.split(DELIMITER_PATTERN);
        if (!TetrahedronValidator.areParametersValid(splitData)) {
            throw new TetrahedronException("Argument contains invalid parameters");
        }
        List<Double> parameters = Arrays.stream(splitData)
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        logger.log(Level.INFO, "Tetrahedron parameters are parsed successfully: " + parameters);
        return parameters;
    }

    public List<Double[]> parseTetrahedronsParameters(List<String> data) throws TetrahedronException {
        if (data == null || data.size() == 0) {
            throw new TetrahedronException("Argument contains null or empty");
        }
        List<Double[]> groupsOfParameters = data.stream()
                .map(line -> line.split(DELIMITER_PATTERN))
                .filter(TetrahedronValidator::areParametersValid)
                .map(numericStrings -> Arrays.stream(numericStrings)
                        .map(Double::parseDouble)
                        .toArray(Double[]::new))
                .collect(Collectors.toList());
        if (groupsOfParameters.size() == 0) {
            throw new TetrahedronException("Argument contains invalid group of parameters");
        }
        logger.log(Level.INFO, "Tetrahedrons parameters are parsed successfully: " + groupsOfParameters);
        return groupsOfParameters;
    }
}