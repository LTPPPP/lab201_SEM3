/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioce181023;

import java.util.Scanner;

/**
 * IOCE181023
 *
 * @author Lam Tan Phat - CE181023
 */
public class IOCE181023 {

    static Scanner sc = new Scanner(System.in);

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
                // check the string must not null, accept character only
                if (r.length() != 0 && r.matches("^[a-zA-Z]+")) {
                    return r;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }

    /**
     * Get string, throws Exception if null
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @param iError2 error message when entered incorrectly
     * @param iError3 error message when entered incorrectly
     * @param start from input ( the number must be greater than start number )
     * @return string from input
     */
    public static String getString2(String iMsg, String iError, String iError2, String iError3, double start) {
        String r = "";
        while (true) {
            try {
                System.out.print(iMsg);
                r = sc.nextLine().trim();
                //Check the string must not null, digit only and must be greater than start number
                if (r.length() == 0 || !r.matches("^[0-9]+") || Double.parseDouble(r) <= start) {
                    throw new Exception();
                }
                return r;
            } catch (Exception e) {
                //If string is the negative number
                if (r.matches("^[-0-9]+")) {
                    System.out.println(iError3);
                } else if (!r.matches("^[0-9]+")) {
                    //If String is null
                    if (r.length() == 0) {
                        System.out.println(iError);
                    } else {
                        System.out.println(iError2);
                    }
                }
            }
        }
    }
}
