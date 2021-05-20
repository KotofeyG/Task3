package com.kotov.shape.observer.impl;

import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.entity.TetrahedronParameter;
import com.kotov.shape.entity.TetrahedronWarehouse;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.observer.TetrahedronObserver;
import com.kotov.shape.observer.TetrahedronEvent;
import com.kotov.shape.service.impl.TetrahedronCalculateServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronObserverImpl implements TetrahedronObserver {
    public static Logger logger = LogManager.getLogger();

    @Override
    public void parametersChanged(TetrahedronEvent event) {
        var service = new TetrahedronCalculateServiceImpl();
        TetrahedronWarehouse warehouse = TetrahedronWarehouse.getInstance();
        Tetrahedron tetrahedron = event.getSource();
        try {
            double volume = service.calculateVolume(tetrahedron);
            double area = service.calculateArea(tetrahedron);
            double height = service.calculateHeight(tetrahedron);
            double perimeter = service.calculatePerimeter(tetrahedron);
            var parameter = new TetrahedronParameter(volume, area, height, perimeter);
            warehouse.putParameter(tetrahedron.getTetrahedronId(), parameter);
            logger.log(Level.INFO, "Parameters for tetrahedron is updated: id = "
                    + tetrahedron.getTetrahedronId() + ", volume = " + volume + ", area = " + area
                    + ", height = " + height + ", perimeter = " + perimeter);
        } catch (TetrahedronException e) {
            logger.log(Level.ERROR, "Parameters cannot be changed: " + e);
        }
    }
}