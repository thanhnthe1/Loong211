
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doson
 */
public class Controller {
    private ArrayList<Task> list = new ArrayList<>();
    
    public Controller(){    
    }
    
    public Controller(ArrayList<Task> list){
        this.list = list;
    }
    
    /**
     * Function check the existence of id
     * @param id
     * @return int
     */
    public int existanceId(int id){
        for(int i =0; i<list.size();i++){
            //If id existance
            if(list.get(i).getId() == id){
                return i; 
            }
        }
        return -1; // If id not exist
    }
    
    /**
     * Return all element of list Task
     * @return list
     */
    public ArrayList<Task> getAllListTask(){
        return list;
    }
    
    /**
     * Function check duplicate of task
     * @param taskTypeID
     * @param requirementName
     * @param date
     * @param planFrom
     * @param planTo
     * @param assignee
     * @param reviewer
     * @return 
     */
    public boolean checkDuplicateTask(String taskTypeID, String requirementName, String date, 
            double planFrom, double planTo, String assignee, String reviewer){
        for(int i =0; i<list.size();i++){
            //If in list has task 
            if(list.get(i).getTaskTypeId().equalsIgnoreCase(taskTypeID) 
                    && list.get(i).getRequirementName().equalsIgnoreCase(requirementName) 
                    && list.get(i).getDate().equalsIgnoreCase(date)
                    && list.get(i).getPlanFrom() == planFrom
                    && list.get(i).getPlanTo() == planTo
                    && list.get(i).getAssignee().equalsIgnoreCase(assignee)
                    && list.get(i).getReviewer().equalsIgnoreCase(reviewer)){
                return true;
            }
        }
        return false; // If in list hasn't task
    }
    
    /**
     * Function auto up id
     * @return 
     */
    public int inputId(){
        int id;
        // If list is empty then id = 1
        if(list.isEmpty()){
            id = 1;
        }
        else{
            id = list.get(list.size()-1).getId() + 1; // id = last id of list + 1
        }
        return id;
    }
    
    /**
     * Function add Task
     * @param taskTypeID
     * @param requirementName
     * @param date
     * @param planFrom
     * @param planTo
     * @param assignee
     * @param reviewer 
     */
    public int addTask(String taskTypeID, String requirementName, String date, double planFrom, double planTo, String assignee, String reviewer){
        int id = inputId();
        list.add(new Task(id, taskTypeID, requirementName, date, planFrom, planTo, assignee, reviewer));
        return id;
    }
    
    /**
     * Function delete Task by id
     * @param id 
     */
    public void deleteTask(int id){
        list.remove(existanceId(id));
    }
    
    /**
     * Function display Task by sort id 
     */
    public void getDataTasks(){
        Collections.sort(getAllListTask(), new Comparator<Task>(){
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getId() - o2.getId();
            }
        });
    }
}
