package com.example.sprout.model;

public class TodoTask {
    private String name;
    private boolean done;

    public TodoTask(String name, boolean done) {
        this.name = name;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

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
