
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
public class ReverseCharacter {

    public static void main(String[] args) {
        printReverse("");
    }

    /**
     * 
     * @param string 
     */
    private static void printReverse(String string) {
        Scanner scanner = new Scanner(System.in);
        do {
            if (string.isEmpty()) {
                System.out.print("Input string: ");
                string = scanner.nextLine();
            }
        } while (string.isEmpty());
        StringBuilder output = new StringBuilder(string);
        System.out.println(output.reverse());

    }
}
