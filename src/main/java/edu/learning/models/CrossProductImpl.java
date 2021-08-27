package edu.learning.models;

public class CrossProductImpl extends CrossProduct{

    private final int row;

    CrossProductImpl(int row) {
        this.row = row;
    }

    @Override
    public void run() {
        try {
            int rows = B.getRows(),
                    cols = B.getCols();

            for(int j=0; j<cols; j++) {
                double sum = 0;
                for(int i=0; i<rows; i++) {
                    sum += A.getVal(row, i) * B.getVal(i, j);
                }
                result.setVal(row, j, sum);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
