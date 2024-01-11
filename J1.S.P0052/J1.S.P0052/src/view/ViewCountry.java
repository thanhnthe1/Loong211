/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Manage;
import java.util.List;
import model.EastAsiaCountries;

/**
 *
 * @author kidzd
 */
public class ViewCountry {

    Manage manage = new Manage();

    void input() {
        //check size of list
        if (manage.getListCountry().size() == 11) {
            System.out.println("List is full");
            return;
        }
        //input information
        String countryCode = getCountryCode();
        String countryName = getCountryName();
        double totalArea = getTotalArea();
        String terrain = getTerrain();
        //check duplicate
        if (manage.checkDuplicate(countryCode)) {
            System.out.println("ID is existed");
        } else {
            //create instance
            EastAsiaCountries countries = new EastAsiaCountries(terrain, countryCode, countryName, totalArea);
            //add instance
            manage.addCountry(countries);
            System.out.println("Add Country successfull !");
        }
    }

    /**
     * get Country code from input
     *
     * @return countryCode
     */
    private String getCountryCode() {
        String countryCode = Ultility.getString("Enter code of country: ", "Country code must be letters", Ultility.REGEX_STRING);
        return countryCode;
    }

    /**
     * get Country name from input
     *
     * @return countryName
     */
    private String getCountryName() {
        String countryName = Ultility.getString("Enter name of country: ", "Country name must be letters", Ultility.REGEX_STRING);
        return countryName;
    }

    /**
     * get total area from input
     *
     * @return totalArea
     */
    private double getTotalArea() {
        double totalArea = Ultility.getDouble("Enter total Area: ", "Total area must be digits", 0, Double.MAX_VALUE);
        return totalArea;
    }

    /**
     * get terrain from input
     *
     * @return terrain
     */
    private String getTerrain() {
        String terrain = Ultility.getString("Enter terrain of country: ", "Terrain must be letters", Ultility.REGEX_STRING);
        return terrain;
    }

    void displayLastCountry() {
        //if list is empty then tell error
        if (manage.getListCountry().size() == 0) {
            System.out.println("List is empty");
            return;
        } else {
            System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
            manage.getListCountry().get(manage.getListCountry().size() - 1).display();
        }
    }
/**
 * search country by name
 */
    void searchCountry() {
        String name = getCountryName();
        List<EastAsiaCountries> listSearch = manage.getCountryByName(name);
        if (listSearch.size() == 0) {
            System.out.println("NOT FOUND");
        } else {
            displayListCountry(listSearch);
        }
    }
/**
 * display list Country after Search
 * @param listSearch 
 */
    private void displayListCountry(List<EastAsiaCountries> listSearch) {
        System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountries eastAsiaCountries : listSearch) {
            eastAsiaCountries.display();
        }
    }

    void sortCountry() {
        if (manage.getListCountry().size() == 0) {
            System.out.println("List is empty");
        } else {
            List<EastAsiaCountries> listSort = manage.sort();
            displayListCountry(listSort);
        }
    }
}
