/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioce181023;

import java.util.Scanner;

/**
 * S09 Manage student
 *
 * @author Lam Tan Phat - CE181023
 */
public class IOCE181023 {

    static Scanner sc = new Scanner(System.in);

    /**
     * Get integer from start number to end number, if wrong( invalid ) throws
     * to Exception
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @param start number from input ( the number must be greater than start
     * number )
     * @param end number from input ( the number must be smaller than end number
     * )
     * @return integer from start number to end number
     */
    public static int getInteger2(String iMsg, String iError, int start, int end) {
        // check the number start must be greater than end number
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        int r = 0;
        while (true) {
            try {
                System.out.print(iMsg);
                r = Integer.parseInt(sc.nextLine().trim());
                // check the number r must from start number to end number
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
                // check the number r must from start number to end number
                if (r <= start) {
                    throw new Exception();
                }
                return r;
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }

    /**
     * Get string(accepts letters only), throws Exception if null
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
                // check the string must not null
                if (r.length() == 0 || !r.matches("^[a-zA-z\\s+]+")) {
                    throw new Exception();
                }
                return r;
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }

    /**
     * Get string(accepts a specific format), throws Exception if null
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @return string from input
     */
    public static String getString2(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().toLowerCase().trim();
                //Check if the entered string is not empty and follows a specific format
                if (r.length() == 0 || !r.matches("^sv[0-9]+")) {
                    throw new Exception();
                }
                return r;
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }

    /**
     * Get string(accepts a specific date format), throws Exception if null
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @return string from input
     */
    public static String getString3(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().toLowerCase().trim();
                //Check if the entered string is not empty and follows a specific date format
                if (r.length() == 0 || !r.matches("^(0[1-9]|[12][0-9]|3[01])-(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)-([0-9][0-9][0-9][0-9]+)$")) {
                    throw new Exception();
                }
                return r;
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }

    /**
     * Get string(accepts a specific date format), throws Exception if null
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @return string from input
     */
    public static String getString4(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().trim();
                //Check if the entered string is not empty and follows a specific date format
                if (r.length() == 0 || !r.matches("^(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)$")) {
                    throw new Exception();
                }
                return r;
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }

}
