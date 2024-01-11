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
    /**
     * Function reverser string and print it 
     * @param input 
     */
    public static void printReverse(String input){
        if(input.isEmpty()){
            return;
        }
        else{
            // Run from the end of the string and print it
            for(int i=input.length()-1;i>=0;i--){
                System.out.print(input.charAt(i)); 
            }
            System.out.println("");   
        }
    }
    
    /**
     * Main call function
     * @param args 
     */
    public static void main(String[] args) {
        printReverse("Hello there!");
    }
}
