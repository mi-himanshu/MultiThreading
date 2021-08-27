package edu.learning.models;

public class CrossProd implements Runnable {
    private static Matrix A, B, C;
    private int row;

    public static void setMatrices(Matrix A, Matrix B, Matrix C) {
        CrossProd.A = A;
        CrossProd.B = B;
        CrossProd.C = C;
    }
    public static Matrix getResult() {
        return C;
    }
    public CrossProd(int row) {
        this.row = row;
    }
    @Override
    public void run() {
        try {
            int rows = B.getRows(),
                cols = B.getCols();

//            System.out.println(rows + " " + cols);
//            System.out.println("row: " + row);

            for(int j=0; j<cols; j++) {
                double sum = 0;
                for(int i=0; i<rows; i++) {
                    sum += A.getVal(row, i) * B.getVal(i, j);
                }
//                System.out.println(row + " , " + j + " : " + sum);
                C.setVal(row, j, sum);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
