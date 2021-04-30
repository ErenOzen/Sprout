package com.example.sprout.model;

import android.graphics.Color;

/**
 * This class represent habits for user.
 * @author DilayYigit, Eren Ozen
 * @version 30 April 2021
 */

public class Habit {

    //Instance variables
    private String name;
    private int volume;
    private Color colors;

    //Constructor
    public Habit(String name, int volume, Color colors) {
        this.name = name;
        this.volume = volume;
        this.colors = colors;
    }

    /**
     * Getter method for habit's name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for habit's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for habit's volume
     * @return volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Setter method for habit's volume
     * @param volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Getter method for habit's color
     * @return
     */
    public Color getColors() {
        return colors;
    }

    /**
     * Setter method for habit's color
     * @param colors
     */
    public void setColors(Color colors) {
        this.colors = colors;
    }

    /**
     * This method increments volume of the habit by 1.
     */
    public void addRep() {
        volume++;
    }

    @Override
    public String toString() {
        return "Habit{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", colors=" + colors +
                '}';
    }
}
