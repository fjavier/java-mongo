package com.ni.course;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldSparkStyle {
    //Spark se ejecuta en el puerto 4567
    public static void main(String[] args) {
        Spark.get("/", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                return "Hello World from Spark";
            }
        });
    }
}
