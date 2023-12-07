package org.example;

public interface Command {
    Output execute (Input input);

    interface Input {
        String get (String key);
    }
    interface Output {
        int response();
        String result();
    }
}
