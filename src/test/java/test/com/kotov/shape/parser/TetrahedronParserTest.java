package test.com.kotov.shape.parser;

import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.parser.TetrahedronParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TetrahedronParserTest {
    TetrahedronParser parser;

    @BeforeClass
    public void SetUpParser() {
        parser = new TetrahedronParser();
    }

    @Test
    public void testParseTetrahedronParameters() throws TetrahedronException {
        String data = "0   0  0   1 0 0 0.5     0.866025 0 0.5 0.288675    0.816496";
        List<Double> actual = parser.parseTetrahedronParameters(data);
        List<Double> expected = List.of(0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.5, 0.866025, 0.0, 0.5, 0.288675, 0.816496);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = TetrahedronException.class)
    public void testParseTetrahedronParametersExceptionWithNull() throws TetrahedronException {
        List<Double> actual = parser.parseTetrahedronParameters(null);
    }

    @Test(expectedExceptions = TetrahedronException.class)
    public void testParseTetrahedronParametersExceptionWithEmptyString() throws TetrahedronException {
        List<Double> actual = parser.parseTetrahedronParameters("");
    }
}