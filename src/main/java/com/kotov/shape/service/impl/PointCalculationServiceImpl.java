package com.kotov.shape.service.impl;

import com.kotov.shape.entity.Point;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.service.PointCalculationService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointCalculationServiceImpl implements PointCalculationService {
    public static Logger logger = LogManager.getLogger();

    @Override
    public double calculateLengthBetweenPoints(Point a, Point b) throws TetrahedronException {
        if (a == null || b == null) {
            throw new TetrahedronException("Calculation of length between two points cannot be completed."
                    + " Argument(s) contains null");
        }
        logger.log(Level.DEBUG, "a = " + a + ", b = " + b);
        double distance = Math.sqrt(Math.pow((b.getX() - a.getX()), 2)
                + Math.pow((b.getY() - a.getY()), 2)
                + Math.pow((b.getZ() - a.getZ()), 2));
        logger.log(Level.INFO, "Calculation of length between two points is successful. Result is " + distance);
        return distance;
    }
}