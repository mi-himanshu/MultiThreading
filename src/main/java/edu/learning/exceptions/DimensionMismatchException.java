package edu.learning.exceptions;

public class DimensionMismatchException extends Exception {

    @Override
    public String getMessage() {
        return "Dimensions do not match the required conditions! Please try again.";
    }
}
