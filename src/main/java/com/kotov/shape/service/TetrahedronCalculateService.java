package com.kotov.shape.service;

import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.exception.TetrahedronException;

public interface TetrahedronCalculateService {
    double calculateVolumeOfTetrahedron(Tetrahedron tetrahedron) throws TetrahedronException;

    double calculateAreaOfTetrahedron(Tetrahedron tetrahedron) throws TetrahedronException;

    double calculateHeightOfTetrahedron(Tetrahedron tetrahedron) throws TetrahedronException;

    double calculatePerimeterOfTetrahedron(Tetrahedron tetrahedron) throws TetrahedronException;
}