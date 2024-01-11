
import java.math.BigInteger;
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
public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static String[] Hex = {"0", "1", "2", "3", "4'", "5", "6", "7", "8",
        "9", "A", "B", "C", "D", "E", "F"};

    public static String input() {
        String input = sc.nextLine();
        return input.toUpperCase().trim();
    }

    public static String checkInputBinary() {
        while (true) {
            String binary = input();
            if (binary.matches("^[0-1]+$") && binary.length() > 0) {
                return binary;
            } else {
                System.out.print("Binary just 0 or 1. Enter again: ");
            }
        }
    }

    public static String checkInputDecimal() {
        while (true) {
            String decimal = input();
            if (decimal.matches("^[0-9]+$") && decimal.length() > 0) {
                return decimal;
            } else {
                System.out.print("Decimal just 0 -> 9. Enter again: ");
            }
        }
    }

    public static String checkInputHexadecimal() {
        while (true) {
            String hexadecimal = input();
            if (hexadecimal.matches("^[0-9A-F]+$") && hexadecimal.length() > 0) {
                return hexadecimal;
            } else {
                System.out.print("Hexadecimal just 0 -> 9 and A -> F. Enter again: ");
            }
        }
    }

    public static String checkAnswer() {
        while (true) {
            String ans = input();
            if (ans.matches("^[YN]+$") && ans.length() > 0) {
                return ans;
            } else {
                System.out.println("Y or N. Enter again:  ");
            }
        }
    }

    public static int display(String s) {
        int choose = 0;
        while (true) {
            try {
                System.out.println(s
                        + "\n1. is Binary"
                        + "\n2. is Decimal"
                        + "\n3. is Hexadecimal");
                System.out.print("Enter choose: ");
                choose = Integer.parseInt(sc.nextLine());
                if (choose < 1 || choose > 3) {
                    System.out.println("Choose just 1 -> 3.");
                } else {
                    return choose;
                }
            } catch (NumberFormatException e) {
                System.out.println("Choose just 1 -> 3.");
            }
        }
    }

    public static StringBuilder decimalTo(String input, String base) {
        StringBuilder result = new StringBuilder();
        BigInteger n1 = new BigInteger(input);
        if (input.equals("0")) {
            result.append("0");
        } else {
            while (n1.compareTo(new BigInteger("0")) != 0) {
                BigInteger n2 = n1;
                n1 = n1.divide(new BigInteger(base));// chia lấy phần nguyên
                BigInteger mol = n2.subtract(n1.multiply(new BigInteger(base)));// lấy số dư
                result.append(Hex[mol.intValue()]);// add phần dư vào result
            }
        }
        return result.reverse();// đảo ngược lại chuỗi
    }
    public static BigInteger toDecimal(String input, String base) {
        BigInteger result = new BigInteger("0");
        if (input.equals("0")) {
            return result;
        } else {
            String[] number = input.split("");
            BigInteger pow = new BigInteger("1");
            for (int i = number.length - 1; i >= 0; i--) {
                for (int j = 0; j < 16; j++) {
                    if (number[i].equals(Hex[j])) { // so sánh với hex[j]
                        BigInteger n1 = new BigInteger(Integer.toString(j));
                        result = result.add(n1.multiply(pow));
                        pow = pow.multiply(new BigInteger(base));
                    }
                }
            }
        }
        return result;
        // 1011 
    }

    public static void main(String[] args) {

        String ans = "";
        while (!ans.equals("N")) {
            String n1 = "";
            int chooseInput = display("Number input: ");
            int chooseOutput = display("Number output: ");
            switch (chooseInput) {
                case 1:
                    System.out.print("Enter binary: ");
                    n1 = checkInputBinary();
                    System.out.print("Result: ");
                    switch (chooseOutput) {
                        case 1:
                            System.out.print(n1);
                            break;
                        case 2:
                            System.out.print(toDecimal(n1, "2"));
                            break;
                        case 3:
                            BigInteger n = toDecimal(n1, "2");
                            System.out.print(decimalTo(n.toString(), "16"));
                            break;
                    }

                    break;
                case 2:
                    System.out.print("Enter decimal: ");
                    n1 = checkInputDecimal();
                    System.out.print("Result: ");
                    switch (chooseOutput) {
                        case 1:
                            System.out.print(decimalTo(n1, "2"));
                            break;
                        case 2:
                            System.out.print(n1);
                            break;
                        case 3:
                            System.out.print(decimalTo(n1, "16"));
                            break;
                    }
                    break;
                case 3:
                    System.out.print("Enter hexadecimal: ");
                    n1 = checkInputHexadecimal();
                    System.out.print("Result: ");
                    switch (chooseOutput) {
                        case 1:
                            BigInteger n = toDecimal(n1, "16");
                            System.out.print(decimalTo(n.toString(), "2"));
                            break;
                        case 2:
                            System.out.print(toDecimal(n1, "16"));
                            break;
                        case 3:
                            System.out.print(n1);
                    }
                    break;
            }
            System.out.println("");
            System.out.print("Do you want continute convert: Y/N?: ");
            ans = checkAnswer();
        }
    }
}
