/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l02ce181023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * L02 Quiz Bow
 *
 * @author Lam Tan Phat - CE181023
 */
public class QuizManagement {

    Scanner sc = new Scanner(System.in);

    //Declare the variable for question anh answer of them
    String questionTF;
    String ansTF;
    String questionSA;
    String ansSA;
    String questionMC;
    String choiceMCOp;
    String ansMC;

    //Declare the variable to check the unique answer of multiple choices
    boolean checkUni = false;
    int n;

    //Declare variable to store the firstname and last name
    String firstName;
    String lastName;

    //Declare variable to store filename and amout of question user want to 
    String fileName;
    String amountQues;

    //Declare the list to contain the question and answer
    ArrayList<Quiz> listQuiz = new ArrayList<>();
    ArrayList<String> choiceMC = new ArrayList<>();

    // Declare the counter for point for each question
    int countQuiz = 0;
    // Declare the totalpoint
    int totalPoint = 0;

    /**
     * Display the menu to get first name, last name and file name
     */
    public void menu() {
        int count = 0;
        boolean checkFile = false;
        //Get the firstname and last name
        firstName = IOCE181023.getString("What is your first name?\n", "Accept letter only");
        lastName = IOCE181023.getString("What is your last name?\n", "Accept letter only");
        //Using loop to get the file name
        do {
            fileName = IOCE181023.getStringFile("What file store your question?\n", "Cannot be empty and end with .txt");
            File f = new File(fileName);
            //Check the file exist or not
            if (!f.exists()) {
                int i = 1;
                //If file is not exist then display all file exist in folder
                System.out.println("File not found! Try again");
                File directory = new File("/CN/SP24_K3/LAB/LAB/L02_new_2/L02CE181023");
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
                        readQuizTF(sc);
                        //Add value (question, answer, point) to the list
                        listQuiz.add(new Quiz(questionTF, ansTF, Integer.parseInt(arr[1])));
                        System.out.println();
                        //Call the method displayQuizTF
                        displayQuizTF();
                        break;
                    // Case the question is mutiple choice
                    case "MC":
                        readQuizMC(sc);
                        System.out.println();
                        //Check the unique of the multiple choice
                        listQuiz.add(new Quiz(questionMC, ansMC, choiceMC, Integer.parseInt(arr[1])));
                        // Call the method displayQuizMC
                        displayQuizMC();
                        if (n > 9) {
                            System.out.println("Error question (The question have at most 9 answer)");
                        } else {
                            if (checkUni) {
                                System.out.println("Error question (The answer to the question cannot have the same answer)");
                            }
                        }
                        break;
                    //Case the question is short answer
                    case "SA":
                        readQuizSA(sc);
                        //Add value (question, answer, point) to the list
                        listQuiz.add(new Quiz(questionSA, ansSA, Integer.parseInt(arr[1])));
                        System.out.println();
                        //Call the method displayQuizSA
                        displayQuizSA();
                        break;
                }
            }

        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method read a file to get the question and answer of TF
     *
     * @param sc to read the value from file
     */
    public void readQuizTF(Scanner sc) {
        //Get the value of the file
        questionTF = sc.nextLine();
        ansTF = sc.nextLine();
    }

    /**
     * Method read a file to get the question and answer of SA
     *
     * @param sc to read the value from file
     */
    public void readQuizSA(Scanner sc) {
        //Get the value of the file
        questionSA = sc.nextLine();
        ansSA = sc.nextLine();
    }

    /**
     * Method read a file to get the question and answer of MC
     *
     * @param sc
     */
    public void readQuizMC(Scanner sc) {
        checkUni = false;
        //Get the value of the file
        questionMC = sc.nextLine();
        //Get the number of the answer
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            choiceMCOp = sc.nextLine();
            //Check the answer exist or not
            if (choiceMC.contains(choiceMCOp)) {
                checkUni = true;
            }
            //Add the multiple choice to list
            choiceMC.add(choiceMCOp);
        }
        ansMC = sc.nextLine();
    }

