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
     * get all integer numbers
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
                //throw Exception if invalid
            } catch (NumberFormatException e) {
                System.out.println(iError);
            }
        }
    }

    /**
     * get integer from start number to end number, if wrong( invalid ) throws
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
     * get integer from start number, if wrong( invalid ) throws to Exception
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
                if (r < start) {
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
     * get all double numbers
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @return double numbers
     */
    public static double getDouble1(String iMsg, String iError) {
        Double r;
        while (true) {
            try {
                System.out.print(iMsg);
                r = Double.parseDouble(sc.nextLine().trim());
                return r;
                //throw Exception if invalid
            } catch (NumberFormatException e) {
                System.out.println(iError);
            }

        }
    }

    /**
     * get double number from start number to end number, if wrong( invalid )
     * throws to Exception
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @param start number from input ( the number must be greater than start
     * number )
     * @param end number from input ( the number must be greater than end number
     * )
     * @return double number from start number to end number
     */
    public static double getDouble2(String iMsg, String iError, double start, double end) {
        //check the number start must be greater than end number
        if (start > end) {
            double temp = start;
            start = end;
            end = temp;
        }
        double r = 0;
        while (true) {
            try {
                System.out.print(iMsg);
                r = Double.parseDouble(sc.nextLine().trim());
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
     * get double number from start number, if wrong( invalid ) throws to
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
                if (r < start) {
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
     * get string, throws Exception if null
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
                //check the string must not null
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
     * get char a or b from input,throws Exception if null
     *
     * @param iMsg notification when entering
     * @param iError error message when entered incorrectly
     * @param a character from input ( the letter must be equal a )
     * @param b character from input ( the letter must be equal b )
     * @return char a or b from input
     */
    public static char getChar(String iMsg, String iError, char a, char b) {
        while (true) {
            try {
                System.out.print(iMsg);
                char r = sc.next().charAt(0);
                //check the character cannot be null and equal a or b
                if (r == ' ' && (r != a || r != b)) {
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
