package com.ichaoge.pet.domain.jserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LiuYu on 2016/5/10.
 */
public class DateJDeSerializer extends StdDeserializer<Date> {

    private SimpleDateFormat dateFormat;

    public DateJDeSerializer() {
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String dateStr = jp.getValueAsString();
        if(dateStr!=null) {
            try {
                if (dateStr.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")) {
                    this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                } else if (dateStr.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}")) {
                    this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                } else if (dateStr.matches("\\d{4}年\\d{1,2}月\\d{1,2}日")) {
                    this.dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                } else if (dateStr.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
                    this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                } else if (dateStr.matches("\\d{4}\\.\\d{1,2}\\.\\d{2}")) {
                    this.dateFormat = new SimpleDateFormat("yyyy.MM.dd");
                } else if (dateStr.matches("\\d{1,2}:\\d{1,2}")) {
                    this.dateFormat = new SimpleDateFormat("H:m");
                } else {
                   return null;
                }

                this.dateFormat.setLenient(false);
                return dateFormat.parse(dateStr);
            } catch(ParseException e) {
                return null;
            }
        }
        
        return null;
    }
}
