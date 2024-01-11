
import java.text.ParseException;
import java.util.ArrayList;

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
        ArrayList<Task> L_task = new ArrayList<>();
        Controller c = new Controller(L_task);
        
        View v = new View(c);
        Validation val = new Validation();        
        
        L_task.add(new Task(1,"code","dev program","12-09-2018",9.0, 15.5, "dev", "Lead"));
        L_task.add(new Task(2,"test","dev program","11-10-2018",9.0, 14.5, "dev", "Lead"));
        L_task.add(new Task(3,"manager","dev program","15-06-2019",9.0, 17.5, "dev", "Lead"));
                    
        int option;
        while (true) {  
            System.out.println("------------------------");
            System.out.println("1.Add Task");
            System.out.println("2.Delete Task");
            System.out.println("3.Display all list task");
            System.out.println("4.Exit the program");
            System.out.println("-------------------------");
            System.out.print("Choose a option:");
            option = val.inputNumberOfRange(1, 4);
            switch (option) {
                case 1:
                    v.addTask();
                    break;
                case 2:
                    v.deleteTask();
                    break;
                case 3:
                    v.showTask();
                    break;
            }
            if(option==4){
                System.out.println("Exit program!!!");
                break;
            }
        }
    }
    }
