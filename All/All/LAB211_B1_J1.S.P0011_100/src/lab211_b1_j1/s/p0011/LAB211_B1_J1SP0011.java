/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0011;

import java.math.BigInteger;

/**
 *
 * @author Nam
 */
public class LAB211_B1_J1SP0011 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Convert manager = new Convert();
        Validate input = new Validate();
        String choice;
        do {
            //S1: User choose the base number in
            int baseIn = manager.inputBaseIn(input);
            //S2: User choose the base number out
            int baseOut = manager.inputBaseOut(input, baseIn);
            //S3: User enter the input value
            String valueIn = manager.inputValueIn(input, baseIn);
            //S4: Convert process
            String valueOut = manager.convertNumber(baseIn, baseOut, valueIn);
            //S5: Display output value
            manager.displayOutputValue(valueOut);
            //S6: ask user want to continue
            choice = manager.wantToCoutinue(input);
        } while (choice.compareToIgnoreCase("Y") == 0);
    } 
}
