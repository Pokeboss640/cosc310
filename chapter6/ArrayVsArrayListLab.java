package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class ArrayVsArrayListLab {

    

    protected static int listRandomAccess (int indices[], ArrayList<Integer> list) 
    {
        int result = 0;
        for (int i = 0; i < indices.length; i++){
            result += list.get(indices[i]);

        }
        
        return result;


    }
    public static void main(String[] args) throws IOException {
        /*
        long start = System.nanoTime();
        System.out.println("Hello World");
        long finish = System.nanoTime();

        long elapsed = finish - start;
        System.out.println("Time take "+ elapsed + "nanoseconds");
    
        start = System.nanoTime();
        arrayTest(1_000_000_000);
        finish = System.nanoTime();

        elapsed = finish - start;
        System.out.println("arraytest "+ elapsed + "nanoseconds");*/
        int arr[] = DataLoader.loadArray("numbers.txt");
        ArrayList<Integer> list = DataLoader.loadArrayList("numbers.txt");
        Random r = new Random ();
        int indices[] = new int [100];
        for (int i = 0; i < indices.length; i++){
            indices [i] = r.nextInt(arr.length);

        }

        PrintWriter fileOut = new PrintWriter(new File("results.csv"));
        Target tests[] = new Target [8];
       
        tests[0] = new ArrayRandom(arr,list, "array,random_access");
        tests [1] = new ArrayRandom(arr,list, "array,random_access"); new ListRandom (arr, list, "array, random_access");
        tests[2] = new ArrayAppend(arr, list, "array,append");
        tests[3] = new ListAppend(arr,list,"array,append");



        for (Target target : tests) {
            target.runTests(indices);
            target.writeResults(fileOut);
            
        }
        fileOut.close();


        for (int i=0; i<5; i++) {

            long start = System.nanoTime();
            int result = listRandomAccess(indices, arr);
            long finish = System.nanoTime();
            long elapsed = finish - start;
            System.out.println(result);
            System.out.println("array "+ elapsed);
            fileOut.printf("array,random_access,%d,%.2f,%d\n", i +1, elapsed/1000.0,result);

        }


        for (int i=0; i<5; i++) {    

            long start = System.nanoTime();
            long result = listRandomAccess(indices, list);
            long finish = System.nanoTime();
            long elapsed = finish - start;
            System.out.println("loaded" + list.size());
            System.out.println("array list"+ elapsed);
            fileOut.printf("arraylist,random_access,%d,%.2f,%d\n", i +1 , elapsed/1000.0, result);




        }

        fileOut.close();


        
        
    }
}
