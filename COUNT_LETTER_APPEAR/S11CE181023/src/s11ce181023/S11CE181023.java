/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s11ce181023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * S11 Count the number of the appearance of letters in a string
 *
 * @author Lam Tan Phat - CE181023
 */
public class S11CE181023 {

    //Declare the variable and HashMap
    String s;
    HashMap<String, Integer> name = new HashMap<>();

    /**
     * Method to get the string from input, cannot be empty
     */
    public void inputString() {
        s = ioce181023.IOCE181023.getString("Enter a string: ", "String cannot be empty");
        //Call the countChar 's method
        countChar();
    }

    /**
     * Method count the number of the appearance of letters in a string
     */
    public void countChar() {
        //Iterate through each character in the input string 's'
        for (int i = 0; i < s.length(); i++) {
            //Check if the current character is a letter
            if (Character.isLetter(s.charAt(i))) {
                //Update the count of the current letter in the 'name' map
                name.put(s.substring(i, i + 1), name.getOrDefault(s.substring(i, i + 1), 0) + 1);
            }
        }
        //Call the outputString 's method
        outputString();
    }

    /**
     * Display the letter and the number of its appear
     */
    public void outputString() {
        //Sort the keys in ascending order using a List and Collections.sort()
        List<String> sort = new ArrayList<>(name.keySet());
        Collections.sort(sort);
        //Iterate through the sorted keys and print character-count pairs
        for (String key : sort) {
            System.out.println(key + " : " + name.get(key));
        }
    }

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        S11CE181023 obj = new S11CE181023();
        //Call inputString 's method
        obj.inputString();
    }
}
