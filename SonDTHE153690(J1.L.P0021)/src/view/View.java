/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.util.ArrayList;
import java.util.Scanner;
import model.Report;
import model.Student;

/**
 *
 * @author doson
 */
public class View {

    Validation val = new Validation();
    Controller c;

    public View(Controller c) {
        this.c = c;
    }

    Scanner sc = new Scanner(System.in);

    public void Add() {
        String ans = "";
        while (!ans.equalsIgnoreCase("N")) {
            Student s = new Student();
            System.out.print("Enter ID: ");
            String id = val.Input_String();
            s.setId(id);
            if (c.checkID(id) != -1) {// nếu đã có sinh viên trong list
                Student sh = c.obj(id);
                System.out.println("Name: " + sh.getNameStudent());// hiển thị luôn tên sinh viên có trong list
                s.setNameStudent(sh.getNameStudent());
                System.out.print("Enter Semester: ");
                String newsmt = val.Input_String();// Nhập kì học 
                s.setSemester(newsmt);
                System.out.print("Enter Course: ");
                while (true) { // check xem trong kì học đó, sinh viên đó có môn đó chưa?
                    String newCourse = val.Input_Course();// nhập tên môn học
                    if (!c.checkSemester(id, newsmt, newCourse)) {// tên môn học trong 1 kì phải khác nhau
                        s.setNameCourse(newCourse);
                        break;
                    } else { // nếu bị trùng
                        System.out.println("A student cannot take two of the same subjects in one semester!!!");
                        System.out.print("Enter again course: ");
                    }
                }
            } else { // nếu không có sinh viên trong list thì nhập vào bình thường
                System.out.print("Enter Name: ");
                String name = val.Input_String(); 
                s.setNameStudent(name);
                System.out.print("Enter Semester: ");
                String newsmt = val.Input_String();
                s.setSemester(newsmt);
                System.out.print("Enter Course: ");
                String newCourse = val.Input_Course();
                s.setNameCourse(newCourse);
            }
            c.AddStudent(s); // add vào list.
            System.out.print("Do you want add continue( Y_Yes or N_No): ");
            ans = val.Ans_Add();
            System.out.println("");
        }
    }

    public void findByName() {
        if (c.listStudent().isEmpty()) { // nếu không có sinh viên nào
            System.out.println("Don't have student");
        } else {
            String name;
            System.out.print("Enter name want find: ");
            name = val.Input_String();
            System.out.println("-------------Search Result-------------");
            System.out.printf("%-8s  %-20s  %-10s  %-10s\n",
                    "ID", "Name", "Semester", "Course");
            for (Student List1 : c.findSort(name)) { // in ra sinh viên có tên là một phần của name
                System.out.printf("%-8s  %-20s  %-10s  %-10s\n",
                         List1.getId(), List1.getNameStudent(), List1.getSemester(), List1.getNameCourse());
            }
        }
    }

    public void updateOrDelete() {
        if (c.listStudent().isEmpty()) {
            System.out.println("Don't have student");
        } else {
            String Id = "";
            System.out.print("Enter ID you want find: ");
            while (c.checkID(Id) == -1) {
                Id = val.Input_String();
                if (c.checkID(Id) == -1) {
                    System.out.print("No student have id = " + Id + ". Enter again: ");// ko có id sinh viên trong danh sách, nhập lại
                }
            }
            ArrayList<Student> listU = c.listByID(Id);// danh sách môn học và học kì của sinh viên đó
            System.out.printf("%-3s  %-8s  %-20s  %-10s  %-10s\n", "STT",
                    "ID", "Name", "Semester", "Course");
            for (int i = 0; i < listU.size(); i++) { // in ra danh sách đó
                System.out.printf("%-3s  %-8s  %-20s  %-10s  %-10s\n", i + 1,
                        listU.get(i).getId(), listU.get(i).getNameStudent(),
                        listU.get(i).getSemester(), listU.get(i).getNameCourse());
            }
            int stt;
            System.out.print("Select an STT you want edit: (1 -> )" + listU.size() + "): ");// nhập stt muốn edit
            while (true) {
                stt = val.Check_int();
                if (stt >= 1 && stt <= listU.size()) {
                    break;
                } else {
                    System.out.print("Enter again: (1 -> )" + listU.size() + "):"); // stt ngoài khoảng sẽ phải nhập lại
                }
            }
            int index = c.obj(stt-1, Id);// lấy đúng vị trí của sinh viên cần edit trong list chính
            Student su = c.listStudent().get(index); // lấy sinh viên đó ra
            String ans;
            System.out.print("You choose Update(U) or Delete(D): ");// chọn xóa hoặc sửa
            ans = val.Ans_UpOrDe();
            if (ans.equalsIgnoreCase("D")) {// Xóa stt đi
                c.delete(su);
                System.out.println("Delete Successfull...");
            } else {// Cập nhật
                System.out.print("Enter new Semester:");
                String newSemester = val.Input_String(); // sửa học kì của sinh viên cần sửa
                su.setSemester(newSemester);
                System.out.println("Enter new Course: ");
                while (true) {
                    String newCourse = val.Input_Course();
                    if (!c.checkSemester(su.getId(), su.getSemester(), newCourse)) { // check xem sinh viên đó 1 học kì có 2 môn giống nhau hay không
                        su.setNameCourse(newCourse);
                        break;
                    } else {
                        System.out.println("A student cannot take two of the same subjects in one semester!!!");
                    }
                }
            }
        }
    }

    public void Report() {
        if(c.listStudent().isEmpty()){
            System.out.println("Don't have student");
        }
        else{
            ArrayList<Report> ar = c.Report();
            System.out.printf("%-8s  %-20s  %-10s  %-5s\n",
                "ID", "Name", "Course", "Total");
            for (int i = 0; i < ar.size(); i++) { // in ra danh sách report
                System.out.printf("%-8s  %-20s  %-10s  %-5s\n",ar.get(i).getId()
                ,ar.get(i).getStudentName(),ar.get(i).getCourseName(),ar.get(i).getTotalCourse()); 
            }
        }
    }
}
