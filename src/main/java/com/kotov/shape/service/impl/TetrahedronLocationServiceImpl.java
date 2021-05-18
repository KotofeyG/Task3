package com.kotov.shape.service.impl;

import com.kotov.shape.entity.Point;
import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.service.TetrahedronLocationService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronLocationServiceImpl implements TetrahedronLocationService {
    public static Logger logger = LogManager.getLogger();

    @Override
    public boolean isBaseOnCoordinateLineXY(Tetrahedron tetrahedron) throws TetrahedronException {
        if (tetrahedron == null) {
            throw new TetrahedronException("Calculation cannot be completed. Argument contains null");
        }
        logger.log(Level.DEBUG, tetrahedron);
        boolean result = false;
        Point a = tetrahedron.getA();
        Point b = tetrahedron.getB();
        Point c = tetrahedron.getC();
        Point d = tetrahedron.getD();

        if (a.getZ() == 0 && b.getZ() == 0 && c.getZ() == 0) {
            result = true;
        } else if (a.getZ() == 0 && b.getZ() == 0 && d.getZ() == 0) {
            result = true;
        } else if (b.getZ() == 0 && c.getZ() == 0 && d.getZ() == 0) {
            result = true;
        } else if (a.getZ() == 0 && c.getZ() == 0 && d.getZ() == 0) {
            result = true;
        }
        logger.log(Level.INFO, "Result is " + result);
        return result;
    }

    @Override
    public boolean isBaseOnCoordinateLineXZ(Tetrahedron tetrahedron) throws TetrahedronException {
        if (tetrahedron == null) {
            throw new TetrahedronException("Calculation cannot be completed. Argument contains null");
        }
        logger.log(Level.DEBUG, tetrahedron);
        boolean result = false;
        Point a = tetrahedron.getA();
        Point b = tetrahedron.getB();
        Point c = tetrahedron.getC();
        Point d = tetrahedron.getD();

        if (a.getY() == 0 && b.getY() == 0 && c.getY() == 0) {
            result = true;
        } else if (a.getY() == 0 && b.getY() == 0 && d.getY() == 0) {
            result = true;
        } else if (b.getY() == 0 && c.getY() == 0 && d.getY() == 0) {
            result = true;
        } else if (a.getY() == 0 && c.getY() == 0 && d.getY() == 0) {
            result = true;
        }
        logger.log(Level.INFO, "Result is " + result);
        return result;
    }

    @Override
    public boolean isBaseOnCoordinateLineYZ(Tetrahedron tetrahedron) throws TetrahedronException {
        if (tetrahedron == null) {
            throw new TetrahedronException("Calculation cannot be completed. Argument contains null");
        }
        logger.log(Level.DEBUG, tetrahedron);
        boolean result = false;
        Point a = tetrahedron.getA();
        Point b = tetrahedron.getB();
        Point c = tetrahedron.getC();
        Point d = tetrahedron.getD();

        if (a.getX() == 0 && b.getX() == 0 && c.getX() == 0) {
            result = true;
        } else if (a.getX() == 0 && b.getX() == 0 && d.getX() == 0) {
            result = true;
        } else if (b.getX() == 0 && c.getX() == 0 && d.getX() == 0) {
            result = true;
        } else if (a.getX() == 0 && c.getX() == 0 && d.getX() == 0) {
            result = true;
        }
        logger.log(Level.INFO, "Result is " + result);
        return result;
    }
}