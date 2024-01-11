/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0052;

/**
 *
 * @author Nam
 */
public class EastAsiaCountries extends Country{
    private String countryTerrain;

    public EastAsiaCountries(String countryCode, String countryName, float totalArea,String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }
    
    

    @Override
    public void display(){
        super.display();
        System.out.printf("%-20s\n",countryTerrain);
    }
    
    
}
