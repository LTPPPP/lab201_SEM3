/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v05ce181023;

/**
 * V05 Input and display Person Info
 *
 * @author Lam Tan Phat - CE181023
 */
public class Person {

    //Declare the vaiable
    private String name;
    private String address;
    private double salary;

    /**
     * Default constructor
     */
    public Person() {
    }

    /**
     * The new constructor or person
     *
     * @param name from input data
     * @param address from input data
     * @param salary from input data
     */
    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    /**
     * Get the new value for name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the new value for name
     *
     * @param name from input data
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the new value for address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the new value for address
     *
     * @param address from input data
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the new value for salary
     *
     * @return the value of salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Set the new value for salary
     *
     * @param salary from input data
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * The method return the string with data
     *
     * @return the string with format
     */
    @Override
    public String toString() {
        return "Name:" + this.name + "\n" + "Address:" + this.address + "\n" + String.format("Salary:%.1f\n", this.salary);
    }

}
