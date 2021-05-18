package com.kotov.shape.repository.impl;

import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.entity.TetrahedronParameter;
import com.kotov.shape.entity.Warehouse;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.repository.Specification;
import com.kotov.shape.service.impl.TetrahedronCalculateServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class TetrahedronVolumeRangeSpecification implements Specification {
    public static Logger logger = LogManager.getLogger();
    private double fromVolume;
    private double toVolume;

    public TetrahedronVolumeRangeSpecification(double fromVolume, double toVolume) {
        this.fromVolume = fromVolume;
        this.toVolume = toVolume;
    }

    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        double volume = 0;
        boolean result = false;
        Warehouse warehouse = Warehouse.getInstance();
        Optional<TetrahedronParameter> optional = warehouse.get(tetrahedron.getTetrahedronId());
        if (optional.isPresent()) {
            TetrahedronParameter parameter = optional.get();
            volume = parameter.getVolume();
        } else {
            var service = new TetrahedronCalculateServiceImpl();
            try {
                volume = service.calculateVolumeOfTetrahedron(tetrahedron);
            } catch (TetrahedronException e) {
                logger.log(Level.ERROR, "Calculation error: ", e);
                return result;
            }
        }
        result = (volume >= fromVolume && volume <= toVolume);
        return result;
    }
}