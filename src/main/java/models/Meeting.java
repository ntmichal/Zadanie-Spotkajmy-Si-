package models;

import java.time.LocalTime;

public class Meeting implements Comparable{

    private LocalTime start;

    private LocalTime end;

    public Meeting(){}
    public Meeting(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalTime getStart() {
        return start;
    }

    public Meeting setStart(LocalTime start) {
        this.start = start;
        return this;
    }

    public LocalTime getEnd() {
        return end;
    }

    public Meeting setEnd(LocalTime end) {
        this.end = end;
        return this;
    }

    @Override
    public int compareTo(Object o) {
        return start.compareTo((LocalTime)o);
    }

    @Override
    public String toString() {
        return "[\""+getStart() +"\", \"" + getEnd() + "\"]";
    }

}
