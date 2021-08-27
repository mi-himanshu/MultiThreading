package edu.learning.models;

import edu.learning.exceptions.DimensionMismatchException;

/**
 * Equivalent to the Matrix in Mathemetics.
 * */
public interface Matrix {
    /**
     * Returns the number of rows in the matrix.
     * */
    int getRows();
    /**
     * Returns the number of columns in the matrix.
     * */
    int getCols();
    /**
     * Compares the two matrices for equality. Both are equal only if all the elements of each
     * equals to the other along with the same dimensions.
     * */
    boolean equals(Matrix mat);
    /**
     * Checks if multi-threading operations are enabled.
     * */
    boolean isMULTI_THREADING();
    /**
     * Acts as a switch for using multi-threading operations.
     * */
    void setMULTI_THREADING(boolean value);
    /**
     * Displays the matrix on the console.
     * */
    void display(String message);
    /**
     * Gets the value on the specified coordinates in the matrix.
     * */
    Double getVal(int i, int j);
    /**
     * Sets the given value at the specified coordinates in the matrix.
     * */
    void setVal(int i, int j, Double val);
    /**
     * Performs a matrix cross product on the matrices.
     * */
    Matrix crossProduct(Matrix matrix) throws DimensionMismatchException, InterruptedException;
}
