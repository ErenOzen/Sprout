package com.example.sprout.model;

import java.time.LocalDateTime;
import java.util.Arrays;

//There can be a design flaw we are not sure yet
public class Event {

    private String name;
    private LocalDateTime time;
    private String[] eventType;

    public Event(String name, LocalDateTime time, String[] eventType) {
        this.name = name;
        this.time = time;
        this.eventType = eventType;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", eventType=" + Arrays.toString(eventType) +
                '}';
    }
}
