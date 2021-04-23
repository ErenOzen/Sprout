package src.user;

import java.sql.Time;
import java.util.ArrayList;

import src.model.CalendarEvent;
import src.model.Habit;
import src.model.Timeline;
import src.model.Todo;

public class User {
    private String email;
    private String password;
    private Timeline timeline;
    private Todo todos;
    private ArrayList<Habit> habits;
    private ArrayList<CalendarEvent> CalendarEvent;
    // forest (in some form)


    public User(String email, String password, Timeline timeline, Todo todos, ArrayList<Habit> habits, ArrayList<src.model.CalendarEvent> calendarEvent) {
        this.email = email;
        this.password = password;
        this.timeline = timeline;
        this.todos = todos;
        this.habits = habits;
        CalendarEvent = calendarEvent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

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
