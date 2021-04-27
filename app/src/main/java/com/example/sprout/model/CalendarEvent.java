package com.example.sprout.model;

import java.time.LocalDateTime;

public class CalendarEvent {
    private String title;
    private String description;
    private LocalDateTime time;

    @Override
    public String toString() {
        return "CalendarEvent{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                '}';
    }

    public CalendarEvent(String title, String description, LocalDateTime time) {
        this.title = title;
        this.description = description;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
