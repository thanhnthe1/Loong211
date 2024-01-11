/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0063;

/**
 *
 * @author Nam
 */
public class Person {

    private String name;
    private String address;
    private double salary;

    public Person() {
    }

    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void setAddress(String address) {
        this.address = address;

    }

    public void setSalary(double salary) throws Exception {
        try {
            if (salary < 0) {
                 throw new Exception("Salary is greater than zero.");
            } else {
                this.salary = salary;
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", address=" + address + ", salary=" + salary + '}';
    }

    public Person inputPersonInfo(String name, String address, double salary) {

        return new Person(name, address, salary);
    }
}
