import models.Calendar;
import models.Meeting;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MeetingAlgorithm {
    /**
     *
     * @param calendar1
     * @param calendar2
     * @param meetingDurationString format HH:mm
     * @return
     */
    public static List<Meeting> timeIntervals(Calendar calendar1, Calendar calendar2, String meetingDurationString){

        Duration duration = Duration.parse("PT"+meetingDurationString.split(":")[0]+"H"+meetingDurationString.split(":")[1]+"M");

        calendar1.getMeetings().add(new Meeting(LocalTime.MIN,calendar1.getWorkingHours().getStart()));
        calendar1.getMeetings().add(new Meeting(calendar1.getWorkingHours().getEnd(),LocalTime.MAX));
        calendar2.getMeetings().add(new Meeting(LocalTime.MIN,calendar2.getWorkingHours().getStart()));
        calendar2.getMeetings().add(new Meeting(calendar2.getWorkingHours().getEnd(),LocalTime.MAX));

        List<Meeting> meetings = Stream.concat(calendar1.getMeetings().stream(),
                calendar2.getMeetings().stream())
                .collect(Collectors.toList());

        meetings.sort(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.getStart().compareTo(o2.getStart());
            }
        });

        List<Meeting> timeInterval = new ArrayList<>();

        LocalTime tempMeetingStart =  meetings.get(0).getStart();
        LocalTime tempMeetingEnd = meetings.get(0).getEnd();
        for (int i = 1; i < meetings.size(); i++) {

            if( (meetings.get(i).getStart().compareTo(tempMeetingStart) >= 0) &&
                    (meetings.get(i).getStart().compareTo(tempMeetingEnd) <= 0)) {

                tempMeetingEnd = (tempMeetingEnd.compareTo(meetings.get(i).getEnd()) ) >= 0 ?
                        tempMeetingEnd : meetings.get(i).getEnd();

            }else{

                if(Duration.between(tempMeetingEnd,meetings.get(i).getStart()).toMinutes() >= duration.toMinutes()){
                    timeInterval.add(new Meeting(tempMeetingEnd,meetings.get(i).getStart()));
                }

                tempMeetingStart = meetings.get(i).getStart();
                tempMeetingEnd = meetings.get(i).getEnd();
            }
        }
        return timeInterval;
    }
}
