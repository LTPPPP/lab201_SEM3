/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioce181023;

import java.util.Scanner;

/**
 * S01 Reverse a string, convert to upper case and vice versa
 *
 * @author Lam Tan Phat - CE181023
 */
public class IOCE181023 {

    static Scanner sc = new Scanner(System.in);

    /**
     * Get string only get character and end with ., !, or , throws Exception if
     * null
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
                //Check the string must end with '.'or '?' or '!' and not null
                if (r.length() != 0 && (r.matches("^[a-zA-Z\\s+]+[a-zA-Z.!?]"))) {
                    return r;
                } else {
                    //Throw Exception if invalid
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }

}
