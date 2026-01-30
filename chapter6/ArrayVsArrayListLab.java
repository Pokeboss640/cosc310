package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class ArrayVsArrayListLab {

    public static void main(String[] args) throws IOException {
        int arr[] = DataLoader.loadArray("numbers.txt");
        ArrayList<Integer> list = DataLoader.loadArrayList("numbers.txt");
        Random r = new Random();
        int indices[] = new int[100_000];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = r.nextInt(arr.length);
        }

        PrintWriter fileOut = new PrintWriter(new File("results.csv"));
        Target tests[] = new Target[8];
        double testAverages[] = new double[8];


        //you need to compare the results of the array version of a text with the array
        //list version of the test, so you must be able to distinquish them
        tests[0] = new ArrayRandom(arr, new ArrayList<>(list), "array, random_access");
        tests[1] = new ListRandom(arr,  new ArrayList<>(list), "arraylist, random_access");
        tests[2] = new ArrayAppend(arr,  new ArrayList<>(list), "array, append");
        tests[3] = new ListAppend(arr, new ArrayList<>(list),"arraylist, append");
        tests[4] = new ArrayInsert(arr, new ArrayList<>(list), "array, insert_front");
        tests[5] = new ListInsert(arr, new ArrayList<>(list),"arraylist, insert_front");
        tests[6] = new ArrayRemove(arr, new ArrayList<>(list), "array, remove_front");
        tests[7] = new ListRemove(arr, new ArrayList<>(list), "arraylist, remove_front");


        for (int i=0; i<tests.length; i++) {
            Target target = tests[i];
            if (target != null) {
                testAverages[i] = target.runTests(indices);
                target.writeResults(fileOut);
            }
        }
        System.out.println(java.util.Arrays.toString(testAverages));

        System.out.println("Operation: Random Access.  Array Average Time: " + testAverages[0] + ". ArrayList Average Time " + testAverages[1]);
        
        if (testAverages[0] < testAverages[1]){
            System.out.println("Array Wins!");
        }

        else {
            System.out.println("Array List Wins!");
        }

        System.out.println("Operation: Append.  Array Average Time: " + testAverages[2] + ". ArrayList Average Time " + testAverages[3]);
        
        if (testAverages[2] < testAverages[3]){
            System.out.println("Array Wins!");
        }

        else {
            System.out.println("Array List Wins!");
        }

        System.out.println("Operation: Insert.  Array Average Time: " + testAverages[4] + ". ArrayList Average Time " + testAverages[5]);
        
        if (testAverages[4] < testAverages[5]){
            System.out.println("Array Wins!");
        }

        else {
            System.out.println("Array List Wins!");
        }

        System.out.println("Operation: Remove.  Array Average Time: " + testAverages[6] + ". ArrayList Average Time " + testAverages[7]);
        
        if (testAverages[6] < testAverages[7]){
            System.out.println("Array Wins!");
        }

        else {
            System.out.println("Array List Wins!");
        }
        
        


        
        fileOut.close();
        
    }

}