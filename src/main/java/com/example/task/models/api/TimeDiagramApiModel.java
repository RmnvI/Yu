package com.example.task.models.api;

public class TimeDiagramApiModel {
    private long count;
    private String startTime;
    private String endTime;

    public TimeDiagramApiModel(long count, String startTime, String endTime) {
        this.count = count;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
