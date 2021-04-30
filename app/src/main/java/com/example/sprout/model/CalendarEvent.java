package com.example.sprout.model;

import java.time.LocalDateTime;

/**
 * This class creates basic events for user's calendar.
 * @author DilayYigit, Eren Ozen
 * @version 30 April 2021
 */

public class CalendarEvent {

    //Instance variables
    private String title;
    private String description;
    private LocalDateTime time;

    //Constructor
    public CalendarEvent(String title, String description, LocalDateTime time) {
        this.title = title;
        this.description = description;
        this.time = time;
    }

    /**
     * Getter method for event title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for event title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter method for event description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for event description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CalendarEvent{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                '}';
    }
}
