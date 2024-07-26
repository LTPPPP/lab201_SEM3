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
        //check the number start must be greater than end number
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
                //check the number r must from start number to end number
                if (r < start || r > end) {
                    throw new Exception();
                }
                return r;
                //throw Exception if invalid
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }

    /**
     * Get integer from start number, if wrong( invalid ) throws to Exception
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @param start number from input ( the number must be greater than start
     * number )
     * @return integer from start number
     */
    public static int getInteger3(String iMsg, String iError, int start) {
        int r = 0;
        while (true) {
            try {
                System.out.print(iMsg);
                r = Integer.parseInt(sc.nextLine().trim());
                //check the number r must from start number
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
