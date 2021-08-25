package edu.learning.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MatDSTest {
    @Test
    public void noValueConstructor() {
        int rows = 3, cols = 3;
        MatDS mat = new MatDSImpl(rows, cols);


        assertEquals(rows, mat.getRows());
        assertEquals(cols, mat.getCols());
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                assertEquals(Double.valueOf(0), mat.getVal(i, j));
            }
        }

    }
    @Test
    public void noPriorityConstructor() {
        int rows = 3, cols = 3;
        MatDS mat = new MatDSImpl(rows, cols, new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0)));

        assertEquals(rows - 1, mat.getRows());
        assertEquals(cols, mat.getCols());

        Double val = 0.0;
        for(int i=0; i<rows-1; i++) {
            for(int j=0; j<cols; j++) {
                assertEquals(++val, mat.getVal(i, j));
            }
        }
    }
    @Test
    public void colPriorityConstructor() {
        int rows = 3, cols = 3;
        MatDS mat = new MatDSImpl(rows, cols, new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0)), false);

        assertEquals(rows - 1, mat.getRows());
        assertEquals(cols, mat.getCols());

        Double val = 0.0;
        for(int i=0; i<rows-1; i++) {
            for(int j=0; j<cols; j++) {
                assertEquals(++val, mat.getVal(i, j));
            }
        }
    }

    @Test
    public void rowPriorityConstructor() {
        int rows = 3, cols = 3;
        MatDS mat = new MatDSImpl(rows, cols, new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0)), true);

        assertEquals(rows, mat.getRows());
        assertEquals(cols-1, mat.getCols());

        Double val = 0.0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols-1; j++) {
                assertEquals(++val, mat.getVal(i, j));
            }
        }
    }

    @Test
    public void changingValues() {
        int rows = 3, cols = 3;
        MatDS mat = new MatDSImpl(rows, cols, new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0)));

        Double val = 6.3; int x = 1, y = 1;

        mat.setVal(x, y, 6.3);
        assertEquals(val, mat.getVal(x, y));
    }

    @Test
    public void consoleOutputTest() {
        int rows = 3, cols = 3;
        MatDS mat = new MatDSImpl(rows, cols, new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0)));

        String out = "1.0 , 2.0 , 3.0\n" +
                "4.0 , 5.0 , 6.0\n";

        assertEquals(out, mat.toString());
    }
}
