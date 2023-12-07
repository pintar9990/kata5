package org.example;

import spark.Request;
import spark.Response;
import spark.Spark;

import java.util.HashMap;
import java.util.Map;

public class SparkCommandExecutor {
    private final static Map<String, Command> commands = new HashMap<>();
    private final Request request;
    private final Response response;

    public SparkCommandExecutor(Request request, Response response) {
        this.request = request;
        this.response = response;
    }

    public static SparkCommandExecutor with (Request request, Response response) {
        return new SparkCommandExecutor(request, response);
    }

    public static void put (String name, Command command) {
        commands.put(name,command);
    }


    public String execute (String command){
        return execute(commands.get(command));
    }
    private String execute (Command command) {
        return unwrap(command.execute(input()));
    }

    private Command.Input input() {
        return request::queryParams;
    }

    private String unwrap (Command.Output output) {
        response.status(output.response());
        return output.result();
    }
}



