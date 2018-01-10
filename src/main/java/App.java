import java.util.ArrayList;
import java.util.HashMap;

import models.Places;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import java.util.Map;
/**
 * Created by Guest on 1/10/18.
 */
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Places.clearAll();
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String date = request.queryParams("date");
            boolean lived = Boolean.parseBoolean(request.queryParams("lived"));
            String food = request.queryParams("food");
            String activities = request.queryParams("activities");
            Places newPlaces = new Places(name, date, lived, food, activities);
            ArrayList allPlaces = Places.getAll();
            model.put("allPlaces", allPlaces);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());

        get("/display", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList allPlaces = Places.getAll();
            model.put("allPlaces", allPlaces);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
