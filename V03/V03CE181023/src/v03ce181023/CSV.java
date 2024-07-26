/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v03ce181023;

/**
 * V03 The subsystem lists and searches files by content.
 *
 * @author Lam Tan Phat - CE181023
 */
public class CSV {

    //Declare the varible
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;

    /**
     * Default constructor
     */
    public CSV() {
    }

    /**
     * Create new CSV
     *
     * @param id CSV's ID
     * @param name CSV's Name
     * @param email CSV's Email
     * @param phone CSV's Phone
     * @param address CSV's Address
     */
    public CSV(int id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Return CSV's ID
     *
     * @return CSV's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Set new value for CSV's ID
     *
     * @param id CSV's ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return CSV's Name
     *
     * @return CSV's Name
     */
    public String getName() {
        return name;
    }

    /**
     * Set new value for CSV's name
     *
     * @param name CSV's Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return CSV's Email
     *
     * @return CSV's Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set new value for CSV's email
     *
     * @param email CSV's Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return CSV's Phone
     *
     * @return CSV's Phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set new value for CSV's Phone
     *
     * @param phone CSV's Phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Return CSV's Address
     *
     * @return CSV's Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set new value for CSV's Address
     *
     * @param address CSV's Address
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
