package com.kotov.shape.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TetrahedronWarehouse {
    private final static TetrahedronWarehouse instance = new TetrahedronWarehouse();
    private Map<Long, TetrahedronParameter> map = new HashMap<>();

    private TetrahedronWarehouse() {
    }

    public static TetrahedronWarehouse getInstance() {
        return instance;
    }

    public Optional<TetrahedronParameter> getParameter(long id) {
        TetrahedronParameter parameter = map.get(id);
        return parameter != null
                ? Optional.of(parameter)
                : Optional.empty();
    }

    public void putParameter(long id, TetrahedronParameter parameter) {
        map.put(id, parameter);
    }

    public void removeParameter(long id) {
        map.remove(id);
    }
}