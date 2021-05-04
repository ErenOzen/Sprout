package com.example.sprout;

public class ReportDatas {
    String dates;
    int activityTime;

    public ReportDatas (String dates, int activityTime) {
        this.activityTime = activityTime;
        this.dates = dates;
    }
    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public int getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(int activityTime) {
        this.activityTime = activityTime;
    }
}
