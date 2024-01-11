/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kidzd
 */
public class Main {

    public static void main(String[] args) {
        //1. input number of array
        int numberOfArray = SelectionSort.inputNumberOfArray();

        //2. create array
        int[] array = new int[numberOfArray];

        //3. enter element of array
        SelectionSort.enterElement(array);

        //4. display unsort array
        SelectionSort.displayArray("Unsorted array: ", array);

        //5. selection sort array
        SelectionSort.selectionSort(array);

        //6. display sorted array
        SelectionSort.displayArray("Sorted array: ", array);
    }
}
