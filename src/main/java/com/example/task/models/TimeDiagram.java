package com.example.task.models;


import java.util.Date;

public class TimeDiagram {

    private long count;
    private Date start;
    private Date end;

    public TimeDiagram() {
    }

    public TimeDiagram(long count, Date start, Date end) {
        this.count = count;
        this.start = start;
        this.end = end;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
