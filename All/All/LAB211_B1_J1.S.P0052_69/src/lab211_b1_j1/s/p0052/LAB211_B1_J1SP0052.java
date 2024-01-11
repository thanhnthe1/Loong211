/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0052;

import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class LAB211_B1_J1SP0052 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ManageEastAsiaCountries manageCountries = new ManageEastAsiaCountries();
        ArrayList<EastAsiaCountries> listCountries = new ArrayList<>();
        //listCountries.add(new EastAsiaCountries("IDN", "Indonesia", 1860360, "Nice"));
        int userChoice = 0;
        do {
            //Display menu
            manageCountries.displayMenu();
            //Ask user to choice in the menu
            userChoice = manageCountries.EnterToChoice();
            switch (userChoice) {
                case 1: {
                    //input information of country
                    manageCountries.inputCountryToList(listCountries);
                    break;
                }
                case 2: {
                    //display information of recently entered country
                    manageCountries.displayRecentlyEnteredCountry(listCountries);
                    break;
                }
                case 3: {
                    //search information of country by user entered name
                    manageCountries.searchCountryByEnteredName(listCountries);
                    break;
                }
                case 4: {
                    //display all countries sorted name in ascending order
                    manageCountries.displayAllCountryByAscendingOrderName(listCountries);
                    break;
                }
                case 5: {
                    //Exit program
                    manageCountries.exitProgram();
                    break;
                }
            }
        } while (userChoice != 5);
    }
    
}
