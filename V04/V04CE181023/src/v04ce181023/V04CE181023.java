/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v04ce181023;

import java.util.Scanner;

/**
 * V04 Grade Student
 *
 * @author Lam Tan Phat - CE181023
 */
public class V04CE181023 {

    Scanner sc = new Scanner(System.in);
    //Declare the mid 's weight variable
    int weightMid;
    //Declare the final 's weight variable
    int weightFinal;
    //Declare the homework 's weight variable
    int weightHomeWork;
    //Declare the weightScoreMid variable to calculate
    double weightScoreMid;
    //Declare the weightScoreFinal variable to calculate
    double weightScoreFinal;
    //Declare the weightScoreHome variable to calculate
    double weightScoreHome;

    /**
     * Method displays a message with a brief description of the chapter program
     * for users to understand how this system will work and what functions it
     * has
     */
    public void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
        //Call the method midTerm
        midTerm();
    }

    /**
     * Method used to enter midterm exam scores - Midterm
     */
    public void midTerm() {
        System.out.println();
        //Declare the variable
        int shiftAmountMid = 0;
        int totalPointMid;
        System.out.println("Midterm:");
        //Get the value of mid 's weight
        weightMid = ioce181023.IOCE181023.getInteger2("Weight (0-100)? ", "Accept only integer from 0 to 98", 0, 98);
        //Get the value mid 's score
        int scoreMid = ioce181023.IOCE181023.getInteger2("Score eared? ", "Score must be positive integer number from 0 to 100", 0, 100);
        //Get value to check whether scores shifted are entered or not
        int shiftScoreMid = ioce181023.IOCE181023.getInteger2("Were score shifted (1=yes, 2=n0)? ", "Only accept 1 or 2", 0, 2);
        //Check to see if the scores shifted is obtained or not
        if (shiftScoreMid == 1) {
            //If have scores shifted then get value
            shiftAmountMid = ioce181023.IOCE181023.getInteger3("Shift amount? ", "Must be the positive integer", 0);
        }
        //Check if the total score exceeds the maximum score(100)
        if (scoreMid + shiftAmountMid > 100) {
            totalPointMid = 100;
        } else {
            totalPointMid = scoreMid + shiftAmountMid;
        }
        //Display on the screen the result
        System.out.println("Total point = " + totalPointMid + " / 100");
        weightScoreMid = (double) (totalPointMid) / 100 * weightMid;
        System.out.printf("Weighted score = %.1f / %d", weightScoreMid, weightMid);
        System.out.println();
        //Call the method finalTerm
        finalTerm();
    }

    /**
     * Method used to enter final term exam scores - Final term
     */
    public void finalTerm() {
        System.out.println();
        //Declare the variable
        int shiftAmountFinal = 0;
        int totalPointFinal;
        System.out.println("Final:");
        do {
            weightFinal = ioce181023.IOCE181023.getInteger2("Weight (0-100)? ", "Accept only integer from 0 to 99", 0, 99);
            //Check whether the sum of final 's weight and mid 's weight exceeds 100 or not
            if (weightFinal + weightMid >= 100) {
                System.out.println("Weight of final and weight mid must smaller than 100");
            }
        } while (weightFinal + weightMid > 100);
        //Get the value final 's score
        int scoreFinal = ioce181023.IOCE181023.getInteger2("Score eared? ", "Score must be positive number from 0 to 100", 0, 100);
        //Get value to check whether scores shifted are entered or not
        int shiftScoreFinal = ioce181023.IOCE181023.getInteger2("Were score shifted (1=yes, 2=no)? ", "Only accept 1 or 2", 0, 2);
        //Check to see if the scores shifted is obtained or not
        if (shiftScoreFinal == 1) {
            //If have scores shifted then get value
            shiftAmountFinal = ioce181023.IOCE181023.getInteger3("Shift amount? ", "Must be the positive integer", 0);
        }
        //Check if the total score exceeds the maximum score(100)
        if (scoreFinal + shiftAmountFinal > 100) {
            totalPointFinal = 100;
        } else {
            totalPointFinal = scoreFinal + shiftAmountFinal;
        }
        //Display on the screen the result
        System.out.println("Total point = " + totalPointFinal + " / 100");
        weightScoreFinal = (double) (totalPointFinal) / 100 * weightFinal;
        System.out.printf("Weighted score = %.1f / %d", weightScoreFinal, weightFinal);
        System.out.println();
        //Call the method homeWork
        homeWork();
    }

    /**
     * Method used to enter homework scores - Homework
     */
    public void homeWork() {
        System.out.println();
        System.out.println("Homework:");
        //Declare the variable
        int totalPointHome = 0;
        int totalPointHomeMax = 0;
        int sectionPoint;
        do {
            weightHomeWork = ioce181023.IOCE181023.getInteger2("Weight (0-100)? ", "Accept only integer from 0 to 100", 0, 100);
            //Check whether the sum of final 's weight and mid 's weight exceeds 100 or not, then give suggestions to the person entering 
            if (weightMid + weightFinal + weightHomeWork != 100) {
                System.out.println("Must ensure the total of 3 weights exactly 100");
                System.out.println("The weight should be " + (100 - weightMid - weightFinal));
            }
        } while (weightMid + weightFinal + weightHomeWork != 100);
        //Get the value to enter the number of exercises
        int numberOfAss = ioce181023.IOCE181023.getInteger3("Number of assignments? ", "Accept only positive integer number", 0);
        //Using loop with i variable to get the value of assignment
        for (int i = 1; i <= numberOfAss; i++) {
            System.out.print("Assignment " + i + " score and max? ");
            //Get the value of assignment
            int scoreAssHome = ioce181023.IOCE181023.getInteger4("", "Accept positive integer number", 0);
            int scoreAssHomeMax = ioce181023.IOCE181023.getInteger3("", "Accept positive integer number greater than " + scoreAssHome, scoreAssHome);
            totalPointHome += scoreAssHome;
            totalPointHomeMax += scoreAssHomeMax;
        }
        //Check the maximum score for the Assignment section is 150, if it exceeds it, it will only count as 150 points
        if (totalPointHomeMax > 150) {
            totalPointHomeMax = 150;
        }
        //Get the value of the section points
        int attend = ioce181023.IOCE181023.getInteger3("How many sections did you attend? ", "Accept only positive integer number", 0);
        //Check if the section points exceeds the maximum or not
        if (attend >= 6) {
            sectionPoint = 30;
        } else {
            sectionPoint = attend * 5;
        }
        //Display the result
        System.out.println("Section points = " + sectionPoint + " / 30");
        System.out.println("Total point = " + (totalPointHome + sectionPoint) + " / " + (totalPointHomeMax + 30));
        weightScoreHome = ((double) (totalPointHome + sectionPoint) / (totalPointHomeMax + 30)) * weightHomeWork;
        System.out.printf("Weighted score = %.1f / %d\n", weightScoreHome, weightHomeWork);
        System.out.println();
        //Call the method report
        report();
    }

    /**
     * Method to calculate and display the resulting GPA as well as notify
     * correlation comments
     */
    public void report() {
        //Display the result
        System.out.println();
        double overall = weightScoreMid + weightScoreFinal + weightScoreHome;
        System.out.printf("Overall percentage = %.1f\n", overall);
        double GPA;
        //Check overall to get GPA
        if (overall >= 85) {
            GPA = 3;
        } else if (overall < 85 && overall >= 75) {
            GPA = 2;
        } else if (overall < 75 && overall >= 60) {
            GPA = 1;
        } else {
            GPA = 0;
        }
        //Display the result
        System.out.println("Your grade will be at least: " + GPA);
        System.out.println("<< Your custom grade message here >>");
    }

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Declare object then call the begin method to run
        V04CE181023 obj = new V04CE181023();
        obj.begin();
    }

}
