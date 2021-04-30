package com.example.sprout.model;

import java.util.ArrayList;

/**
 * This class creates Habit list for the user.
 * @author DilayYigit, Eren Ozen
 * @version 30 April 2021
 */

public class Habits {

    //Instance Variables
    private ArrayList<Habit> habits;

    //Constructor
    public Habits() {
        habits = new ArrayList<Habit>();
    }

    /**
     * This method add an habit to user's habit list
     *
     * @param t
     */
    public void addHabit(Habit t) {
        habits.add(t);
    }

    /**
     * This methods clear the array list, so user's habit list
     */
    public void clearHabits() {
        habits.clear();
    }

    @Override
    public String toString() {
        String output = "Habits = ";
        for (Habit i : habits) {
            output += i.toString() + "\n";
        }
        return output;
    }
}
