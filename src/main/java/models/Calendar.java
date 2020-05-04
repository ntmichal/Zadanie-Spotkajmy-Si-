package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    @JsonProperty("working_hours")
    private WorkingHours workingHours;

    @JsonProperty("planned_meetings")
    private List<Meeting> meetings = new ArrayList<>();

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public Calendar setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
        return this;
    }

    public void addMeeting(Meeting meeting){
        meetings.add(meeting);
    }

    @Override
    public String toString() {
        return "{\n" + workingHours +",\nplanned_meeting:" + meetings + "\n}";
    }


}
