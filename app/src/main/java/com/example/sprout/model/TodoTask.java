package com.example.sprout.model;

/**
 * This class represent one to-do task.
 * @author DilayYigit, ErenOzen
 * @version 30 April 2021
 */
public class TodoTask {

    //Instance variables
    private String name;
    private boolean done;

    //Constructor
    public TodoTask(String name, boolean done) {
        this.name = name;
        this.done = done;
    }

    /**
     * Getter method for to-do task name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for to-do task name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for whether the to-do task is done or not
     * @return done
     */
    public boolean getDone() {
        return done;
    }

    /**
     * Setter method for whether the to-do task is done or not
     * @param done
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TodoTask{" +
                "name='" + name + '\'' +
                ", done=" + done +
                '}';
    }
}
