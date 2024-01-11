/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class EastAsiaCountries extends Country {

    private String countryTerrain;
/**
 * 
 * @return countryTerrain
 */
    public String getCountryTerrain() {
        return countryTerrain;
    }
/**
 * 
 * @param countryTerarain the countryTerrain to set
 */
    public void setCountryTerrain(String countryTerrain) {
        if (countryTerrain != null) {
            this.countryTerrain = countryTerrain;
        }
    }
//super is used to invoke Country class constructor.
    public EastAsiaCountries() {
        super();
    }
    /**
     *
     * @param countryTerrain
     * @param countryCode
     * @param countryName
     * @param totalArea
     */
    public EastAsiaCountries(String countryTerrain, String countryCode, String countryName, double totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }
    @Override
    //to display CountryTerrain
    public void display() {
        System.out.printf("%-20s%-20s%-20s%-20s\n", countryCode, countryName, totalArea, countryTerrain);
    }

}
