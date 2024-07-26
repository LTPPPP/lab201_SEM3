/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioce181023;

import java.util.Scanner;

/**
 * V03 The subsystem lists and searches files by content.
 *
 * @author Lam Tan Phat - CE181023
 */
public class IOCE181023 {

    static Scanner sc = new Scanner(System.in);

    /**
     * Check input data of String type, if it not string type or null then then
     * display an error message and re-enter
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @return valid string
     */
    public static String getString(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().trim();
                if (r.length() == 0) {
                    throw new Exception();
                }
                return r;
            } catch (Exception e) {
                System.out.println(iError);
            }

        }
    }

    /**
     * Check input data of integer type, if it not integer type or not in the
     * range from Start to end then display an error message and re-enter
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @param start limit on the start of the data type when inputting
     * @param end limit at the end of the input data type
     * @return valid integer
     */
    public static int getInteger(String iMsg, String iError, int start, int end) {

        //check the start number must be greater than end number
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        int r;
        while (true) {
            try {
                System.out.print(iMsg);
                r = Integer.parseInt(sc.nextLine().trim());
                if (r < start || r > end) {
                    throw new Exception();
                }
                return r;
            } catch (Exception e) {
                System.out.println(iError);

            }
        }
    }

    /**
     * Get string with special format, throws Exception if null
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @return string from input
     */
    public static String getStringFile(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().trim();
                //Check the string must not null and must end with .txt
                if (r.length() != 0 && r.endsWith(".txt")) {
                    return r;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }
}
