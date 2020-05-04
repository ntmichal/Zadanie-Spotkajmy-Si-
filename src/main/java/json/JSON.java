package json;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.module.SimpleModule;
import models.Calendar;
import models.Meeting;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

public class JSON {

    public static void saveAsJson(Calendar jsonDataObject, String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalTime.class, new TimeSerializer());
        mapper.registerModule(module);
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(fileName+".json"), jsonDataObject);

    }

    public static void saveAsJson(List<Meeting> listOfMeetings, String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Meeting.class, new MeetingListSerializer());
        mapper.registerModule(module);
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(fileName+".json"), listOfMeetings);

    }
    public static Calendar readCalendar(String fileName) throws IOException {
        Calendar calendar = null;

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalTime.class, new TimeDeserializer());
        mapper.registerModule(module);
        File file = new File(fileName+".json");
        calendar = mapper.readValue(new File(fileName+".json"),Calendar.class);


        return calendar;
    }



}
