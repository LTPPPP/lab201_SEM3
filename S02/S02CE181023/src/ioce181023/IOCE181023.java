/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioce181023;

import java.util.Scanner;

/**
 * S02 Convert hexadecimal and octal to binary
 *
 * @author Lam Tan Phat - CE181023
 */
public class IOCE181023 {

    static Scanner sc = new Scanner(System.in);

    /**
     * Get string then check number entered if it is not Octal Or Hexadecimal
     * then display an error message, throws Exception if null and let user
     * re-enter
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @return string from input
     */
    public static String getString2(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().trim();
                // Check for specific patterns based on ending character
                if (r.toLowerCase().endsWith("h")) {
                    if (!r.substring(0, r.length() - 1).matches("^[0-9A-Fa-f]+$")) {
                        throw new Exception();
                    }
                    // String is valid, return it
                    return r;
                } else if (r.toLowerCase().endsWith("q")) {
                    if (!r.substring(0, r.length() - 1).matches("^[0-7]+$")) {
                        throw new Exception();
                    }
                    // String is valid, return it
                    return r;
                } else {// Check for required ending character (case-insensitive)                   
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }

}
