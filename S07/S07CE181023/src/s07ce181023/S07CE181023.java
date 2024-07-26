/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s07ce181023;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * S07 Delete duplicate elements in an array
 *
 * @author Lam Tan Phat - CE181023
 */
public class S07CE181023 {

    //Declera the variable
    Scanner sc = new Scanner(System.in);
    int n;
    ArrayList<Integer> arr = new ArrayList<>();
    int count = 0;

    /**
     * Method get value from input
     */
    public void input() {
        //Get the size of the array
        n = ioce181023.IOCE181023.getInteger3("Please enter size of array: ", "Positive integer number only", 0);
        //Using loop to get value for array
        for (int i = 0; i < n; i++) {
            arr.add(ioce181023.IOCE181023.getInteger1("Element[" + i + "] = ", "Accept integer number only"));
        }
        System.out.println();
        //Call the method to show the array then remove the duplicate elements
        removeEl();
    }

    /**
     * Method loop up duplicate elements and remove it from the array
     */
    public void removeEl() {
        System.out.println("The original array:");
        //Show the array
        for (Integer in : arr) {
            System.out.printf("%d\t", in);
        }
        //Using loop by loop to remove the duplicate element
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i).equals(arr.get(j))) {
                    //Remove the duplicate element
                    arr.remove(j);
                    count++;
                    j--;
                }
            }
        }
        System.out.println();
        //Call the output method
        output();
    }

    /**
     * Method display the array after removing
     */
    public void output() {
        System.out.println();
        //Check if array has no duplicate characters
        if (count != 0) {
            System.out.println("The array after removing duplicate elements:");
        } else {
            System.out.println("Array has no duplicate characters");
        }
        //Display the array after removing
        for (Integer in : arr) {
            System.out.printf("%d\t", in);
        }
        System.out.println();
    }

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        S07CE181023 obj = new S07CE181023();
        //Call the input 's method
        obj.input();
    }
}
