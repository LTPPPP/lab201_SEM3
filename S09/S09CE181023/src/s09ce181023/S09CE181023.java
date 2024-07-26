/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s09ce181023;

/**
 * S09 Manage student
 *
 * @author Lam Tan Phat - CE181023
 */
public class S09CE181023 {

    /**
     * Main method to run the student management application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Create an instance of the StudentManagement class
        StudentManagement obj = new StudentManagement();
        //Variable to store user's menu choice
        int op;
        //Menu loop
        do {
            //Display the menu
            System.out.println("1. Enter student list");
            System.out.println("2. Look up student");
            System.out.println("3. Display student list");
            System.out.println("4. Exit");
            //Get user's menu choice with validation
            op = ioce181023.IOCE181023.getInteger2("Please choose menu (1 – 4): ", "Accept from 1 to 4", 1, 4);
            //Perform action based on user's choice
            switch (op) {
                case 1:
                    //Input student data
                    obj.inputStu();
                    break;
                case 2:
                    //Look up student by name
                    obj.lookUp();
                    break;
                case 3:
                    //Display the student list
                    obj.display();
                    break;
                case 4:
                    //Write the student list to a file and exit
                    if (!obj.list.isEmpty()) {
                        obj.writeFile("student.txt");
                    }
                    break;
            }
        } while (op != 4);
    }

}
