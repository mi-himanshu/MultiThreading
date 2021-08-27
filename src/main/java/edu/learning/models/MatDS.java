package edu.learning.models;

/**
 * A DataStructure for the Matrix. This provides all the necessary
 * methods to operate on the data structure.
 * */
public interface MatDS {
    /**
     * Returns the number of rows in the data structure.
     * */
    int getRows();
    /**
     * Returns the number of columns in the data structure.
     * */
    int getCols();
    /**
     * Returns the value at the specified coordinates in the data structure.
     * */
    Double getVal(int i, int j);
    /**
     * Sets the value at the specified coordinates in the data structure.
     * */
    void setVal(int i, int j, Double val);
    /**
     * Displays the data structure contents on the console.
     * */
    void display();
}
