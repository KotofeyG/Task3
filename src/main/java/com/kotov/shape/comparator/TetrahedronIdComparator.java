package com.kotov.shape.comparator;

import com.kotov.shape.entity.Tetrahedron;

import java.util.Comparator;

public class TetrahedronIdComparator implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        int result = Long.compare(o1.getTetrahedronId(), o2.getTetrahedronId());
        return result;
    }
}