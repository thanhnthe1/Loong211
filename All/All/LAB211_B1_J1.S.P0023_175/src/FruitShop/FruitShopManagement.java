/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FruitShop;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author vinh2
 */
public class FruitShopManagement {

    void menu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("    1. Create Fruit");
        System.out.println("    2. View orders");
        System.out.println("    3. Shopping (for buyer)");
        System.out.println("    4. Exit");
    }

    //create fruit
    ArrayList<Fruit> createFruit(ArrayList<Fruit> listFruit) throws IOException {
        String option = "y";
        while (option.equalsIgnoreCase("y")) {
            System.out.println("INPUT FRUIT.");
            int fruitID = Validation.getNonNagativeInt("Enter fruit ID: ");
            //if fruit is already in storage just add more
            if (isInList(listFruit, fruitID)) {
                //input quanlity
                int quanlity = Validation.getNonNagativeInt("Fruit's exist in shop, just enter quanlity: ");
                //add that quanlity into that fruit in storage
                listFruit = updateListFruits(listFruit, fruitID, quanlity);
            } //if fruit is not in list input fully information then add it into storage
            else {
                String fruitName = Validation.getNonEmptyString("Enter fruit name: ");
                String origin = Validation.getNonEmptyString("Enter origin: ");
                int quanlity = Validation.getNonNagativeInt("Enter quanlity: ");
                double price = Validation.getPositiveDouble("Enter price: ");
                //add to list fruit in storage
                listFruit.add(new Fruit(fruitID, fruitName, price, quanlity, origin));
            }
            //get option to continue or stop
            option = Validation.stopOrContinue("Do you want to continue (Y/N)? ");
            System.out.println("");
        }
        return listFruit;
    }

    //view orders of customer
    void viewOrder(Hashtable<StringBuilder, Order> ht) {
        //if there is no orders record in list notify for user and return main screen
        if (ht.isEmpty()) {
            System.out.println("There is no oreder in list.");
            return;
        }
        double total;
        System.out.println("VIEW ORDERS.");
        //traverse all element in list orders
        for (StringBuilder name : ht.keySet()) {
            Order Order = ht.get(name);
            total = 0;
            System.out.println("Customer: " + Order.getCustomer());
            System.out.println("  Product | Quantity | Price | Amount ");
            //traverse all all fruit that in orders of the customer
            ArrayList<Fruit> listFruit = Order.getFruitList();
            for (int j = 0; j < listFruit.size(); j++) {
                System.out.println((j + 1) + "." + listFruit.get(j).printToView());
                total += listFruit.get(j).getPrice() * listFruit.get(j).getQuanlity();
            }
            System.out.println("Total: " + total + "$");
            System.out.println("");
        }
    }

    //Shopping to buy product
    void shopping(ArrayList<Fruit> listFruit, Hashtable<StringBuilder, Order> ht) throws IOException {
        ArrayList<Order> listOrder = new ArrayList<>();
        Order order = new Order();
        //if no fruit in storage notify user and back to main screen
        if (listFruit.isEmpty() || isOutOfStock(listFruit)) {
            System.out.println("Have no fruit in shop, pls add more.");
            return;
        }
        System.out.println("SHOPPING");
        String option = "n";
        double total = 0;
        ArrayList<Fruit> buyFruits = new ArrayList<>();
        while (option.equalsIgnoreCase("n")) {
            //choose fruit in list and input quanlity to buy
            Fruit fruit = chosseToBuyFruit(listFruit);
            //update quanlity of that fruit in storage
            listFruit = updateListFruits(listFruit, fruit.getFruitID(), -fruit.getQuanlity());
            //if fruit is in that bill, just update more quanlity in that bill
            if (isOrdered(buyFruits, fruit.getFruitID())) {
                buyFruits = updateBuyList(buyFruits, fruit.getFruitID(), fruit.getQuanlity());
            } //if fruit is not in bill add new fruit order in that bill except fruit quanlity in that order =0.
            else {
                if (fruit.getQuanlity() == 0) {
                    continue;
                } else {
                    buyFruits.add(fruit);
                }
            }
            //enter y/n to know customer wanna order or not yet
            option = Validation.stopOrContinue("Do you want to order now (Y/N): ");
            System.out.println("");
        }
        System.out.println("Product | Quantity | Price | Amount");
        //traverse all orders in that bill after bought fruit finished
        for (Fruit f : buyFruits) {
            System.out.println(f.printToView());
            total += f.getPrice() * f.getQuanlity();
        }
        System.out.println("Total: " + total + "$");
        //Enter name of customer
        String customer = Validation.getNonEmptyString("Input your name: ");
        order = new Order(customer, buyFruits);
        //add it into list order of customers
        ht.put(new StringBuilder(), order);
    }

    //choose fruit in storage and input quanlity to buy
    private Fruit chosseToBuyFruit(ArrayList<Fruit> listFruit) throws IOException {
        System.out.println("List of fruit: ");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        //traverse all to print out all fruits in storage
        for (int i = 0; i < listFruit.size(); i++) {
            System.out.printf("     %-13s", i + 1 + "");
            System.out.println(listFruit.get(i).printToShoping());
        }
        //select fruit wanna buy
        int option = Validation.getIntInRange(1, listFruit.size(), "Select an option: ") - 1;
        int fruitID = listFruit.get(option).getFruitID();
        String fruitName = listFruit.get(option).getFruitName();
        System.out.println("You selected: " + fruitName);
        int quanlity = 0;
        //if quanlity in storage =0, customer cannot buy that fruit
        if (listFruit.get(option).getQuanlity() == 0) {
            System.out.println("There is no " + fruitName + " left in the shop.");
        } //if fruit remaining is shop >0, customer will input quanlity to buy
        else {
            quanlity = Validation.getIntInRange(0, listFruit.get(option).getQuanlity(), "Please input quantity: ");
        }
        double price = listFruit.get(option).getPrice();
        String Origin = listFruit.get(option).getOrigin();
        Fruit fruit = new Fruit(fruitID, fruitName, price, quanlity, Origin);
        return fruit;
    }

    //check if fruit is in storage
    private boolean isInList(ArrayList<Fruit> listFruit, int fruitID) {
        for (Fruit fruit : listFruit) {
            if (fruit.getFruitID() == fruitID) {
                return true;
            }
        }
        return false;
    }

    //update quanlity of fruit in list after buy or add more
    private ArrayList<Fruit> updateListFruits(ArrayList<Fruit> listFruit, int fruitID, int quanlity) {
        for (Fruit fruit : listFruit) {
            if (fruit.getFruitID() == fruitID) {
                fruit.setQuanlity(fruit.getQuanlity() + quanlity);
            }
        }
        return listFruit;
    }

    //check if customer is order that fruit
    private boolean isOrdered(ArrayList<Fruit> buyFruits, int fruitID) {
        for (Fruit fruit : buyFruits) {
            if (fruit.getFruitID() == fruitID) {
                return true;
            }
        }
        return false;
    }

    //update quanlity of fruit in bill
    private ArrayList<Fruit> updateBuyList(ArrayList<Fruit> buyFruits, int fruitID, int quanlity) {
        for (Fruit fruit : buyFruits) {
            if (fruit.getFruitID() == fruitID) {
                fruit.setQuanlity(fruit.getQuanlity() + quanlity);
            }
        }
        return buyFruits;
    }

    //check if there is nothing in storage
    private boolean isOutOfStock(ArrayList<Fruit> listFruit) {
        for (Fruit fruit : listFruit) {
            if (fruit.getQuanlity() > 0) {
                return false;
            }
        }
        return true;
    }
}
