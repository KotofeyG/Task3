package test.com.kotov.shape.reader;

import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.reader.DataReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class DataReaderTest {
    DataReader reader;

    @BeforeClass
    public void setUpReader() {
        reader = new DataReader();
    }

    @Test
    public void testReadDataFromFile() throws TetrahedronException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL testDataResource = classLoader.getResource("testTetrahedrons.txt");
        String path = new File(testDataResource.getFile()).getAbsolutePath();
        List<String> actual = reader.readDataFromFile(path);
        List<String> expected = new ArrayList<>();
        expected.add("0   0  0   1 0 0 0.5     0.8660254037844386 0 0.5 0.2886751345948129    0.816496580927726");
        expected.add("5 66 5 2 3 2.5437 0 888 @34 ### number");
        assertEquals(actual, expected, "Test failed as file reading algorithm is not correct");
    }

    @Test(expectedExceptions = TetrahedronException.class)
    public void testReadDataFromFileExceptionWithNull() throws TetrahedronException {
        reader.readDataFromFile(null);
    }

    @Test(expectedExceptions = TetrahedronException.class)
    public void testReadDataFromFileExceptionWithEmptyFile() throws TetrahedronException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL testDataResource = classLoader.getResource("emptyTestFile.txt");
        String path = new File(testDataResource.getFile()).getAbsolutePath();
        reader.readDataFromFile(path);
    }
}