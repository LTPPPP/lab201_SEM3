/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s12ce181023;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * S12 Write a login function uses MD5 encryption for passwords
 *
 * @author Lam Tan Phat - CE181023
 */
public class UsersManagement {

    //Declare the variable
    String acc;
    String pass;
    String name;
    String phone;
    String email;
    String address;
    String dob;

    //Declare the arraylist to contain the value of users
    ArrayList<Users> list = new ArrayList<>();

    int dd;
    int mm;
    int yyyy;
    //Get the time today
    LocalDate today = LocalDate.now();
    int day = today.getDayOfMonth();
    int year = today.getYear();
    int month = today.getMonthValue();

    /**
     * The method to display the menu
     */
    public void menu() {
        //Declare the variable of option
        int op;
        do {
            System.out.println("============ Login Program =========");
            System.out.println("1. Add User");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            //Get the option
            op = ioce181023.IOCE181023.getInteger2("Please choice one option: ", "Accept only from 1 to 3", 1, 3);
            //Call back the method for each option
            switch (op) {
                case 1:
                    addUser();
                    break;
                case 2:
                    login();
                    break;
            }
        } while (op != 3);//The menu stop
    }

    /**
     * Method to add the user
     */
    public void addUser() {
        System.out.println();
        System.out.println("---------- Add User --------");
        //Get the account of user and check is exist or not
        do {
            acc = ioce181023.IOCE181023.getString("Account : ", "Cannot be empty.");
            //Check the account exist or not
            if (checkAcc()) {
                System.out.println("Account already exist");
            }
        } while (checkAcc());
        //Get the pass of user
        pass = ioce181023.IOCE181023.getString("Password : ", "Cannot be empty.");
        //Get the phone of user and check is exist or not
        do {
            phone = ioce181023.IOCE181023.getStringPhone("Phone : ", "Phone number must be 10 or 11 number.");
            //Check the phone exist or not
            if (checkPhone()) {
                System.out.println("Phone already exist");
            }
        } while (checkPhone());
        //Get the email of user and check is exist or not
        do {
            email = ioce181023.IOCE181023.getStringEmail("Email : ", "Email is valid format (abc@def.com)");
            //Check the email exist or not
            if (checkEmail()) {
                System.out.println("Email already exist");
            }
        } while (checkEmail());
        //Get the address of the user
        address = ioce181023.IOCE181023.getString("Address : ", "Cannot be empty.");
        //Get the birth of user then check it
        inputBirth();
        //Add the value to list
        list.add(new Users(acc, pass, name, phone, email, address, dob));
        System.out.println();
    }

