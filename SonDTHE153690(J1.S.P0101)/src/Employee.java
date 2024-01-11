

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doson
 */
public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String DOB;
    private String sex;
    private double salary;
    private String egency;

    public Employee() {
    }

    public Employee(String id, String firstName, String lastName, String phone, String email, String address, String DOB, String sex, double salary, String egency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.sex = sex;
        this.salary = salary;
        this.egency = egency;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEgency(String egency) {
        this.egency = egency;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDOB() {
        return DOB;
    }

    public String getSex() {
        return sex;
    }

    public double getSalary() {
        return salary;
    }

    public String getEgency() {
        return egency;
    }
    
    
}
