
import java.util.Arrays;
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
public class SelectionSort {
// input size of Array

    public static int inputNumberOfArray() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter number of array: ");
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Number of array must be greater than 0");
                }
            } catch (Exception e) {
                System.out.println("You must input positive decimal number!!");
            }
        }
    }
// input elements of Array

    public static void enterElement(int[] array) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            while (true) {
                System.out.print("Enter element: ");
                String input = scanner.nextLine();
                try {
                    array[i] = Integer.parseInt(input);
                    break;
                } catch (Exception e) {
                    System.out.println("You must input digit!!");
                }
            }
        }
    }
//display array

    public static void displayArray(String message, int[] array) {
        System.out.println(message + Arrays.toString(array));
    }
//sort array by selection sort

    public static void selectionSort(int[] array) {
        int indexMin, i, j;
        //loop through each element
        for (i = 0; i < array.length - 1; i++) {
            indexMin = i;
            //loop to find smallest elements unsorted  
            for (j = i + 1; j < array.length; j++) {
                if (array[j] < array[indexMin]) {
                    indexMin = j;
                }
            }
            //swap smallest  elements with the first elements
            if (indexMin != i) {
                int temp = array[indexMin];
                array[indexMin] = array[i];
                array[i] = temp;
            }
        }
    }
}
