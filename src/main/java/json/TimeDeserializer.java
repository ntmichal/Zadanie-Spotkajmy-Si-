package json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeDeserializer extends StdDeserializer<LocalTime> {
    public TimeDeserializer(){
        this(null);
    }

    public TimeDeserializer(Class<LocalTime> vc) {
        super(vc);
    }

    @Override
    public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return LocalTime.parse(jsonParser.readValueAs(String.class),
                DateTimeFormatter.ofPattern("HH:mm"));
    }

}
