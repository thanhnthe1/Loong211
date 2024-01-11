/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author kidzd
 */
public class ManageEastAsiaCountries {

    public static void main(String[] args) {

        ViewCountry view = new ViewCountry();
        while (true) {
            displayMenu();
            //input choice
            int choice = Ultility.getInt("Enter your choice: ", "Your choice must be from 1 to 5", 1, 5);
            switch (choice) {
                case 1:
                    // input country information
                    view.input();
                    break;
                case 2:
                    // display last country
                    view.displayLastCountry();
                    break;
                case 3:
                    // search country by  name
                    view.searchCountry();
                    break;
                case 4:
                    // sort country by name
                    view.sortCountry();
                    break;
                case 5:
                    // exit program
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("                               MENU\n"
                + "==========================================================================\n"
                + "1. Input the information of 11 countries in East Asia\n"
                + "2. Display the information of country you've just input\n"
                + "3. Search the information of country by user-entered name\n"
                + "4. Display the information of countries sorted name in ascending order  \n"
                + "5. Exit \n"
                + "==========================================================================");
    }

}
