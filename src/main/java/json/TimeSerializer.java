package json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeSerializer extends StdSerializer<LocalTime> {

    public TimeSerializer() {
        this(null);
    }
    public TimeSerializer(Class<LocalTime> t) {
        super(t);
    }


    @Override
    public void serialize(LocalTime localTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        jsonGenerator.writeObject(localTime.format(dateTimeFormatter));
    }

}
