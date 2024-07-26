/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioce181023;

import java.util.Scanner;

/**
 * S05 Printing payments and calculating total expenditure
 *
 * @author Lam Tan Phat - CE181023
 */
public class IOCE181023 {

    static Scanner sc = new Scanner(System.in);

    /**
     * Get double number from start number, if wrong( invalid ) throws to
     * Exception
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @param start number from input ( the number must be greater than start
     * number )
     * @return double number from start number
     */
    public static double getDouble3(String iMsg, String iError, double start) {
        double r = 0;
        while (true) {
            try {
                System.out.print(iMsg);
                r = Double.parseDouble(sc.nextLine().trim());
                //check the number r must from start number to end number
                if (r <= start) {
                    throw new Exception();
                }
                return r;
                //throw Exception if invalid
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }
}
