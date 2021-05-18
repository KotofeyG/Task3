package com.kotov.shape.repository;

import com.kotov.shape.entity.Tetrahedron;

@FunctionalInterface
public interface Specification {
    boolean specify(Tetrahedron tetrahedron);
}
