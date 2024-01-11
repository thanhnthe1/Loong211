
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author doson
 */
class View_User {

    Check_Input check = new Check_Input();
    Method method = new Method();

    void Add() throws ParseException {
        String ans = "";
        while (!ans.equalsIgnoreCase("N")) {
            Employee employeeNew = new Employee();
            System.out.print("Enter ID: ");
            String id;
            while (true) {
                id = check.Input_ID();
                if (method.checkID(id) != -1) {
                    System.out.println("Sorry. Already have id in the list. Enter again.");
                } else {
                    employeeNew.setId(id);
                    break;
                }
            }
            System.out.print("Enter first name: ");
            employeeNew.setFirstName(check.Input_String());
            System.out.print("Enter last name: ");
            employeeNew.setLastName(check.Input_String());
            System.out.print("Enter phone: ");
            employeeNew.setPhone(check.Input_Phone());
            System.out.print("Enter email: ");
            employeeNew.setEmail(check.Input_Email());
            System.out.print("Enter address: ");
            employeeNew.setAddress(check.Input_Address());
            System.out.print("Enter DOB (dd-mm-yyyy): ");
            employeeNew.setDOB(check.Input_Date());
            System.out.print("Enter sex (Male or FeMale): ");
            employeeNew.setSex(check.Input_Sex());
            System.out.print("Enter salary: ");
            employeeNew.setSalary(check.Input_double());
            System.out.print("Enter egency: ");
            employeeNew.setEgency(check.Input_String());
            method.addEmployee(employeeNew);
            System.out.println("Do you want countinue add employee: Y-Yes or N-No");
            ans = check.Ans_Add();
        }
    }

    void Update() throws ParseException {
        String id = "";
        String ans = "";
        while (!ans.equalsIgnoreCase("N")) {
            System.out.print("Enter ID you want update: ");
            id = check.Input_ID();
            int checkID = method.checkID(id);
            while (true) {
                if (checkID != -1) {
                    Employee e = method.obj(id);
                    int options = 0;
                    do {
                        System.out.println("what are you want update?");
                        System.out.println("1.  First Name");
                        System.out.println("2.  Last Name");
                        System.out.println("3.  Phone");
                        System.out.println("4.  Email");
                        System.out.println("5.  Address");
                        System.out.println("6.  DOB");
                        System.out.println("7.  Sex");
                        System.out.println("8.  Salary");
                        System.out.println("9.  Agency");
                        System.out.println("10. Exit");
                        System.out.println("");
                        System.out.print("Select a option:");
                        options = check.Input_Int();
                        switch (options) {
                            case 1:
                                System.out.print("Enter New First Name: ");
                                e.setFirstName(check.Input_String());
                                break;
                            case 2:
                                System.out.print("Enter New Last Name: ");
                                e.setLastName(check.Input_String());
                                break;
                            case 3:
                                System.out.print("Enter New Phone: ");
                                e.setPhone(check.Input_Phone());
                                break;
                            case 4:
                                System.out.print("Enter New Email: ");
                                e.setEmail(check.Input_Email());
                                break;
                            case 5:
                                System.out.print("Enter New Address: ");
                                e.setAddress(check.Input_Address());
                                break;
                            case 6:
                                System.out.print("Enter New DOB: ");
                                e.setDOB(check.Input_Date());
                                break;
                            case 7:
                                System.out.print("Enter New Sex: ");
                                e.setSex(check.Input_String());
                                break;
                            case 8:
                                System.out.print("Enter New Salary: ");
                                e.setSalary(check.Input_double());
                                break;
                            case 9:
                                System.out.print("Enter New Agency: ");
                                e.setEgency(check.Input_String());
                                break;
                        }
                    } while (options < 10);
                    break;
                } else {
                    System.out.println("ID not found in the list");
                    break;
                }
            }
            System.out.println("Do you want continue update employee: Y-Yes or N-No");
            ans = check.Ans_Add();
        }
    }

    void Remove() {
        String id = "";
        String ans = "";
        while (!ans.equalsIgnoreCase("N")) {
            System.out.print("Enter ID you want remove: ");
            id = check.Input_ID();
            int checkID = method.checkID(id);
            if (checkID != -1) {
                method.getEmployee().remove(checkID);
                System.out.println("Delete Successful....");
            } else {
                System.out.println("ID not found in the list");
            }
            System.out.println("Do you want continue remove employee: Y-Yes or N-No");
            ans = check.Ans_Add();
        }
    }

    void Search() {
        Scanner sc = new Scanner(System.in);
        String name = "";
        String ans = "";
        while (!ans.equalsIgnoreCase("N")) {
            System.out.print("Enter name you want search: ");
            name = sc.nextLine();
            ArrayList<Employee> listSearch = method.Search_Employees(name);
            System.out.println("Result seaching:");
            System.out.printf("%-5s  %-10s  %-10s  %-10s  %-25s  %-20s  %-10s  %-5s  %-10s  %-10s\n",
                    "Id", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Egency");
            for (int i = 0; i < listSearch.size(); i++) {
                System.out.printf("%-5s  %-10s  %-10s  %-10s  %-25s  %-20s  %-10s  %-5s  %-10s  %-10s\n",
                        listSearch.get(i).getId(), listSearch.get(i).getFirstName(),
                        listSearch.get(i).getLastName(), listSearch.get(i).getPhone(),
                        listSearch.get(i).getEmail(), listSearch.get(i).getAddress(),
                        listSearch.get(i).getDOB(), listSearch.get(i).getSex(),
                        listSearch.get(i).getSalary(), listSearch.get(i).getEgency());
            }
            System.out.println("Do you want continue search employee: Y-Yes or N-No");
            ans = check.Ans_Add();
        }
    }

    void Sort() {
        ArrayList<Employee> sort = method.sortBySalary();
        System.out.printf("%-5s  %-10s  %-10s  %-10s  %-25s  %-20s  %-10s  %-5s  %-10s  %-10s\n",
                "Id", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Egency");
        for (int i = 0; i < sort.size(); i++) {
            System.out.printf("%-5s  %-10s  %-10s  %-10s  %-25s  %-20s  %-10s  %-5s  %-10s  %-10s\n",
                    sort.get(i).getId(), sort.get(i).getFirstName(),
                    sort.get(i).getLastName(), sort.get(i).getPhone(),
                    sort.get(i).getEmail(), sort.get(i).getAddress(),
                    sort.get(i).getDOB(), sort.get(i).getSex(),
                    sort.get(i).getSalary(), sort.get(i).getEgency());
        }
    }

}
