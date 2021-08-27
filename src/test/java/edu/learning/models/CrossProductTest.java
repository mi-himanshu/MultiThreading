package edu.learning.models;

import edu.learning.exceptions.DimensionMismatchException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertTrue;

public class CrossProductTest {
    @Test
    public void checkRun() throws InterruptedException, DimensionMismatchException {
        List<Integer> values1 = new ArrayList<>(Arrays.asList(3, 2, 1, 2, 7, 6));
        List<Integer> values2 = new ArrayList<>(Arrays.asList(1, 7, 6, 3, 2, 4, 2, 1, 5));

        int rows1 = 2, cols1 = 3;
        int rows2 = 3, cols2 = 3;
        Matrix A = new MatrixImpl(rows1, cols1, values1);
        Matrix B = new MatrixImpl(rows2, cols2, values2);

        Matrix C = A.crossProduct(B);

        List<Integer> resultValues = new ArrayList<>(Arrays.asList(11, 26, 31, 35, 34, 70));
        Matrix res = new MatrixImpl(rows1, cols2, resultValues);

        assertTrue(res.equals(C));


    }
}
