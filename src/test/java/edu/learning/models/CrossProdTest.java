package edu.learning.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertTrue;

public class CrossProdTest {
    @Test
    public void checkRun() throws InterruptedException {
        List<Integer> values1 = new ArrayList<>(Arrays.asList(3, 2, 1, 2, 7, 6));
        List<Integer> values2 = new ArrayList<>(Arrays.asList(1, 7, 6, 3, 2, 4, 2, 1, 5));

        int rows1 = 2, cols1 = 3;
        int rows2 = 3, cols2 = 3;
        Matrix A = new MatrixImpl(rows1, cols1, values1);
        Matrix B = new MatrixImpl(rows2, cols2, values2);

        Matrix C = new MatrixImpl(rows1, cols2);

        CrossProd.setMatrices(A, B, C);
        ExecutorService pool = Executors.newFixedThreadPool(5);

        List<Callable<Object>> callables = new ArrayList<>();
        for(int i=0; i<rows1; i++) {
            CrossProd cp = new CrossProd(i);
            callables.add(Executors.callable(cp));
        }
        pool.invokeAll(callables);


        C = CrossProd.getResult();
        C.display("C");

        List<Integer> resultValues = new ArrayList<>(Arrays.asList(11, 26, 31, 35, 34, 70));
        Matrix res = new MatrixImpl(rows1, cols2, resultValues);
        res.display("res");

        assertTrue(res.equals(C));
        pool.shutdown();


    }
}
