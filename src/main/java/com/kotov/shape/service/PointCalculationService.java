package com.kotov.shape.service;

import com.kotov.shape.entity.Point;
import com.kotov.shape.exception.TetrahedronException;

public interface PointCalculationService {
    double calculateLengthBetweenPoints(Point a, Point b) throws TetrahedronException;
}