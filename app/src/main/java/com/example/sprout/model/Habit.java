package com.example.sprout.model;

import android.graphics.Color;

public class Habit {
    private String name;
    private int volume;
    private Color colors;

    public Habit(String name, int volume, Color colors) {
        this.name = name;
        this.volume = volume;
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "Habit{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", colors=" + colors +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Color getColors() {
        return colors;
    }

    public void setColors(Color colors) {
        this.colors = colors;
    }

    //to-do
    public void addRep() {

    }
}
