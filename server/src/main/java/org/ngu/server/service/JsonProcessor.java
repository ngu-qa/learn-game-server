package org.ngu.server.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public abstract class JsonProcessor implements Processor<String, String> {

    protected Gson gson = new Gson();

}
