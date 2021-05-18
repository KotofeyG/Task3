package com.kotov.shape.comparator;

import com.kotov.shape.entity.Tetrahedron;

import java.util.Comparator;

public class TetrahedronFirstPointZComparator implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        int result = 0;
        double firstPointZ1 = o1.getA().getZ();
        double firstPointZ2 = o2.getA().getZ();

        result = Double.compare(firstPointZ1, firstPointZ2);
        return result;
    }
}