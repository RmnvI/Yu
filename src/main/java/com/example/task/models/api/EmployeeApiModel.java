package com.example.task.models.api;

import java.sql.Date;
import java.sql.Time;

public class EmployeeApiModel {
    private String firstName;
    private String lastName;
    private String startTime;
    private String endTime;

    public EmployeeApiModel(String firstName, String lastName, String startTime, String endTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public EmployeeApiModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
