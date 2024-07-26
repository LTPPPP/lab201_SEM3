/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s02ce181023;

import java.util.Scanner;

/**
 * S02 Convert hexadecimal and octal to binary
 *
 * @author Lam Tan Phat - CE181023
 */
public class S02CE181023 {

    /**
     * Method convert hexadecimal and octal to binary
     *
     * @param s from input a hexadecimal or octal number
     */
    public void convertToDecimal(String s) {
        int total = 0;
        String ns = s.toUpperCase();
        //Check if the string ends with the letter h/H (Hexadecimal)
        if (ns.charAt(s.length() - 1) == 'H') {
            //Using loop with variable i to get the character(i) of the string
            for (int i = 0; i < ns.length() - 1; i++) {
                //Algorithm to calculating to convert hexadecimal to decimal and is stored in the variable total
                switch (ns.charAt(i)) {
                    //Case it is the letter A
                    case 'A':
                        total += 10 * Math.pow(16, s.length() - i - 2);
                        break;
                    //Case it is the letter B
                    case 'B':
                        total += 11 * Math.pow(16, s.length() - i - 2);
                        break;
                    //Case it is the letter C
                    case 'C':
                        total += 12 * Math.pow(16, s.length() - i - 2);
                        break;
                    //Case it is the letter D
                    case 'D':
                        total += 13 * Math.pow(16, s.length() - i - 2);
                        break;
                    //Case it is the letter E
                    case 'E':
                        total += 14 * Math.pow(16, s.length() - i - 2);
                        break;
                    //Case it is the letter F
                    case 'F':
                        total += 15 * Math.pow(16, s.length() - i - 2);
                        break;
                    //Case when character is number from 0-9
                    default:
                        total += ((int) s.charAt(i) - 48) * Math.pow(16, s.length() - i - 2);
                        break;
                }
            }
            //Check if the string ends with the letter q/Q (Octal)
        } else if (ns.charAt(s.length() - 1) == 'Q') {
            //Using loop with variable i to get the character(i) of the string
            for (int i = 0; i < s.length() - 1; i++) {
                //Algorithm to calculating to convert octal to decimal
                total += ((int) s.charAt(i) - 48) * Math.pow(8, s.length() - i - 2);
            }
        }
        //Reference the total variable to method convertToBinary 
        convertToBinary(total);
    }

    /**
     * Method convert decimal to the binary and space between each 4 digits
     *
     * @param total is the decimal value of the input string
     */
    public void convertToBinary(int total) {
        //Decleare the string b variable
        String b = "";
        //Decleare the integer count variable
        int count = 0;
        //Algorithm for conversion decimal to binary and space between each 4 digits
        do {
            count++;
            b += total % 2;
            if (count % 4 == 0) {
                b += " ";
            }
            total = total / 2;
        } while (total != 0);
        //Reverse the string
        StringBuilder bi = new StringBuilder();
        for (int i = b.length() - 1; i >= 0; i--) {
            bi.append(b.charAt(i));
        }
        //Reference the bi variable to method outputString
        outputString(bi);
    }

    /**
     * Method to display the binary string on screen
     *
     * @param bi is a string containing binary values
     */
    public void outputString(StringBuilder bi) {
        //display the result on the screen
        System.out.println(" Binary number: " + bi + "b");
    }

    /**
     * The main method
     *
     * @param args an array of arguments
     */
    public static void main(String[] args) {
        //Create an object to refer to the method
        S02CE181023 obj = new S02CE181023();
        Scanner sc = new Scanner(System.in);
        //Decleare the string s variable
        String s;
        //Decleare the string cont variable
        String cont;
        //Using loop do while and System.in.read() to repective until users close the program
        do {
            System.out.println("Convert Hexadecimal number / Octal number to Binary program");
            //Get string s from input then check it valid or not
            s = ioce181023.IOCE181023.getString2(" Enter a Hexadecimal (h) / Octal (q) number: ", "Hexadecimal only accept from 0 to 9 ,a/A, b/B, c/C, d/D, e/E, f/F and must ending with h/H.\nOctal only accept from 0 to 7, and must ending with q/Q.\n");
            //convert the string to binary if not return null
            obj.convertToDecimal(s);
            //Input the some thing to continue program
            System.out.println("Press any key to do another conversion.");
            System.out.print("--------------------");
            cont = sc.nextLine();
            System.out.println();
            //If user does not press any key , the program will not continue
        } while (cont != null);
    }
}
