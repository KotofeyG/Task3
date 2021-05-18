package com.kotov.shape.comparator;

import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.entity.TetrahedronParameter;
import com.kotov.shape.entity.Warehouse;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.service.impl.TetrahedronCalculateServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.Optional;

public class TetrahedronHeightComparator implements Comparator<Tetrahedron> {
    public static Logger logger = LogManager.getLogger();

    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        int result = 0;
        double height1 = 0;
        double height2 = 0;
        Warehouse warehouse = Warehouse.getInstance();
        Optional<TetrahedronParameter> optional1 = warehouse.get(o1.getTetrahedronId());
        Optional<TetrahedronParameter> optional2 = warehouse.get(o2.getTetrahedronId());

        if (optional1.isPresent()) {
            TetrahedronParameter parameter1 = optional1.get();
            height1 = parameter1.getHeight();
        } else {
            var service = new TetrahedronCalculateServiceImpl();
            try {
                height1 = service.calculateHeightOfTetrahedron(o1);
            } catch (TetrahedronException e) {
                logger.log(Level.ERROR, "Calculation error: ", e);
                return -1;
            }
        }
        if (optional2.isPresent()) {
            TetrahedronParameter parameter2 = optional2.get();
            height2 = parameter2.getHeight();
        } else {
            var service = new TetrahedronCalculateServiceImpl();
            try {
                height2 = service.calculateHeightOfTetrahedron(o2);
            } catch (TetrahedronException e) {
                logger.log(Level.ERROR, "Calculation error: ", e);
                return 1;
            }
        }
        result = Double.compare(height1, height2);
        return result;
    }
}