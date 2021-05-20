package test.com.kotov.shape.repository;

import com.kotov.shape.comparator.TetrahedronIdComparator;
import com.kotov.shape.entity.Point;
import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.repository.Specification;
import com.kotov.shape.repository.TetrahedronRepository;
import com.kotov.shape.repository.impl.TetrahedronIdSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TetrahedronRepositoryTest {
    TetrahedronRepository repository;

    @BeforeClass
    public void setUpRepository() throws TetrahedronException {
        repository = TetrahedronRepository.getInstance();
        Tetrahedron tetrahedron1 = new Tetrahedron(new Point(0, 0, 0), new Point(1, 0, 0)
                , new Point(0.5, 0.866025, 0), new Point(0.5, 0.288675, 0.816496));
        Tetrahedron tetrahedron2 = new Tetrahedron(new Point(3, 2, 1), new Point(6, 2, 1)
                , new Point(4.5, 4.59807, 1), new Point(4.5, 2.86602, 3.44948));
        Tetrahedron tetrahedron3 = new Tetrahedron(new Point(5, 1, 2), new Point(7, 2, 4)
                , new Point(45.6, 2.98044, 2), new Point(4.3, 6.56242, 1.54678));
        Tetrahedron tetrahedron4 = new Tetrahedron(new Point(1, 0, 0), new Point(4, 0, 0)
                , new Point(2.5, 0, 2.598076), new Point(2.5, 2.449489, 0.866025));
        repository.add(tetrahedron4);
        repository.add(tetrahedron3);
        repository.add(tetrahedron2);
        repository.add(tetrahedron1);
    }

    @Test
    public void testQuery() {
        Specification specification = new TetrahedronIdSpecification(1);
        List<Tetrahedron> list = repository.query(specification);
        Tetrahedron actual = list.get(0);
        Tetrahedron expected = repository.get(3);
        assertEquals(actual, expected);
    }

    @Test
    public void testQueryStream() {
        Specification specification = new TetrahedronIdSpecification(1);
        List<Tetrahedron> list = repository.queryStream(specification);
        Tetrahedron actual = list.get(0);
        Tetrahedron expected = repository.get(3);
        assertEquals(actual, expected);
    }

    @Test
    public void testSort() {
        List<Tetrahedron> actual = repository.sort(new TetrahedronIdComparator());
        List<Tetrahedron> expected = new ArrayList<>();
        expected.add(repository.get(3));
        expected.add(repository.get(2));
        expected.add(repository.get(1));
        expected.add(repository.get(0));
        assertEquals(actual, expected);
    }

    @Test
    public void testSortStream() {
        List<Tetrahedron> actual = repository.sort(new TetrahedronIdComparator());
        List<Tetrahedron> expected = new ArrayList<>();
        expected.add(repository.get(3));
        expected.add(repository.get(2));
        expected.add(repository.get(1));
        expected.add(repository.get(0));
        assertEquals(actual, expected);
    }
}