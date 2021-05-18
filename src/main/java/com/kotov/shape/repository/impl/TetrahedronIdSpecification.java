package com.kotov.shape.repository.impl;

import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.repository.Specification;

public class TetrahedronIdSpecification implements Specification {
    private long id;

    public TetrahedronIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        boolean result = tetrahedron.getTetrahedronId() == id;
        return result;
    }
}