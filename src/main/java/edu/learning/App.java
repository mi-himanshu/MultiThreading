package edu.learning;

import edu.learning.exceptions.DimensionMismatchException;
import edu.learning.models.Matrix;
import edu.learning.models.MatrixImpl;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws DimensionMismatchException, InterruptedException {
        System.out.println("Matrix Cross Product!");

        int rows1 = 1000, cols1 = 1500;
        int rows2 = 1500, cols2 = 1000;
        Matrix mat1 = getRandomMatrix(rows1, cols1, false);
        Matrix mat2 = getRandomMatrix(rows2, cols2, false);

//        mat1.display("A");
//        mat2.display("B");

        StopWatch watch = new StopWatch();
        watch.start();

        Matrix res = mat1.crossProduct(mat2);
        watch.stop();

//        res.display("ResultMatrix");
        System.out.println("Time elapsed [ MULTI-THREADING ]: " + (double)(watch.getTime()) / 1000 + "s");

        mat1.setMULTI_THREADING(false);
        watch = new StopWatch();
        watch.start();

        res = mat1.crossProduct(mat2);
        watch.stop();

//        res.display("ResultMatrix");
        System.out.println("Time elapsed [ NAIIVE ]: " + (double)(watch.getTime()) / 1000 + "s");


    }
    public static Matrix getRandomMatrix(int rows, int cols, boolean priority) {
        List<Integer> values = new ArrayList<>();
        for(int i=0; i<rows*cols; i++)
            values.add((int)(Math.random() * 20));

        Matrix mat = new MatrixImpl(rows, cols, values, priority);
        return mat;
    }
}
