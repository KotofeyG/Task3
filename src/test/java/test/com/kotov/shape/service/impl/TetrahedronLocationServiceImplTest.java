package test.com.kotov.shape.service.impl;

import com.kotov.shape.entity.Point;
import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.service.impl.TetrahedronLocationServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TetrahedronLocationServiceImplTest {
    Tetrahedron tetrahedron;
    TetrahedronLocationServiceImpl service;

    @BeforeClass
    public void setUpService() {
        service = new TetrahedronLocationServiceImpl();
    }

    @Test
    public void testIsBaseOnCoordinateLineXY() throws TetrahedronException {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0.5, 0.86602, 0);
        Point d = new Point(0.5, 0.28867, 0.81649);
        tetrahedron = new Tetrahedron(a, b, c, d);
        boolean condition = service.isBaseOnCoordinateLineXY(tetrahedron);
        assertTrue(condition);
    }

    @Test
    public void testIsBaseOnCoordinateLineXZ() throws TetrahedronException {
        Point a = new Point(1, 0, 0);
        Point b = new Point(4, 0, 0);
        Point c = new Point(2.5, 0, 2.598076211353316);
        Point d = new Point(2.5, 2.449489742783178, 0.8660254037844386);
        tetrahedron = new Tetrahedron(a, b, c, d);
        boolean condition = service.isBaseOnCoordinateLineXZ(tetrahedron);
        assertTrue(condition);
    }

    @Test
    public void testIsBaseOnCoordinateLineYZ() throws TetrahedronException {
        Point a = new Point(10, 0, 0);
        Point b = new Point(0, 0, 0);
        Point c = new Point(0, 0, 3);
        Point d = new Point(0, 3, 1);
        tetrahedron = new Tetrahedron(a, b, c, d);
        boolean condition = service.isBaseOnCoordinateLineXZ(tetrahedron);
        assertTrue(condition);
    }

    @Test(expectedExceptionsMessageRegExp = "Calculation cannot be completed. Argument contains null")
    public void testIsBaseOnCoordinateLineXYException() {
        try {
            service.isBaseOnCoordinateLineXY(null);
            fail("Test isBaseOnCoordinateLineXY for null should have thrown TetrahedronException");
        } catch (TetrahedronException e) {
            assertEquals("Calculation cannot be completed. Argument contains null", e.getMessage());
        }
    }

    @Test(expectedExceptionsMessageRegExp = "Calculation cannot be completed. Argument contains null")
    public void testIsBaseOnCoordinateLineXZException() {
        try {
            service.isBaseOnCoordinateLineXZ(null);
            fail("Test isBaseOnCoordinateLineXZ for null should have thrown TetrahedronException");
        } catch (TetrahedronException e) {
            assertEquals("Calculation cannot be completed. Argument contains null", e.getMessage());
        }
    }

    @Test(expectedExceptionsMessageRegExp = "Calculation cannot be completed. Argument contains null")
    public void testIsBaseOnCoordinateLineYZException() {
        try {
            service.isBaseOnCoordinateLineYZ(null);
            fail("Test isBaseOnCoordinateLineYZ for null should have thrown TetrahedronException");
        } catch (TetrahedronException e) {
            assertEquals("Calculation cannot be completed. Argument contains null", e.getMessage());
        }
    }
}