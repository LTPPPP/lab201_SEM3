/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l02ce181023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Lam Tan Phat - CE181023
 */
public class Quiz {

    Scanner sc = new Scanner(System.in);

    // Declare arraylist to contain question
    ArrayList<String> listQuizTF = new ArrayList<>();
    ArrayList<String> listQuizMC = new ArrayList<>();
    ArrayList<String> listQuizSA = new ArrayList<>();

    ArrayList<String> listAnsTF = new ArrayList<>();
    ArrayList<String> listAnsMC = new ArrayList<>();
    HashMap<String, ArrayList> listAllAnsMC = new HashMap<>();
    ArrayList<String> listAnsSA = new ArrayList<>();

    // ArrayList to store point for each question
    ArrayList<Integer> pointTF = new ArrayList<>();
    ArrayList<Integer> pointMC = new ArrayList<>();
    ArrayList<Integer> pointSA = new ArrayList<>();

    ArrayList<String> firstName = new ArrayList<>();
    ArrayList<String> lastName = new ArrayList<>();

    // Declare variable to store filename and amout of question user want to
    String fileName;
    String amountQues;

    // Declare the variable for question anh answer of them
    String questionTF;
    String ansTF;
    String questionMC;
    String chooiceMC;
    String ansMC;
    String questionSA;
    String ansSA;

    boolean checkUni = false;
    int n;

    int orderMC;

    // Declare the counter for point for each question
    int MCCount = 0;
    int TFCount = 0;
    int SACount = 0;
    // Declare the totalpoint
    int totalPoint = 0;

    /**
     * Display the menu to get first name, last name and file name
     */
    public void menu() {
        int count = 0;
        boolean checkFile = false;
        // Get the firstname and last name
        String firstNameGet = IOCE181023.getString("What is your first name?\n", "Accept letter only");
        String lastNameGet = IOCE181023.getString("What is your last name?\n", "Accept letter only");
        firstName.add(firstNameGet);
        lastName.add(lastNameGet);
        // Using loop to get the file name
        do {
            fileName = IOCE181023.getStringFile("What file store your question?\n",
                    "Cannot be empty and end with .txt");
            File f = new File(fileName);
            // Check the file exist or not
            if (!f.exists()) {
                int i = 1;
                // If file is not exist then display all file exist in folder
                System.out.println("File not found! Try again");
                File directory = new File("/CN/SP24_K3/LAB/LAB/L02/L02CE181023");
                File[] files = directory.listFiles();
                // Display all file exist
                System.out.println("---List file exist---");
                for (File file : files) {
                    if (file.getName().endsWith(".txt")) {
                        count++;
                        System.out.println((i++) + ". " + file.getName());
                    }
                }
                // Display when no file exist
                if (count == 0) {
                    System.out.println("No .txt files appear");
                }
                System.out.println("---------------------");
                checkFile = true;
            } else {
                checkFile = false;
            }
        } while (checkFile);
    }

    /**
     * The method to read file, get the value and add to hash map
     */
    public void readFile() {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int k = Integer.parseInt(sc.nextLine());
            // Get the amout of question user want
            amountQues = IOCE181023.getIntegerAmout("How many question would you like (out of " + k + ")\n",
                    "Sorry, that is too many", "Accept positive integer only", "Sorry, that is not valid", 0, k);
            // Using loop to get the value from readfile
            for (int i = 0; i < Integer.parseInt(amountQues); i++) {
                String s = sc.nextLine();
                String arr[] = s.split("\\s+");
                // Using switch case to check the arr[0] what type of question does it belong to
                switch (arr[0]) {
                    // Case the question is true/false
                    case "TF":
                        readQuizTF();
                        pointTF.add(Integer.parseInt(arr[1]));
                        break;
                    // Case the question is mutiple choice
                    case "MC":
                        readQuizMC();
                        if (n > 9) {
                            System.out.println();
                            System.out.println("Question at most 9 choices");
                            System.out.println();
                        } else {
                            System.out.println();
                            if (checkUni) {
                                System.out.println("The answer to the question cannot have the same answer");
                            } else {
                                // Call the method quesMC
                            }
                        }
                        break;
                    // Case the question is short answer
                    case "SA":
                        readQuizSA();
                        pointSA.add(Integer.parseInt(arr[1]));
                        break;
                }
            }

        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readQuizTF() {
        questionTF = sc.nextLine();
        ansTF = sc.nextLine();
        listQuizTF.add(questionTF);
        listAnsTF.add(ansTF);
    }

    public void readQuizMC() {
        checkUni = false;
        questionMC = sc.nextLine();
        n = Integer.parseInt(sc.nextLine());
        listQuizMC.add(questionMC);
        for (int i = 0; i < n; i++) {
            ansMC = sc.nextLine();
            if (listAnsMC.contains(ansMC)) {
                checkUni = true;
                return;
            }
            listAnsMC.add(ansMC);
        }
        listAllAnsMC.put(questionMC, listAnsMC);
    }

    public void readQuizSA() {
        questionSA = sc.nextLine();
        ansSA = sc.nextLine();
        listQuizSA.add(questionSA);
        listAnsSA.add(ansSA);
    }

    public void quizTF() {
        System.out.println("Point : " + pointTF.get(TFCount));
        System.out.println(listQuizTF.get(TFCount));
        String answer = IOCE181023.getStringTF("", "Accept true/false only");
        if (answer.equals(listAnsTF.get(TFCount))) {
            System.out.println("Correct! you get " + pointTF.get(TFCount) + " points.");
            totalPoint += pointTF.get(TFCount);
        } else if (answer.equals("skip")) {
            System.out.println("You have selected to skip that question.");
        } else {
            System.out.println("Incorect, the answer was " + listAnsTF.get(TFCount) + ". You lose "
                    + pointTF.get(TFCount) + " points.");
            totalPoint -= pointTF.get(TFCount);
        }
        TFCount++;
    }

    public void quizMC() {
        int i = 0;
        char character = 0;
        System.out.println("Point : " + pointMC.get(MCCount));
        System.out.println(listQuizMC.get(MCCount));
        
        character = (char) (65 + (i++));
        System.out.println(character + ")" + s);

    }
}
