/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author doson
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();       
        Validation val = new Validation();
        Controller c = new Controller(list);
        View v = new View(c);
        list.add(new Student("A1", "Ha Van E","1", "C/C++"));
        list.add(new Student("A2", "Ha Van B","2", "Java"));
        list.add(new Student("A3", "Ha Van C","3", ".Net"));
        list.add(new Student("A4", "Ha Van D","1", "Java"));
        list.add(new Student("A5", "Ha Van A","2", "C/C++"));
        list.add(new Student("A6", "Ha Van F","3", ".Net"));
        
        int choose;
        
        while(true){
            System.out.println("---------------------------");
            System.out.println("1.Add:");
            System.out.println("2.Find by name and Sort:");
            System.out.println("3.Update/Delete :");
            System.out.println("4.Report :");
            System.out.println("5.Exit Program:");
            System.out.println("----------------------------");
            System.out.print("Select a option:");
            choose = val.Check_int();
            switch(choose){
                case 1:
                    v.Add();
                    break;
                case 2:
                    v.findByName();
                    break;
                case 3:
                    v.updateOrDelete();
                    break;
                case 4:
                    v.Report();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Choose from 1 -> 5. Enter again:");
            }
            if(choose == 5){
                break;
            }
        }
    }
}
