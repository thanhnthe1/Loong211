/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author doson
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public String Input_Course() {
        String Input;
        while (true) {
            Input = sc.nextLine();
            if (Input.equalsIgnoreCase(".net")
                    || Input.equalsIgnoreCase("c/c++")
                    || Input.equalsIgnoreCase("java")) {
                // chỉ được nhập 3 khóa học
                break;
            } else {
                System.err.print("Incorrect format(Java, .Net , C/C++) Re-Enter:");
            }
        }
        return Input.toUpperCase();
    }

    public String Input_String() {
        String Input;
        while (true) {
            Input = sc.nextLine();
            if (Input.matches("^[a-zA-Z0-9\\s]+$") && Input.equalsIgnoreCase("0") == false) {
                break;
            } else {
                System.err.println("In-valid(only letter ,digit and space)!!!");
                System.out.print("Re-enter:");
            }
        }
        return Input;
    }

    //Check số nguyên
    public int Check_int() {
        int result;
        while (true) {
            try {
                result = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
                System.err.print("In-valid(Integer),please Re-enter!!!: ");
                continue;
            }
            break;
        }
        return result;
    }

    //Check có muốn thêm sinh viên không   
    public String Ans_Add() {
        String a;
        while (true) {
            a = sc.nextLine();
            if (a.matches("^[yYnN]+$")) {
                break;
            } else {
                System.err.println("Only Enter(Yes(Y) or No(N)!!!");
                System.out.print("Re-Enter: ");
            }
        }
        return a;
    }

    //Check hỏi update hay delete 
    public String Ans_UpOrDe() {
        String a = "";
        while (true) {
            a = sc.nextLine();
            if (a.matches("^[uUdD]+$")) {
                break;
            } else {
                System.err.println("Only Enter(Update(U) or Delete(D)!!!");
                System.out.print("Re-Enter: ");
            }
        }
        return a;
    }
}
