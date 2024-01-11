/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author kidzd
 */
public class GetInput {

    static Scanner scanner = new Scanner(System.in);
    public static final String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public static final String REGEX_YN = "[yYnN]";
    public static final String REGEX_DATE = "\\d{1,2}[-]\\d{1,2}[-]\\d{4}";

    public static int getInt(String message, String error, int min, int max) {
        String REGEX_NUMBER = "[0-9]+";
        while (true) {
            System.out.print(message);
            String result = scanner.nextLine();
            if (result.isEmpty()) {
                System.out.println("Input cannot be empty");
            } else if (result.matches(REGEX_NUMBER) == false) {
                System.out.println(error);

            } else {

                try {
                    int number = Integer.parseInt(result);
                    if (number >= min && number <= max) {
                        return number;

                    } else {
                        System.out.println("Number must in range from " + min + " to " + max);
                    }

                } catch (NumberFormatException e) {
                    System.out.println(error);

                }
            }
        }
    }
   
    public static double getDouble(String message, String error, double min, double max) {
        String REGEX_NUMBER = "[0-9.]+";
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty");
            } else {
                try {
                    double number = Double.parseDouble(input);
                    if (number < min || number > max) {
                        System.out.println("Input must be in range from " + min + " to " + max);
                    } //: check regex 
                    else if (!input.matches(REGEX_NUMBER)) {
                        System.out.println(error);
                        //time must be divide to 0.5
                    } else if (!(number % 0.5 == 0)) {
                        System.out.println("Input must be divide to 0.5");
                    } else {
                        return number;
                    }
                   
                } catch (NumberFormatException e) {
                    System.out.println(error);
                }

            }
        }
    }

    public static String getString(String message, String error, String regex) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!!");
            } else {
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }
    }

    public static String getDate(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print(message);
            String input = scanner.nextLine(); 

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!!");
            } else {
                if (!input.matches(regex)) {
                    System.out.println(error);
                } else {

                    try {
                        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        //false if date isn't invalid
                        dateFormat.setLenient(false);

                        Date dateInput = new Date();
                        dateInput = dateFormat.parse(input);

                        Date currentDate = new Date();
                        String currentDatString = dateFormat.format(currentDate);
                        boolean lessThanDate = checkLessThanDate(input, currentDatString);
                        if (lessThanDate == true) {
                            System.out.println("Date must be before or equals " + currentDatString);
                        } else {
                            return input;
                        }

                    } catch (ParseException ex) {
                        System.out.println("Date does not exist !");
                    }

                }
            }
        }
    }
// check date must before current date
    private static boolean checkLessThanDate(String input, String currentDatString) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date firstDate = dateFormat.parse(input);
            Date secondDate = dateFormat.parse(currentDatString);

            if (firstDate.before(secondDate)) {
                return true;
            } else {
                return false;
            }

        } catch (ParseException ex) {
            return false;
        }

    }

}
