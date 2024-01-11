/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FruitShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author vinh2
 */
public class Validation {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static int getNonNagativeInt(String mess) throws IOException {
        System.out.print(mess);
        while (true) {
            try {
                int num = Integer.parseInt(in.readLine());
                if (num < 0) {
                    System.out.print("Pls, enter a non-nagative number: ");
                    continue;
                }
                return num;
            } catch (Exception e) {
                System.out.print("Invalid value, re-enter: ");
            }
        }
    }

    public static double getPositiveDouble(String mess) throws IOException {
        System.out.print(mess);
        while (true) {
            try {
                double num = Double.parseDouble(in.readLine());
                if (num <= 0) {
                    System.out.print("Pls, enter a positive number: ");
                    continue;
                } else {
                    return num;
                }
            } catch (Exception e) {
                System.out.print("Invalid value, re-enter: ");
            }
        }
    }

    //Enter a non-empty string
    public static String getNonEmptyString(String mess) throws IOException {
        System.out.print(mess);
        while (true) {
            String str = in.readLine().trim();
            if (str.equals("")) {
                System.out.print("Pls, enter a string not empty: ");
            } else {
                return str;
            }
        }
    }

    public static int getIntInRange(int min, int max, String mess) throws IOException {
        System.out.print(mess);
        while (true) {
            try {
                int num = Integer.parseInt(in.readLine());
                if (num < min || num > max) {
                    System.out.print("Pls, enter number in range " + "(" + min + "-" + max + "): ");
                    continue;
                } else {
                    return num;
                }
            } catch (Exception e) {
                System.out.print("Invalid value, re-enter: ");
            }
        }
    }

    public static String stopOrContinue(String mess) throws IOException {
        System.out.print(mess);
        String strOption = in.readLine();
        while (strOption.equalsIgnoreCase("y") == false && strOption.equalsIgnoreCase("n") == false) {
            System.out.print("Just y or n, re-enter: ");
            strOption = in.readLine();
        }
        return strOption;
    }
}
