package edu.learning;

import edu.learning.exceptions.DimensionMismatchException;
import edu.learning.models.Matrix;
import edu.learning.models.MatrixImpl;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Shows the difference between single and multi threaded applications.
 * @author Himanshu Mishra
 *
 */
public class App {
    public static void main(String[] args) throws DimensionMismatchException, InterruptedException {
        System.out.println("Matrix Cross Product!");

        /* Initializing the operand matrices */
        int rows1 = 100, cols1 = 1500;
        int rows2 = 1500, cols2 = 100;

        double time1, time2;
        Matrix mat1 = getRandomMatrix(rows1, cols1, false);
        Matrix mat2 = getRandomMatrix(rows2, cols2, false);

        StopWatch watch = new StopWatch(); // used for getting the time elapsed

        /* Using multi-threading for cross product calculation */
        watch.start();
        Matrix res = mat1.crossProduct(mat2);
        watch.stop();

        time1 = (double)(watch.getTime()) / 1000;

        /* Using a single thread for same calculation */
        mat1.setMULTI_THREADING(false);
        watch = new StopWatch();

        watch.start();
        res = mat1.crossProduct(mat2);
        watch.stop();

        time2 = (double)(watch.getTime()) / 1000;

        /* Results */
        System.out.println("Time elapsed [ NAIIVE ]: " + time2 + "s");
        System.out.println("Time elapsed [ MULTI-THREADING ]: " + time1 + "s");


    }
    /**
     * Generates matrix for the given shape with random values
     * @param rows rows of the required matrix
     * @param cols cols of the required matrix
     * @param priority direction in which values should be filled (row-wise or column-wise)
     *
     * @return Matrix required matrix.
     * */
    public static Matrix getRandomMatrix(int rows, int cols, boolean priority) {
        List<Integer> values = new ArrayList<>();
        for(int i=0; i<rows*cols; i++)
            values.add((int)(Math.random() * 20));

        Matrix mat = new MatrixImpl(rows, cols, values, priority);
        return mat;
    }
}
