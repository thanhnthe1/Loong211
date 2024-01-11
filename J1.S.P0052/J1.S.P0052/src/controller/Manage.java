/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.EastAsiaCountries;

/**
 *
 * @author kidzd
 */
public class Manage {
// create list country
    List<EastAsiaCountries> list = new ArrayList<>();
//get list country
    public List<EastAsiaCountries> getListCountry() {
        return list;
    }
//to add Country to list
    public void addCountry(EastAsiaCountries countries) {
        list.add(countries);
    }
//to check duplicate
    public boolean checkDuplicate(String countryCode) {
        for (EastAsiaCountries country : list) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                return true;
            }
        }
        return false;
    }
 // to search Country by name
    public List<EastAsiaCountries> getCountryByName(String name) {
        List<EastAsiaCountries> listSearch = new ArrayList<>();
        for (EastAsiaCountries eastAsiaCountries : list) {
            if (eastAsiaCountries.getCountryName().toUpperCase().contains(name.toUpperCase())) {
                listSearch.add(eastAsiaCountries);
            }
        }
        return listSearch;
    }
// create list country to sort
    public List<EastAsiaCountries> sort() {
        List<EastAsiaCountries> listSort = new ArrayList<>();
        listSort.addAll(list);
        //sort
         /*Loop from the first to last person , 
        after each loop, one person is sorted*/
        for (int i = 0; i < listSort.size(); i++) {
            //Loop from first to last person through unsorted person
            for (int j = 0; j < listSort.size() - 1 - i; j++) {
                //swap two person if not in ascending order
                if (list.get(j).getCountryName().compareToIgnoreCase(listSort.get(j + 1).getCountryName()) > 0 ) {
                    Collections.swap(listSort, j, j + 1);
                }
            }
        }
        return listSort;
    }
}
