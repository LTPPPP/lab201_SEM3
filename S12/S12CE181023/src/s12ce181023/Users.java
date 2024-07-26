/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s12ce181023;

/**
 * S12 Write a login function uses MD5 encryption for passwords
 *
 * @author Lam Tan Phat - CE181023
 */
public class Users {

    //User attributes
    private String username;
    private String pass;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String dob;

    /**
     * Default constructor for creating a Users object with default values.
     */
    public Users() {
    }

    /**
     * Parameterized constructor to initialize a Users object with specific
     * values.
     *
     * @param username The username of the user.
     * @param pass The password of the user.
     * @param name The name of the user.
     * @param phone The phone number of the user.
     * @param email The email address of the user.
     * @param address The address of the user.
     * @param dob The date of birth of the user.
     */
    public Users(String username, String pass, String name, String phone, String email, String address, String dob) {
        this.username = username;
        this.pass = pass;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
    }

    /**
     * Gets the username of the user.
     *
     * @return The username as a String.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for the user.
     *
     * @param username The new username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password as a String.
     */
    public String getPass() {
        return pass;
    }

    /**
     * Sets the password for the user.
     *
     * @param pass The new password to set.
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Gets the name of the user.
     *
     * @return The name as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for the user.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the phone number of the user.
     *
     * @return The phone number as a String.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number for the user.
     *
     * @param phone The new phone number to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the email address of the user.
     *
     * @return The email address as a String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address for the user.
     *
     * @param email The new email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the address of the user.
     *
     * @return The address as a String.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address for the user.
     *
     * @param address The new address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the date of birth of the user.
     *
     * @return The date of birth as a String.
     */
    public String getDob() {
        return dob;
    }

    /**
     * Sets the date of birth for the user.
     *
     * @param dob The new date of birth to set.
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * Override of the toString method to provide a string representation of the
     * Users object.
     *
     * @return A string containing user information in a readable format.
     */
    @Override
    public String toString() {
        return "Users{" + "username=" + username + ", pass=" + pass + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address + ", dob=" + dob + '}';
    }

}
