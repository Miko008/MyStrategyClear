/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Random;

/**
 *
 * @author LeopardProMK
 */
public class DataGenerator {
    
    public static double[] generate(int count) {
        Random r = new Random();
        double[] data = new double[count];
        for (int i = 0; i < count; i++) {
            data[i] = round(r.nextDouble(), 2);
        }
        return data;
    }

    private static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
