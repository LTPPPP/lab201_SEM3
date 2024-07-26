/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s08ce181023;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * S08 English – English dictionary
 *
 * @author Lam Tan Phat - CE181023
 */
public class S08CE181023 {

    //Declare the hashmap to contains the value
    HashMap<String, String> word = new HashMap<>();
    //Declare the variable
    String sw;
    String sm;

    /**
     * Method to get the new word
     */
    public void newWord() {
        boolean check = false;
        System.out.println();
        System.out.println("- User choose 1:");
        do {
            //Get the new word
            sw = ioce181023.IOCE181023.getString("Enter a new word: ", "Accept letter only");
            //Check word exist or not
            if (word.containsKey(sw)) {
                System.out.println("The word already exists");
            } else {
                check = true;
            }
        } while (!check);
        //Get the new meaning
        sm = ioce181023.IOCE181023.getString("Meaning: ", "Accept letter only");
        word.put(sw, sm);
        System.out.println();
    }

    /**
     * Method to update an existing word
     */
    public void updateWord() {
        System.out.println();
        //Check the dictionary is empty or not
        if (word.isEmpty()) {
            System.out.println("Dictionary is empty");
            return;
        }
        System.out.println("- User choose 2:");
        //Get the word to update
        String swf = ioce181023.IOCE181023.getString("Enter a word to update: ", "Accept charater only");
        //Check the word exists or not
        if (word.containsKey(swf)) {
            //Get the meaning
            String smn = ioce181023.IOCE181023.getString("Meaning: ", "Accept charater only");
            //Replace in meaning
            word.put(swf, smn);
        } else {
            System.out.println("The word has not exists");
        }
        System.out.println();
    }

    /**
     * Method to look up meaning
     */
    public void findWord() {
        int count = 0;
        //Check the dictionary is empty or not
        if (word.isEmpty()) {
            System.out.println("Dictionary is empty");
            return;
        }
        //Get the key of hashmap to arraylist
        ArrayList<String> dict = new ArrayList<>(word.keySet());
        System.out.println();
        System.out.println("- User choose 3:");
        //Get the word want look up a meaning
        String swf = ioce181023.IOCE181023.getString("Enter a word to look up: ", "Accept charater only");
        //Display all word contain key word
        for (String d : dict) {
            if (d.contains(swf)) {
                System.out.println("----------");
                System.out.println("Word : " + d);
                System.out.println("Meaning : " + word.get(d));
                count++;
            }
        }
        //Check the word exists or not
        if (count == 0) {
            System.out.println("Word does not exist");
        }
        System.out.println();
    }

    /**
     * Method write word and meaning to file,keyword is stored in an index file,
     * word meaning is stored in data file,stored in each category
     */
    public void writeFile() {
        String firstLetter;
        try {
            //Initialize FileWriter for index and data files
            FileWriter indexOut = null;
            FileWriter dataOut = null;
            //Initialize FileWriter for index and data files
            int a = 0;
            int i;
            //Create a list of keys from the 'word' HashMap
            ArrayList<String> listKey = new ArrayList<>(word.keySet());
            //Create a HashMap to store the count of characters
            HashMap<String, Integer> listNumChar = new HashMap<>();
            //Sort the list of keys alphabetically
            Collections.sort(listKey);
            //Initialize variables for counting consecutive characters
            char first = listKey.get(0).charAt(0);
            int countChar = 1;
            //Iterate through the sorted list of keys
            for (i = 1; i < listKey.size(); i++) {
                if (listKey.get(i).charAt(0) == first) {
                    //If the current character is the same as the previous one, increment the count
                    countChar++;
                } else {
                    //If a new character is encountered, store the count for the previous character
                    listNumChar.put(listKey.get(i - 1).substring(0, 1), countChar);
                    first = listKey.get(i).charAt(0);
                    countChar = 1;
                }
            }
            //Store the count for the last character encountered
            listNumChar.put(listKey.get(listKey.size() - 1).substring(0, 1), countChar);
            //Iterate through the HashMap containing character counts
            for (Map.Entry<String, Integer> entry : listNumChar.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                //Create FileWriter for index and data files based on the character
                indexOut = new FileWriter(key + "_index.dat");
                dataOut = new FileWriter(key + "_meaning.dat");
                //Using loop to write equal with value times
                for (i = 0; i < value; i++) {
                    //Write the key (word) and its meaning to respective files
                    indexOut.write(listKey.get(i + a) + "\n");
                    dataOut.write(word.get(listKey.get(i + a)) + "\n");
                }
                //Close the FileWriter for the current character
                indexOut.close();
                dataOut.close();
                //Increment the counter 'a' based on the current iteration
                a += i;
            }
        } catch (IOException e) {
        }
    }

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Declare the object
        S08CE181023 obj = new S08CE181023();
        //Declare the variable
        int op;
        do {
            //Display the menu
            System.out.println("1. Create a new word");
            System.out.println("2. Edit a word");
            System.out.println("3. Look up meaning");
            System.out.println("4. Exit");
            //Get option, accept from 1 to 4 only
            op = ioce181023.IOCE181023.getInteger2("Please choose number (1 – 4):", "Accept from 1 to 4 only", 1, 4);
            switch (op) {
                //Case to create a new word
                case 1:
                    obj.newWord();
                    break;
                //Case edit a word
                case 2:
                    obj.updateWord();
                    break;
                //Case look up meaning
                case 3:
                    obj.findWord();
                    break;
                //Case write the data to file when stop the program
                case 4:
                    if (!obj.word.isEmpty()) {
                        obj.writeFile();
                    }
                    break;
            }
        } while (op != 4);
    }
}
