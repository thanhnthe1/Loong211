/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0055;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nam
 */
public class validValue {
    
    public Scanner sc = new Scanner(System.in);

    //option of user choice
    public int option(String message) {
        int input = 0;
        //Run again until number is integer number
        //and integer number is in range between 1 and 6 so stop
        do {
            try {
                System.out.println(message);
                input = Integer.parseInt(sc.nextLine());
                if (input > 0 && input < 6) {
                    break;
                }
                if (input <= 0 || input >= 6) {
                    System.out.println("Must from 1 to 5. Pls, enter again!");
                }
            } catch (Exception e) {
                System.out.println("Must integer number. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    //check input of code
    public String stringCode(String message) {
        String input = "";
        //Run again until check valid vode is true so break loop
        do {
            System.out.print(message);
            input = sc.nextLine();

            if (isCode(input) && containSpecial(input) == false) {
                break;
            } else {
                if (containSpecial(input)) {
                    System.out.println("You don't enter | ");
                }
                else System.out.println("Must code. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    //check string is word
    public String stringWord(String message) {
        String input = "";
        //Run again until check valid words is true so break loop
        do {
            System.out.print(message);
            input = sc.nextLine();
            if (isWord(input)&& containSpecial(input) == false) {
                break;
            } else {
                if (containSpecial(input)) {
                    System.out.println("You don't enter | ");
                }
                else System.out.println("Must word. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    //check input of availability
    public int availability(String message) {
        int input = 0;
        //Run again until number is integer so break loop
        do {
            try {
                System.out.print(message);
                String number = sc.nextLine().trim();
                if (number.isEmpty() || message.equals("")) {
                    input = -1;
                    System.out.println("Must integer number. Pls, enter again!");
                } else {
                    input = Integer.parseInt(number);
                    if (input > 0) {
                        break;
                    }
                    if (input <= 0) {
                        System.out.println("Availability must greater than 0. Pls, enter again!");
                    }
                }

            } catch (Exception e) {
                System.out.println("Must integer number. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    //check string is code
    public boolean isCode(String name) {
        //charecter is a-z, number, space, | in last
        String regex = "[a-z0-9\\s]+|^$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        //If name and pattern matches and name isn't empty so return true (if no return false)
        if (matcher.matches() && !name.trim().equals("")) {
            return true;
        }
        return false;
    }

    //check duplicate new code of doctor
    boolean isDuplicatelyCodeDoctorUpdate(String newcode,
            HashMap<String, Doctor> listDoctors, String codeToUpdate) {
        //Run from first doctor until check is true or to last doctor
        for (Map.Entry<String, Doctor> entry : listDoctors.entrySet()) {
            String key = entry.getKey();
            Doctor value = entry.getValue();
            //Check duplicately code and diffirent code to update
            if (newcode.replaceAll("\\s+", "").equalsIgnoreCase(value.getCode().replaceAll("\\s+", ""))
                    && !codeToUpdate.replaceAll("\\s+", "").equalsIgnoreCase(value.getCode().replaceAll("\\s+", "")) ) {
                return true;
            }
        }
        return false;
    }

    //check input is word
    public boolean isWord(String id) {
        //accept character a-z,space, | in last
        String regex = "[a-z\\s]+|^$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(id);
        //If id and pattern matches and id isn't empty so return true (if no return false)
        if (matcher.matches() && !id.trim().equals("")) {
            return true;
        }
        return false;
    }

    //check attribute of doctor is empty
    public boolean isAttributeDoctor(Doctor doctor) {
        //Check all attribute of doctor
        if (doctor.getCode().trim().compareTo("") == 0
                || doctor.getName().trim().compareTo("") == 0
                || doctor.getSpecialization().trim().compareTo("") == 0
                || doctor.getAvailability() < 1) {
            return true;
        }
        return false;
    }

    //check duplicate of new doctor 
    boolean isSameInfo(Doctor doc, HashMap<String, Doctor> listDoctors,
            String codeToUpdate) {
        //Run from first doctor until check is true or to last doctor
        for (Map.Entry<String, Doctor> entry : listDoctors.entrySet()) {
            String key = entry.getKey();
            Doctor value = entry.getValue();
            //Check list have code to update
            if (codeToUpdate.compareToIgnoreCase(value.getCode()) == 0) {
                //Check name, specialization, availability is same of two doctor
                if (value.getName().compareToIgnoreCase(doc.getName()) == 0
                        && value.getSpecialization().compareToIgnoreCase(doc.getSpecialization()) == 0
                        && value.getAvailability() == doc.getAvailability()) {
                    return true;
                }
            }
        }
        return false;
    }

    // check duplicate new code
    public boolean isDuplicatelyCodeDoctor(String code,
            Map<String, Doctor> listDoctors) {
        //Run from first doctor until check is true or to last doctor
        for (Map.Entry<String, Doctor> entry : listDoctors.entrySet()) {
            Doctor value = entry.getValue();
            //Check duplicately code
            if (code.compareToIgnoreCase(value.getCode()) == 0) {
                return true;
            }
        }
        return false;
    }
    
    public boolean containSpecial(String string){
        if(string.contains("|")){
                return true;
            }
        return false;
    }
}
