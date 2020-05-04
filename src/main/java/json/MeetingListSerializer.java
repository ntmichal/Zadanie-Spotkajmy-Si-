package json;

import models.Meeting;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class MeetingListSerializer extends StdSerializer<Meeting> {

    public MeetingListSerializer()  {
        this(null);
    }

    public MeetingListSerializer(Class<Meeting> t) {
        super(t);
    }

    @Override
        public void serialize(Meeting meeting, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
        IOException {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            jsonGenerator.writeArray(new String[]{meeting.getStart().format(dateTimeFormatter),meeting.getEnd().format(dateTimeFormatter)},0,2);
        };

}