    /**
     * Method check the account exist or not
     *
     * @return true if exist, false if not exist
     */
    public boolean checkAcc() {
        //Using loop to check the account exist or not
        for (Users u : list) {
            if (u.getUsername().endsWith(acc)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method check the phone exist or not
     *
     * @return true if exist, false if not exist
     */
    public boolean checkPhone() {
        //Using loop to check the phone exist or not
        for (Users u : list) {
            if (u.getPhone().endsWith(phone)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method check the email exist or not
     *
     * @return true if exist, false if not exist
     */
    public boolean checkEmail() {
        //Using loop to check the email exist or not
        for (Users u : list) {
            if (u.getEmail().endsWith(email)) {
                return true;
            }
        }
        return false;
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
                //Get the birth of the user with format dd/mm/yyyy
                dob = ioce181023.IOCE181023.getStringDob("DOB : ", "Date of birth is valid format dd/mm/yyyy.");
                //Split it to variable dd, mm, yy by '-'
                String arr[] = dob.split("\\/");
                dd = Integer.parseInt(arr[0]);
                mm = Integer.parseInt(arr[1]);
                yyyy = Integer.parseInt(arr[2]);
                //Check the year, month, day is valid or not
                if (yyyy > year) {
                    checkValidDay = true;
                    System.out.println("Year must smaller or equal than " + year);
                } else if (yyyy == year) {
                    if (mm > month) {
                        checkValidDay = true;
                        System.out.printf("Month must smaller or equal than " + month);
                    } else if (mm == month) {
                        if (dd > day) {
                            checkValidDay = true;
                            System.out.printf("Day must smaller or equal than " + day);
                        }
                    } else if (yyyy == 0) {//Check the year cannot equal 0
                        checkValidDay = true;
                        System.out.println("Year must not equal 0000");
                    }
                }
            } while (checkValidDay);
            //Check the leap year or not
            if (((yyyy % 4 == 0) && (yyyy % 100 != 0)) || (yyyy % 400 == 0)) {
                //If the leap year so February has a maximum of 29 days
                if (mm == 2 && dd > 29) {
                    System.out.println(yyyy + " is a leap year, so February has a maximum of 29 days");
                    check = false;
                } else {
                    check = true;
                }
            } //If is not the leap year
            else if (mm == 2 && dd > 28) {
                System.out.println(yyyy + " is not a leap year, so February has a maximum of 28 days");
                check = false;
            } //Check the months only have 30 days
            else if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {
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
     * Method user 's login
     */
    public void login() {
        System.out.println();
        boolean check = false;
        //Check the list is empty or not
        if (list.isEmpty()) {
            System.out.println("Account information is empty");
            System.out.println();
            return;
        }
        do {
            System.out.println("------------- Login ----------------");
            //Get the value acc, pass to login
            acc = ioce181023.IOCE181023.getString("Account : ", "Cannot be empty.");//not null
            pass = ioce181023.IOCE181023.getString("Password : ", "Cannot be empty.");
            //Check the acc, pass is correct then call the method greeting
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUsername().equals(acc) && list.get(i).getPass().equals(pass)) {//pass lowercase
                    check = true;
                    greeting();
                }
            }
            //If the acc, pass is incorrect then print out error and try again
            if (!check) {
                System.out.println("Login fail, try again!");
                System.out.println();
            }
        } while (!check);
        System.out.println();
    }

    /**
     * Metho greeting the user
     */
    public void greeting() {
        System.out.println();
        System.out.println("------------ Wellcome -----------");
        //Get the value y or n to change the password
        String yn = ioce181023.IOCE181023.getStringYN("Hi SkyLine, do you want change password now? Y/N: ", "Accept Y or N");
        //If the value is 'y' then call the method changePass, if the value is 'n' then return to menu
        if (yn.toLowerCase().equals("y")) {
            changePass();
        }
    }

    /**
     * Method to change the pass
     */
    public void changePass() {
        System.out.println();
        //Declare the variable 
        String oldPass;
        String newPass;
        String renewPass;
        boolean check = false;
        do {
            //Get the value oldPass, newPass, renewPass
            oldPass = ioce181023.IOCE181023.getString("Old Password : ", "Cannot be empty.");
            newPass = ioce181023.IOCE181023.getString("New Password : ", "Cannot be empty.");
            renewPass = ioce181023.IOCE181023.getString("Renew Password : ", "Cannot be empty.");
            //Check the newpass is equal with the renewpass or not
            if (!newPass.equals(renewPass)) {
                System.out.println("Renewpass is incorect, try again");
                System.out.println();
            } else {
                //If the newpass is equal with the renewpass then change the pass from the list
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getPass().equals(oldPass)) {
                        list.get(i).setPass(newPass);
                        System.out.println("Change password successful!!!");
                        check = true;
                    }
                }
                //Check the old password is wrong, does not exist in the list
                if (!check) {
                    System.out.println("The old password is wrong");
                    System.out.println();
                }
                //Check the old pass is equal the new pass and renew pass
                if (newPass.equals(renewPass) && newPass.equals(oldPass) && check) {
                    System.out.println("Your password remains the same");
                    System.out.println();
                }
            }
        } while (!newPass.equals(renewPass) || !check);
        System.out.println();
    }
}
