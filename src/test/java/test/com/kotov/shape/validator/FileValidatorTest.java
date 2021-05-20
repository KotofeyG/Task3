package test.com.kotov.shape.validator;

import com.kotov.shape.validator.FileValidator;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

import static org.testng.Assert.*;

public class FileValidatorTest {
    @Test
    public void testIsFileValid() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL testDataResource = classLoader.getResource("testTetrahedrons.txt");
        String path = new File(testDataResource.getFile()).getAbsolutePath();
        boolean condition = FileValidator.isFileValid(path);
        assertTrue(condition);
    }

    @Test
    public void testIsFileValidWithNull() {
        assertFalse(FileValidator.isFileValid(null));
    }

    @Test
    public void testIsFileValidWithEmptyFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL testDataResource = classLoader.getResource("emptyTestFile.txt");
        String path = new File(testDataResource.getFile()).getAbsolutePath();
        boolean condition = FileValidator.isFileValid(path);
        assertFalse(condition);
    }
}