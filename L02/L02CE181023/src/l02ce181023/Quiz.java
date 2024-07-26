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
 * L02 Quiz Bow
 *
 * @author Lam Tan Phat - CE181023
 */
public class Quiz {// + 6 class

    Scanner sc = new Scanner(System.in);
    //HashMaps to store questions and answers for true/false, multiple choice, and short answer questions
    HashMap<String, String> quizTF = new HashMap<>();
    HashMap<String, HashMap<String, ArrayList<String>>> quizMC = new HashMap<>();
    HashMap<String, String> quizSA = new HashMap<>();
    //ArrayList to store point for each question
    ArrayList<Integer> pointTF = new ArrayList<>();
    ArrayList<Integer> pointMC = new ArrayList<>();
    ArrayList<Integer> pointSA = new ArrayList<>();

    //Declare the variable for question anh answer of them
    String questionTF;
    String ansTF;
    String questionMC;
    String chooiceMC;
    String ansMC;
    String questionSA;
    String ansSA;

    //Declare variable to store the firstname and last name
    String firstName;
    String lastName;

    //Declare variable to store filename and amout of question user want to 
    String fileName;
    String amountQues;

    //Declare the counter for point for each question
    int pointMCCount = 0;
    int pointTFCount = 0;
    int pointSACount = 0;
    //Declare the totalpoint
    int totalPoint = 0;

