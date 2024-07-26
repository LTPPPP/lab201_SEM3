/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v01ce181023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * V01 Guess the lucky number
 *
 * @author Lam Tan Phat - CE181023
 */
public class V01CE181023 {

    ArrayList<Integer> listGuess = new ArrayList<>();
    //Declare countplay to count the play turn
    int countPlay = 0;

    /**
     * Method input the number and calculating the lucky number
     */
    public void inputNumber() {
        Random random = new Random();
        //Get the number from input (Must be the positive integer number)
        int number = ioce181023.IOCE181023.getInteger3("Enter the range of lucky number: ", "Must be the positive integer number.", 0);
        //Calculating the lucking number by function random ( calculate a random number from 0 to number )      
        int randomNum = random.nextInt(number + 1);
        play(randomNum);
    }

    /**
     * Method to check if the number the user enters is a lucky number. Print
     * out instructions if it's not a lucky number. If you guess correctly,
     * print out a congratulatory message. and count each user's guess
     *
     * @param randomNum is the lucky number calculated in the input number
     * method
     */
    public void play(int randomNum) {
        int guessNum;
        //Declare countguess to count the time guess
        int countGuess = 0;
        //Use loop if user guesses wrong
        do {
            //Enter the positive integer that the user guesses 
            guessNum = ioce181023.IOCE181023.getInteger3("Guess the lucky number: ", "Must be a non-negative integer.", 0);
            countGuess++;
            //If guessnum is smaller randomnum
            if (guessNum < randomNum) {
                System.out.println("The lucky number is greater than your guess. Guess again!!!");
            } //If guessnum is greater randomnum
            else if (guessNum > randomNum) {
                System.out.println("The lucky number is smaller than your guess. Guess again!!!");
            } //If user guess is correct
            else if (guessNum == randomNum) {
                System.out.println("Congratulations, you predicted correctly lucky number!!!");
            }
        } while (guessNum != randomNum);
        listGuess.add(countGuess);
    }

    /**
     * Method display on screen result of the game
     */
    public void report() {
        //Calculating total guess of all plays turn
        int totalGuess = 0;
        for (Integer b : listGuess) {
            totalGuess += b;
        }
        //Get the min value of the list
        int best = Collections.min(listGuess);
        //display the result on screen
        System.out.println("Total game: " + countPlay);
        System.out.println("Total guess: " + totalGuess);
        System.out.printf("Guess average: %.2f\n", (double) totalGuess / countPlay);
        System.out.println("Best guess is game " + (listGuess.indexOf(best) + 1) + ", play with " + best + " guesses");
    }

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        V01CE181023 obj = new V01CE181023();
        //Declare the option 
        int op;
        String c;
        Boolean check = false;
        //Display the menu
        do {
            System.out.println(" - Guess the lucky number - ");
            System.out.println("1 - Play");
            System.out.println("2 - Statistic");
            op = ioce181023.IOCE181023.getInteger2("Enter option: ", "Choose option from 1 to 2", 1, 2);
            System.out.println();
            switch (op) {
                case 1:
                    //Call the method to enter the number
                    obj.inputNumber();
                    obj.countPlay++;
                    break;
                case 2:
                    //In case it doesn't run any time
                    if (obj.countPlay != 0) {
                        obj.report();
                    } else {
                        System.out.println("There is no statistic history");
                    }
                    break;
            }
            //using loop to check the program is continue or not
            do {
                System.out.println();
                System.out.print("Do you want to continue? ");
                c = sc.nextLine().toLowerCase().trim();
                //Check the string is yes(y), no(n), khonng, co
                if (c.equals("y") || c.equals("n") || c.equals("yes") || c.equals("no") || c.equals("khong") || c.equals("co")) {
                    check = true;
                } else {
                    System.out.println("Accepts only yes/y or no/n");
                    check = false;
                }
            } while (!check);
            //End the program if string is n, no, khong, co then print out the leader board
            if ((c.equals("n") || c.equals("no") || c.equals("khong") || c.equals("co"))) {
                System.out.println("--- End game ---");
                //In case it doesn't run any time
                if (obj.countPlay != 0) {
                    obj.report();
                } else {
                    System.out.println("There is no statistic history");
                }
            }
        } while (!(c.equals("n") || c.equals("no") || c.equals("khong") || c.equals("co")));
    }
}
