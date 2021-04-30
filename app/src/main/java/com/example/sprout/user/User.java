package com.example.sprout.user;

import com.example.sprout.model.CalendarEvent;
import com.example.sprout.model.Habits;
import com.example.sprout.model.Timeline;
import com.example.sprout.model.Todo;

import java.util.ArrayList;

/**
 * This is the core class for the user.
 * @author DilayYigit, Eren Ozen
 * @version 30 April 2021
 */
public class User {

    //Instance variables
    private String email;
    private String password;
    private Timeline timeline;
    private Todo todos;
    private Habits habits;
    private ArrayList<CalendarEvent> CalendarEvent;
    // forest (in some form)
    // calendar event is not working

    //Constructor
    public User(String email, String password, Timeline timeline, ArrayList<com.example.sprout.model.CalendarEvent> calendarEvent) {
        this.email = email;
        this.password = password;
        this.timeline = new Timeline();
        this.todos = new Todo();
        this.habits = new Habits();
        CalendarEvent = calendarEvent;
    }

    /**
     * Getter method for email of user
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for the email of user
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for user's password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for user's password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", timeline=" + timeline +
                ", todos=" + todos +
                ", habits=" + habits +
                ", CalendarEvent=" + CalendarEvent +
                '}';
    }
}
