package edu.learning.models;

import edu.learning.exceptions.DimensionMismatchException;

import java.util.ArrayList;
import java.util.List;

public class MatrixImpl implements Matrix{
    private MatDS matrix;

    private static List<Double> castValues(List<?> values) {
        List<Double> res = new ArrayList<>();

        for (Object val : values) {
            if (val instanceof Integer) {
                res.add(((Integer)val).doubleValue());
            } else if (val instanceof Float) {
                res.add(((Float)val).doubleValue());
            } else if (val instanceof Double) {
                res.add((Double) val);
            }
        }
        return res;
    }

    public MatrixImpl(int rows, int cols) {
        this.matrix = new MatDSImpl(rows, cols);
    }
    public MatrixImpl(int rows, int cols, List<?> values) {
        this.matrix = new MatDSImpl(rows, cols, castValues(values));
    }
    public MatrixImpl(int rows, int cols, List<?> values, boolean rowPriority) {
        this.matrix = new MatDSImpl(rows, cols, castValues(values), rowPriority);
    }
    @Override
    public int getRows() {
        return matrix.getRows();
    }

    @Override
    public int getCols() {
        return matrix.getCols();
    }

    @Override
    public void display(String message) {
        System.out.println("Displaying matrix "+ message +"...");
        matrix.display();
    }

    @Override
    public Double getVal(int i, int j) {
        return matrix.getVal(i, j);
    }

    @Override
    public void setVal(int i, int j, Double val) {
        matrix.setVal(i, j, val);
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix = " + matrix.toString() +
                '}';
    }

    @Override
    public Matrix crossProduct(Matrix matrix) throws DimensionMismatchException {
        int row1 = this.getRows(), row2 = matrix.getRows();
        int col1 = this.getCols(), col2 = matrix.getCols();



        if (row2 != col1)
            throw new DimensionMismatchException();

//        System.out.println("Initializing result matrix...");
        Matrix res = new MatrixImpl(row1, col2);

//        System.out.println("Rows: " + res.getRows() + ", Cols: " + res.getCols());
//        res.display();
        for(int i=0; i<row1; i++) {
            for(int j=0; j<col2; j++) {
                Double sum = 0.0;
                for(int k=0; k<col1; k++) {
                    sum += this.getVal(i, k) * matrix.getVal(k, j);
                }
                res.setVal(i, j, sum);
            }
        }

        return res;
    }
}
