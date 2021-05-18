package com.kotov.shape.repository.impl;

import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.repository.Specification;

public class TetrahedronInFourthOctantSpecification implements Specification {
    @Override
    public boolean specify(Tetrahedron ob) {
        boolean result = false;
        if (ob.getA().getX() > 0 && ob.getA().getY() < 0 && ob.getA().getZ() > 0) {
            if (ob.getB().getX() > 0 && ob.getB().getY() < 0 && ob.getB().getZ() > 0) {
                if (ob.getC().getX() > 0 && ob.getC().getY() < 0 && ob.getC().getZ() > 0) {
                    if (ob.getD().getX() > 0 && ob.getD().getY() < 0 && ob.getD().getZ() > 0) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }
}
