package test.com.kotov.shape.factory;

import com.kotov.shape.entity.Point;
import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.factory.TetrahedronFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TetrahedronFactoryTest {
    @Test
    public void testCreateTetrahedron() throws TetrahedronException {
        List<Double> coordinates = List.of(0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.5, 0.866025, 0.0, 0.5, 0.288675, 0.816496);
        Tetrahedron actual = TetrahedronFactory.createTetrahedron(coordinates);
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0.5, 0.866025, 0);
        Point d = new Point(0.5, 0.288675, 0.816496);
        Tetrahedron expected = new Tetrahedron(a, b, c, d);
        boolean condition = actual.getA().equals(expected.getA()) && actual.getB().equals(expected.getB())
                && actual.getC().equals(expected.getC()) && actual.getD().equals(expected.getD());
        assertTrue(condition, "Logic of creation Tetrahedron object is wrong");
    }

    @Test(expectedExceptions = TetrahedronException.class)
    public void testCreateTetrahedronWithWrongParameters() throws TetrahedronException {
        List<Double> coordinates = List.of(1.0, 1.0, 5.0, 1.0, 7.0, 0.0, 0.5, 0.866025, 0.0, 0.5, 0.288675, 0.816496);
        TetrahedronFactory.createTetrahedron(coordinates);
    }

    @Test(expectedExceptions = TetrahedronException.class)
    public void testCreateTetrahedronWithNull() throws TetrahedronException {
        TetrahedronFactory.createTetrahedron(null);
    }

    @Test
    public void testCreateListOfTetrahedrons() throws TetrahedronException {
        List<Double[]> coordinates = new ArrayList<>();
        Double[] parameters1 = {3.0, 2.0, 1.0, 6.0, 2.0, 1.0, 4.5, 4.59807, 1.0, 4.5, 2.86602, 3.44948};
        Double[] parameters2 = {0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.5, 0.866025, 0.0, 0.5, 0.288675, 0.816496};
        Double[] parameters3 = {1.0, 0.0, 0.0, 4.0, 0.0, 0.0, 2.5, 0.0, 2.598076, 2.5, 2.449489, 0.866025};
        coordinates.add(parameters1);
        coordinates.add(parameters2);
        coordinates.add(parameters3);
        List<Tetrahedron> actual = TetrahedronFactory.createListOfTetrahedrons(coordinates);
        for (Tetrahedron tetrahedron : actual)
            System.out.println(tetrahedron);
        Tetrahedron tetrahedron1 = new Tetrahedron(new Point(3.0, 2.0, 1.0), new Point(6.0, 2.0, 1.0)
                , new Point(4.5, 4.59807, 1.0), new Point(4.5, 2.86602, 3.44948));
        Tetrahedron tetrahedron2 = new Tetrahedron(new Point(0.0, 0.0, 0.0), new Point(1.0, 0.0, 0.0)
                , new Point(0.5, 0.866025, 0.0), new Point(0.5, 0.288675, 0.816496));
        Tetrahedron tetrahedron3 = new Tetrahedron(new Point(1.0, 0.0, 0.0), new Point(4.0, 0.0, 0.0)
                , new Point(2.5, 0.0, 2.598076), new Point(2.5, 2.449489, 0.866025));
        List<Tetrahedron> expected = new ArrayList<>();
        expected.add(tetrahedron1);
        expected.add(tetrahedron2);
        expected.add(tetrahedron3);
        boolean condition = actual.get(0).getA().equals(expected.get(0).getA())
                && actual.get(0).getB().equals(expected.get(0).getB())
                && actual.get(0).getC().equals(expected.get(0).getC())
                && actual.get(0).getD().equals(expected.get(0).getD())
                && actual.get(1).getA().equals(expected.get(1).getA())
                && actual.get(1).getB().equals(expected.get(1).getB())
                && actual.get(1).getC().equals(expected.get(1).getC())
                && actual.get(1).getD().equals(expected.get(1).getD())
                && actual.get(2).getA().equals(expected.get(2).getA())
                && actual.get(2).getB().equals(expected.get(2).getB())
                && actual.get(2).getC().equals(expected.get(2).getC())
                && actual.get(2).getD().equals(expected.get(2).getD());
        assertTrue(condition);
    }

    @Test(expectedExceptions = TetrahedronException.class)
    public void testCreateListOfTetrahedronsWithNull() throws TetrahedronException {
        TetrahedronFactory.createListOfTetrahedrons(null);
    }

    @Test(expectedExceptions = TetrahedronException.class)
    public void testCreateListOfTetrahedronsWithEmptyParameters() throws TetrahedronException {
        TetrahedronFactory.createListOfTetrahedrons(new ArrayList<>());
    }
}