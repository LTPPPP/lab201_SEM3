/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v03ce181023;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * V03 The subsystem lists and searches files by content.
 *
 * @author Lam Tan Phat - CE181023
 */
public class CSVManegement {

    LinkedList<CSV> list = new LinkedList<>();

    /**
     * Read File: The program requires the user to provide a CSV file including
     * the fields: ID, Name, Email, Phone, Address and checks whether this file
     * exists or not
     *
     * @param fileName path to the file entered by the user
     */
    public void readFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                String[] word = line.split(",\\s+");
                int id = Integer.parseInt(word[0]);
                String name = word[1].trim();
                String email = word[2].trim();
                String phone = word[3].trim();
                String address = word[4].trim();
                //Add properties to the list
                list.add(new CSV(id, name, email, phone, address));
            }
            System.out.println("Import: Done");
        } catch (FileNotFoundException | NumberFormatException e) {
            //Check this file exists or not
            System.out.println("The path is not correct or the file name is wrong. Please check again!");
        }
    }

    /**
     * Address Format: Check the address format and remove extra spaces from
     * address fields
     */
    public void addressFormat() {
        //Check if the user has not added a file path to read, then ask the user to enter 1 to add the file path
        if (list.isEmpty()) {
            System.out.println("You have not provided a CSV file (choose 1 to add the path of the csv file)");
            return;
        }
        System.out.println("--------- Format Address");
        for (CSV csv : list) {
            String address = csv.getAddress().trim();
            int len = csv.getAddress().trim().length();
            //Use a loop to consider each character in a string
            for (int i = 0; i < len - 1; i++) {
                //In case there are 2 consecutive spaces, delete the second space
                if (address.charAt(i) == ' ') {
                    //Use a while loop to remove the second space until the next character is not a space
                    while (address.charAt(i + 1) == ' ') {
                        address = address.substring(0, i + 1) + address.substring(i + 2, len);
                        //Each deletion reduces the length by 1
                        len--;
                    }
                }
                //If there is no space before and after the '-' character, the program will add a space
                if (address.charAt(i) == '-' && address.charAt(i + 1) != ' ') {
                    address = address.substring(0, i + 1) + " " + address.substring(i + 1, len);
                    //Increase the length by one each time you add it
                    len++;
                } else if (address.charAt(i) != ' ' && address.charAt(i + 1) == '-') {
                    address = address.substring(0, i + 1) + " " + address.substring(i + 1, len);
                    //Increase the length by one each time you add it
                    len++;
                }
            }
            //Reset the formatted address value
            csv.setAddress(address);
        }
        System.out.println("-------Format: Done");
    }

    /**
     * Name Format: The program removes extra spaces and changes the first
     * character of a word to uppercase
     */
    public void nameFormat() {
        //Check if the user has not added a file path to read, then ask the user to enter 1 to add the file path
        if (list.isEmpty()) {
            System.out.println("You have not provided a CSV file (choose 1 to add the path of the csv file)");
            return;
        }
        System.out.println("--------- Format Name");
        for (CSV csv : list) {
            String name = csv.getName().toLowerCase().trim();
            //Set the first character of the string to uppercase
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
            int len = csv.getName().trim().length();
            //Use a loop to consider each character in a string
            for (int i = 0; i < len - 1; i++) {
                //In case there are 2 consecutive spaces, delete the second space
                if (name.charAt(i) == ' ') {
                    //Use a while loop to remove the second space until the next character is not a space
                    while (name.charAt(i + 1) == ' ') {
                        name = name.substring(0, i + 1) + name.substring(i + 2, len);
                        //Each deletion reduces the length by 1
                        len--;
                    }
                }
                //Checks if the previous character is a space and the next character is not a space, then uppercase the next character
                if (name.charAt(i) == ' ' && name.charAt(i + 1) != ' ') {
                    name = name.substring(0, i + 1) + Character.toUpperCase(name.charAt(i + 1)) + name.substring(i + 2, len);
                }
            }
            //Reset the formatted name value
            csv.setName(name);
        }

        System.out.println("-------Format: Done");
    }

    /**
     * Write File: Export files formatted according to the user's chosen format
     */
    public void writeFile() {
        //Check if the user has not added a file path to read, then ask the user to enter 1 to add the file path
        if (list.isEmpty()) {
            System.out.println("You have not provided a CSV file (choose 1 to add the path of the csv file)");
            return;
        }
        System.out.println("--------- Import CSV ------");
        //The user enters the path of the csv file to write (path cannot be empty)
        String fileExport = ioce181023.IOCE181023.getString("Enter Path:", "You must enter a file name to export!");
        try {
            FileWriter out = new FileWriter(fileExport);
            for (CSV csv : list) {
                //Check if the user has not added a file path to read, then ask the user to enter 1 to add the file path
                out.write(csv.getId() + ", " + csv.getName() + ", " + csv.getEmail() + ", " + csv.getPhone() + ", " + csv.getAddress() + "\n");
            }
            System.out.println("Export: Done");
            out.close();
        } catch (IOException e) {
        }
    }
}
