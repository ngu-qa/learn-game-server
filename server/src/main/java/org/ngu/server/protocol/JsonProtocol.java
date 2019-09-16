package org.ngu.server.protocol;

import com.google.gson.Gson;
import lombok.Data;

@Data
public class JsonProtocol {

    private static final Gson gson = new Gson();

    private int opCode;

    private String json;

    private int retCode;


    public static String marshal(JsonProtocol jp) {
        return gson.toJson(jp);
    }

    public JsonProtocol unmarshal(String json) {
        return gson.fromJson(json, JsonProtocol.class);
    }
}
