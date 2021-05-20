package test.com.kotov.shape.validator;

import com.kotov.shape.entity.Point;
import com.kotov.shape.validator.TetrahedronValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TetrahedronValidatorTest {
    @Test
    public void testAreParametersValidWithTrueCondition() {
        String[] data = {"0", "0", "0", "1", "0", "0", "0.5", "0.8660254037844386", "0"
                , "0.5", "0.2886751345948129", "0.816496580927726"};
        boolean condition = TetrahedronValidator.areParametersValid(data);
        assertTrue(condition);
    }

    @Test
    public void testAreParametersValidWithFalseCondition() {
        String[] data = {"0$", "0", "0", "1", "0", "0", "0.5$", "0.8660254037844386", "0"
                , "0.5", "0.2886751345948129", "0.816496580927726"};
        boolean condition = TetrahedronValidator.areParametersValid(data);
        assertFalse(condition);
    }

    @Test
    public void testAreParametersValidWithNullCondition() {
        boolean condition = TetrahedronValidator.areParametersValid(null);
        assertFalse(condition);
    }

    @Test
    public void testIsTetrahedronValidWithTrueCondition() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0.5, 0.8660254037844386, 0);
        Point d = new Point(0.5, 0.2886751345948129, 0.816496580927726);
        boolean condition = TetrahedronValidator.isTetrahedronValid(a, b, c, d);
        assertTrue(condition);
    }

    @Test
    public void testIsTetrahedronValidWithFalseCondition() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0.5, 0.8660254037844386, 0);
        Point d = new Point(0.5, 0.2886751345948129, 5.816496580927726);
        boolean condition = TetrahedronValidator.isTetrahedronValid(a, b, c, d);
        assertFalse(condition);
    }

    @Test
    public void testIsTetrahedronValidWithNullCondition() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0.5, 0.8660254037844386, 0);
        Point d = null;
        boolean condition = TetrahedronValidator.isTetrahedronValid(a, b, c, d);
        assertFalse(condition);
    }
}