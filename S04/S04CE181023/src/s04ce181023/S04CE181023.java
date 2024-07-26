/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s04ce181023;

import java.util.Scanner;

/**
 * S04 Fuel economy
 *
 * @author Lam Tan Phat - CE181023
 */
public class S04CE181023 {

    /**
     * Method calculating fuel economy integer.
     */
    public void cacFuelEco() {
        //Input the number of minutes the car has traveled will be an integer
        int minute = ioce181023.IOCE181023.getInteger3("How many minutes did you drive?\n", "Must be a integer positive number", 0);
        //Input the speed of the car will be positive real number
        double speed = ioce181023.IOCE181023.getDouble3("What was the average speed of the car during that time?\n", "Must be a real positive number", 0);
        //Input the gasoline cinsumed will be a positive real number
        double gallon = ioce181023.IOCE181023.getDouble3("How many gallons of gas did your car use?\n", "Must be a real positive number", 0);
        //Algorithm to calculating the fuel
        double fuel = ((double) minute / 60 * speed) / gallon;
        //Output the fuel efficiency in miles per gallon to two decimal places
        System.out.printf("Your car averaged %.2f miles per gallon.\n", fuel);
    }

    /**
     * Method to calculating distance traveled
     */
    public void cacDisTra() {
        //Input the radius of the tires will be a positive real number in inches
        double r = ioce181023.IOCE181023.getDouble3("What is radius of your tires, in inches?\n", "Must be a real positive number", 0);
        //Input the number of revolutions of the tires will be a positive integer
        double revolutions = ioce181023.IOCE181023.getDouble3("How many revolutions did your car's tire make?\n", "Must be a real positive number", 0);
        //Algorithm to calculating distance
        double miles1 = (revolutions * (2 * r * Math.PI)) / 63360;
        //Output the number of miles the car has traveled based in the given information, to two decimal places
        System.out.printf("Your car traveled %.2f miles.\n", miles1);
    }

    /**
     * Method revised fuel economy calculation
     */
    public void reFuelEcoCac() {
        //Input the radius of the car's will be a positive real number in inches
        double r = ioce181023.IOCE181023.getDouble3("What is radius of your tires, in inches?\n", "Must be a real positive number", 0);
        //Input the number of revolutions of the tires will be a positive integer
        double revolutions = ioce181023.IOCE181023.getDouble3("How many revolutions did your car's tire make?\n", "Must be a real positive number", 0);
        //input the gasoline cinsumed will be a positive real number
        double gallon = ioce181023.IOCE181023.getDouble3("How many gallons of gas did your car use?\n", "Must be a real positive number", 0);
        //Algorithm calculating revised fuel economy 
        double miles1 = (revolutions * (2 * r * Math.PI)) / 63360;
        double miles2 = miles1 / gallon;
        //Output the fuel efficiency in miles per gallon to two decimal places
        System.out.printf("Your car averaged %.2f miles per gallon.\n", miles2);
    }

    /**
     * The main method
     *
     * @param args an array of arguments
     */
    public static void main(String[] args) {
        //Create an object to refer to the method
        Scanner sc = new Scanner(System.in);
        //Decleare the op variable
        int op;
        S04CE181023 obj = new S04CE181023();
        System.out.println("1 - Caculating Fuel Economy");
        System.out.println("2 - Caculating Distance Traveled");
        System.out.println("3 - Revised Fuel Economy Calculation");
        System.out.println("4 - Exit");
        //using do while loop to repeat
        do {
            System.out.println("");
            op = ioce181023.IOCE181023.getInteger2("Choice feature: ", "Choice only from 1 to 4", 1, 4);
            System.out.println("");
            //Using swtich case with op variable
            switch (op) {
                case 1:
                    //If op is 1 run the method 1
                    obj.cacFuelEco();
                    break;
                case 2:
                    //If op is 2 run the method 2
                    obj.cacDisTra();
                    break;
                case 3:
                    //If op is 3 run the method 3                    
                    obj.reFuelEcoCac();
                    break;
            }
        } while (op != 4);
    }
}
