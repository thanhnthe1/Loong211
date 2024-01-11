
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author doson
 */
public class Method {

    private ArrayList<Employee> listEmployee = new ArrayList<>();

    //check ID
    public int checkID(String id) {
        for (int i = 0; i < listEmployee.size(); i++) {
            if (listEmployee.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Employee> getEmployee() {
        return listEmployee;
    }

    // Find Employee by ID
    public Employee obj(String id) {
        Employee e = null;
        for (int i = 0; i < listEmployee.size(); i++) {
            if (listEmployee.get(i).getId().equalsIgnoreCase(id)) {
                e = listEmployee.get(i);
            }
        }
        return e;
    }

    // Add Employee
    public void addEmployee(Employee e) {
        listEmployee.add(e);
    }

    //Search Employee by name
    public ArrayList<Employee> Search_Employees(String name) {
        ArrayList<Employee> eNew = new ArrayList<>();
        name = name.toLowerCase().trim();
        if (name.isEmpty()) {
            return eNew;
        }
        for (int i = 0; i < listEmployee.size(); i++) {
            String fullName = (listEmployee.get(i).getFirstName() + " " + listEmployee.get(i).getLastName()).toLowerCase();
            if (name.equalsIgnoreCase(listEmployee.get(i).getFirstName())
                    || name.equalsIgnoreCase(listEmployee.get(i).getLastName())
                    || fullName.contains(name)==true) {
                eNew.add(listEmployee.get(i));
            }
        }
        return eNew;
    }

    // Sort by Salary
    public ArrayList<Employee> sortBySalary() {
        Collections.sort(listEmployee, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getSalary() > o2.getSalary()) {
                    return 1;
                } else if (o1.getSalary() < o2.getSalary()) {
                    return -1;
                } else {
                    if (o1.getId().compareTo(o2.getId()) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        return listEmployee;
    }
}
