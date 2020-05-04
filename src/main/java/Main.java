import models.Calendar;
import models.Meeting;
import models.WorkingHours;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {

        Calendar calendarEmployee1 = new Calendar();
        calendarEmployee1.setWorkingHours(new WorkingHours(LocalTime.of(9,00),LocalTime.of(20,00)));
        calendarEmployee1.addMeeting(new Meeting(LocalTime.of(9,00),LocalTime.of(10,30)));
        calendarEmployee1.addMeeting(new Meeting(LocalTime.of(12,00),LocalTime.of(13,00)));
        calendarEmployee1.addMeeting(new Meeting(LocalTime.of(16,00),LocalTime.of(18,30)));

        Calendar calendarEmployee2 = new Calendar();
        calendarEmployee2.setWorkingHours(new WorkingHours(LocalTime.of(10,00),LocalTime.of(18,30)));
        calendarEmployee2.addMeeting(new Meeting(LocalTime.of(10,00),LocalTime.of(11,30)));
        calendarEmployee2.addMeeting(new Meeting(LocalTime.of(12,30),LocalTime.of(14,30)));
        calendarEmployee2.addMeeting(new Meeting(LocalTime.of(14,30),LocalTime.of(15,00)));
        calendarEmployee2.addMeeting(new Meeting(LocalTime.of(16,00),LocalTime.of(17,00)));


//        Calendar calendarEmployee1 = JSON.readCalendar("calendar1");
//        Calendar calendarEmployee2 = JSON.readCalendar("calendar2");


        List<Meeting> output = MeetingAlgorithm.timeIntervals(calendarEmployee1, calendarEmployee2, "00:30");
        System.out.println(output.toString());

//        JSON.saveAsJson(output,"output");


    }


}
