
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
public class Validation {

    Scanner sc = new Scanner(System.in);
    
    /**
     * Function input number integer from min to max
     * @param min
     * @param max
     * @return int
     */
    public int inputNumberOfRange(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    System.out.print("Re-enter(only enter digit " + min + "->" + max + "): "); // If number out range
                }
                else{ // If number in range
                return n; 
                }
            } catch (NumberFormatException ex) { // If user input string
                System.out.print("Input must number. Re-enter:");
            }
        }
    }
    
    /**
     * Function check format date
     * @param result
     * @return boolean
     */
    public boolean checkFormatDate(String result) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date = format.parse(result);
            String temp[] = result.split("-");
            int year = Integer.parseInt(temp[2]);
            LocalDate localDate = LocalDate.now();
            int now = localDate.getYear();
            if (!result.equalsIgnoreCase(format.format(date)) || year > now) { // If input wrong format then user enter again
                System.out.print("Invalid(dd-MM-yyyy): ");
            } else {
                return true;
            }
        } catch (ParseException e) {
            System.out.print("Format must(dd-MM-yyyy). Re-enter: ");
        }
        return false;
    }
    
    /**
     * Input date
     * @return String
     * @throws ParseException 
     */
    public String inputDate() throws ParseException {
        while (true) {
            String result = sc.nextLine().trim();
            if(checkFormatDate(result))
                return result;
        }
    }
    
    /**
     * Input String
     * @return String
     */
    public String inputString() {
        while (true) {
            String result = sc.nextLine();
            if (result.matches("^[a-zA-Z0-9\\s]+$")) {
                return result;
            } else {
                System.out.println("In-valid(only letter ,digit and space)!!!");
                System.out.print("Re-enter: ");
            }
        }
    }
    
    /**
     * Input Double
     * @return double
     */
    public double inputDouble() {
        double result;
        while (true) {
            try {
                result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.out.print("Re-enter: ");
            }
        }
    }
    
    /**
     * Input plan from
     * @return double
     */
    public double inputPlanFrom(){
        double input;
        while(true){
            input = inputDouble();
            // If plan from >= 8 and <= 17 and must %0.5==0
            if(input>=8.0 && input<=17.0 && input%0.5==0){
                return input;
            }
            else{
                System.out.print("Re-enter(8->17 && 8.0, 8.5, 9.0,...): ");
            }
        }
    }
    
    /**
     * Input plan To
     * @param n
     * @return double
     */
    public double inputPlanTo( double planFrom){
        double input;
        while(true){
            input = inputDouble();
            // if plan to <= 17.5 && > plan from && must %0.5==0
            if(input<=17.5 && input>planFrom  && input%0.5==0){
                return input;
            }
            else{
                System.out.print("Re-enter( must > Plan From and 8->17 && 8.0, 8.5, 9.0,...): ");
            }
        }
    }
    
    /**
     * Function input task type id
     * @return String
     */
    public String inputTaskTypeId(){
        String result = null;
        while (true) {
            int n = inputNumberOfRange(1, 4); // input number range from 1 - 4
            switch (n) {
                case 1:
                    result = "Code";
                    break;
                case 2:
                    result = "Test";
                    break;
                case 3:
                    result = "Manager";
                    break;
                case 4:
                    result = "Learn";
            }
            return result;
        }
    }
    
    /**
     * Function to ask user want add continue
     * @return String
     */
    public String Ans_Add() {
        String a;
        while (true) {
            a = sc.nextLine();
            if (a.matches("^[yYnN]+$")) { // User enter Y/y or N/n
                break;
            } else {
                System.out.print("Only Enter(Yes(Y) or No(N)!!!. Re-Enter: ");
            }
        }
        return a;
    }
}
