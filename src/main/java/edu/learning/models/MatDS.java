package edu.learning.models;

public interface MatDS {
    int getRows();
    int getCols();
    Double getVal(int i, int j);
    void setVal(int i, int j, Double val);
    void display();
}
