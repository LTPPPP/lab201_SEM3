/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s10ce181023;

import java.util.ArrayList;
import java.util.Collections;

/**
 * S10 Array Manipulations
 *
 * @author Lam Tan Phat - CE181023
 */
public class S10CE181023 {

    //Declare an ArrayList to store integers
    ArrayList<Integer> list = new ArrayList<>();
    int n;

    /**
     * Method to add a value to the ArrayList
     */
    public void input() {
        System.out.println();
        //Get an integer input and add it to the ArrayList
        n = ioce181023.IOCE181023.getInteger1("Add a value : ", "Accept integer only");
        list.add(n);
        System.out.println();
    }

    /**
     * Method to search for a value in the ArrayList
     */
    public void search() {
        int count = 0;
        System.out.println();
        //Check if the ArrayList is empty
        if (list.isEmpty()) {
            System.out.println("Array is empty");
            System.out.println();
            return;
        } else {
            //Get an integer input for searching and display the index if found
            int index = ioce181023.IOCE181023.getInteger1("Enter a searching value : ", "Accept integer only");
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(index)) {
                    System.out.println("Array[" + (i + 1) + "] = " + index);
                    count++;
                }
            }
        }
        //Display a message if the value is not found
        if (count == 0) {
            System.out.println("Number does not exist!");
        }
        System.out.println();
    }

    /**
     * Method to display all elements in the ArrayList
     */
    public void display() {
        System.out.println();
        //Check if the ArrayList is empty
        if (list.isEmpty()) {
            System.out.println("Array is empty");
        } else {
            //Display all elements in the ArrayList
            System.out.println("Array:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println("Array[" + i + "] = " + list.get(i));
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Method to display elements in a specified range
     */
    public void displayRange() {
        System.out.println();
        int max;
        int min;
        int count = 0;
        //Check if the ArrayList is empty
        if (list.isEmpty()) {
            System.out.println("Array is empty");
        } else {
            // Get the min and max values for the range and display elements in that range
            do {
                min = ioce181023.IOCE181023.getInteger1("Enter the min range : ", "Accept integer only");
                max = ioce181023.IOCE181023.getInteger1("Enter the max range : ", "Accept integer only");
                //Check the max value must greater than or equal min value
                if (max < min) {
                    System.out.println("Max value must greater than or equal min value!");
                }
            } while (max < min);
            //Print out the value in range min to max
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= max && list.get(i) >= min) {
                    count++;
                    System.out.println("Array[" + i + "] = " + list.get(i));
                }
            }
            //Check to see if a value within the range can be found
            if (count == 0) {
                System.out.println("Can not find any value in range!");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Method to sort the elements in the ArrayList
     */
    public void sort() {
        System.out.println();
        //Check if the ArrayList is empty
        if (list.isEmpty()) {
            System.out.println("Array is empty");
        } else {
            // Create a new ArrayList, sort it, and display the sorted elements
            System.out.println("Array after sort:");
            ArrayList<Integer> list2 = new ArrayList<>(list);
            //Sort the array by ascending order
            Collections.sort(list2);
            //Print out the array
            for (int i = 0; i < list2.size(); i++) {
                System.out.println("Array[" + i + "] = " + list2.get(i));
            }
            System.out.println();
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
        //Create an object of the class
        S10CE181023 obj = new S10CE181023();
        String s;
        boolean check = false;
        //Menu-driven loop to perform array manipulations
        do {
            System.out.println("1- Add a value");
            System.out.println("2- Search a value");
            System.out.println("3- Print ");
            System.out.println("4- Print out values in a range of inputted min and max values");
            System.out.println("5- Sort the array ");
            //Get user input for menu choice
            s = ioce181023.IOCE181023.getString("Choose option : ", "Option from 1 to 5, other to exit");
            // Perform the corresponding operation based on user choice
            switch (s) {
                //Case get input
                case "1":
                    obj.input();
                    break;
                //Case to search a value
                case "2":
                    obj.search();
                    break;
                //Case print out the array
                case "3":
                    obj.display();
                    break;
                //Case print out values in a range of inputted min and max
                case "4":
                    obj.displayRange();
                    break;
                //Case sort the array in ascending order
                case "5":
                    obj.sort();
                    break;
                default://When choose other then stop the program
                    check = true;
                    break;
            }
        } while (!check);
    }

}
