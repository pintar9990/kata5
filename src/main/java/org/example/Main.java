package org.example;

import spark.Spark;

public class Main {
    public static void main(String[] args) {
        SparkCommandExecutor.put("factorial", new FactorialCommand());
        Spark.port(1234);
        Spark.get("/factorial",(req,res)->SparkCommandExecutor.with(req,res).execute("factorial"));
    }
}
