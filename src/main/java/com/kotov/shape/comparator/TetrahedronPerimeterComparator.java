package com.kotov.shape.comparator;

import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.entity.TetrahedronParameter;
import com.kotov.shape.entity.TetrahedronWarehouse;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.service.impl.TetrahedronCalculateServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.Optional;

public class TetrahedronPerimeterComparator implements Comparator<Tetrahedron> {
    public static Logger logger = LogManager.getLogger();

    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        int result = 0;
        double perimeter1 = 0;
        double perimeter2 = 0;
        TetrahedronWarehouse warehouse = TetrahedronWarehouse.getInstance();
        Optional<TetrahedronParameter> optional1 = warehouse.getParameter(o1.getTetrahedronId());
        Optional<TetrahedronParameter> optional2 = warehouse.getParameter(o2.getTetrahedronId());

        if (optional1.isPresent()) {
            TetrahedronParameter parameter1 = optional1.get();
            perimeter1 = parameter1.getPerimeter();
        } else {
            var service = new TetrahedronCalculateServiceImpl();
            try {
                perimeter1 = service.calculatePerimeter(o1);
            } catch (TetrahedronException e) {
                logger.log(Level.ERROR, "Calculation error: ", e);
                return -1;
            }
        }
        if (optional2.isPresent()) {
            TetrahedronParameter parameter2 = optional2.get();
            perimeter2 = parameter2.getPerimeter();
        } else {
            var service = new TetrahedronCalculateServiceImpl();
            try {
                perimeter2 = service.calculatePerimeter(o2);
            } catch (TetrahedronException e) {
                logger.log(Level.ERROR, "Calculation error: ", e);
                return 1;
            }
        }
        result = Double.compare(perimeter1, perimeter2);
        return result;
    }
}