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
public class Student {

    //Declare the variable
    private String code;
    private String name;
    private String birth;
    private double point;

    /**
     * Constructor to initialize a Student object with provided values.
     *
     * @param code The student code.
     * @param name The student name.
     * @param birth The date of birth of the student.
     * @param point The learning point of the student.
     */
    public Student(String code, String name, String birth, double point) {
        this.code = code;
        this.name = name;
        this.birth = birth;
        this.point = point;
    }

    /**
     * Default constructor with no parameters
     */
    public Student() {
    }

    /**
     * Getter method to retrieve the learning point of the student.
     *
     * @return The learning point of the student.
     */
    public double getPoint() {
        return point;
    }

    /**
     * Setter method to set the learning point of the student.
     *
     * @param point The learning point to set.
     */
    public void setPoint(double point) {
        this.point = point;
    }

    /**
     * Getter method to retrieve the student code.
     *
     * @return The student code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method to set the student code.
     *
     * @param code The student code to set.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method to retrieve the student name.
     *
     * @return The student name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method to set the student name.
     *
     * @param name The student name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method to retrieve the date of birth of the student.
     *
     * @return The date of birth of the student.
     */
    public String getBirth() {
        return birth;
    }

    /**
     * Setter method to set the date of birth of the student.
     *
     * @param birth The date of birth to set.
     */
    public void setBirth(String birth) {
        this.birth = birth;
    }

    /**
     * Override the toString method to provide a string representation of the
     * student object.
     *
     * @return a formatted string with student information.
     */
    @Override
    public String toString() {
        return "Student code: " + code + "\n" + "Student name: " + name + "\n" + "Date of birth: " + birth + "\n" + String.format("Learning point: %.1f", point);
    }

}
