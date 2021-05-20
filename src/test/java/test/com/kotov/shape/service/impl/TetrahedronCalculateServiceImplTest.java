package test.com.kotov.shape.service.impl;

import com.kotov.shape.entity.Point;
import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.service.impl.TetrahedronCalculateServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TetrahedronCalculateServiceImplTest {
    Tetrahedron tetrahedron;
    TetrahedronCalculateServiceImpl service;

    @BeforeClass
    public void setUpService() throws TetrahedronException {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0.5, 0.86602, 0);
        Point d = new Point(0.5, 0.28867, 0.81649);
        tetrahedron = new Tetrahedron(a, b, c, d);
        service = new TetrahedronCalculateServiceImpl();
    }

    @Test
    public void testCalculateVolumeOfTetrahedron() throws TetrahedronException {
        double actual = service.calculateVolume(tetrahedron);
        double expected = 0.11785113019775793;
        assertEquals(actual, expected, "Wrong formula is used");
    }

    @Test
    public void testCalculateAreaOfTetrahedron() throws TetrahedronException {
        double actual = service.calculateArea(tetrahedron);
        double expected = 1.7320508075688772;
        assertEquals(actual, expected, "Wrong formula is used");
    }

    @Test
    public void testCalculateHeightOfTetrahedron() throws TetrahedronException {
        double actual = service.calculateHeight(tetrahedron);
        double expected = 0.816496580927726;
        assertEquals(actual, expected, "Wrong formula is used");
    }

    @Test
    public void testCalculatePerimeterOfTetrahedron() throws TetrahedronException {
        double actual = service.calculatePerimeter(tetrahedron);
        double expected = 6.0;
        assertEquals(actual, expected, "Wrong formula is used");
    }

    @Test(expectedExceptionsMessageRegExp = "Calculation of volume cannot be completed. Argument contains null")
    public void testCalculateVolumeOfTetrahedronException() {
        try {
            service.calculateVolume(null);
            fail("Test calculateVolumeOfTetrahedron method for null should have thrown TetrahedronException");
        } catch (TetrahedronException e) {
            assertEquals("Calculation of volume cannot be completed. Argument contains null", e.getMessage());
        }
    }

    @Test(expectedExceptionsMessageRegExp = "Calculation of area cannot be completed. Argument contains null")
    public void testCalculateAreaOfTetrahedronException() {
        try {
            service.calculateArea(null);
            fail("Test calculateAreaOfTetrahedron method for null should have thrown TetrahedronException");
        } catch (TetrahedronException e) {
            assertEquals("Calculation of area cannot be completed. Argument contains null", e.getMessage());
        }
    }

    @Test(expectedExceptionsMessageRegExp = "Calculation of height cannot be completed. Argument contains null")
    public void testCalculateHeightOfTetrahedronException() {
        try {
            service.calculateHeight(null);
            fail("Test calculateHeightOfTetrahedron method for null should have thrown TetrahedronException");
        } catch (TetrahedronException e) {
            assertEquals("Calculation of height cannot be completed. Argument contains null", e.getMessage());
        }
    }

    @Test(expectedExceptionsMessageRegExp = "Calculation of perimeter cannot be completed. Argument contains null")
    public void testCalculatePerimeterOfTetrahedronException() {
        try {
            service.calculatePerimeter(null);
            fail("Test calculatePerimeterOfTetrahedron method for null should have thrown TetrahedronException");
        } catch (TetrahedronException e) {
            assertEquals("Calculation of perimeter cannot be completed. Argument contains null", e.getMessage());
        }
    }
}