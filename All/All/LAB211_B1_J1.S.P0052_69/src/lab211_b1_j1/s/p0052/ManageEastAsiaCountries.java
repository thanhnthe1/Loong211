/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0052;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Nam
 */
public class ManageEastAsiaCountries {

    public Scanner sc = new Scanner(System.in);

    //Display menu
    public void displayMenu() {
        System.out.println("\n\t\t\t\tMENU");
        System.out.println("===========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display information of countries you’ve just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Displays the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("===========================================================================");
    }

    //user enter choice
    public int EnterToChoice() {

        int input = 0;
        System.out.println("Enter your choice:");
        //Run again until number is integer number
        //from 1 to 5
        while (true) {
            try {

                input = Integer.parseInt(sc.nextLine());
                //choice from 1 to 5 to run program
                if (input > 0 && input < 6) {
                    return input;
                } //differrent 1 to 5, user enter again
                else if (input <= 0 || input >= 6) {
                    System.out.println("Must from 1 to 5. Pls, enter again!"
                            + "\nEnter your choice:");
                }
            } catch (Exception e) {
                System.out.println("Must integer number. Pls, enter again!"
                        + "\nEnter your choice:");
            }
        }
    }

    //input country info to list
    public void inputCountryToList(ArrayList<EastAsiaCountries> listCountries) {
        //Require to put information of country
        EastAsiaCountries country = inputCountryInfo(listCountries);
        try {
            //Add data into program
            addCountryInformation(country, listCountries);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //input Information Of Country
    private EastAsiaCountries inputCountryInfo(ArrayList<EastAsiaCountries> listEastAsiaCountries) {
        String code;
        while (true) {
            code = stringCharacter("Enter code of country:");
            CheckValue check = new CheckValue();
            //Check country duplicate with list
            if (check.checkDuplicatedCountry(listEastAsiaCountries, code)) {
                System.out.println("Your code of country have been in the list.");
            }else break;
        }
        String name = stringWords("Enter name of country:");
        float totalArea = inputFloatNumber("Enter total Area:");
        String terrain = stringWords("Enter terrain of country:");
        return new EastAsiaCountries(code, name, totalArea, terrain);
    }

    //add Information of Country to list EastAsiaCountry
    private void addCountryInformation(EastAsiaCountries country,
        ArrayList<EastAsiaCountries> listEastAsiaCountries) throws Exception {
        //Check list of country is equal 11 country so don't add
        if (listEastAsiaCountries.size() == 11) {
            throw new Exception("The list is full.");
        } 
        //add country to list
        else {
            listEastAsiaCountries.add(country);
        }
    }

    //display Recently Entered Country
    public void displayRecentlyEnteredCountry(
            ArrayList<EastAsiaCountries> listCountries) {
        EastAsiaCountries country;
        try {
            //Get country user's just input
            country = getRecentlyEnteredInformation(listCountries);
            //Display information of country user's just input
            displayAttributeCountry();
            country.display();
            System.out.println("");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //get Recently Entered Information of country
    private EastAsiaCountries getRecentlyEnteredInformation(
            ArrayList<EastAsiaCountries> listCountries) throws Exception {
        //Check list is empty, it mean there'is not recently entered information
        if (listCountries.isEmpty()) {
            throw new Exception("There aren't any recently entered information.");
        } else {
            return listCountries.get(listCountries.size() - 1);
        }
    }

    //search infomation of country by user input name
    public void searchCountryByEnteredName(
            ArrayList<EastAsiaCountries> listCountries) {
        if (!(listCountries.isEmpty())) {
            //Input country name
            String nameCountry = inputNameCountry();
            try {
                ArrayList<EastAsiaCountries> countriesByName;
                //Find countries match with entered name
                countriesByName = searchInformationByName(listCountries, nameCountry);
                //Display that countries
                displayAttributeCountry();
                //Run from first country to last country
                for (EastAsiaCountries country : countriesByName) {
                    country.display();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("There are no countries in the list.");
        }
    }

    //enter name of country to search
    private String inputNameCountry() {
        return stringWords("Enter the name you want to search for:");
    }

    //search infomation of country by name
    private ArrayList<EastAsiaCountries> searchInformationByName(
            ArrayList<EastAsiaCountries> listCountries, String name) throws Exception {
        ArrayList<EastAsiaCountries> countryByName = new ArrayList<>();
        name = name.replaceAll("\\s+", "");
        //Check list don't have countreis
        if (listCountries.isEmpty()) {
            throw new Exception("There aren't any country to search.");
        } else {
            //Run from first country to last country
            for (EastAsiaCountries country : listCountries) {
                //Check name country contains just entered name
                String NameCountry = country.getCountryName().replaceAll("\\s+", "");
                if ((NameCountry.toLowerCase().contains(name.toLowerCase())) ) {
                    countryByName.add(country);
                }
            }
        }
        //Check country just search by name have countries
        if (!countryByName.isEmpty()) {
            return countryByName;
        } else {
            throw new Exception("There're not any name is " + name);
        }
    }

    //display list of Countries sorted Ascending by Name 
    public void displayAllCountryByAscendingOrderName(
            ArrayList<EastAsiaCountries> listCountries) {

        try {
            //Sort countries
            ArrayList<EastAsiaCountries> countrySorted;
            countrySorted = sortInformationByAscendingOrder(listCountries);
            //Display list countries just sorted by name
            final int FINAL_POSITION_COUNTRY = countrySorted.size() - 1;
            displayAttributeCountry();
            //Run first counry to near last country 
            for (int i = 0; i < FINAL_POSITION_COUNTRY; i++) {
                countrySorted.get(i).display();
                System.out.println("");
            }
            countrySorted.get(FINAL_POSITION_COUNTRY).display();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //sort Information of country By Ascending Order Name
    private ArrayList<EastAsiaCountries> sortInformationByAscendingOrder(
            ArrayList<EastAsiaCountries> listCountries) throws Exception {
        //Check list don't have country
        if (listCountries.isEmpty()) {
            throw new Exception("There aren't any country to sort.");

        } else {
            ArrayList<EastAsiaCountries> sortCountryByName = new ArrayList<>();
            //Add all countries in list into a new list
            sortCountryByName.addAll(listCountries);
            //Sort a new list by ascending name
            Collections.sort(sortCountryByName, new Comparator<EastAsiaCountries>() {
                @Override
                public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                    return o2.getCountryName().compareToIgnoreCase(o1.getCountryName());
                }
            });
            return sortCountryByName;
        }
    }

    //display Attribute of each Country
    private void displayAttributeCountry() {
        System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
    }

    //End program
    public void exitProgram() {
        //End program
        System.out.println("End program!");
    }

    //Input choice of user with masage
    //Input number type integer with masage
    public int inputIntegerNumber(String message) {
        int input = 0;
        System.out.println(message);
        //Run again until number is integer number so stop
        do {
            try {

                input = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Must integer number. Pls, enter again!\n" + message);
            }
        } while (true);
        return input;
    }

    //input number type float with masage
    public float inputFloatNumber(String message) {
        float input = 0;
        //Run again until number is float number
        //and float number greater than 0 so stop
        System.out.println(message);
        do {
            try {

                input = Float.parseFloat(sc.nextLine());
                if (input > 0) {
                    break;
                } else {
                    System.out.println("Total area must be greater than 0. Pls, enter again!\n" + message);
                }
            } catch (Exception e) {
                System.out.println("Must number. Pls, enter again!\n" + message);
            }
        } while (true);
        return input;
    }

    //input string only word with message
    public String stringWords(String message) {
        CheckValue check = new CheckValue();
        String input = "";
        System.out.println(message);
        //Run again until check valid words is true so stop
        do {
            input = sc.nextLine().trim();
            //check input is word
            if (check.checkWords(input)) {
                return input;
            } else {
                System.out.println("Must words. Pls, enter again!\n" + message);
            }
        } while (true);
    }

    //input string is characters
    public String stringCharacter(String message) {
        CheckValue check = new CheckValue();
        String input = "";
        System.out.println(message);
        //Run again until check valid character is true so stop
        do {
            input = sc.nextLine().trim();
            if (check.checkCharacter(input)) {
                break;
            } else {
                System.out.println("Must character. Pls, enter again!\n" + message);
            }
        } while (true);
        return input;
    }
}
