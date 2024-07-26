/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v03ce181023;

import java.io.File;

/**
 * V03 The subsystem lists and searches files by content.
 *
 * @author Lam Tan Phat - CE181023
 */
public class V03CE181023 {

    /**
     * Show menu on screen
     */
    public void menu() {
        System.out.println("======= Format CSV Program =======");
        System.out.println("1. Import CSV");
        System.out.println("2. Format Address");
        System.out.println("3. Format Name");
        System.out.println("4. Export CSV");
        System.out.println("5. Exit");
    }

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Declare the object
        V03CE181023 obj = new V03CE181023();
        CSVManegement csv = new CSVManegement();
        int op;
        do {
            //Method display menu on screen
            obj.menu();
            //User chose the function from 1 to 5
            op = ioce181023.IOCE181023.getInteger("Please choice one option: ", "Only accept from 1 to 5", 1, 5);
            switch (op) {
                //Case import file to read
                case 1:
                    System.out.println("--------- Import CSV -------");
                    //The user enters the path of the csv file to read (path cannot be empty)
                    String fileImport = ioce181023.IOCE181023.getStringFile("Enter Path:", "You must enter a file name to import (end with .txt)!");
                    File f = new File(fileImport);
                    //Check file is exist or not 
                    if (!f.exists()) {
                        int count = 0;
                        int i = 1;
                        System.out.println("File not found! Try again");
                        File directory = new File("/CN/SP24_K3/LAB/LAB/V03/V03CE181023");
                        File[] files = directory.listFiles();
                        //Display the list of file have exist
                        System.out.println("---List file exist---");
                        for (File file : files) {
                            if (file.getName().endsWith(".txt")) {
                                System.out.println((i++) + ". " + file.getName());
                                count++;
                            }
                        }
                        //When no .txt files appear
                        if (count == 0) {
                            System.out.println("No .txt files appear");
                        }
                        System.out.println("---------------------");
                        csv.readFile(fileImport);
                        break;
                    }
                //Case format address
                case 2:
                    csv.addressFormat();
                    break;
                //Case format name
                case 3:
                    csv.nameFormat();
                    break;
                //Case write to file
                case 4:
                    csv.writeFile();
                    break;
            }
        } while (op != 5);
    }

}
