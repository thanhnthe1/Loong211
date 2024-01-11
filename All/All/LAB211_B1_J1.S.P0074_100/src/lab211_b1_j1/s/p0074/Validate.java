/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0074;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nam
 */
public class Validate {
    public Scanner sc = new Scanner(System.in);
    
    public int option(String message, int first, int last) {
        int input = 0;
        //Run again until number is integer number
        //and integer number is in range between 1 and 6 so stop
        do {
            try {
                System.out.println(message);
                input = Integer.parseInt(sc.nextLine());
                if (input >= first && input <= last) {
                    break;
                }
                if (input < first || input > last) {
                    System.out.println("Must from " + first + " to "
                            + last + ". Pls, enter again!");
                }
            } catch (Exception e) {
                System.out.println("Must integer number. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    public int integerNumber(String message) {
        int input = 0;
        //Run again until number is integer so break loop
        do {
            try {
                System.out.print(message);
                String number = sc.nextLine();
                input = Integer.parseInt(number);
                if (input > 0) {
                    break;
                } else {
                    System.out.println("Must greater than 0. Pls, enter again!");
                }
            } catch (Exception e) {
                System.out.println("Must integer number. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    public int matrixValue(String message) {
        int input = 0;
        //Run again until number is integer so break loop
        do {
            try {
                System.out.print(message);
                String number = sc.nextLine();
                input = Integer.parseInt(number);
                break;
            } catch (Exception e) {
                System.out.println("Value of matrix is digit");
            }
        } while (true);
        return input;
    }
    boolean isNumber(String money) {
        //Create pattern with regex is float number
        String regex = "[0-9\\.]+";
        Pattern pattern = Pattern.compile(regex);
        //Create matcher which matches string name with pattern
        Matcher matcher = pattern.matcher(money);
        //If name and pattern matches and name isn't empty so return true (if no return false)
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
