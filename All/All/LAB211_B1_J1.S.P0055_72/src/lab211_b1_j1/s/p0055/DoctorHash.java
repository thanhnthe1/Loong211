/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0055;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Nam
 */
public class DoctorHash {

    // input data from DB.txt file
    public void inputData(HashMap<String, Doctor> listDoctors) {
        File file = new File("DB.txt");
        try {
            Scanner input = new Scanner(file);
            //Run each line in file
            while (input.hasNextLine()) {
                //Get information each line
                String info = input.nextLine();
                //Add Doctor from file
                addDoctorFromFile(listDoctors, info);
            }
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Can'r read file");
        }
    }

    // add infomation of doctor from file
    private void addDoctorFromFile(HashMap<String, Doctor> listDoctors,
            String info) {
        
        try {
            Doctor doctor = getDataFromFile(info);
            listDoctors.put(doctor.getCode(), doctor);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //get data infomation of doctor from file
    private Doctor getDataFromFile(String info) {
        //split data of line
        String[] infoAttribute = info.split("\\|");
        //get code of doctor
        String code = infoAttribute[0].trim();
        //get name of doctor
        String name = infoAttribute[1].trim();
        //get specialization of doctor
        String specialization = infoAttribute[2].trim();
        //get availability of doctor
        int availability = Integer.parseInt(infoAttribute[3].trim());
        return new Doctor(code, name.trim(), specialization, availability);
    }

    //display menu choice for user
    public void displayMenu() {
        System.out.println("========= Doctor Management ==========");
        System.out.println("  ·   Add Doctor");
        System.out.println("  ·   Update Doctor");
        System.out.println("  ·   Delete Doctor");
        System.out.println("  ·   Search Doctor");
        System.out.println("  ·   Exit");
    }

    //user choice 
    public int userChoice() {
        validValue input = new validValue();
        return input.option("Enter option:");
    }

    // add doctor from file to hashmap
    public void addDoctor(HashMap<String, Doctor> listDoctors) {
        listDoctors.clear();
        inputData(listDoctors);
        System.out.println("--------- Add Doctor ----------");
        //Enter information of Doctor
        Doctor doctor = inputInfoDoctor(listDoctors);
        //doctor different null
        if (doctor != null) {
            listDoctors.put(doctor.getCode(), doctor);
            System.out.println("Add doctor successfully");
        } else {
            System.out.println("Database does not exist");
        }
        writeToFile(listDoctors);
    }
    
    
    
    //input info of doctor 
    private Doctor inputInfoDoctor(HashMap<String, Doctor> listDoctors) {
        validValue input = new validValue();
        validValue check = new validValue();
        //Run until the information is satisfy
        do {
            String code = input.stringCode("Enter Code:");
            //Check code has existed in list
            if (check.isDuplicatelyCodeDoctor(code, listDoctors)) {
                System.out.println("Code is duplicate!!!!!!!!!!!!!!!!!!");
            } else {
                String name = input.stringWord("Enter Name:");
                String specialization = input.stringWord("Enter Specialization:");
                int availability = input.availability("Enter Availability:");
                Doctor doc = new Doctor(code.trim(), name.trim(),
                        specialization.trim(), availability);
                //Check each attribute is empty
                return doc;
            }
        } while (true);
    }

    //input info of doctor to update
    private Doctor inputInfoToUpdate(HashMap<String, Doctor> listDoctors,
            String codeToUpdate) {
        validValue input = new validValue();
        validValue check = new validValue();
        //Run until information is satisfy
        do {
            String code = input.stringCode("Enter Code:");
            //Check code is duplicately in list(except codeToUpdate)
            if (check.isDuplicatelyCodeDoctorUpdate(code, listDoctors,
                    codeToUpdate)) {
                System.out.println("Code is duplicate!!!!!!!!!!!!!!!!!!!!!!!");
            } else {
                String name = input.stringWord("Enter Name:");
                String specialization = input.stringWord("Enter Specialization:");
                int availability = input.availability("Enter Availability:");
                Doctor doc = new Doctor(code.trim(), name.trim(),
                        specialization.trim(), availability);
                //Check each attribute is empty
                if (check.isAttributeDoctor(doc)) {
                    System.out.println("Data doesn't exist.");
                    return null;
                }
                return doc;
            }
        } while (true);
    }

    // save info of doctor from hashmap to file
    private void writeToFile(HashMap<String, Doctor> listDoctors) {
        try {
            FileWriter writer = new FileWriter("DB.txt");
            //Run from first Doctor to last Doctor
            for (HashMap.Entry<String, Doctor> entry : listDoctors.entrySet()) {
                Doctor value = entry.getValue();
                writer.write(value.getCode()
                        + "|" + value.getName()
                        + "|" + value.getSpecialization()
                        + "|" + value.getAvailability()
                        + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("Can't save file.");
        }
    }

    //update infomation of doctor by code
    public void updateDoctorByCode(HashMap<String, Doctor> listDoctors) {
        listDoctors.clear();
        inputData(listDoctors);
        //Check list is empty
        if (listDoctors.isEmpty()) {
            System.out.println("Database does not exist");
            return;
        }
        System.out.println("--------- Update Doctor -------");
        String codeToUpdate = inputCode(listDoctors);
        Doctor doctor = inputInfoToUpdate(listDoctors, codeToUpdate);
        //doctor is null
        if (doctor == null) {
            return;
        }
        //Run from first doctor to last doctor
        for (HashMap.Entry<String, Doctor> entry : listDoctors.entrySet()) {
            String key = entry.getKey();
            Doctor value = entry.getValue();
            //check new code and old code is same
            if (value.getCode().compareToIgnoreCase(codeToUpdate) == 0) {
                //Update Doctor
                value.setCode(doctor.getCode());
                value.setName(doctor.getName());
                value.setSpecialization(doctor.getSpecialization());
                value.setAvailability(doctor.getAvailability());
            }
        }
        writeToFile(listDoctors);
        System.out.println("Update doctor successfully");
    }

    //input code to update info of doctor
    private String inputCode(HashMap<String, Doctor> listDoctors) {
        validValue input = new validValue();
        validValue check = new validValue();
        //Run until find code in list
        do {
            String code = input.stringCode("Enter code to find: ");
            //check duplicate code
            if (check.isDuplicatelyCodeDoctor(code, listDoctors)) {
                //run from first entry to last entry
                for(Map.Entry<String,Doctor> entry : listDoctors.entrySet()){
                    Doctor value = entry.getValue();
                    //check equal of code of hashmap and enter 
                    //code to get same vale in file
                    if(value.getCode().replaceAll("\\s+", "").
                            equalsIgnoreCase(code.replaceAll("\\s+", ""))){
                       code = value.getCode();
                    }
                }
                return code;
            } else {
                System.out.println("Doctor code doesn’t exist");
            }
        } while (true);
    }

    //delete doctor by code 
    public void deleteDoctorByCode(HashMap<String, Doctor> listDoctors) {
        listDoctors.clear();
        inputData(listDoctors);
        //Check list is empty
        if (listDoctors.isEmpty()) {
            System.out.println("Database does not exist.");
            return;
        }
        System.out.println("--------- Delete Doctor -------");
        String code = inputCode(listDoctors);
        //Delete Doctor
        try {
            //Run from first Doctor to last Doctor
            for (Map.Entry<String, Doctor> entry : listDoctors.entrySet()) {
                String key = entry.getKey();
                Doctor value = entry.getValue();
                //compare doctor code 
                if (value.getCode().compareToIgnoreCase(code) == 0) {
                    listDoctors.remove(key);
                }
            }
            System.out.println("Delete doctor successfully");
        } catch (Exception e) {
            System.out.println("Can't remove");
        }
        writeToFile(listDoctors);
    }

    // search info of doctor by code
    public void searchDoctorsByCode(HashMap<String, Doctor> listDoctors) {
        //check list is empty
        if (listDoctors.isEmpty()) {
            System.out.println("Database does not exist.");
            return;
        }
        validValue input = new validValue();
        System.out.println("--------- Search Doctor -------");
        //User enter text
        String text = input.stringCode("Enter text:");
        HashMap<String, Doctor> doctorsByCode;
        try {
            System.out.println("--------- Result -------");
            //Search Doctors by code
            doctorsByCode = searchDoctor(listDoctors, text);
            //Check list find by code is empty
            if (doctorsByCode.isEmpty()) {
                System.out.println("Can't find text is " + text+"!!!!!!!!!!!!!!");
                return;
            } else {
                System.out.printf("%-8s%-10s%-20s%-20s\n", "Code", "Name",
                        "Specialization", "Availability");
                //Display Doctors just searched
                for (HashMap.Entry<String, Doctor> entry : doctorsByCode.entrySet()) {
                    Doctor value = entry.getValue();
                    value.display();
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private HashMap<String, Doctor> searchDoctor(HashMap<String, Doctor> listDoctors,
            String text) throws Exception {
        listDoctors.clear();
        inputData(listDoctors);
        //Check list is empty
        if (listDoctors.isEmpty()) {
            throw new Exception("Database is not exist");
        } else {
            HashMap<String, Doctor> doctorsByCode = new HashMap<>();
            //run from first hashmap to last hashmap
            for (HashMap.Entry<String, Doctor> entry : listDoctors.entrySet()) {
                String key = entry.getKey();
                Doctor value = entry.getValue();
                text = text.toLowerCase();
                //Check any attribute can contain text
                if (value.getCode().toLowerCase().contains(text)
                        || value.getName().toLowerCase().contains(text)
                        || value.getSpecialization().toLowerCase().contains(text)
                        || (value.getAvailability() + "").contains(text)) {
                    doctorsByCode.put(key, value);
                }
            }
            return doctorsByCode;
        }
    }

    public void exitProgram(HashMap<String, Doctor> listDoctors) {
        System.out.println("Thanks.");
    }

}
