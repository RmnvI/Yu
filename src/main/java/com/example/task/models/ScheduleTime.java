package com.example.task.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class ScheduleTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Time startTime;
    private Time endTime;

    public ScheduleTime(long id, Time startTime, Time endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public ScheduleTime() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "ScheduleTime{" +
                "Id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
