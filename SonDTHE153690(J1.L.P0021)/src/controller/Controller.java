/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Report;
import model.Student;

/**
 *
 * @author doson
 */
public class Controller {
    private ArrayList<Student> list = new ArrayList<>();
    
    public Controller(ArrayList<Student> list){
        this.list = list;
    }
    /* Check id */
    public int checkID(String id){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getId().equalsIgnoreCase(id)){
                return i; // Nếu id được tìm thấy thì trả về vị trí của nó trong list;
            }
        }
        return -1;
    }
    
    /* Trả về 1 student có id = id */
    public Student obj(String id){
        Student st = list.get(checkID(id));
        return st;
    }
    
    /* Trả về 1 danh sách student có id = id */
    public ArrayList<Student> listByID(String id){
        ArrayList<Student> l = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getId().equalsIgnoreCase(id)){
                l.add(list.get(i));
            }
        }
        return l;
    }
    
    /* Trả về vị trí thứ i của 1 student có thỏa mãn cả 3 điều kiện là id,semester và course*/
    public int obj(int select, String id){
        Student s = listByID(id).get(select);
        int index = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getId().equalsIgnoreCase(s.getId()) 
                    && list.get(i).getSemester().equalsIgnoreCase(s.getSemester()) 
                    && list.get(i).getNameCourse().equalsIgnoreCase(s.getNameCourse()) ){
                index = i;
            }
        }
        return index;
    }
    
    /* Nếu sinh viên đó trong kì học đó mà học 2 môn giống nhau trả về true ngược lại là false */
    public boolean checkSemester(String id, String semester, String course){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id) && list.get(i).getSemester().equalsIgnoreCase(semester)
                    && list.get(i).getNameCourse().equalsIgnoreCase(course)) { // check xem cùng 1 sinh viên, trong 1 kì có 2 môn giống nhau
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Student> listStudent(){
        return list;
    }
    public void AddStudent(Student s){
        list.add(s);
    }
    public void delete(Student s){
        list.remove(checkID(s.getId()));
    }
    
    /* Trả về 1 list sinh viên có một phần của name và sắp xếp chúng theo tên */
    public ArrayList<Student> findSort(String name){
        ArrayList<Student> listNew = new ArrayList<>();
        if(name.isEmpty()){ // nếu name là rỗng thì trả về toàn bộ sinh viên có trong danh sách
            return list;
        }
        for(int i=0; i<list.size();i++){
            if(list.get(i).getNameStudent().toLowerCase().contains(name.toLowerCase())){ // add thêm sinh viên có tên giống với name
                listNew.add(list.get(i));
            }
        }
        Collections.sort(listNew, new Comparator<Student>(){ // sắp xếp các sinh viên vừa được add vào theo tên
            @Override
            public int compare(Student o1, Student o2) {
                if (!o1.getNameStudent().equalsIgnoreCase(o2.getNameStudent())) {
                    return o1.getNameStudent().compareToIgnoreCase(o2.getNameStudent());
                } else {
                    return 0;
                }
            }   
        });
        return listNew;
    }
    // báo cáo
    public ArrayList<Report> Report(){
        ArrayList<Report> lr = new ArrayList<>();
        ArrayList<Student> ls = new ArrayList<>(); // tạo 1 list student tạm
        for(int i=0; i<list.size(); i++){
            ls.add(list.get(i)); // add tất cả các list chính vào list student vừa tạo
        }
        for(int i=0; i<ls.size(); i++){
            int total = 1;
            for(int j=i+1; j<ls.size(); j++){
                if(ls.get(i).getId().equalsIgnoreCase(ls.get(j).getId()) 
                        && ls.get(i).getNameCourse().equalsIgnoreCase(ls.get(j).getNameCourse())
                        ){
                    // nếu cùng là 1 sinh viên và có khóa học giống nhau thì total++
                    total ++;
                    ls.remove(ls.get(j)); //xóa luôn thông tin bị trùng đó ra khỏi danh sách tạm
                    j--;
                }
            }
            lr.add(new Report(ls.get(i).getId(), ls.get(i).getNameStudent(), ls.get(i).getNameCourse(), total)); // add list tạm thời đó vào trong list Report
        }
        return lr;
    }
}
