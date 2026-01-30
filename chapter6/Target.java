package chapter6;

import java.io.PrintWriter;
import java.util.ArrayList;

abstract public class Target{

    public static final int TRIALS = 5;

        protected int arr[];
        protected ArrayList<Integer> list;
        private String name; //must be in this format: array,random_access, etc.
        private long results [] = new long[TRIALS];

        public Target (int arr[], ArrayList<Integer> list, String name) {

            this.arr = arr;
            this.list = list;
            this.name = name;
        }



    

    //Method under test
    //indicesOrnums is beng used for two diffeent

        // calls the method under test TRIALS number of times
    abstract public int method (int [] indicesOrnums);

    public double runTests( int indicesOrnums []) {
        long total = 0;
        for (int i = 0; i < TRIALS; i++){
            
            long start = System.nanoTime();
            int result = method(indicesOrnums);
            long end = System.nanoTime();
            long elapsed = end-start;
            results[i] = elapsed;




        }

        double avg = total/(double) TRIALS;
        return avg;

    }


    public void writeResults(PrintWriter out) {
        for (int i = 0; i < TRIALS; i++){
            out.printf("%s,%d,%.2f\n", name, i +1, results[i]/1000.0,results [i]);



        }

        
    }
    
}