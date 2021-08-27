package edu.learning.models;

public abstract class CrossProduct implements Runnable{
    protected static Matrix A, B;
    protected static Matrix result;
    protected static boolean data = false;

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
