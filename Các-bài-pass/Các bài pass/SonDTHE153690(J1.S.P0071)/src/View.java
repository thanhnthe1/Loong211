
import java.text.ParseException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author doson
 */
public class View {

    Scanner sc = new Scanner(System.in);
    Controller c;
    Validation vl = new Validation();

    public View(Controller c) {
        this.c = c;
    }
    
    /**
     * Function add task
     * @throws ParseException 
     */
    public void addTask() throws ParseException {
        String ans = "";
        while (!ans.equalsIgnoreCase("N")) {
            System.out.println("ID:" + c.inputId()); // Display next id in list
            System.out.print("Enter Task TypeID: ");
            String taskTypeId = vl.inputTaskTypeId(); // Enter number of task type id
            System.out.print("Enter Requirement Name: ");
            String requirement = vl.inputString(); // Enter requiremen name
            System.out.print("Enter Date(dd-MM-yyyy): ");
            String date = vl.inputDate(); // Enter date
            System.out.print("Plan From: ");
            double planFrom = vl.inputPlanFrom(); // Enter plan from
            System.out.print("Plan To: ");
            double planTo = vl.inputPlanTo(planFrom); // Enter plan to
            System.out.print("Enter Assignee: ");
            String assignee = vl.inputString(); // enter Assignee
            System.out.print("Enter Reviewer: ");
            String review = vl.inputString(); // enter Assignee
            if (c.checkDuplicateTask(taskTypeId, requirement, date, planFrom, planTo, assignee, review) == false) { // If there isn't a task with all of the above values, it will add
                c.addTask(taskTypeId, requirement, date, planFrom, planTo, assignee, review);
                System.out.print("Do you want add task (Y - N): ");
                ans = vl.Ans_Add();
            } else { // If task existed then enter again.
                System.err.println("Task was existed,Re-enter: ");
            }
        }
    }
    
    /**
     * Function delete Task
     */
    public void deleteTask() {
        if (c.getAllListTask().isEmpty()) {
            System.out.println("List is empty!!!");
        } else {
            while (true) {
                int id;
                System.out.print("Enter ID you want delete:");
                id = vl.inputNumberOfRange(1, Integer.MAX_VALUE);
                // If id not exist then enter again
                if (c.existanceId(id) == -1) {
                    System.out.print("Id does not exist, re-enter:");
                } 
                // If id exist then delete
                else {
                    c.deleteTask(id);
                    break;
                }
            }
            System.out.println("Delete successful....");
        }
    }
    
    /**
     * Function show Task
     */
    public void showTask(){
        if (c.getAllListTask().isEmpty()) {
            System.out.println("List is empty!!!");
        }
        else{
            c.getDataTasks();
            System.out.printf("%-3s  %-15s  %-10s  %-10s  %-5s  %-8s  %-7s\n",
                    "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            for (Task List1 : c.getAllListTask()) {
                System.out.printf("%-3s  %-15s  %-10s  %-10s  %-5.2f  %-8s  %-7s\n",
                        List1.getId(), List1.getRequirementName(), List1.getTaskTypeId(), List1.getDate(),
                        List1.getPlanTo() - List1.getPlanFrom(), List1.getAssignee(), List1.getReviewer());
            }
        }
    }
}
