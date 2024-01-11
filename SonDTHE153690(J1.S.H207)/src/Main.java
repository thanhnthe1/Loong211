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
     * Function count character second half letters.
     * @param input
     * @return 
     */
    public static int secondHalfLetters(String input){
        int count = 0;
        input = input.toLowerCase().trim();
        for(int i=0; i<input.length();i++){
            if(input.charAt(i)>='n' && input.charAt(i)<= 'z'){
                count ++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println("Number letters come from the second half of the alphabet: "+ secondHalfLetters("ruminates"));
    }
}
