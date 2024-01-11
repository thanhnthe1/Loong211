/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0021;

import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class LAB211_B1_J1SP0021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Student> listStudents = new ArrayList<>();
        StudentManagement manage = new StudentManagement();
        int choice;
        do {
            //Display a menu
            manage.displayMenu();
            //User choice option
            choice = manage.choiceOption();
            switch (choice) {
                case 1:
                    //Option 1: Create student
                    manage.createStudent(listStudents);
                    break;
                case 2:
                    //Option 2: Find and Sort student
                    manage.findAndSortStudent(listStudents);
                    break;
                case 3:
                    //Option 3: Update/Delete student
                    manage.updateOrDeleteStudent(listStudents);
                    break;
                case 4:
                    //Option 4: Report student
                    manage.reportStudent(listStudents);
                    break;
                case 5:
                    //Option 5: Exit
                    manage.exit();
                    break;
            }
        } while (choice != 5);
    }

}
