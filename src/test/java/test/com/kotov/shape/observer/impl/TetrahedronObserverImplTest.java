package test.com.kotov.shape.observer.impl;

import com.kotov.shape.entity.Point;
import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.entity.TetrahedronParameter;
import com.kotov.shape.entity.TetrahedronWarehouse;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.observer.TetrahedronEvent;
import com.kotov.shape.observer.impl.TetrahedronObserverImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TetrahedronObserverImplTest {
    @Test
    public void testParametersChanged() throws TetrahedronException {
        TetrahedronObserverImpl observer = new TetrahedronObserverImpl();
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0.5, 0.86602, 0);
        Point d = new Point(0.5, 0.28867, 0.81649);
        TetrahedronEvent event = new TetrahedronEvent(new Tetrahedron(a, b, c, d));
        observer.parametersChanged(event);
        TetrahedronParameter actual = TetrahedronWarehouse.getInstance().getParameter(1).get();
        TetrahedronParameter expected = new TetrahedronParameter(0.11785113019775793, 1.7320508075688772
                , 0.816496580927726, 6.0);
        assertEquals(actual, expected);
    }
}