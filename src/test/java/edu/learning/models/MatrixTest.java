package edu.learning.models;

import edu.learning.exceptions.DimensionMismatchException;
import org.junit.Test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixTest {
    @Test
    public void crossProductTest() throws DimensionMismatchException {

        int row1 = 3, col1 = 3;
        int row2 = 3, col2 = 2;

        List<Integer> values1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 3, 2, 1));
        List<Integer> values2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        Matrix A = new MatrixImpl(row1, col1, values1);
        Matrix B = new MatrixImpl(row2, col2, values2, true);

        Matrix C = A.crossProduct(B);

        String out = "Matrix{matrix = 22.0 , 28.0\n" +
                "49.0 , 64.0\n" +
                "14.0 , 20.0\n}";

        assertEquals(out , C.toString());
    }
}
