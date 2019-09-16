package org.ngu.server.service.example;

import org.ngu.server.protocol.RetCode;
import org.ngu.server.protocol.example.SayHelloReq;
import org.ngu.server.protocol.example.SayHelloResp;
import org.ngu.server.service.JsonProcessor;

public class SayHello extends JsonProcessor {

    @Override
    public String process(String json) {

        SayHelloReq sayHelloReq = gson.fromJson(json, SayHelloReq.class);

        String name = sayHelloReq.getName();

        SayHelloResp resp = new SayHelloResp();
        resp.setResult(String.format("Hello %s!", name));

        return gson.toJson(resp);
    }
}
