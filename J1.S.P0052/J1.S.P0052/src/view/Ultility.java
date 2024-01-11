package view;



import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Ultility {
    public static Scanner scanner = new Scanner(System.in);
    static final String REGEX_STRING = "[A-Za-z0-9 ]+";
    
    public static int getInt(String message, String error, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                //if input is empty then tell user
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!!");
                } //kiem tra dau vao co dung dinh dang khong
                else {
                    int number = Integer.parseInt(input);
                    //if number in range then return number
                    //else tell user number must in range
                    if (min <= number && number <= max) {
                        return number;
                    } else {
                        System.out.println("Input must in range from "
                                + min + " to " + max);
                    }

                }
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }

    }

    public static double getDouble(String message, String error, double min, double max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                //if input is empty then tell user
                //else parse input to double type
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!!");
                } 
                else {
                    double number = Double.parseDouble(input);
                    //if number in range then return number
                    //else tell user number must in range
                    if (min <= number && number <= max) {
                        return number;
                    } else {
                        System.out.println("Input must be in range from " + min + " to " + max);
                    }

                }
                
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }

    }

    public static String getString(String message, String error, String regex) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            //if input empty then tell user 
            //else is input matches with regex ?
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!!");
            } else {
                //if input matches with regex then return input
                //else announce error
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }
    }

}
