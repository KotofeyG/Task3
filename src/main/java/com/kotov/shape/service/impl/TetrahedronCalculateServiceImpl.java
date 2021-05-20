package com.kotov.shape.service.impl;

import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.service.TetrahedronCalculateService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronCalculateServiceImpl implements TetrahedronCalculateService {
    public static Logger logger = LogManager.getLogger();

    @Override
    public double calculateVolume(Tetrahedron tetrahedron) throws TetrahedronException {
        if (tetrahedron == null) {
            throw new TetrahedronException("Calculation of volume cannot be completed. Argument contains null");
        }
        var service = new PointCalculationServiceImpl();
        double edge = service.calculateLengthBetweenPoints(tetrahedron.getA(), tetrahedron.getB());
        double volume = Math.pow(edge, 3) * Math.sqrt(2) / 12;
        logger.log(Level.INFO, "Calculation of volume is successful. Result is " + volume);
        return volume;
    }

    @Override
    public double calculateArea(Tetrahedron tetrahedron) throws TetrahedronException {
        if (tetrahedron == null) {
            throw new TetrahedronException("Calculation of area cannot be completed. Argument contains null");
        }
        var service = new PointCalculationServiceImpl();
        double edge = service.calculateLengthBetweenPoints(tetrahedron.getA(), tetrahedron.getB());
        double area = Math.pow(edge, 2) * Math.sqrt(3);
        logger.log(Level.INFO, "Calculation of area is successful. Result is " + area);
        return area;
    }

    @Override
    public double calculateHeight(Tetrahedron tetrahedron) throws TetrahedronException {
        if (tetrahedron == null) {
            throw new TetrahedronException("Calculation of height cannot be completed. Argument contains null");
        }
        var service = new PointCalculationServiceImpl();
        double edge = service.calculateLengthBetweenPoints(tetrahedron.getA(), tetrahedron.getB());
        double height = edge * Math.sqrt(2.0 / 3.0);
        logger.log(Level.INFO, "Calculation of height is successful. Result is " + height);
        return height;
    }

    @Override
    public double calculatePerimeter(Tetrahedron tetrahedron) throws TetrahedronException {
        if (tetrahedron == null) {
            throw new TetrahedronException("Calculation of perimeter cannot be completed. Argument contains null");
        }
        var service = new PointCalculationServiceImpl();
        double edge = service.calculateLengthBetweenPoints(tetrahedron.getA(), tetrahedron.getB());
        double perimeter = edge * 6;
        logger.log(Level.INFO, "Calculation of perimeter is successful. Result is " + perimeter);
        return perimeter;
    }
}