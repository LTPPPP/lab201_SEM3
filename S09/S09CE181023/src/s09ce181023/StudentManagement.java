/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s09ce181023;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * S09 Manage student
 *
 * @author Lam Tan Phat - CE181023
 */
public class StudentManagement {

    //ArrayList to store the list of students
    ArrayList<Student> list = new ArrayList<>();

    //Declare the variable
    String code;
    String name;
    String birth;
    double point;
    int dd;
    String mmm;
    int yy;
    int mm;
    //Get the time today
    LocalDate today = LocalDate.now();
    int day = today.getDayOfMonth();
    int year = today.getYear();
    int month = today.getMonthValue();

    /**
     * Method to input student information. Ensures uniqueness of student code
     * and validates input for name, date of birth, and learning point.
     */
    public void inputStu() {
        System.out.println();
        System.out.println("Enter new student:");
        int count;
        do {
            count = 0;
            //Get the student code value
            code = ioce181023.IOCE181023.getString2("Student code: ", "Code must start with 'SV' and end with number");
            //Check the student code exist or not
            for (Student s : list) {
                if (s.getCode().equalsIgnoreCase(code)) {
                    count++;
                }
            }
            //If student code has exist
            if (count != 0) {
                System.out.println("Student code has exist!");
            }
        } while (count != 0);
        //Get the name, birth, point value
        name = ioce181023.IOCE181023.getString("Student name: ", "Accept letter only");
        //Get the birth and check it valid or not
        inputBirth();
        point = ioce181023.IOCE181023.getDouble3("Learning point: ", "Accept real positive number", 0);
        //Add value to list
        list.add(new Student(code, name, birth, point));
        System.out.println();
    }

    /**
     * Convert string of month to number
     */
    public void convertMonth() {
        switch (mmm) {
            //Case january
            case "jan":
                mm = 1;
                break;
            //Case February
            case "feb":
                mm = 2;
                break;
            //Case March
            case "mar":
                mm = 3;
                break;
            //Case April
            case "apr":
                mm = 4;
                break;
            //Case May
            case "may":
                mm = 5;
                break;
            //Casea June
            case "jun":
                mm = 6;
                break;
            //Case July
            case "jul":
                mm = 7;
                break;
            //Case August
            case "aug":
                mm = 8;
                break;
            //Case September
            case "sep":
                mm = 9;
                break;
            //Case October
            case "oct":
                mm = 10;
                break;
            //Case November
            case "nov":
                mm = 11;
                break;
            //Case December
            case "dec":
                mm = 12;
                break;
        }
    }

    /**
     * Method to get the birth and check it valid or not
     */
    public void inputBirth() {
        //Declare the variable
        boolean check = false;
        boolean checkValidDay = false;
        //Using loop to check the birth, continue if check is false
        do {
            do {
                checkValidDay = false;
                birth = ioce181023.IOCE181023.getString3("Date of birth: ", "dd-mmm-yyyy (dd from 01 to 31), (mmm is 3 first letter of the month), (yyyy is year to today)");
                //Split it to variable dd, mm, yy by '-'
                String arr[] = birth.split("\\-");
                dd = Integer.parseInt(arr[0]);
                mmm = arr[1];
                yy = Integer.parseInt(arr[2]);
                convertMonth();
                //Check the day is valid or not
                if (yy > year) {
                    checkValidDay = true;
                    System.out.println("Date of birth until to date " + day + "/" + month + "/" + year);
                } else if (yy == year) {
                    if (mm > month) {
                        checkValidDay = true;
                        System.out.println("Date of birth until to date " + day + "/" + month + "/" + year);
                    } else if (mm == month) {
                        if (dd > day) {
                            checkValidDay = true;
                            System.out.println("Date of birth until to date " + day + "/" + month + "/" + year);
                        }
                    }
                } else if (yy == 0) {//Check the year cannot be 0
                    checkValidDay = true;
                    System.out.println("Year must not equal 0000");
                }
            } while (checkValidDay);
            //Check the leap year or not
            if (((yy % 4 == 0) && (yy % 100 != 0)) || (yy % 400 == 0)) {
                //If the leap year so February has a maximum of 29 days
                if (mmm.equalsIgnoreCase("feb") && dd > 29) {
                    System.out.println(yy + " is a leap year, so February has a maximum of 29 days");
                    check = false;
                } else {
                    check = true;
                }
            } //If is not the leap year
            else if (mmm.equalsIgnoreCase("feb") && dd > 28) {
                System.out.println(yy + " is not a leap year, so February has a maximum of 28 days");
                check = false;
            } //Check the months only have 30 days
            else if (mmm.equalsIgnoreCase("apr") || mmm.equalsIgnoreCase("jun") || mmm.equalsIgnoreCase("sep") || mmm.equalsIgnoreCase("nov")) {
                if (dd > 30) {
                    System.out.println("April, June, September and November only have 30 days");
                    check = false;
                } else {
                    check = true;
                }
            } else {
                check = true;
            }
        } while (!check);

    }

    /**
     * Method to look up students by name and display their information.
     */
    public void lookUp() {
        System.out.println();
        if (list.isEmpty()) {
            System.out.println("List is empty");
        } else {
            int count = 0;
            //Input student name for lookup
            name = ioce181023.IOCE181023.getString("Student name: ", "Accept letter only");
            System.out.println("---Student list---");
            //Using loop to display the student if found
            for (Student s : list) {
                if (s.getName().toLowerCase().contains(name.toLowerCase())) {
                    count++;
                    System.out.println("---------------------------");
                    System.out.println(s.toString());
                }
            }
            //Check the name exist in the list or not
            if (count == 0) {
                System.out.println("Student doesn't exist!");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Method to display the list of students and their information.
     */
    public void display() {
        System.out.println();
        if (list.isEmpty()) {
            System.out.println("List is empty");
        } else {
            //Sorted student name by ascending order
            list.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
            System.out.println("Student list:\n");
            System.out.println("---------------------------");
            for (Student s : list) {
                System.out.println(s.toString());
                System.out.println("---------------------------");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Method to write the list of students and their information to a file.
     *
     * @param filename The name of the file to write the data.
     */
    public void writeFile(String filename) {
        try {
            FileWriter out = new FileWriter(filename);
            //Using loop to display the information of student sorted in student name ascending order
            list.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
            out.write("Student list:\n");
            for (Student s : list) {
                out.write("---------------------------\n");
                out.write(s.toString() + "\n");
            }
            out.close();
        } catch (IOException e) {
        }
    }
}
