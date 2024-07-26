/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l02ce181023;

/**
 * L02 Quiz Bow
 *
 * @author Lam Tan Phat - CE181023
 */
public class L02CE181023 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Declare the object
        Quiz obj = new Quiz();
        //Call the method menu
        obj.menu();
        //Call the method readFile
        obj.readFile();
        System.out.println();
        //Call the method totalpoint when end the program
        obj.totalPoint();
    }

}
