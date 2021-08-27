package edu.learning.models;

/**
 * An abstract class for the CrossProduct Task to be implemented.
 * Using abstract class in order for the user to restrict to
 * implement the `Runnable` interface.
 * */
public abstract class CrossProduct implements Runnable{
    /**
     * Initial Data to operate on.
     * */
    protected static Matrix A, B;
    /**
     * Placeholder for result of operation.
     * */
    protected static Matrix result;
    /**
     * To check if the data is initialized before accessing the result.
     * */
    protected static boolean data = false;

    /**
     * Static method to initialize the data.
     * */
    public static void initData(Matrix mat1, Matrix mat2) {
        data = true;
        A = mat1; B = mat2;
        result = new MatrixImpl(A.getRows(), B.getCols());
    }

    public static Matrix getResult() {
        return result;
    }

    public void resetData() {
        data = false;
    }

    public boolean isInitData() {
        return data;
    }

}
