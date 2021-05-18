package com.kotov.shape.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse {
    private final static Warehouse instance = new Warehouse();
    private Map<Long, TetrahedronParameter> map = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public Optional<TetrahedronParameter> get(long id) {
        TetrahedronParameter parameter = map.get(id);
        return parameter != null
                ? Optional.of(parameter)
                : Optional.empty();
    }

    public void put(long id, TetrahedronParameter parameter) {
        map.put(id, parameter);
    }

    public void remove(long id) {
        map.remove(id);
    }
}