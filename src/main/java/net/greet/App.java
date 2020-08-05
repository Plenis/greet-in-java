//package net.greet;
//
//import spark.ModelAndView;
//import spark.template.handlebars.HandlebarsTemplateEngine;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static spark.Spark.*;
//
//public class Routes extends Greeter{
//    static Map<String, Object> map = new HashMap<>();
//
//    public static void main(String[] args) {
//        staticFiles.location("public");
//        get("/greet", (request, response) -> "Molo"
//
////            return new ModelAndView(map, "hello.handlebars");
//
//        );
//
//
//        post("/hello", (request, response) -> {
//            // create the greeting message
//            String greeting = "Hello, " + request.queryParams("username");
//            String[] users = request.queryParamsValues("username");
////            int counter = 0;
//
////            if (map.containsKey(users)) {
////                map.put("counter", counter + 1);
////            } else {
////                map.put("counter", 1);
////            }
////
//            int counter = map.size();
//            // put it in the map which is passed to the template - the value will be merged into the template
//            map.put("greeting", greeting);
//            map.put("users", users);
//            map.put("counter", counter);
//            return new ModelAndView(map, "hello.handlebars");
//
//        }, new HandlebarsTemplateEngine());
//
//    }
//}
