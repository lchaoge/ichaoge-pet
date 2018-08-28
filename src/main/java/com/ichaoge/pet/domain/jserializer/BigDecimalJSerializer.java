package com.ichaoge.pet.domain.jserializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by LiuYu on 2016/5/9.
 */
public class BigDecimalJSerializer extends StdSerializer<BigDecimal> {
    public BigDecimalJSerializer() {
        super(BigDecimal.class,true);
    }

    //    public BigDecimalJSerializer() {
//        super(BigDecimal.class,true);
//    }
//
//    @Override
//    public void serialize(BigDecimal value, JsonGenerator jgen, org.codehaus.jackson.map.SerializerProvider provider) throws IOException, JsonGenerationException {
//        if(value!=null) {
//            jgen.writeNumber(value.intValue());
//        }
//        jgen.writeString("");
//    }
//
//    @Override
//    public org.codehaus.jackson.JsonNode getSchema(org.codehaus.jackson.map.SerializerProvider provider, Type typeHint) throws org.codehaus.jackson.map.JsonMappingException {
//        return null;
//    }


    @Override
    public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
        if(value!=null) {
            jgen.writeNumber(value.intValue());
        } else {
            jgen.writeString("");
        }
    }
}
