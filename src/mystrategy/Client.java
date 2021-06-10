/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystrategy;

import data.DataGenerator;
import sort.methods.Bubblesort;
import sort.methods.Insertionsort;
import sort.methods.Quicksort;
import sort.methods.Selectionsort;

/**
 *
 * @author LeopardProMK
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* Algorytmy sortowania */
        // http://www.algorytm.org/algorytmy-sortowania/
        
        // quick check
//        double[] data = DataGenerator.generate(1000);
//        Bubblesort.Sort(data);
//        System.out.println(CheckSort(data));
//        
//        data = DataGenerator.generate(1000);
//        Insertionsort.Sort(data);
//        System.out.println(CheckSort(data));
//        
//        data = DataGenerator.generate(1000);
//        Quicksort.Sort(data);                
//        System.out.println(CheckSort(data));
//        
//        data = DataGenerator.generate(1000);
//        Selectionsort.Sort(data);
//        System.out.println(CheckSort(data));
        
       /* Wzorzec Stratega */
        //...
        Context context = new Context(new Quicksort());
        double[] data = DataGenerator.generate(100000);
        double[] datacopy = data.clone(); 
        System.out.println("Time: " + context.Sort(data));
        System.out.println(CheckSort(data));
        
        
        context = new Context(new Bubblesort());
        data = datacopy.clone();
        System.out.println("Time: " + context.Sort(data));
        System.out.println(CheckSort(data));
        
        context = new Context(new Insertionsort());
        data = datacopy.clone();
        System.out.println("Time: " + context.Sort(data));
        System.out.println(CheckSort(data));
        
        context = new Context(new Bubblesort());
        data = datacopy.clone();
        System.out.println("Time: " + context.Sort(data));
        System.out.println(CheckSort(data));
        
        
    }
    
    public static boolean CheckSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            if(array[i-1]>array[i])
                return false;
        }
        return true;
    }
    
}
