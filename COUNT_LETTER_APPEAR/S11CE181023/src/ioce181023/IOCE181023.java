/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioce181023;

import java.util.Scanner;

/**
 * S11 Count the number of the appearance of letters in a string
 *
 *
 * @author Lam Tan Phat - CE181023
 */
public class IOCE181023 {

    static Scanner sc = new Scanner(System.in);

    /**
     * Get string then lowercase, throws Exception if null
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @return string from input
     */
    public static String getString(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().toLowerCase().trim();
                // check the string must not null
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
