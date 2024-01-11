

import java.text.ParseException;
import java.time.Year;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doson
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Check_Input check = new Check_Input();
        View_User view = new View_User();
        //Method method = new Method();
        view.method.addEmployee(new Employee("A", "Do", "Son", "0985384347", "doson6411@gmail.com", "Son La", "20-09-2001", "Male", 2000, "IT"));
        view.method.addEmployee(new Employee("B", "Hoang", "Kien", "0344025802", "hoangkien@gmail.com", "Son La", "20-09-2001", "Male", 5000, "IT"));
        int option;
        while(true){
            System.out.println("Main menu:\n" +
                           "       1. Add employees \n" +
                           "       2. Update employees\n" +
                           "       3. Remove employees\n" +
                           "       4. Search employees\n" +
                           "       5. Sort employees by salary\n" +
                           "       6. Exit");
            while(true){
                System.out.print("Select a option: ");
                option = check.Input_Int();
                if(option>6 || option<1){
                    System.out.print("Option from 1->6. Enter again: ");
                }
                else{
                    break;
                }
            }
            switch(option){
                case 1:
                    view.Add();break;
                case 2:
                    view.Update();break;
                case 3:
                    view.Remove();break;
                case 4:
                    view.Search();break;
                case 5:
                    view.Sort();break;
            }
            if(option==6){
                System.out.println("Exit program!!!");
                break;
            }
        }    
    }
}
