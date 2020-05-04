package models;

import java.time.LocalTime;

public class WorkingHours{

    private LocalTime start;

    private LocalTime end;

    public  WorkingHours(){}
    public WorkingHours(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalTime getStart() {
        return start;
    }

    public WorkingHours setStart(LocalTime start) {
        this.start = start;
        return this;
    }

    public LocalTime getEnd() {
        return end;
    }

    public WorkingHours setEnd(LocalTime end) {
        this.end = end;
        return this;
    }

    @Override
    public String toString() {
        return "working_hours: {\n\tstart: \""+getStart()+"\",\n\tend: \""+getEnd()+"\"\n}";
    }


}