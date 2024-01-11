/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Manage;
import java.util.ArrayList;
import java.util.List;
import model.Report;
import model.Student;

/**
 *
 * @author kidzd
 */
public class View {

    Manage manage = new Manage();

    void input() {
        //input properties
        String id = getId();

        //name
        Student studentInList = manage.getStudentByID(id);
        String name;
        if (studentInList == null) {
            name = getName();
        } else {
            name = studentInList.getName();
            System.out.println("Enter name: " + name);
        }
        int semester = getSemester();
        int course = getCourse();

        if (manage.checkDuplicate(id, name, semester, course)) {
            System.out.println("Your input is duplicate !!");
        } else {
            Student student = new Student(id, name, semester, course);
            manage.addStudent(student);
            System.out.println("Add successfull !!");
        }
    }

    /**
     * get id from user input
     *
     * @return id
     */
    private String getId() {
        String id = GetInput.getString("Enter id: ", "Wrong", GetInput.REGEX_STRING);
        return id;
    }

    /**
     * get name from user input
     *
     * @return name
     */
    private String getName() {
        String name = GetInput.getString("Enter name: ", "Wrong", GetInput.REGEX_STRING);
        return name;
    }

    /**
     * get semester from user input
     *
     * @return semester
     */
    private int getSemester() {
        int semester = GetInput.getInt("Enter semester: ", "Wrong", 0, 15);
        return semester;
    }

    /**
     * get course from user input
     *
     * @return course
     */
    private int getCourse() {
        int course = GetInput.getInt("Enter course (1:Java 2:.NET 3: C/C++): ", "Wrong", 1, 3);
        return course;
    }

    /**
     * get yes or no
     *
     * @return true or false
     */
    private boolean checkYesNo() {
        String result = GetInput.getString("Do you want to continue (Y/N)?: ",
                "Must be y or n", GetInput.REGEX_Y_N);
        if (result.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }
    // find student by name and sort

    void findAndSort() {
        String name = getName();

        List<Student> listSearch = manage.getListStudentByName(name);
        if (listSearch.size() == 0) {
            System.out.println("Not found !");
        } else {
            manage.sort(listSearch);
            displayListStudent(listSearch);
        }

    }
    // use to display list student

    private void displayListStudent(List<Student> listSearch) {
        System.out.printf("%-10s %-20s %-10s %-10s\n", "ID", "Name", "Semester", "Course");
        for (Student student : listSearch) {
            System.out.println(student);
        }
    }

    // report
    void report() {
        manage.getListReport().clear();
         
        for (Student firstStudent : manage.getListStudent()) {
            //check exist report
            if (manage.checkExistReport(firstStudent, manage.getListReport()) == false) {
                int total = 0;
                //if  record not in exist
                for (Student secondStudent : manage.getListStudent()) {
                    if (firstStudent.getId().equalsIgnoreCase(secondStudent.getId())
                            && firstStudent.getCourse() == (secondStudent.getCourse())) {
                        total++;
                    }
                }
                manage.addReport(new Report(firstStudent.getId(), firstStudent.getName(),
                        firstStudent.getCourse(), total));
            }
        }
    
        System.out.printf("%-20s | %-10s | %-10s\n", "Name", "Course", "Total Course");
        for (Report report : manage.getListReport()) {
            System.out.println(report);
        }
    }

    void updateOrDelete() throws Exception {
        String id = getId();

        List<Student> listSearch = manage.getListStudentByID(id);
        if (listSearch.size() == 0) {
            System.out.println("Not found !");
        } else {

            if (checkUpdateOrDelete()) {
                //true = update
                updateStudent(listSearch);
            } else {
                //false = delete
                deleteStudent(listSearch);
            }
        }
    }

    /**
     * ask user want to update or delete
     *
     * @return true or false
     */
    private boolean checkUpdateOrDelete() {
        String result = GetInput.getString("Do you want to update (U) or delete (D) ?: ", "Your input must be U or D !", GetInput.REGEX_UD);
        if (result.equalsIgnoreCase("u")) {
            return true;
        }
        return false;
    }
    // use to update 

    private void updateStudent(List<Student> listFoundByID) throws Exception {
        displayListFoundByID(listFoundByID);
        int choice = GetInput.getInt("Which record do you want to update? : ", "Wrong", 1, listFoundByID.size());

        Student student = listFoundByID.get(choice - 1);

        String idUpdate = student.getId();
        String name = student.getName();
        int semester = student.getSemester();
        int courseName = student.getCourse();

        //check want to update properties
        if (checkWantToUpdate("id")) {
            idUpdate = getId();
        }

        if (checkWantToUpdate("name")) {
            name = getName();
        }

        if (checkWantToUpdate("semester")) {
            semester = getSemester();
        }

        if (checkWantToUpdate("course")) {
            courseName = getCourse();
        }

        if (manage.checkNotUpdate(idUpdate, name, semester, courseName, student)) {
            System.out.println("You not update !!");
        } else if (manage.checkDuplicate(idUpdate, name, semester, courseName)) {
            System.out.println("Your input is duplicate !!");
        } else {
            student.setId(idUpdate);
            manage.updateAllName(idUpdate, name);
            student.setSemester(semester);
            student.setCourseName(courseName);
        }

    }

    // delete student
    private void deleteStudent(List<Student> listFoundByID) {
        displayListFoundByID(listFoundByID);
        int choice = GetInput.getInt("Which record you want to delete? : ", "Wrong", 1, listFoundByID.size());

        Student student = listFoundByID.get(choice - 1);
        manage.removeStudent(student);

    }
// display list after found by id

    private void displayListFoundByID(List<Student> listFoundByID) {
        System.out.printf("%-10s %-10s %-20s %-10s %-10s\n", "No", "ID", "Name", "Semester", "Course");
        for (int i = 1; i <= listFoundByID.size(); i++) {
            System.out.printf("%-10s%s\n", i, listFoundByID.get(i - 1));
        }
    }

    /**
     * check user want to update or not
     *
     * @param message
     * @return true or false
     */
    private boolean checkWantToUpdate(String message) {
        String result = GetInput.getString("Do you want to update " + message + " (y/n)? ",
                "ONLY y or n !!!", GetInput.REGEX_Y_N);
        //if result == y => true
        //else => false 
        if (result.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

}
