package com.kotov.shape.validator;

import com.kotov.shape.entity.Point;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.service.impl.PointCalculationServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronValidator {
    public static Logger logger = LogManager.getLogger();
    private static final int NUMBER_OF_PARAMETERS = 12;
    private static final double ALLOWABLE_ERROR = 0.0001;
    private static final String NUMBER = "-?\\d+\\.?\\d*?";

    public static boolean areParametersValid(String[] data) {
        if (data == null || data.length != NUMBER_OF_PARAMETERS) {
            return false;
        }
        boolean result = true;
        int index = 0;
        while (index < data.length) {
            if (!data[index].matches(NUMBER)) {
                result = false;
                break;
            }
            index++;
        }
        return result;
    }

    public static boolean isTetrahedronValid(Point a, Point b, Point c, Point d) {
        boolean result = false;
        if (a == null && b == null && c == null && d == null) {
            return result;
        }
        var service = new PointCalculationServiceImpl();
        try {
            double edgeAB = service.calculateLengthBetweenPoints(a, b);
            double edgeAC = service.calculateLengthBetweenPoints(a, c);
            double edgeAD = service.calculateLengthBetweenPoints(a, d);
            double edgeBC = service.calculateLengthBetweenPoints(b, c);
            double edgeBD = service.calculateLengthBetweenPoints(b, d);
            double edgeCD = service.calculateLengthBetweenPoints(c, d);

            if (a.getX() == b.getX() && b.getX() == c.getX() && a.getX() != d.getX()) {
                if (isEdgesAlmostEquals(edgeAB, edgeAC) && isEdgesAlmostEquals(edgeAB, edgeAD)
                        && isEdgesAlmostEquals(edgeAB, edgeBC) && isEdgesAlmostEquals(edgeAB, edgeBD)
                        && isEdgesAlmostEquals(edgeAB, edgeCD)) {
                    result = true;
                }
            }

            if (a.getY() == b.getY() && b.getY() == c.getY() && a.getY() != d.getY()) {
                if (isEdgesAlmostEquals(edgeAB, edgeAC) && isEdgesAlmostEquals(edgeAB, edgeAD)
                        && isEdgesAlmostEquals(edgeAB, edgeBC) && isEdgesAlmostEquals(edgeAB, edgeBD)
                        && isEdgesAlmostEquals(edgeAB, edgeCD)) {
                    result = true;
                }
            }

            if (a.getZ() == b.getZ() && b.getZ() == c.getZ() && a.getZ() != d.getZ()) {
                if (isEdgesAlmostEquals(edgeAB, edgeAC) && isEdgesAlmostEquals(edgeAB, edgeAD)
                        && isEdgesAlmostEquals(edgeAB, edgeBC) && isEdgesAlmostEquals(edgeAB, edgeBD)
                        && isEdgesAlmostEquals(edgeAB, edgeCD)) {
                    result = true;
                }
            }
        } catch (TetrahedronException e) {
            logger.log(Level.ERROR, "Unable to calculate edge of tetrahedron: ", e);
        }
        logger.log(Level.INFO, "Result is " + result);
        return result;
    }

    private static boolean isEdgesAlmostEquals(double a, double b) {
        boolean result = false;
        double diff = Math.abs(a - b);
        if (diff <= ALLOWABLE_ERROR) {
            result = true;
        }
        return result;
    }
}