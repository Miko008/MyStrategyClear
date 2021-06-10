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
        double[] data = DataGenerator.generate(10000);
        //double[] data = GenerateSorted(10000);
        double[] datacopy = data.clone();                   //głęboka kopia aby zachować kolejność losowania
        System.out.println("Time: " + context.Sort(data) + "\tSorted: " + CheckSort(data));
        
        context.ChangeStrat(new Bubblesort());
        data = datacopy.clone();                            //powrot do losowania
        System.out.println("Time: " + context.Sort(data) + "\tSorted: " + CheckSort(data));
        
        context.ChangeStrat(new Insertionsort());
        data = datacopy.clone();
        System.out.println("Time: " + context.Sort(data) + "\tSorted: " + CheckSort(data));
        
        context.ChangeStrat(new Selectionsort());
        data = datacopy.clone();
        System.out.println("Time: " + context.Sort(data) + "\tSorted: " + CheckSort(data));
        
        //  ODPOWIEDZI NA PYTANIA
        
        // 1. Wzorzec strategii pozwala na wybór implementacji rozwiazania zgodnie 
        //      z zasada open/close jak i jej zmiane w runtimie.
        
        // 2. Tak, jednak trzeba poszerzyć istniejące rozwiazanie np. o metode pozwalajaca na taki wybór.
        
        // 3. Algorytmy spełnione są wewnatrz klas, a przekazanie danych nastepuje przez context i interfejs.
        
        // 4. Dla przypadków gdzie różne rozwiązania lepiej radzą sobie dla różnych przypadków jednego typu danych
        //      lub kiedy chcemy sprawdzić sprawność różnych rozwiązań.
        //      Np. quicksort radzi sobie najszybciej dla nieposortowanych danych, lecz dla prawie posortowanych
        //      inne algorytmy radza sobie podobnie lub nawet lepiej przy mniejszym zużyciu zasobów.
        //      (Jednak często trudno stwierdzić jak bardzo zshufflowane są dane).
    }
    
    public static boolean CheckSort(double[] array) {       //sprawdzenie poprawnosci sortowania (redundantnie)
        for (int i = 1; i < array.length; i++) {
            if(array[i-1]>array[i])
                return false;
        }
        return true;
    }
    
    public static double[] GenerateSorted(int length)       //dla sprawdzenia predkosci dla posortowanych
    {
        double[] array = new double[length];
        for (int i = 0; i < length; i++) {
            array[i] = 0.01*i;
        }
        return array;
    }
    
}
