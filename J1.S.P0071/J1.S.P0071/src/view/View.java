/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Manage;
import model.Task;

/**
 *
 * @author kidzd
 */
public class View {
    Manage manage = new Manage();
    void inputTask() {
         int taskType;
        String requirementName, date, assignee, reviewer;
        double planFrom, planTo;
        
        //user input information task
        requirementName = getRequirementName();
        taskType = getTaskType();
        date = getDate();
        planFrom = getPlanFrom();
        planTo = getPlanTo(planFrom);
        assignee = getAssignee();
        reviewer = getReviewer();
        
        
        //check duplicate
        int idTaskCreate = manage.addTask(requirementName, taskType, date, assignee, reviewer, planFrom, planTo);
        
        //if idTaskCreate == 0 => duplicate task and not add successful
        //else add successful
        if (idTaskCreate == 0) {
            System.out.println("Duplicate Task !!!");
        }else {
            System.out.println("Add successfull !! ");
        }
    }
    
     /**
     * this function use to input requirement name
     *
     * @return requirementName
     */
    private static String getRequirementName() {
        String requirementName = GetInput.getString("Requirement Name: ",
                "Name must be a string ", GetInput.REGEX_STRING);
        return requirementName;
    }

    /**
     * this function use to input taskType
     *
     * @return taskType
     */
    private static int getTaskType() {
        int taskType = GetInput.getInt("Task Type: ",
                "Task Type must be decimal integer and from 1 to 4 ! ", 1, 4);
        return taskType;
    }

    /**
     * this function use to input date
     *
     * @return date
     */
    private static String getDate() {
        String date = GetInput.getDate("Date: ", "Format must be"
                + " dd-MM-yyyy", "\\d{1,2}[-]\\d{1,2}[-]\\d{4}");
        return date;
    }

    /**
     * this function use to input planFrom
     *
     * @return planFrom
     */

    private static double getPlanFrom() {
        double planFrom = GetInput.getDouble("From: ", "From[8.0"
                + " - 17]", 8.0, 17);
        return planFrom;
    }

    /**
     * this function use to input planTo
     *
     * @return planTo
     */

    private static double getPlanTo(double planFrom) {
        double planTo = GetInput.getDouble("To: ", "To[" + (planFrom + 0.5)
                + " - 17.5]", (planFrom + 0.5), 17.5);
        return planTo;
    }

    /**
     * this function use to input assignee
     *
     * @return assignee
     */
    private static String getAssignee() {
        String assignee = GetInput.getString("Assignee: ",
                "Assignee must be a string ", "^[a-z A-Z]+$");
        return assignee;
    }

    /**
     * this function use to input reviewer
     *
     * @return reviewer
     */

    private static String getReviewer() {
        String reviewer = GetInput.getString("Reviewer: ",
                "Reviewer must be a string ", "^[a-z A-Z]+$");
        return reviewer;
    }
    
    /**
     * this function use to get id input from user
     * @return 
     */
    private int getID() {
        int id = GetInput.getInt("Enter ID: ", "Re-input ID", 0, Integer.MAX_VALUE);
        return  id;
    }
// search task by ID and Delete
    void deleteTask() {
        int id = getID();
        
        Task task = manage.getTaskByID(id);
        
        if (task == null) {
            System.out.println("Not found task !!");
        }else {
            manage.removeTask(task);
            System.out.println("Delete task successfull");
        }
        
    }
// use to display list task
    void displayTask() {
         if (manage.getListTask().size() == 0) {
            System.out.println("List Task is empty !");
            return;
        }
        System.out.printf("%-10s %-10s %-10s %-20s %-10s %-10s %-10s %-10s\n", "ID",
                "Name", "TaskType", "Date", "From", "To", "Assignee", "Reviewer");
        for (Task task : manage.getListTask()) {
            System.out.println(task);
        }
    }
    
}
