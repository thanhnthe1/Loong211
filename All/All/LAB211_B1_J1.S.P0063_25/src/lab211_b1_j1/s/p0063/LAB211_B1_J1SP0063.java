/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0063;  //M15

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Nam
 */
public class LAB211_B1_J1SP0063 {

    /**
     * @param args the command line arguments
     */
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Person[] person = new Person[3];
        //Display GUI
        displayGui();
        //Input Persons information
        inputPersonsInfo(person);
        //Sort Person array by salary ascending.
        sortBySalary(person);
        //Display Persons information.
        displayPersonsInfo(person);

    }
    //Display GUI
    private static void displayGui(){
        System.out.println("=====Management Person programer=====");
    }
    //Input list person info 
    private static void inputPersonsInfo(Person[] person) throws Exception {
        person[2] = new Person("ha", "ab", 0);
        person[2].setName("nam");
        person[2].setAddress("hanoi");
        person[2].setSalary(-100);
        //add from first position to last position
        for (int i = 0; i < person.length-1; i++) {
            System.out.println("Input Information of Person");
            System.out.print("Please input name:");
            String name = InputName();
            System.out.print("Please input address:");
            String address = InputAddress();
            System.out.print("Please input salary:");
            double salary = InputSalary();
            Person per = new Person();
            //add info for each person
            person[i] = per.inputPersonInfo(name, address, salary);
        }
    }

    //input name
    private static String InputName() {
        try {
            //loop until input only is string
            while (true) {
                String result = in.nextLine().trim();
                int count = 0;
                //Check from FirstString to lastString
                for (int i = 0; i < result.length(); i++) {
                    // count character is digit
                    if (Character.isDigit(result.charAt(i))) {
                        count++;
                    }
                }
                //warning if input empty
                if (result.isEmpty()) {
                    System.err.print("You must input Name.\nPlease input name:");
                } //warning if string have digit
                else if (count > 0) {
                    System.err.print("Name is not digit.\nPlease input name:");
                } else {
                    return result;
                }
            }
        } catch (Exception e) {
            System.out.print("Please input name:");
        }
        return null;
    }

    //input address
    private static String InputAddress() {
        try {
            //loop until input is string
            while (true) {
                String result = in.nextLine().trim();
                //warning if input empty
                if (result.isEmpty()) {
                    System.err.print("You must input Address.\nPlease input address:");
                } else {
                    return result;
                }
            }
        } catch (Exception e) {
            System.out.print("Please input address:");
        }
        return null;
    }

    //input salary
    private static double InputSalary() {
        //loop until input is positive double
        while (true) {
            try {
                String result = in.nextLine();
                //check input empty 
                if (result.isEmpty()) {
                    System.err.print("You must input Salary.\nPlease input salary:");
                } //check input is positive double?
                else if (Double.parseDouble(result) < 0) {
                    System.err.print("Salary is greater than zero\nPlease input salary:");
                } else {
                    return Double.parseDouble(result);
                }
            } catch (NumberFormatException ex) {
                System.err.print("You must input digit.\nPlease input salary:");
            }
        }
    }

    //Display Persons information. 
    private static void displayPersonsInfo(Person[] person) {
        //Display info from first person to last person
        for (int i = 0; i < person.length; i++) {
            System.out.println("\nInformation of Person you have entered:");
            System.out.println("Name:" + person[i].getName());
            System.out.println("Address:" + person[i].getAddress());
            System.out.println("Salary:" + person[i].getSalary());
        }
    }

    //Sort Person array by salary ascending with bubbleSort.
    private static Person[] sortBySalary(Person[] person) {
        try {
            //run from first elm to near last elm
            for (int i = 0; i < person.length-1; i++) {
                //run from first elm to near elm was sorted
                for (int j = 0; j < person.length - i - 1; j++) {
                    //compare salary of two person 
                    if (person[j].getSalary() > person[j + 1].getSalary()) {
                        //change position 
                        Person temp = person[j];
                        person[j] = person[j + 1];
                        person[j + 1] = temp;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Can't Sort Person.");
        }
        return person;
    }
}
