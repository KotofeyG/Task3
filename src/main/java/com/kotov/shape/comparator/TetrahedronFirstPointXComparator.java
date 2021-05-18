package com.kotov.shape.comparator;

import com.kotov.shape.entity.Tetrahedron;

import java.util.Comparator;

public class TetrahedronFirstPointXComparator implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        int result = 0;
        double firstPointX1 = o1.getA().getX();
        double firstPointX2 = o2.getA().getX();

        result = Double.compare(firstPointX1, firstPointX2);
        return result;
    }
}