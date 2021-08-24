package edu.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Matrix Cross Product!" );

        Vector<Vector<Double>> mat = new Vector<>();
        int rows = 3, cols = 3;
        for (int i = 0; i<rows; i++) {
            Vector<Double> i_row = new Vector<>();
            for (int j=0; j < cols; j++) {
                i_row.add(Math.random());
            }
            mat.add(i_row);
        }

        System.out.println(mat);


    }
}
