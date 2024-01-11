/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FruitShop;

import java.util.ArrayList;

/**
 *
 * @author vinh2
 */
public class Order {

    private String customer;
    private ArrayList<Fruit> fruitList;

    public Order() {
        fruitList = new ArrayList<>();
    }

    public Order(String customer, ArrayList<Fruit> fruitList) {
        this.customer = customer;
        this.fruitList = fruitList;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    //addFruit
    public void addFruit(Fruit fruit) {
        int check = 0;
        for (Fruit f : fruitList) {
            if (f.getFruitID() == fruit.getFruitID()) {
                check = 1;
                f.setQuanlity(f.getQuanlity() + fruit.getQuanlity());
            }
        }
        if (check == 1) {
            if (fruit.getQuanlity() != 0) {
                fruitList.add(fruit);
            } 
            
        }
    }

    //total 
    public double total() {
        double total = 0;
        for (int i = 0; i < fruitList.size(); i++) {
            total += fruitList.get(i).getPrice() * fruitList.get(i).getQuanlity();
        }
        return total;
    }
}
