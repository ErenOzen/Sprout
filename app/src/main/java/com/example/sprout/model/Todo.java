package com.example.sprout.model;

import java.util.ArrayList;

public class Todo {
    private ArrayList<TodoTask> tasks;

    @Override
    public String toString() {
        return "Todo{" +
                "tasks=" + tasks +
                '}';
    }

    public Todo(ArrayList<TodoTask> tasks) {
        this.tasks = tasks;
    }

    //to-do
    public void sortTask() {

    }
}
