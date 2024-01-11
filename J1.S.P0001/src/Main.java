
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thien Thanh
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(10);
        array.add(5);
        array.add(2);
        array.add(4);
        array.add(5);
        array.add(6);
        
        for (Integer o : array) {
            System.out.print(o+",");
            
        }
        System.out.println("sort");
        Collections.sort(array);
        for (Integer o : array) {
            System.out.print(o+",");
        }
        
    }
       
            
}
