/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s03ce181023;

import java.util.Scanner;

/**
 * S03 convert number to words
 *
 * @author Lam Tan Phat CE181023
 */
public class S03CE181023 {

    /**
     * Method convert number to words
     *
     * @param number from input is a integer number
     * @return the string's words that converted from a number
     */
    public static String numberToWords(int number) {
        //array of unitsMap and tensMap representation for units and tens
        String[] unitsMap = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tensMap = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        //if number is 0 print out zero
        if (number == 0) {
            return "zero";
        }
        //if number is a negative numbe print out with minus "-" and call funtion again
        if (number < 0) {
            return "minus " + numberToWords(Math.abs(number));
        }

        String words = "";

        //if number is greater or equal than one million
        if ((number / 1000000) > 0) {
            //write the number to word after recursive to numberToWords to get million units
            words += numberToWords(number / 1000000) + " million ";
            number %= 1000000;
        }
        //if number is greater or equal than one thousand
        if ((number / 1000) > 0) {
            //write the number to word after recursive to numberToWords to get thousand units
            words += numberToWords(number / 1000) + " thousand ";
            number %= 1000;
        }
        //if number is greater or equal than one hundred     
        if ((number / 100) > 0) {
            //write the number to word after recursive to numberToWords to get hundred units
            words += numberToWords(number / 100) + " hundred ";
            number %= 100;
        }
        //The algorithm handles tens and units of numbers by referencing tens and units into arrays unitsMap and unitsMap
        if (number > 0) {
            //if words is not null print out "and" to make connections between numbers 
            if (words != "") {
                words += "and ";
            }
            //if number is smaller than 20 is referencing into unitsMap
            if (number < 20) {
                words += unitsMap[number];
            } //if number is greater or equal than 20 is referencing into tensMap and unitsMap
            else {
                words += tensMap[number / 10];
                if ((number % 10) > 0) {
                    words += "-" + unitsMap[number % 10];
                }
            }
        }
        //return the string words
        return words;
    }

    /**
     * The main method
     *
     * @param args an array of arguments
     */
    public static void main(String[] args) {
        //Create an object to refer to the method
        Scanner sc = new Scanner(System.in);
        S03CE181023 obj = new S03CE181023();
        String c;
        Boolean check = false;
        //loop of repetive program. If users press y is countinue, press n to stop
        do {
            int number = ioce181023.IOCE181023.getInteger1("Please enter string in numeric format: ", "Only accpect from -999999999 to 999999999.");
            System.out.print("The converted string: ");
            System.out.println(numberToWords(number));
            //the loop check the letter c is only get y or n
            do {
                System.out.print("Do you want to continue? (Y/N) ");
                c = sc.nextLine();
                //check the charater is yes(y) or no(n)
                if ((Character.toLowerCase(c.charAt(0)) == 'y' || Character.toLowerCase(c.charAt(0)) == 'n') && c.length() == 1) {
                    check = true;
                } else {
                    System.out.println("Accepts only the letter y/Y or n/N.");
                    check = false;
                }
            } while (!check);
        } while (Character.toLowerCase(c.charAt(0)) != 'n');
    }
}
