package edu.learning;

import edu.learning.exceptions.DimensionMismatchException;
import edu.learning.models.Matrix;
import edu.learning.models.MatrixImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws DimensionMismatchException {
        System.out.println("Matrix Cross Product!");


        int row1 = 3, col1 = 3;
        int row2 = 3, col2 = 2;

        List<Integer> values1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 3, 2, 1));
        List<Integer> values2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        Matrix A = new MatrixImpl(row1, col1, values1);
        A.display("A");

        Matrix B = new MatrixImpl(row2, col2, values2, true);
        B.display("B");

        Matrix C = A.crossProduct(B);
        C.display("C");

    }
}
