
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
    public static void printReverse(String input){
        Scanner sc = new Scanner(System.in);
        input = input.trim();
        while(input.isEmpty()){
            System.out.print("String is not empty. Enter again: ");
            input = sc.nextLine();
        }
        String []word = input.split(" "); // Split string into string array.
        for(int i=word.length-2 ; i>=0 ; i--){
            if(word[i].charAt(word[i].length()-1) == '.'){
                word[i] = word[i].replace(".", ""); //Remove dot.
                word[i+1] = word[i+1]+"."; //Add dot
            }
        }
        int n = word.length;
        if(word[n-1].substring(word[n-1].length()-2, word[n-1].length()).equals("..")){
            word[n-1] = word[n-1].substring(0,word[n-1].length()-1);
            word[0] = word[0]+".";
        }
        else if(word[n-1].charAt(word[n-1].length()-1)=='.'){
            word[n-1] = word[n-1].replace(".", "");
            word[0] = word[0]+".";
        }
        System.out.print("Result: ");
        for(int i=n-1;i>=1;i--){
            if(i==n-1){
                word[i]=word[i].substring(0, 1).toUpperCase()+word[i].substring(1, word[i].length());
            }
            if(word[i].charAt(word[i].length()-1)=='.'){
                word[i-1] = word[i-1].substring(0, 1).toUpperCase()+word[i-1].substring(1, word[i-1].length());
            }
        }
        for(int i=n-1;i>=0;i--){
            System.out.print(word[i]+" ");
        }
    }
    public static void main(String[] args) {
        printReverse("hello there. abc. xyz.");
    }
    
}
