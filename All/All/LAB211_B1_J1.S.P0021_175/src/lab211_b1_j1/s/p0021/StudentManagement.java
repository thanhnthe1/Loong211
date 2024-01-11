/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0021;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Nam
 */
public class StudentManagement{

    public void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
    }

    public int choiceOption() {
        Validate input = new Validate();
        return input.option("Enter your option: ", 1, 5);
    }

    public void createStudent(ArrayList<Student> listStudents) {
        //Input student
        Student student = inputInfoStudent(listStudents);
        //Add student
        listStudents.add(student);
        System.out.println("Add succesfully");
        //Check list student at least 10 student
        if (listStudents.size() < 10) {
            createStudent(listStudents);
        } else {
            //Ask user wanna add student
            wannaAddMoreStudent(listStudents);
        }
    }

    private Student inputInfoStudent(ArrayList<Student> listStudents) {
        Validate input = new Validate();
        Validate check = new Validate();
        String id, name, courseName;
        int semester;
        //Run until check id have existed and must same name
        //and check info Student haven't existed
        do {
            id = input.stringCode("Enter student code: ");
            System.out.println("Enter student name: ");
            name = input.stringWords();
            //Check code is same but name is diffirent
            if (check.isSameIdAndDifName(listStudents, id, name)) {
                System.out.println("There is ID student in list, name"
                        + "must equals with this student.");
            } else {
                semester = input.integerNumber("Enter student semester: ");
                courseName = input.inputCourse();
                Student student = new Student(id, name, semester, courseName);
                //Check information has existed in list
                if (check.isDuplicate(listStudents, student)) {
                    System.out.println("Data is duplicate!!!!!!!!!!!!!");
                } else {
                    return student;
                }
            }
        } while (true);
    }

    private void wannaAddMoreStudent(ArrayList<Student> listStudents) {
        Validate input = new Validate();
        String wannaAdd = input.yesOrNo("Do you want to continue (Y/N):");
        //Check user want to add
        if (wannaAdd.compareToIgnoreCase("Y") == 0) {
            createStudent(listStudents);
        }
    }

    public void findAndSortStudent(ArrayList<Student> listStudents) {
        //Check list is empty
        if (listStudents.isEmpty()) {
            System.out.println("List students is empty.");
            return;
        }
        Validate input = new Validate();
        System.out.println("Enter name student need to find: ");
        //Enter name student
        String name = input.stringWords();
        //Find students
        ArrayList<Student> listStudentsFind = findStudentByName(listStudents, name);
        //Check list student find by name is empty
        if (listStudentsFind.isEmpty()) {
            System.out.println("Can't find student name is " + name + "!!!!!!!!!!");
        } else {
            Collections.sort(listStudentsFind, (o1, o2) -> {
                String preName = o1.getName();
                String posName = o2.getName();
                return preName.compareTo(posName);
            });
            displayStudents(listStudentsFind);
        }
    }

    private ArrayList<Student> findStudentByName(ArrayList<Student> listStudents,
            String name) {
        ArrayList<Student> listStudentsByName = new ArrayList<>();
        name = name.toLowerCase();
        //Run from first student to last student
        for (Student student : listStudents) {
            String nameInList = student.getName().toLowerCase();
            //Check students name contains inputed name
            if (nameInList.contains(name)) {
                listStudentsByName.add(student);
            }
        }
        return listStudentsByName;
    }

    private void displayStudents(ArrayList<Student> liststudents) {
        //Run from first student to last student
        for (Student student : liststudents) {
            System.out.println(student.toString());
        }
    }

    public void updateOrDeleteStudent(ArrayList<Student> listStudents) {
        //Check list is empty
        if (listStudents.isEmpty()) {
            System.out.println("List students is empty.");
            return;
        }
        Validate input = new Validate();
        //Enter id student
        String idToFind = input.stringCode("Enter id student to update or delete: ");
        //Find students by id
        ArrayList<Student> listStudentsFind;
        listStudentsFind = findStudentByID(listStudents, idToFind);
        //Check list student by id is empty
        if (listStudentsFind.isEmpty()) {
            System.out.println("Can't find student id is " + idToFind);
        } else {
            int i = 0;
            //Run from first student to last student
            for (Student student : listStudentsFind) {
                System.out.println((i++) + " | " + student.toString());
            }
            int index = input.option("Enter index: ",
                    0, listStudentsFind.size() - 1);
            String choice = input.updateOrDelete("Do you want to update (U)"
                    + "or delete (D): ");
            //Check user want to update
            if (choice.compareToIgnoreCase("U") == 0) {
                updateStudent(listStudents, listStudentsFind, index);
                System.out.println("Update succesfully!");
                //Check user want to delete
            } else if (choice.compareToIgnoreCase("D") == 0) {
                deleteStudentByID(listStudents, listStudentsFind, index);
                System.out.println("Delete succesfully!");
            }
        }
    }

    private ArrayList<Student> findStudentByID(ArrayList<Student> listStudents,
            String id) {
        ArrayList<Student> listStudentsByID = new ArrayList<>();
        //Run from first student to last student
        for (Student student : listStudents) {
            String idInList = student.getId();
            //Check entered id equals with id in list
            if (id.compareToIgnoreCase(idInList) == 0) {
                listStudentsByID.add(student);
            }
        }
        return listStudentsByID;
    }

    private void updateStudent(ArrayList<Student> listStudents,
            ArrayList<Student> listStudentsFind, int index) {
        Validate check = new Validate();
        Student studentToUpdate = listStudentsFind.get(index);
        //Input information of student
        Student newStudent = inputInfoStudentToUpdate(listStudents, studentToUpdate);
        String IDUpdate = newStudent.getId();
        String nameUpdate = newStudent.getName();
        int semesterUpdate = newStudent.getSemester();
        String courseUpdate = newStudent.getCourseName();
        //Update student
        studentToUpdate.setId(IDUpdate);
        //run from first student to last student
        for (Student student : listStudents) {
            if (student.getId().equals(IDUpdate)) {
                studentToUpdate.setName(nameUpdate);
            }
        }
        studentToUpdate.setSemester(semesterUpdate);
        studentToUpdate.setCourseName(courseUpdate);
        //Check id to update has existed in list
        if (check.isSameIDWithList(listStudents, IDUpdate)) {
            //Run from first student to last student
            for (Student student : listStudents) {
                String id = student.getId();
                //Check id is same with each student in list
                if (check.isSameID(id, IDUpdate)) {
                    student.setName(nameUpdate);
                }
            }
        }
    }

    private Student inputInfoStudentToUpdate(ArrayList<Student> listStudents,
            Student studentByIndex) {
        Validate input = new Validate();
        //Run until check information hasn't existed
        do {
            String id = input.stringCode("Enter student code: ");
            System.out.println("Enter student name: ");
            String name = input.stringWords();
            int semester = input.integerNumber("Enter student semester: ");
            String courseName = input.inputCourse();
            Student student = new Student(id, name, semester, courseName);
            //Check information has existed in list
            if (input.isDuplicateAll(listStudents, student, studentByIndex)) {
                System.out.println("Data is duplicate!!!!!!!!!!!");
            } else {
                return student;
            }
        } while (true);
    }

    private void deleteStudentByID(ArrayList<Student> listStudents,
            ArrayList<Student> listStudentsFind, int index) {
        Student studentDel = listStudentsFind.get(index);
        listStudents.remove(studentDel);
    }

    public void reportStudent(ArrayList<Student> listStudents) {
        //Check list is empty
        if (listStudents.isEmpty()) {
            System.out.println("List students is empty.");
            return;
        }
        Validate check = new Validate();
        ArrayList<Student> studentsTotalCourse = new ArrayList<>();
        ArrayList<Integer> totalCourse = new ArrayList<>();
        studentsTotalCourse.addAll(listStudents);
        //Run each diffirent student
        for (int i = 0; i < studentsTotalCourse.size(); i++) {
            int count = 1;
            //Run from first student to last student
            for (int j = 0; j < studentsTotalCourse.size(); j++) {
                //Check two student is diffirent and same id, course
                if (check.sameStudentWithCourse(studentsTotalCourse.get(i),
                        studentsTotalCourse.get(j))) {
                    studentsTotalCourse.remove(j);
                    j--;
                    count++;
                }
            }
            totalCourse.add(count);
        }
        //Display students with total courses
        displayStudentsTotalCourses(studentsTotalCourse, totalCourse);
    }

    private void displayStudentsTotalCourses(ArrayList<Student> studentsTotalCourse,
            ArrayList<Integer> totalCourse) {
        System.out.println("The report as below: ");
        //Run from first student to last student
        for (int i = 0; i < studentsTotalCourse.size(); i++) {
            System.out.printf("%15s | %5s | %-5s", studentsTotalCourse.get(i).getName(),
                     studentsTotalCourse.get(i).getCourseName(), totalCourse.get(i));
            System.out.println("");
        }
    }

    public void exit() {
        System.out.println("Thanks");
    }
}
