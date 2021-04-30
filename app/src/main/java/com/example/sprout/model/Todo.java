package com.example.sprout.model;

import java.util.ArrayList;

/**
 * This class creates to-do list from to-do objects.
 * @author DilayYigit, Eren Ozen
 * @version 30 April 2021
 */
public class Todo {

    //Instance Variables
    private ArrayList<TodoTask> tasks;

    //Constructor
    public Todo() {
        tasks = new ArrayList<TodoTask>();
    }

    /**
     * This method add an to-do to user's to-do list
     *
     * @param t
     */
    public void addTask(TodoTask t) {
        tasks.add(t);
    }

    /**
     * This methods clear the array list, so user's to-do list
     */
    public void clearTodo() {
        tasks.clear();
    }

    /*To-do
    /**
     * This method sorts tasks by alphabetic order
     */
    /*
    public void sortTask() {
        for (TodoTask t : tasks) {
            String name = t.getName();

        }
        Collections.sort(tasks);
    }
    */

    @Override
    public String toString() {
        String output = "To-do Tasks: ";
        for (TodoTask i : tasks) {
            output += i.toString() + "\n";
        }
        return output;
    }
}
