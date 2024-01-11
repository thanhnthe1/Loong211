
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kidzd
 */
public class ReverseWord {

    public static void main(String[] args) {
        printReverse("");
    }
    private static String ReverseString(String input) {
       
        String[] inputArray = input.split("\\b");
        StringBuilder output = new StringBuilder();

        if (input.endsWith(".")) {
               //loop from last to first element
            for (int i = inputArray.length - 1; i > 0; i--) {
                //upper first character of last words
                if (i == inputArray.length - 1) {
                    inputArray[i - 1] = inputArray[i - 1].substring(0, 1).toUpperCase().concat(inputArray[i - 1].substring(1));
                }
                if (inputArray[i].equals(". ")) {
                    inputArray[i - 1] = inputArray[i - 1].substring(0, 1).toUpperCase().concat(inputArray[i - 1].substring(1));
                }

                output.append(inputArray[i - 1]);
            }
            output.append(".");
        } else {
            //loop from last to first element
            for (int i = inputArray.length - 1; i >= 0; i--) {
                //upper first character of last words
                if (i == inputArray.length - 1) {
                    inputArray[i] = inputArray[i].substring(0, 1).toUpperCase().concat(inputArray[i].substring(1));
                }
                if (inputArray[i].equals(". ")) {
                    inputArray[i - 1] = inputArray[i - 1].substring(0, 1).toUpperCase().concat(inputArray[i - 1].substring(1));
                }
                output.append(inputArray[i]);
            }
        }
       return output.toString();
    }

    private static void printReverse(String string) {
        Scanner scanner = new Scanner(System.in);
      
        do {            
            if (string.isEmpty()) {
                System.out.print("Input string: ");
                string = scanner.nextLine();
            }
        } while (string.isEmpty());
        
        String output = ReverseString(string);
        System.out.println(output);
        
        
    }
}
