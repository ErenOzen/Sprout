package com.example.sprout.model;

import java.util.ArrayList;

public class Timeline {
    private ArrayList<Event> events;

    //to-do
    public void resetTimeline() {

    }

    @Override
    public String toString() {
        return "Timeline{" +
                "events=" + events +
                '}';
    }

    public Timeline(ArrayList<Event> events) {
        this.events = events;
    }
}
