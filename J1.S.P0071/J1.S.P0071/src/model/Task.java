/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kidzd
 */
public class Task {
    private static int index = 1;
    private int id, taskType;
    private String name, date, assignee, reviewer;
    private double from, to;

    /**
     * create a task with properties
     *
     * @param taskType
     * @param name
     * @param date
     * @param assignee
     * @param reviewer
     * @param from
     * @param to
     */
    public Task(int taskType, String name, String date, String assignee, String reviewer, double from, double to) {
        this.id = index++;
        this.taskType = taskType;
        this.name = name;
        this.date = date;
        this.assignee = assignee;
        this.reviewer = reviewer;
        this.from = from;
        this.to = to;
    }

    /**
     * create a default task
     */
    public Task() {
        this.id = index++;
    }
    /**
     * @return taskType
     */
    public int getTypeTask(){
        return taskType;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return taskType
     */
    public String getTaskType() {
        String result = null;
        switch (taskType) {
            case 1:
                result = "Code";
                break;
            case 2:
                result = "Test";
                break;
            case 3:
                result = "Design";
                break;
            case 4:
                result = "Reviewer";
                break;
        }
        return result;
    }

    /**
     * @param taskType to set
     */
    public void setTaskType(int taskType) throws Exception {
        if (taskType >= 1 && taskType <= 4) {
            this.taskType = taskType;
        } else {
            throw new Exception("Must choose from 1 - 4");
        }
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name to set
     */
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    /**
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date to set
     */
    public void setDate(String date) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date firstDate = dateFormat.parse(date);
            Date secondDate = new Date();

            if (firstDate.before(secondDate)) {
                throw new Exception("Must be greater than current date");
            } else {
                this.date = date;
            }

        } catch (ParseException ex) {
            throw new Exception("Must be greater than current date");
        }
    }

    /**
     * @return assignee
     */
    public String getAssignee() {
        return assignee;
    }

    /**
     * @param assignee to set
     */
    public void setAssignee(String assignee) {
        if (assignee != null) {
            this.assignee = assignee;
        }
    }

    /**
     * @return reviewer
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * @param reviewer to set
     */
    public void setReviewer(String reviewer) {
        if (reviewer != null) {
            this.reviewer = reviewer;
        }
    }

    /**
     * @return from
     */
    public double getFrom() {
        return from;
    }

    /**
     * @param from to set
     */
    public void setFrom(double from) throws Exception {
        if (from >= 8 && from <= 17) {
            this.from = from;
        } else {
            throw new Exception("Must be choose from 8 to 17");
        }
    }

    /**
     * @return to
     */
    public double getTo() {
        return to;
    }

    /**
     * @param to to set
     */
    public void setTo(double to) throws Exception {
        if (to > 8 && to <= 17.5) {
            this.to = to;
        } else {
            throw new Exception("Must be choose from 8 to 17.5");
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s %-20s %-10s %-10s %-10s %-10s", id, name,
                getTaskType(), date, from, to, assignee, reviewer);
    }
}

