package com.example.sprout.model;

import java.util.ArrayList;

/**
 * This class represents user's timeline. This timeline
 * will store events and represent this storage for the graphs
 * @author DilayYigit, Eren Ozen
 * @version 30 April 2021
 */
public class Timeline {

    //Instance Variables
    private ArrayList<Event> events;

    //Constructor
    public Timeline() {
        events = new ArrayList<Event>();
    }

    /**
     * This methods clear the array list, so user's timeline
     */
    public void resetTimeline() {
        events.clear();
    }

    /**
     * This method add an event to user's timeline
     * @param event
     */
    public void addEvent(Event event) {
        events.add(event);
    }

    @Override
    public String toString() {
        return "Timeline{" +
                "events=" + events +
                '}';
    }

}
