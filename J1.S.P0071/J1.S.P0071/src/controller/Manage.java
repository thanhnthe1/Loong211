/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Task;

/**
 *
 * @author kidzd
 */
public class Manage {
  
    //create list task
    List<Task> listTask = new ArrayList<>();
 
    //get list task
    public List<Task> getListTask() {
        return listTask;
    }
   
    //use to ask task
    public int addTask(String requirementName, int taskType, String date, String assignee, String reviewer, double planFrom, double planTo) {
        //check duplicate
        if (checkDuplicate(requirementName, taskType, date, assignee, reviewer, planFrom, planTo)) {
            return 0;
        } else {
            //create instance
            Task task = new Task(taskType, requirementName, date, assignee, reviewer, planFrom, planTo);
            listTask.add(task);
            return task.getId();
        }

    }
//to check duplicate
    private boolean checkDuplicate(String requirementName, int taskType, String date, String assignee, String reviewer, double planFrom, double planTo) {
        for (Task task : listTask) {
            if (task.getDate().equalsIgnoreCase(date)
                    && task.getAssignee().equalsIgnoreCase(assignee)
                    && task.getName().equalsIgnoreCase(requirementName)
                    && task.getReviewer().equalsIgnoreCase(reviewer)
                    && task.getFrom() == (planFrom)
                    && task.getTo() == (planTo)
                    && task.getTypeTask() == (taskType)) {
                return true;
            }
        }
        return false;
    }
    //remove task
    public void removeTask(Task task) {
        listTask.remove(task);
    }
    
    //get task by ID
    public Task getTaskByID(int id) {
        for (Task task : listTask) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

}
