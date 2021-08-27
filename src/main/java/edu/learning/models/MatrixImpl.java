package edu.learning.models;

import edu.learning.exceptions.DimensionMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixImpl implements Matrix{
    private MatDS matrix;
    private static int MAX_THREADS = 6;
    private boolean MULTI_THREADING = true;
    private ExecutorService pool;

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
    public boolean equals(Matrix mat) {
        int rows = mat.getRows(), cols = mat.getCols();
        if (rows != getRows() || cols != getCols())
            return false;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if (!getVal(i, j).equals(mat.getVal(i, j))) // using the != notation gives error. why???
                    return false;
            }
        }
        return true;
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

    private Matrix crossProductMultiThread(Matrix matrix) throws InterruptedException {
        pool = Executors.newFixedThreadPool(MAX_THREADS);
        CrossProd.setMatrices(this, matrix, new MatrixImpl(this.getRows(), matrix.getCols()));
        List<Callable<Object>> callables = new ArrayList<>();
        for(int i=0; i<getRows(); i++) {
            CrossProd cp = new CrossProd(i);
            callables.add(Executors.callable(cp));
        }
        pool.invokeAll(callables);
        pool.shutdown();
        return CrossProd.getResult();
    }
    private Matrix crossProductNaiive(Matrix matrix) {
        int row1 = this.getRows(), row2 = matrix.getRows();
        int col1 = this.getCols(), col2 = matrix.getCols();

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
    @Override
    public Matrix crossProduct(Matrix matrix) throws DimensionMismatchException, InterruptedException {
        int row1 = this.getRows(), row2 = matrix.getRows();
        int col1 = this.getCols(), col2 = matrix.getCols();

        if (row2 != col1)
            throw new DimensionMismatchException();

        Matrix res;
        if (isMULTI_THREADING()) {
            res = crossProductMultiThread(matrix);
        } else {
            res = crossProductNaiive(matrix);
        }
        return res;
    }

    @Override
    public boolean isMULTI_THREADING() {
        return MULTI_THREADING;
    }

    @Override
    public void setMULTI_THREADING(boolean MULTI_THREADING) {
        this.MULTI_THREADING = MULTI_THREADING;
    }
}
