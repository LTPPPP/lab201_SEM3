/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioce181023;

import java.util.Scanner;

/**
 * S10 Array Manipulations
 *
 * @author Lam Tan Phat - CE181023
 */
public class IOCE181023 {

    static Scanner sc = new Scanner(System.in);

    /**
     * Get all integer numbers
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @return integer from input
     */
    public static int getInteger1(String iMsg, String iError) {
        int r;
        while (true) {
            try {
                System.out.print(iMsg);
                r = Integer.parseInt(sc.nextLine().trim());
                return r;
            } catch (NumberFormatException e) {
                System.out.println(iError);
            }
        }
    }

    /**
     * Get string, throws Exception if null
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @return string from input
     */
    public static String getString(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().trim();
                //Check the string must not null
                if (r.length() == 0) {
                    throw new Exception();
                }
                return r;
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }

}
