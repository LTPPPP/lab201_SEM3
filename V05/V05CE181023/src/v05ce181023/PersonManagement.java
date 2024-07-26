/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v05ce181023;

import java.util.ArrayList;

/**
 * V05 Input and display Person Info
 *
 * @author Lam Tan Phat - CE181023
 */
public class PersonManagement {

    ArrayList<Person> listPer = new ArrayList<>();

    /**
     * Method to get input person information
     */
    public void inputPersonInfo() {
        //Using loop to get the data
        for (int i = 0; i < 3; i++) {
            System.out.println("Input Information of Person");
            //Get the name, accept character only
            String name = ioce181023.IOCE181023.getString("Please input name: ", "Accept character only");
            //Get the address, accept charater only
            String address = ioce181023.IOCE181023.getString("Please input address: ", "Accept character only");
            //Get the salary, salary is greater than zero, must be a digit, cannot be empty
            String salary = ioce181023.IOCE181023.getString2("Please input salary: ", "You must input Salary.", "You must input digit.", "Salary is greater than zero.", 0);
            //Add to the list
            listPer.add(new Person(name, address, Double.parseDouble(salary)));
        }
        //Call the method sort
        sort();
    }

    /**
     * Method array sorted by salary
     */
    public void sort() {
        //Sort array by salary
        listPer.sort((s1, s2) -> Double.compare(s1.getSalary(), s2.getSalary()));
        //Call the method output
        output();
    }

    /**
     * Method use to display the result on screen
     */
    public void output() {
        System.out.println();
        //Using loop to print out the data on screen
        for (Person p : listPer) {
            System.out.println("Information of Person you have entered:");
            System.out.println(p.toString());
        }
    }
}
