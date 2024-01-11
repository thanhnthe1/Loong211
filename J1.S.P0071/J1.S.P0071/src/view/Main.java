/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author kidzd
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        while (true) {
            displayMenu();
            int option = GetInput.getInt("Option: ", "Invalid", 1, 4);

            switch (option) {
                //input Task properties
                case 1:
                   view.inputTask();
                    break;
               //delete Task     
                case 2:
                    view.deleteTask();
                    break;
                //display Task    
                case 3:
                    view.displayTask();
                    break;
                // Exit program    
                case 4:
                    System.exit(0);
                    break;

            }

        }
    }

    private static void displayMenu() {
        System.out.println("========= Task program =========\n"
                + "1.	Add Task\n"
                + "2.	Delete task\n"
                + "3.	Display Task\n"
                + "4.	Exit");
    }
    
}
