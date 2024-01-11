/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0009;

/**
 *
 * @author Nguyen Thien Thanh
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci");
        fibonnaciHelper(5, 1, 0);
    }

    public static int fibonnaciHelper(int term, int lower, int higher) {
        if (term < 1) {
            return higher;
        }
        System.out.print(higher + ", ");
        return fibonnaciHelper(term - 1, higher, higher + lower);
    }

}