/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0011;

import java.math.BigInteger;
import java.util.HashMap;

/**
 *
 * @author Nam
 */
public class Convert {
    //Input datatpye you will enter
    public int inputBaseIn(Validate input) {
        return input.baseNumber("1.Binary(BIN)\n2.Decimal(DEC)\n3.Hexadecimal(HEX)\nYou want convert from: ");
    }
    
    //Input datatype you want convert to
    public int inputBaseOut(Validate input, int baseIn) {
        //Run until number out is diffirent with number in so out loop
        do {
            int baseOut = input.baseNumber("You want convert to: ");
            //two type is same then warning
            if (baseOut == baseIn) {
                System.out.println("You are converting the same data type!");
            } else {
                return baseOut;
            }
        } while (true);
    }

    // input data to convert
    public String inputValueIn(Validate input, int baseIn) {
        String valueIn = "";
        switch (baseIn) {
            case 1:
                valueIn = input.binaryNumber("Enter value to convert: ");
                break;
            case 2:
                valueIn = input.decimalNumber("Enter value to convert: ");
                break;
            case 3:
                valueIn = input.hexadecimalNumber("Enter value to convert: ");
                break;
        }
        return valueIn;
    }

    //convert based on value input
    public String convertNumber(int input, int out, String valueIn) {
        HashMap<BigInteger, String> numConvertChar = new HashMap<>();
        numConvertChar = putNumberToChar(numConvertChar);
        HashMap<String, BigInteger> charConvertNum = new HashMap<>();
        charConvertNum = putCharToNumber(charConvertNum);
        String valueOut = "";
        //Binary to decimal
        if (input == 1 && out == 2) {
            valueOut = binaryConvertDecimal(valueIn);
        }
        //Binary to hexadecimal
        else if (input == 1 && out == 3) {
            valueOut = binaryConvertDecimal(valueIn);
            valueOut = decimalToHexa(valueOut, numConvertChar);
        }
        //Decimal to binary
        else if (input == 2 && out == 1) {
            valueOut = decimalToBinary(valueIn);
        }
        //Decimal to hexadecimal
        else if (input == 2 && out == 3) {
            valueOut = decimalToHexa(valueIn, numConvertChar);
        }
        //Hexadecimal to binary
        else if (input == 3 && out == 1) {
            valueOut = hexaToDecimal(valueIn, charConvertNum);
            valueOut = decimalToBinary(valueOut);
        }
        //Hexadecimal to decimal
        else if (input == 3 && out == 2) {
            valueOut = hexaToDecimal(valueIn, charConvertNum);
        }
        return valueOut;
    }

    //set hashmap values accordingly to convert from number to char
    private HashMap<BigInteger, String> putNumberToChar(HashMap<BigInteger, String> convert) {
        //set value from 0 to 9 when convert
        for(int i=0;i<10;i++){
            convert.put(new BigInteger(String.valueOf(i)), String.valueOf(i));
        }
        String [] a = {"A","B","C","D","E","F"};
        
        //set value from 10 to 15 when convert
        for(int j=0;j<=5;j++){
            convert.put(new BigInteger("1"+String.valueOf(j)), a[j]);
        }
        return convert;
    }

    //set hashmap values accordingly to convert from char to number
    private HashMap<String, BigInteger> putCharToNumber(HashMap<String, BigInteger> convert) {
        //set value from 0 to 9 when convert
        for(int i=0;i<10;i++){
            convert.put(String.valueOf(i),new BigInteger(String.valueOf(i)) );
        }
        String [] a = {"A","B","C","D","E","F"};
        //set value from A to F when convert
        for(int j=0;j<=5;j++){
            convert.put( a[j] , new BigInteger("1"+String.valueOf(j)));
        }
        return convert;
    }

    //convert from binary to decimal
    private String binaryConvertDecimal(String valueIn) {
        BigInteger decimal = BigInteger.ZERO;
        BigInteger n = BigInteger.ZERO;
        BigInteger value = new BigInteger(valueIn);
        //Run until inputed value equals 0 so stop
        while (!value.equals(BigInteger.ZERO)) {
            //Inputed value divide for 10
            BigInteger[] newValues = value.divideAndRemainder(BigInteger.TEN);
            value = newValues[0];
            BigInteger remainder = newValues[1];

            BigInteger decimalPow = pow(new BigInteger("2"), n);
            n = n.add(BigInteger.ONE);
            
            BigInteger decimalMul = decimalPow.multiply(remainder);

            decimal = decimal.add(decimalMul);

        }
        return decimal.toString();
    }

    // covert from decimal to binary
    private String decimalToBinary(String valueIn) {
        String remainders = "";
        BigInteger value = new BigInteger(valueIn);
        //Run until inputed value equals 0 so stop
        while (!value.equals(BigInteger.ZERO)) {
            //Inputed value divide for 2
            BigInteger[] newValues = value.divideAndRemainder(new BigInteger("2"));
            value = newValues[0];
            BigInteger remainder = newValues[1];

            remainders += remainder.toString();
        }
        String valueOut = "";
        //Run from tail character to first character of string
        for (int i = remainders.length() - 1; i >= 0; i--) {
            valueOut += remainders.charAt(i) + "";
        }
        return valueOut;
    }

    //convert from decimal to hexa
    private String decimalToHexa(String valueIn, HashMap<BigInteger, String> convert) {
        String remainders = "";
        BigInteger value = new BigInteger(valueIn);
        //Run until inputed value equals 0 so stop
        while (!value.equals(BigInteger.ZERO)) {
            //Inputed value divide for 16
            BigInteger[] newValues = value.divideAndRemainder(new BigInteger("16"));
            value = newValues[0];
            BigInteger remainder = newValues[1];
            
            remainders += convert.get(remainder);
        }
        String valueOut = "";
        //Run from tail character to first character of string
        for (int i = remainders.length() - 1; i >= 0; i--) {
            valueOut += remainders.charAt(i) + "";
        }
        return valueOut;
    }

    //convert from hexa to decimal
    private String hexaToDecimal(String valueIn, HashMap<String, BigInteger> convert) {
        BigInteger decimal = BigInteger.ZERO;
        BigInteger n = BigInteger.ZERO;
        //Run from tail character to first character of string
        for (int i = valueIn.length() - 1; i >= 0; i--) {
            BigInteger valueHex = convert.get(valueIn.charAt(i) + "");
            BigInteger decimalPow = pow(new BigInteger("16"), n);
            n = n.add(BigInteger.ONE);
            
            BigInteger decimalMul = decimalPow.multiply(valueHex);
            
            decimal = decimal.add(decimalMul);
        }
        return decimal.toString();
    }
    
    private BigInteger pow(BigInteger base, BigInteger exponent) {
        BigInteger result = BigInteger.ONE;
        //Run until exponent equals 0 so out loop
        while (!exponent.equals(BigInteger.ZERO)) {
            result = result.multiply(base);
            exponent = exponent.subtract(new BigInteger("1"));
        }
        return result;
    }

    public void displayOutputValue(String valueOut) {
        System.out.println("After convert: " + valueOut);
    }

    public String wantToCoutinue(Validate input) {
        return input.yesOrNo("Do you want to continue(Y/N): ");
    }
}
