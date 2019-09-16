package org.ngu.server.servlet;

import com.google.gson.Gson;
import org.ngu.server.protocol.JsonProtocol;
import org.ngu.server.protocol.OpCode;
import org.ngu.server.protocol.RetCode;
import org.ngu.server.service.Processor;
import org.ngu.server.service.example.SayHello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "DispatcherServlet", urlPatterns = "/dispatcher")
public class DispatcherServlet extends HttpServlet {

    private Map<Integer, Processor> processorMap = new HashMap<>();

    private Gson gson = new Gson();

    @Override
    public void init() throws ServletException {
        // TODO init processorMap
        processorMap.put(OpCode.SAY_HELLO.code(), new SayHello());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");

        String req = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        JsonProtocol protocol = gson.fromJson(req, JsonProtocol.class);
        int opCode = protocol.getOpCode();
        Processor processor = processorMap.get(opCode);
        if (processor != null) {
            String result = (String) processor.process(protocol.getJson());
            protocol.setJson(result);
            protocol.setRetCode(RetCode.SUCCESS.code());
            response.getWriter().print(gson.toJson(protocol));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // do nothing
    }
}
