/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Report;
import model.Student;

/***
 * @author kidzd
 */
public class Manage {

    List<Student> listStudent = new ArrayList<>();
    List<Report> listReport = new ArrayList<>();

    public List<Student> getListStudent() {
        return listStudent;
    }
   //use to get student by id
    public Student getStudentByID(String id) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }
   // add student
    public void addStudent(Student student) {
        listStudent.add(student);
    }
  
    //check duplicate student
    public boolean checkDuplicate(String id, String name, int semester, int course) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id)
                    && student.getName().equalsIgnoreCase(name)
                    && student.getSemester() == (semester)
                    && student.getCourse() == (course)) {
                return true;
            }
        }
        return false;
    }
 // sort by Name
    public void sort(List<Student> listSearch) {
        /*Loop from the first to last person , 
        after each loop, one person is sorted*/
        for (int i = 0; i < listSearch.size(); i++) {
            //Loop from first to last person through unsorted person
            for (int j = 0; j < listSearch.size() - 1 - i; j++) {
                //swap two person if not in ascending order
                if (listSearch.get(j).getName().compareToIgnoreCase(listSearch.get(j + 1).getName()) > 0) {
                    Collections.swap(listSearch, j, j + 1);
                }
            }
        }
    }
  
    //use to get list student by name (search)
    public List<Student> getListStudentByName(String name) {
        List<Student> listSearch = new ArrayList<Student>();
        name = name.toUpperCase();
        for (Student student : listStudent) {
            if (student.getName().toUpperCase().contains(name)) {
                listSearch.add(student);
            }
        }
        return listSearch;
    }

     //use to add report
    public void addReport(Report report) {
        listReport.add(report);
    }
   //get list Report
    public List<Report> getListReport() {
        return listReport;
    }

    //check duplicate report
    public boolean checkExistReport(Student firstStudent, List<Report> listReport) {
        for (Report report : listReport) {
            if (report.getId().equalsIgnoreCase(firstStudent.getId())
                    && report.getCourse() == firstStudent.getCourse()) {
                return true;
            }
        }
        return false;
    }

    //use to get student by id
    public List<Student> getListStudentByID(String id) {
        List<Student> listSearch = new ArrayList<Student>();
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id)) {
                listSearch.add(student);
            }
        }
        return listSearch;
    }
    
    //use to remove student
    public void removeStudent(Student student) {
        listStudent.remove(student);
    }
    //check updated or not
    public boolean checkNotUpdate(String idUpdate, String name, int semester, int courseName, Student student) {
        if (student.getId().equalsIgnoreCase(idUpdate)
                && student.getName().equalsIgnoreCase(idUpdate)
                && student.getSemester() == (semester)
                && student.getCourse() == (courseName)) {
                return true;
        }
        return false;
    }
   //update all name have same id
    public void updateAllName(String idUpdate, String name) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(idUpdate) && !student.getName().equalsIgnoreCase(name)) {
                student.setName(name);
            }
        }
    }

}
