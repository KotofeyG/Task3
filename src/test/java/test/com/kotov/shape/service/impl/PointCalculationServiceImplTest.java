package test.com.kotov.shape.service.impl;

import com.kotov.shape.entity.Point;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.service.impl.PointCalculationServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PointCalculationServiceImplTest {
    private PointCalculationServiceImpl service;

    @BeforeClass
    public void setUpService() {
        service = new PointCalculationServiceImpl();
    }

    @Test
    public void testCalculateLengthBetweenPoints() throws TetrahedronException {
        Point a = new Point(1, 1, 1);
        Point b = new Point(3, 3, 3);
        double actual = service.calculateLengthBetweenPoints(a, b);
        double expected = 3.4641016151377544;
        assertEquals(actual, expected, "Wrong formula is used");
    }

    @Test(expectedExceptionsMessageRegExp = "Calculation of length between two points cannot be completed."
            + " Argument(s) contains null")
    public void testCalculateLengthBetweenPointsException() {
        try {
            service.calculateLengthBetweenPoints(null, null);
            fail("Test calculateLengthBetweenPoints method for null should have thrown TetrahedronException");
        } catch (TetrahedronException e) {
            assertEquals("Calculation of length between two points cannot be completed."
                    + " Argument(s) contains null", e.getMessage());
        }
    }
}