/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Country {

    protected String countryCode;
    protected String countryName;
    protected double totalArea;
  //create a defaul country
    public Country() {
    }

    /**
     * create a country with parameter
     * @param countryCode
     * @param countryName
     * @param totalArea 
     */
    public Country(String countryCode, String countryName, double totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }
   /**
    * 
    * @return countryCode
    */
    public String getCountryCode() {
        return countryCode;
    }
/**
 * 
 * @param countryCode the countryCode to set
 */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
/**
    * 
    * @return countryName
    */
    public String getCountryName() {
        return countryName;
    }
/**
 * 
 * @param countryName the countryName to set
 */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
 /**
    * 
    * @return totalArea
    */
    public double getTotalArea() {
        return totalArea;
    }
/**
 * 
 * @param totalArea the totalArea to set
 */
    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }
    //to display Country Information
    public void display() {
        System.out.printf("%-20s%-20s%-20s",countryCode,countryName,totalArea);
    }

}