package edu.learning.exceptions;

public class InvalidTypeException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid type provided! Please try again.";
    }
}
