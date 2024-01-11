/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FruitShop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author vinh2
 */
public class Main23 {
        public static void main(String[] args) throws IOException {
        ArrayList<Fruit> listFruit = new ArrayList<>();
            Hashtable<StringBuilder, Order> ht = new Hashtable<>();
        FruitShopManagement sManage = new FruitShopManagement();
        while (true){
            sManage.menu();
            int option = Validation.getIntInRange(1, 4, "Enter your option: ");
            switch(option){
                case 1:
                    //create or add more fruit in storage
                    listFruit = sManage.createFruit(listFruit);
                    break;
                case 2:
                    //view order of customer
                    sManage.viewOrder(ht);
                    break;
                case 3:
                    //customer go to buy fruit
                    sManage.shopping(listFruit,ht);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
