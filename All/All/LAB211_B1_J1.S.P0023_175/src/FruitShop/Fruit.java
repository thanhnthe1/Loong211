/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FruitShop;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 *
 * @author vinh2
 */
public class Fruit {

    private int fruitID;
    private String fruitName;
    private double price;
    private int quanlity;
    private String origin;

    public Fruit() {
    }

    public Fruit(int fruitID, String fruitName, double price, int quanlity, String origin) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quanlity = quanlity;
        this.origin = origin;
    }

    public int getFruitID() {
        return fruitID;
    }

    public void setFruitID(int fruitID) {
        this.fruitID = fruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    String printToView() {
        double amount = price * quanlity;
        return String.format("%-10s%-11s%-8s%s", fruitName, quanlity + "", price + "$", amount + "$");
    }

    String printToShoping() {
        return String.format("%-19s%-15s%s", fruitName, origin, price + "$");
    }

}
