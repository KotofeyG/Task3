package com.kotov.shape.main;

import com.kotov.shape.factory.TetrahedronFactory;
import com.kotov.shape.entity.Tetrahedron;
import com.kotov.shape.exception.TetrahedronException;
import com.kotov.shape.parser.TetrahedronParser;
import com.kotov.shape.reader.DataReader;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) throws TetrahedronException {
        DataReader reader = new DataReader();
        List<String> list = reader.readDataFromFile(String.join(File.separator,
                "src", "main", "resources", "tetrahedrons.txt"));

        TetrahedronParser parser = new TetrahedronParser();
        List<Double[]> numbers = parser.parseTetrahedronsParameters(list);
        List<Tetrahedron> tetrahedrons = TetrahedronFactory.createTetrahedrons(numbers);

        for (Tetrahedron tetrahedron : tetrahedrons) {
            System.out.println(tetrahedron);
        }
    }
}