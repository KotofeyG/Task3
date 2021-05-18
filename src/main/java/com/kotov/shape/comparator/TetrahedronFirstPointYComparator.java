package com.kotov.shape.comparator;

import com.kotov.shape.entity.Tetrahedron;

import java.util.Comparator;

public class TetrahedronFirstPointYComparator implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        int result = 0;
        double firstPointY1 = o1.getA().getY();
        double firstPointY2 = o2.getA().getY();

        result = Double.compare(firstPointY1, firstPointY2);
        return result;
    }
}