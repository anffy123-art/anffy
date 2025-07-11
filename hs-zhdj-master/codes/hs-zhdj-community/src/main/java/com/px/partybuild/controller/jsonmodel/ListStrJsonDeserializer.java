package com.px.partybuild.controller.jsonmodel;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListStrJsonDeserializer extends JsonDeserializer<List<String>> {

    @Override
    public List<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        try{
            List<String> result=new ArrayList<>();

            if(jsonParser!=null){
                ArrayNode an=jsonParser.readValueAs(ArrayNode.class);
                an.forEach(jn->{
                    result.add(jn.toString());
                });
            }

            return result;

        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
