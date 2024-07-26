/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s05ce181023;

/**
 * S05 Printing payments and calculating total expenditure
 *
 * @author Lam Tan Phat - CE181023
 */
public class S05CE181023 {

    /**
     * Method to calculating payments and calculating total expenditure
     */
    public void paymentPlan() {
        int month = 0;
        double amount = 0;
        //Input mortgage is a positive real number
        double mortgage = ioce181023.IOCE181023.getDouble3("What is the value left on the mortgage?\n", "Mortgage must be a real positive number.", 0);
        //Input rate is a positive real number
        double rate = ioce181023.IOCE181023.getDouble3("What is the anual interest rate of the loan, in percent?\n", "Rate must be a real positive number.", 0);
        //Input monthlypayment is a positive real number
        double monthlyPayment = ioce181023.IOCE181023.getDouble3("What is the mothly payment?\n", "Mothly payment must be a real positive number.", 0);
        System.out.println();
        double a = mortgage;
        double b;
        double c = monthlyPayment;
        b = a * (1 + (rate / 12) / 100) - c;
        //If the monthly payment is too small to ever pay off the loan
        if (b < b * (1 + (rate / 12) / 100) - c) {
            System.out.println("The monthly payment is too small to ever pay off the loan");
        } //If the loan is smaller than mothly payment
        else if (b < 0) {
            System.out.printf("%-5s %-8s %-12s\n", "Month ", "Payment", "Amount Owed");
            //Print out the result
            System.out.printf("%5d %8.2f %12.2f\n", ++month, mortgage * (1 + (rate / 12) / 100), amount);
        } else {
            System.out.printf("%-5s %-8s %-12s\n", "Month ", "Payment", "Amount Owed");
            //Using loop do while to calculating payments and calculating total expenditure, loop end when paid in full
            do {
                //Agorithm of the total expenditure 
                amount = mortgage * (1 + (rate / 12) / 100) - monthlyPayment;
                mortgage = amount;
                //Print out the result
                System.out.printf("%5d %8.2f %12.2f\n", ++month, monthlyPayment, amount);
                //Check the monthly payment is too small to ever pay off the loan
                if (monthlyPayment > amount && (int) amount > 0) {
                    monthlyPayment = amount * (1 + (rate / 12) / 100);
                    amount = 0;
                    System.out.printf("%5d %8.2f %12d\n", ++month, monthlyPayment, (int) amount);
                }
            } while ((int) amount != 0);
        }
    }

    /**
     * The main method
     *
     * @param args an array of arguments
     */
    public static void main(String[] args) {
        //Create an object to refer to the method
        S05CE181023 obj = new S05CE181023();
        //Calling method paymentPlan
        obj.paymentPlan();
    }
}
