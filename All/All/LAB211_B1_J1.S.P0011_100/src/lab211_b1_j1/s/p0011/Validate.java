/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0011;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nam
 */
public class Validate {
    public Scanner sc = new Scanner(System.in);

    public int baseNumber(String message) {
        int input = 0;
        //Run again until number is integer so break loop
        do {
            try {
                System.out.print(message);
                String number = sc.nextLine();
                input = Integer.parseInt(number);
                if (input == 1 || input == 2 || input == 3) {
                    break;
                } else {
                System.out.println("Must number 1, 2 or 3. Pls, enter again!");
                }
            } catch (Exception e) {
                System.out.println("Must integer number. Pls, enter again!");
            }
            
        } while (true);
        return input;
    }

    String binaryNumber(String message) {
        String input = "";
        //Run again until number is integer so break loop
        do {
            try {
                System.out.print(message);
                input = sc.nextLine();
                if (isBinary(input)) {
                    break;
                } else {
                    System.out.println("Must binary number. Pls, enter again!");
                }
            } catch (Exception e) {
                System.out.println("Must integer number. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    String decimalNumber(String message) {
        String input = "";
        //Run again until number is integer so break loop
        do {
            try {
                System.out.print(message);
                input = sc.nextLine();
                if (isDecimal(input)) {
                    break;
                } else {
                    System.out.println("Must decimal number. Pls, enter again!");
                }
            } catch (Exception e) {
                System.out.println("Must integer number. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    String hexadecimalNumber(String message) {
        String input = "";
        //Run again until number is integer so break loop
        do {
            try {
                System.out.print(message);
                input = sc.nextLine();
                if (isHexadecimal(input)) {
                    break;
                } else {
                    System.out.println("Must hexadecimal number. Pls, enter again!");
                }
            } catch (Exception e) {
                System.out.println("Must integer number. Pls, enter again!");
            }
        } while (true);
        return input;
    }
    
    public String yesOrNo(String message) {
        Validate check = new Validate();
        String input = "";
        //Run again until check  is y or n so break loop
        do {
            System.out.println(message);
            input = sc.nextLine();
            if (check.isYesOrNo(input)) {
                return input;
            } else {
                System.out.println("Must Y or N. Pls, enter again!");
            }
        } while (true);
    }
    boolean isBinary(String valueIn) {
        String regex = "[0-1]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(valueIn);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    boolean isDecimal(String valueIn) {
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(valueIn);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    boolean isHexadecimal(String valueIn) {
        String regex = "[0-9A-F]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(valueIn);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    boolean isYesOrNo(String input) {
        //Regex mean: input include y or n
        String regex = "[y|n]";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
