/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0055;//J1

import java.util.HashMap;

/**
 *
 * @author Nam
 */
public class LAB211_B1_J1SP0055 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoctorHash managerDoctor = new DoctorHash();
        HashMap<String, Doctor> listDoctors = new HashMap<>();
        int userChoice = 0;
        //Step 1: Input data from file
        managerDoctor.inputData(listDoctors);
        do {
            //Step 2: Display the menu
            managerDoctor.displayMenu();
            //Step 3: Ask user to choice function
            userChoice = managerDoctor.userChoice();
            switch (userChoice) {
                case 1: {
                    //Step 4: Option 1: Add Doctor
                    managerDoctor.addDoctor(listDoctors);
                    break;
                }
                case 2: {
                    //Step 5: Option 2: Update Doctor by code
                    managerDoctor.updateDoctorByCode(listDoctors);
                    break;
                }
                case 3: {
                    //Step 6: Option 3: Delete Doctor by code
                    managerDoctor.deleteDoctorByCode(listDoctors);
                    break;
                }
                case 4: {
                    //Step 7: Option 4: Search Doctor by code
                    managerDoctor.searchDoctorsByCode(listDoctors);
                    break;
                }
                case 5: {
                    //Step 8: Option 5: Exit the program
                    managerDoctor.exitProgram(listDoctors);
                    break;
                }
            }
        } while (userChoice != 5);

    }

}
