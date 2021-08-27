package edu.learning.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the MatDS interface.
 * */
public class MatDSImpl implements MatDS{
    Double[][] mat;
    int rows, cols;

    private static Double[][] initMat(int rows, int cols, List<Double> values) {
        Double[][] res = new Double[rows][cols];

        int i=0, j=0;
        for (Double val : values) {
            res[i][j++] = val;
            if(j == cols) {
                j = 0; i++;
            }
            if(i == rows)
                break;
        }
        return res;
    }
    public MatDSImpl(int rows, int cols) {
        List<Double> values = new ArrayList<>();
        for (int i=0; i<rows*cols; i++)
            values.add(0.0);

        mat = initMat(rows, cols, values);
        this.rows = rows;
        this.cols = cols;

    }
    public MatDSImpl(int rows, int cols, List<Double> values) {
        this(rows, cols, values, false);
    }
    public MatDSImpl(int rows, int cols, List<Double> values, boolean rowPriority) {
        if (rowPriority) {
            cols = Math.min(values.size() / rows, cols);
        } else {
            rows = Math.min(values.size() / cols, rows);
        }

        mat = initMat(rows, cols, values);
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public int getRows() {
        return this.rows;
    }

    @Override
    public int getCols() {
        return this.cols;
    }

    @Override
    public Double getVal(int i, int j) {
        return mat[i][j];
    }

    @Override
    public void setVal(int i, int j, Double val) {
        mat[i][j] = val;
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String res = "";
        for(int i=0; i < rows; i++) {
            for(int j=0; j < cols; j++) {
                if (j != 0)
                    res += " , ";
                res += mat[i][j];
            }
            res += "\n";
        }
        return  res;
    }
}
