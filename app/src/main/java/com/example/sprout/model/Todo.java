package com.example.sprout.model;

/**
 * This class creates to-do list from to-do objects.
 * @author DilayYigit, Eren Ozen
 * @version 30 April 2021
 */
public class Todo {
    private int id, status;
    private String task;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