    /**
     * Method display the quiz of TF
     */
    public void displayQuizTF() {
        //Display point and question on screen
        System.out.println("Point : " + listQuiz.get(countQuiz).getPointTFAndSA());
        System.out.println(listQuiz.get(countQuiz).getQuestionTFAndSA());
        //Get the answer of question
        String answer = IOCE181023.getStringTF("", "Accept true/false only");
        //Check the answer correct or not
        if (answer.equals(listQuiz.get(countQuiz).getAnsTFAndSA().toLowerCase())) {
            System.out.println("Correct! you get " + listQuiz.get(countQuiz).getPointTFAndSA() + " points.");
            //Caculate the totalpoint
            totalPoint += listQuiz.get(countQuiz).getPointTFAndSA();
        } else if (answer.equals("skip")) {//Case you skip the question
            System.out.println("You have selected to skip that question.");
        } else {
            System.out.println("Incorect, the answer was " + listQuiz.get(countQuiz).getAnsTFAndSA() + ". You lose "
                    + listQuiz.get(countQuiz).getPointTFAndSA() + " points.");
            //Caculate the totalpoint
            totalPoint -= listQuiz.get(countQuiz).getPointTFAndSA();
        }
        countQuiz++;
    }

    /**
     * Method display the quiz of SA
     */
    public void displayQuizSA() {
        //Display point and question on screen
        System.out.println("Point : " + listQuiz.get(countQuiz).getPointTFAndSA());
        System.out.println(listQuiz.get(countQuiz).getQuestionTFAndSA());
        //Get the answer of question
        String answer = IOCE181023.getStringAnsSA("", "Cannot be empty");
        //Check the answer correct or not
        if (answer.equals(listQuiz.get(countQuiz).getAnsTFAndSA().toLowerCase())) {
            System.out.println("Correct! you get " + listQuiz.get(countQuiz).getPointTFAndSA() + " points.");
            //Caculate the totalpoint
            totalPoint += listQuiz.get(countQuiz).getPointTFAndSA();
        } else if (answer.equals("skip")) {//Case you skip the question
            System.out.println("You have selected to skip that question.");
        } else {
            System.out.println("Incorect, the answer was " + listQuiz.get(countQuiz).getAnsTFAndSA() + ". You lose "
                    + listQuiz.get(countQuiz).getPointTFAndSA() + " points.");
            //Caculate the totalpoint
            totalPoint -= listQuiz.get(countQuiz).getPointTFAndSA();
        }
        countQuiz++;
    }

    /**
     * Method display the quiz of MC
     */
    public void displayQuizMC() {
        int i = 0;
        char character = 0;
        System.out.println("Point : " + listQuiz.get(countQuiz).getPointMC());
        System.out.println(listQuiz.get(countQuiz).getQuestionMC());
        //Display the multiple choice and capital letter corresponding to the correct answer choice
        for (int j = 0; j < listQuiz.get(countQuiz).getChoiceMC().size(); j++) {
            character = (char) (65 + (i++));
            System.out.println(character + ")" + listQuiz.get(countQuiz).getChoiceMC().get(j));
        }
        if (n < 9 && !checkUni) {
            //Get the answer
            String answer = IOCE181023.getStringAnsMC("", "Accept character only from A to " + character, Character.toLowerCase(character));
            //Check the answer is correct or not, if correct points are added to the total score or subtract points from total score when wrong
            if (listQuiz.get(countQuiz).getAnsMC().toLowerCase().equals(answer)) {
                System.out.println("Correct! you get " + listQuiz.get(countQuiz).getPointMC() + " points.");
                totalPoint += listQuiz.get(countQuiz).getPointMC();
            } else if (answer.equals("skip")) {//Skip the question when user type skip
                System.out.println("You have selected to skip that question.");
            } else {
                System.out.println("Incorect, the answer was " + listQuiz.get(countQuiz).getAnsMC() + ". You lose " + listQuiz.get(countQuiz).getPointMC() + " points.");
                totalPoint -= listQuiz.get(countQuiz).getPointMC();
            }
        }
        countQuiz++;
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
