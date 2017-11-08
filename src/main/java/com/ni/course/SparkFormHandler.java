package com.ni.course;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SparkFormHandler {

    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(SparkFormHandler.class,"/");
        Spark.get("/", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                Map<String, Object> fruitsMap = new HashMap<String, Object>();
                fruitsMap.put("fruits", Arrays.asList("apple", "orange", "banana","peach"));
                Template fruitPickerTemplate = configuration.getTemplate("FruitPicker.ftl");
                StringWriter writer = new StringWriter();
                fruitPickerTemplate.process(fruitsMap, writer);
                return writer;
            }
        });

        Spark.post("favorite-fruit", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                final String fruit = request.queryParams("fruit");
                if(fruit==null){
                    return "Why don't you pick one?";
                }else{
                    return "Your favorite fruit is "+fruit;
                }
            }
        });
    }
}
