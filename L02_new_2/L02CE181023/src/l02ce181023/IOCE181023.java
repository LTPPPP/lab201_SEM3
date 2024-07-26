/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l02ce181023;

import java.util.Scanner;

/**
 * L02 Quiz Bow
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
     * @param iError2 error message when entered incorrectly
     * @param iError3 error message when entered incorrectly
     * @param start number from input ( the number must be greater than start
     * number )
     * @param end number from input ( the number must be smaller than end number
     * )
     * @return integer from start number to end number
     */
    public static String getIntegerAmout(String iMsg, String iError, String iError2, String iError3, int start, int end) {
        // check the number start must be greater than end number
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        String r = null;
        while (true) {
            try {
                System.out.print(iMsg);
                r = sc.nextLine().trim();
                //Check the number r must from start number to end number
                if (Integer.parseInt(r) > start && Integer.parseInt(r) <= end) {
                    return r;
                }
                throw new Exception();
            } catch (Exception e) {
                if (!r.matches("^[0-9]+")) {
                    System.out.println(iError3);
                } else if (Integer.parseInt(r) <= start) {
                    System.out.println(iError2);
                } else if (Integer.parseInt(r) > end) {
                    System.out.println(iError);
                }
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
    public static String getString(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().toLowerCase().trim();
                //Check the string must not null or equal "skip"
                if ((r.length() != 0 || r.equals("skip")) && r.matches("^[a-zA-Z]+")) {
                    return r;
                }
                throw new Exception();
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
    public static String getStringAnsSA(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().toLowerCase().trim();
                //Check the string must not null or equal "skip"
                if (r.length() != 0 || r.equals("skip")) {
                    return r;
                }
                throw new Exception();
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
                //Check the string must not null and end with ".txt"
                if (r.length() != 0 && r.endsWith(".txt")) {
                    return r;
                }
                throw new Exception();
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
    public static String getStringTF(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().toLowerCase().trim();
                //Check the string must not null or equal with"true", "false", "skip"
                if (r.length() != 0 && (r.equals("true") || r.equals("false") || r.equals("skip"))) {
                    return r;
                }
                throw new Exception();
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
     * @param a the range of the letter
     * @return string from input
     */
    public static String getStringAnsMC(String iMsg, String iError, char a) {
        while (true) {
            try {
                System.out.print(iMsg);
                String r = sc.nextLine().toLowerCase().trim();
                //Check the string must not null and the first letter must in range from 'a' to the char s or equal "skip"
                if ((r.length() == 1 && !(r.charAt(0) < 'a' || r.charAt(0) > a) && Character.isLetter(r.charAt(0))) || r.equals("skip")) {
                    return r;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }

}
