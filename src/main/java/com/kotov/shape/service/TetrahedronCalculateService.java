package com.kotov.shape.service;

import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.exception.TetrahedronException;

public interface TetrahedronCalculateService {
    double calculateVolume(Tetrahedron tetrahedron) throws TetrahedronException;

    double calculateArea(Tetrahedron tetrahedron) throws TetrahedronException;

    double calculateHeight(Tetrahedron tetrahedron) throws TetrahedronException;

    double calculatePerimeter(Tetrahedron tetrahedron) throws TetrahedronException;
}