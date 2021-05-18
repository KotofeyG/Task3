package com.kotov.shape.service;

import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.exception.TetrahedronException;

public interface TetrahedronLocationService {
    boolean isBaseOnCoordinateLineXY(Tetrahedron tetrahedron) throws TetrahedronException;

    boolean isBaseOnCoordinateLineXZ(Tetrahedron tetrahedron) throws TetrahedronException;

    boolean isBaseOnCoordinateLineYZ(Tetrahedron tetrahedron) throws TetrahedronException;
}