    /**
     * Display the menu to get first name, last name and file name
     */
    public void menu() {
        int count = 0;
        boolean checkFile = false;
        //Get the firstname and last name
        firstName = ioce181023.IOCE181023.getString("What is your first name?\n", "Accept letter only");
        lastName = ioce181023.IOCE181023.getString("What is your last name?\n", "Accept letter only");
        //Using loop to get the file name
        do {
            fileName = ioce181023.IOCE181023.getStringFile("What file store your question?\n", "Cannot be empty and end with .txt");
            File f = new File(fileName);
            //Check the file exist or not
            if (!f.exists()) {
                int i = 1;
                //If file is not exist then display all file exist in folder
                System.out.println("File not found! Try again");
                File directory = new File("/CN/SP24_K3/LAB/LAB/L02/L02CE181023");
                File[] files = directory.listFiles();
                //Display all file exist
                System.out.println("---List file exist---");
                for (File file : files) {
                    if (file.getName().endsWith(".txt")) {
                        count++;
                        System.out.println((i++) + ". " + file.getName());
                    }
                }
                //Display when no file exist
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
            //Get the amout of question user want
            amountQues = ioce181023.IOCE181023.getIntegerAmout("How many question would you like (out of " + k + ")\n", "Sorry, that is too many", "Accept positive integer only", "Sorry, that is not valid", 0, k);
            //Using loop to get the value from readfile
            for (int i = 0; i < Integer.parseInt(amountQues); i++) {
                String s = sc.nextLine();
                String arr[] = s.split("\\s+");
                //Using switch case to check the arr[0] what type of question does it belong to
                switch (arr[0]) {
                    //Case the question is true/false
                    case "TF":
                        quizTF.clear();
                        questionTF = sc.nextLine();
                        ansTF = sc.nextLine();
                        //Add the value to hashmap
                        quizTF.put(questionTF, ansTF);
                        pointTF.add(Integer.parseInt(arr[1]));
                        System.out.println();
                        //Call the method quesTF
                        quesTF();
                        break;
                    //Case the question is mutiple choice
                    case "MC":
                        boolean checkUni = false;
                        quizMC.clear();
                        questionMC = sc.nextLine();
                        int n = Integer.parseInt(sc.nextLine());
                        ArrayList<String> quizMCList = new ArrayList<>();
                        //Get the multiple choice 
                        for (int j = 0; j < n; j++) {
                            chooiceMC = sc.nextLine();
                            //Check the answer the same or not
                            if (quizMCList.contains(chooiceMC)) {
                                checkUni = true;
                            }
                            quizMCList.add(chooiceMC);
                        }
                        ansMC = sc.nextLine();
                        HashMap<String, ArrayList<String>> ansMCMap = new HashMap<>();
                        ansMCMap.put(ansMC, quizMCList);
                        //Add the value question, multiple choice and answer to hashmap
                        quizMC.put(questionMC, ansMCMap);
                        pointMC.add(Integer.parseInt(arr[1]));
                        //Check the answers  at most 9 choices, this will always be either "A", "B", "C", "D", "E", "F", "G", "H", or "I"
                        if (n > 9) {
                            System.out.println();
                            System.out.println("Question at most 9 choices");
                            System.out.println();
                        } else {
                            System.out.println();
                            if (checkUni) {
                                System.out.println("The answer to the question cannot have the same answer");
                            } else {
                                //Call the method quesMC
                                quesMC();
                            }
                        }
                        break;
                    //Case the question is short answer
                    case "SA":
                        quizSA.clear();
                        questionSA = sc.nextLine();
                        ansSA = sc.nextLine();
                        //Add the value to the hash map
                        quizSA.put(questionSA, ansSA);
                        pointSA.add(Integer.parseInt(arr[1]));
                        System.out.println();
                        //Call the method quesSA
                        quesSA();
                        break;
                }
            }

        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method presents true/false questions to the user and calculates points.
     */
    public void quesTF() {
        //Using loop to entry the hashmap for get key and value
        for (Map.Entry<String, String> entry : quizTF.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            //Display the question and point
            System.out.println("Point : " + pointTF.get(pointTFCount));
            System.out.println("Question : " + key);
            //Get the answer
            String answer = ioce181023.IOCE181023.getStringTF("", "Accept true/false only");
            //Check the answer is correct or not, if correct points are added to the total score or subtract points from total score when wrong
            if (answer.equals(value)) {
                System.out.println("Correct! you get " + pointTF.get(pointMCCount) + " points.");
                totalPoint += pointTF.get(pointTFCount);
            } else if (answer.equals("skip")) {//Skip the question when user type skip
                System.out.println("You have selected to skip that question.");
            } else {
                System.out.println("Incorect, the answer was " + value + ". You lose " + pointTF.get(pointTFCount) + " points.");
                totalPoint -= pointTF.get(pointTFCount);
            }
            //Set the next value
            pointTFCount++;
        }
    }

    /**
     * Method presents multiple choice questions to the user and calculates
     * points.
     */
    public void quesMC() {
        //Declare the variable
        int i = 0;
        char character = 0;
        //Using loop to entry the hashmap(hashset) for get key and value
        for (Map.Entry<String, HashMap<String, ArrayList<String>>> entry : quizMC.entrySet()) {
            String key = entry.getKey();
            HashMap<String, ArrayList<String>> value = entry.getValue();
            for (Map.Entry<String, ArrayList<String>> entry1 : value.entrySet()) {
                String keyAns = entry1.getKey();
                ArrayList<String> valueChoice = entry1.getValue();
                //Display the question and point
                System.out.println("Point : " + pointMC.get(pointMCCount));
                System.out.println("Question : " + key);
                //Display the multiple choice and capital letter corresponding to the correct answer choice
                for (String mc : valueChoice) {
                    character = (char) (65 + (i++));
                    System.out.println(character + ")" + mc);
                }
                //Get the answer
                String answer = ioce181023.IOCE181023.getStringAnsMC("", "Accept character only from A to " + character, Character.toLowerCase(character));
                //Check the answer is correct or not, if correct points are added to the total score or subtract points from total score when wrong
                if (keyAns.toLowerCase().equals(answer)) {
                    System.out.println("Correct! you get " + pointMC.get(pointMCCount) + " points.");
                    totalPoint += pointMC.get(pointMCCount);
                } else if (answer.equals("skip")) {//Skip the question when user type skip
                    System.out.println("You have selected to skip that question.");
                } else {
                    System.out.println("Incorect, the answer was " + keyAns + ". You lose " + pointMC.get(pointMCCount) + " points.");
                    totalPoint -= pointMC.get(pointMCCount);
                }
                //Set the new value
                pointMCCount++;
            }
        }
    }

    /**
     * Method presents short answer questions to the user and calculates points.
     */
    public void quesSA() {
        //Using loop to entry the hashmap for get key and value
        for (Map.Entry<String, String> entry : quizSA.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            //Display the question and point
            System.out.println("Point : " + pointSA.get(pointSACount));
            System.out.println("Question : " + key);
            //Display the question and point
            String answer = ioce181023.IOCE181023.getStringAnsSA("", "Cannot be empty");
            //Check the answer is correct or not, if correct points are added to the total score or subtract points from total score when wrong
            if (answer.equals(value.toLowerCase())) {
                System.out.println("Correct! you get " + pointSA.get(pointSACount) + " points.");
                totalPoint += pointSA.get(pointSACount);
            } else if (answer.equals("skip")) {//Skip the question when user type skip
                System.out.println("You have selected to skip that question.");
            } else {
                System.out.println("Incorect, the answer was " + value + ". You lose " + pointSA.get(pointSACount) + " points.");
                totalPoint -= pointSA.get(pointSACount);
            }
            //Set the new value
            pointSACount++;
        }
    }

    /**
     * Displays the final score of the user.
     */
    public void totalPoint() {
        //Display the first and last name, then total point of user
        System.out.println(firstName + " " + lastName + " , your game is over!");
        System.out.println("Your final score is " + totalPoint + " points.");
        System.out.println("Better luck next time!");
    }
}
