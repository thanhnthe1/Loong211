/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0074;

/**
 *
 * @author Nam
 */
public class LAB211_B1_J1SP0074 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MatrixesManagement manage = new MatrixesManagement();
        int choice = 0;
        do {
            //Step 1: Display a menu
            manage.displayMenu();
            //Step 2: User choice option
            choice = manage.choiceOption();
            switch (choice) {
                case 1: {
                    //Step 3: Option 1 -> Addition matrixes
                    manage.additionMatrixes();
                    break;
                }
                case 2: {
                    //Step 4: Option 2 -> Subtraction matrixes
                    manage.subtractionMatrixes();
                    break;
                }
                case 3: {
                    //Step 5: Option 3 -> Multiplication matrixes
                    manage.multiplicationMatrixes();
                    break;
                }
                case 4: {
                    //Step 6: Option 4 -> Exit program
                    manage.exitProgram();
                    break;
                }
            }
        } while (choice != 4);
    }
    
}
