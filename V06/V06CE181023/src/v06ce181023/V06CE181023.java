/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v06ce181023;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * V06 Sort one-dimensional array with bubble sort algorithm.
 *
 * @author Lam Tan Phat - CE181023
 */
public class V06CE181023 {

    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();
    //Declare the op variable
    int op;

    /**
     * Method display the menu on screen
     */
    public void menu() {
        do {
            //Display the menu
            System.out.println("======== Bubble Sort program =========");
            System.out.println("1. Input Element");
            System.out.println("2. Sort Ascending");
            System.out.println("3. Sort Descending");
            System.out.println("4. Exit");
            //Get the option, only accept from 1 to 4
            op = ioce181023.IOCE181023.getInteger2("Please choice one option: ", "The choice is only from 1 to 4", 1, 4);
            //Check out any options
            switch (op) {
                case 1:
                    //Call the method input element
                    inputEl();
                    break;
                case 2:
                    //If the list is empty then print out "The array is empty, please choose 1 enter a value"
                    if (list.isEmpty()) {
                        System.out.println("The array is empty, please choose 1 to enter a value");
                    } //If the list is not empty then run the method ascending
                    else {
                        ascending();
                        System.out.println();
                    }
                    break;
                case 3:
                    //If the list is empty then print out "The array is empty, please choose 1 enter a value"
                    if (list.isEmpty()) {
                        System.out.println("The array is empty, please choose 1 to enter a value");
                    } //If the list is not empty then run the method descending
                    else {
                        descending();
                        System.out.println();
                    }
                    break;
            }
        } while (op != 4);
    }

    /**
     * Method to input the element
     */
    public void inputEl() {
        System.out.println("----- Input Element -----");
        System.out.println("Input Length Of Array");
        //Get the size of the array
        int n = ioce181023.IOCE181023.getInteger3("Enter Number: ", "Please input number and number is greater than zero", 0);
        for (int i = 0; i < n; i++) {
            //Get value to the array
            list.add(ioce181023.IOCE181023.getInteger1("Enter Number " + (i + 1) + ": ", "Accept integer only"));
        }
    }

    /**
     * Method change the positions of the items, resulting in an array
     * containing sorted elements sort in ascending order
     */
    public void ascending() {
        //Outer loop for multiple passes through the list
        for (int i = 0; i < list.size() - 1; i++) {
            //Inner loop for comparing and swapping adjacent elements
            for (int j = 0; j < list.size() - i - 1; j++) {
                //Compare adjacent elements and swap if necessary for ascending order
                if (list.get(j) > list.get(j + 1)) {
                    // Swap elements
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        //Report the sorted list
        report();
    }

    /**
     * Method changing the position of elements creates an array containing
     * sorted elements In descending order
     */
    public void descending() {
        //Outer loop for multiple passes through the list
        for (int i = 0; i < list.size() - 1; i++) {
            //Inner loop for comparing and swapping adjacent elements
            for (int j = 0; j < list.size() - i - 1; j++) {
                // Change the comparison to sort in descending order
                if (list.get(j) < list.get(j + 1)) {
                    //Swap elements
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        //Report the sorted list
        report();
    }

    /**
     * Method display the sorted array on the screen
     */
    public void report() {
        //Display the numbers sorted in ascending order
        if (op == 2) {
            System.out.println("------ Ascending -----");
            //Print to screen with following format
            System.out.print("[" + list.get(0) + "]");
            for (int i = 1; i < list.size(); i++) {
                System.out.print("->[" + list.get(i) + "]");
            }
        } //Display the numbers sorted in descending order
        else if (op == 3) {
            System.out.println("------ Descending -----");
            //Print to screen with following format
            System.out.print("[" + list.get(0) + "]");
            for (int i = 1; i < list.size(); i++) {
                System.out.print("<-[" + list.get(i) + "]");
            }
        }
    }

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Declare object
        V06CE181023 obj = new V06CE181023();
        //Call back the method 
        obj.menu();
    }
}
