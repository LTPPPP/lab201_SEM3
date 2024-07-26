/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioce181023;

import java.util.Scanner;

/**
 * S12 Write a login function uses MD5 encryption for passwords
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

    /**
     * Get string, throws Exception if null
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @return string from input
     */
    public static String getStringYN(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().trim();
                //Get the char equal 'y' or 'n'
                if (r.length() == 1 && (r.toLowerCase().charAt(0) == 'y' || r.toLowerCase().charAt(0) == 'n')) {
                    return r;
                } else {
                    throw new Exception();
                }
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
     * @return string from input
     */
    public static String getStringPhone(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().trim();
                // check the string must not null
                if (r.length() != 0 && (r.length() == 10 || r.length() == 11) && r.matches("^[0-9]+")) {
                    return r;
                } else {
                    throw new Exception();
                }
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
     * @return string from input
     */
    public static String getStringEmail(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().trim();
                //Get the string with email fommat(///@///.com)
                if (r.length() != 0 && r.matches("^[\\w+.]+@[\\w+.]+\\.com$")) {
                    return r;
                } else {
                    throw new Exception();
                }
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
    public static String getStringDob(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().toLowerCase().trim();
                //Check if the entered string is not empty and follows a specific date format
                if (r.length() == 0 || !r.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9][0-9][0-9][0-9])$")) {
                    throw new Exception();
                }
                return r;
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }
}
