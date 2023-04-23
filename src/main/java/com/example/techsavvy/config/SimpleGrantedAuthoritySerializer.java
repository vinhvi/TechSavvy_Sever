package com.example.techsavvy.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;

public class SimpleGrantedAuthoritySerializer extends JsonSerializer<SimpleGrantedAuthority> {
    @Override
    public void serialize(SimpleGrantedAuthority authority, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("authority", authority.getAuthority());
        jsonGenerator.writeEndObject();
    }
}
