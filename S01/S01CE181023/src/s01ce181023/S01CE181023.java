/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s01ce181023;

/**
 * S01 Reverse a string, convert to upper case and vice versa
 *
 * @author Lam Tan Phat - CE181023
 */
public class S01CE181023 {

    /**
     * Input string s with the string must not empty and only accept character
     * without any special, and must end with . or ? or !
     *
     * @return valid string to perform reverseString function
     */
    public String inputString() {
        //Get string s with the string must not empty and only accept character without any special, and can end with . or ? or !
        String s = ioce181023.IOCE181023.getString("Enter a string: ", "The string cannot empty \n(It should only contain characters without any special characters and can end with . or ? or !)");
        //Return to function reverseString
        return reverseString(s);
    }

    /**
     * Method to reverse string from the string of method input string
     *
     * @param s string from input
     * @return a string have been reversed
     */
    public String reverseString(String s) {
        String reverseString = "";
        //Perform function checkString and reassign to s
        s = convertString(s);
        //Using loop with variable from i from length of String back to 0
        for (int i = s.length() - 1; i >= 0; i--) {
            //After each loop, assign 1 character of the string
            reverseString += s.charAt(i);
        }
        //Return value of reverseString
        return reverseString;
    }

    /**
     * Method to check the letters of string are lower case or upper case
     *
     * @param s string from input
     * @return newString with upper case to lower case and vice versa
     */
    public String convertString(String s) {
        String newString = "";
        //Using loop with variable i with index 0 to smaller than length of String
        for (int i = 0; i < s.length(); i++) {
            //Check the letter is lower case or not. if lower case, print out the upper case and vice versa 
            if (Character.isLowerCase(s.charAt(i))) {
                newString += Character.toUpperCase(s.charAt(i));
            } else {
                newString += Character.toLowerCase(s.charAt(i));
            }
        }
        //Return value of newString
        return newString;
    }

    /**
     * Method display the string on the screen
     *
     * @param s string from input
     */
    public void outputString(String s) {
        System.out.println(s);
    }

    /**
     * The main method
     *
     * @param args an array of arguments
     */
    public static void main(String[] args) {
        //Create an object to refer to the method
        S01CE181023 obj = new S01CE181023();
        //Calling the output string with method input string
        obj.outputString(obj.inputString());
    }
}
