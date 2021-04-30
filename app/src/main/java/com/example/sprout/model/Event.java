package com.example.sprout.model;

import java.time.LocalDateTime;

/**
 * This class creates events for user's daily activities.
 * Events have 6 default event types and a time property.
 * @author DilayYigit, Eren Ozen
 * @version 30 April 2021
 */

//There can be a design flaw we are not sure still*
public class Event {

    //Instance variables
    private String name;
    private LocalDateTime time;
    private final String[] eventTypes = {"Entertainment" , "Socializing" , "Work" , "Study", "Sport" , "Unknown"};
    private String eventType;

    //Constructor
    public Event(String name, LocalDateTime time, int eventTypeNum) {
        this.name = name;
        this.time = time;
        eventTypes[eventTypeNum] = eventType;
    }

    /**
     * Getter method for event's name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for events time
     * !This method will be updated
     * @return time
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     * Setter method for events time
     * !This method will be updated
     *
     * @param time
     */
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    /**
     * Getter method for event type
     * @return eventType
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Setter method for event type
     * @param eventType
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", eventType=" + eventType +
                '}';
    }
}
