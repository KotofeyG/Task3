package com.kotov.shape.factory;

import com.kotov.shape.entity.Point;
import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.validator.TetrahedronValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronFactory {
    public static Logger logger = LogManager.getLogger();
    private static final int NUMBER_OF_PARAMETERS = 12;

    public static Tetrahedron createTetrahedron(List<Double> coordinates) throws TetrahedronException {
        if (coordinates == null || coordinates.size() != NUMBER_OF_PARAMETERS) {
            throw new TetrahedronException("Unable to create Tetrahedron object. "
                    + "Argument contains null or wrong number of parameters");
        }
        Point a = new Point(coordinates.get(0), coordinates.get(1), coordinates.get(2));
        Point b = new Point(coordinates.get(3), coordinates.get(4), coordinates.get(5));
        Point c = new Point(coordinates.get(6), coordinates.get(7), coordinates.get(8));
        Point d = new Point(coordinates.get(9), coordinates.get(10), coordinates.get(11));
        if (!TetrahedronValidator.isTetrahedronValid(a, b, c, d)) {
            throw new TetrahedronException("Incorrect data for creating tetrahedron");
        }
        Tetrahedron tetrahedron = new Tetrahedron(a, b, c, d);
        logger.log(Level.INFO, "Tetrahedron is created successfully: " + tetrahedron);
        return tetrahedron;
    }

    public static List<Tetrahedron> createListOfTetrahedrons(List<Double[]> parameters) throws TetrahedronException {
        if (parameters == null || parameters.isEmpty()) {
            throw new TetrahedronException("Unable to create Tetrahedron object. Argument contains null or empty");
        }
        List<Tetrahedron> tetrahedrons = new ArrayList<>();
        Point a;
        Point b;
        Point c;
        Point d;
        for (Double[] coordinates : parameters) {
            if (coordinates == null || coordinates.length != NUMBER_OF_PARAMETERS) {
                logger.log(Level.ERROR, "Unable to create Tetrahedron object. "
                        + "Argument contains null or wrong number of parameters");
                continue;
            }
            a = new Point(coordinates[0], coordinates[1], coordinates[2]);
            b = new Point(coordinates[3], coordinates[4], coordinates[5]);
            c = new Point(coordinates[6], coordinates[7], coordinates[8]);
            d = new Point(coordinates[9], coordinates[10], coordinates[11]);
            if (!TetrahedronValidator.isTetrahedronValid(a, b, c, d)) {
                logger.log(Level.ERROR, "Incorrect data for creating tetrahedron");
                continue;
            }
            tetrahedrons.add(new Tetrahedron(a, b, c, d));
        }
        if (tetrahedrons.isEmpty()) {
            throw new TetrahedronException("There is not correct data for creating tetrahedrons");
        }
        logger.log(Level.INFO, "Tetrahedrons are created successfully: " + tetrahedrons);
        return tetrahedrons;
    }
}