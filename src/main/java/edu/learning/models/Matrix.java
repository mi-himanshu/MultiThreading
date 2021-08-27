package edu.learning.models;

import edu.learning.exceptions.DimensionMismatchException;

public interface Matrix {
    int getRows();
    int getCols();
    boolean equals(Matrix mat);
    void display(String message);
    Double getVal(int i, int j);
    void setVal(int i, int j, Double val);
    Matrix crossProduct(Matrix matrix) throws DimensionMismatchException;

}
