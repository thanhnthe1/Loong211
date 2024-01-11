/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0052;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nam
 */
public class CheckValue {
    //check string is character
    public boolean checkCharacter(String id) {
        //limit string is only character
        String regex = "[a-z]+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(id);
        //check id and pattern matches and id isn't empty 
        if (matcher.matches() && !id.isEmpty()) {
            return true;
        }
        return false;
    }
    
    //check string is character and space
    public boolean checkWords(String name) {
        //limit string is character and space
        String regex = "[a-z\\s]+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        //check name and pattern matches and name isn't empty
        
        if (matcher.matches() && !(name.isEmpty())) {
            return true;
        }
        return false;
    }

    //check duplicate of two country
    public boolean checkDuplicatedCountry(ArrayList<EastAsiaCountries> listEastAsiaCountrys,
            String EnterdCode) {
        //Run from first country to last country
        for (EastAsiaCountries country : listEastAsiaCountrys) {
            //Check each attribute equals with entered country
            if (equalsOfAttributeCountry(country,EnterdCode )) {
                return true;
            }
        }
        return false;
    }

    //compare infomation of two country
    private boolean equalsOfAttributeCountry(EastAsiaCountries country1,
            String EnterdCode) {
        //Check each attribute equals so return true (if not return false)
        if ((country1.getCountryCode().trim()).compareToIgnoreCase(EnterdCode.trim()) == 0) {
            return true;
        }
        return false;
    }
    
    
}
