import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        //RESTful ARCHITECTURE
        //Use POST to create something on the server
        //Use GET to retrieve something from the server
        //Use PUT to change or update something on the server
        //Use DELETE to remove or delete something on the server
        //Keep URLs intuitive
        //Each request from client contains all info necessary for that request

        //ROUTES: Home Page

        staticFileLocation("/public");
       String layout = "templates/layout.vtl";

       get("/", (request, response) -> {
         HashMap<String, Object> model = new HashMap<String, Object>();
         model.put("template", "templates/index.vtl");
         return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());

       get("/tasks", (request, response) -> {
         HashMap<String, Object> model = new HashMap<String, Object>();
         model.put("tasks", Task.all());
         model.put("template", "templates/tasks.vtl");
         return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());

       get("tasks/new", (request, response) -> {
         HashMap<String, Object> model = new HashMap<String, Object>();
         model.put("template", "templates/task-form.vtl");
         return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());

       post("/tasks", (request, response) -> {
         HashMap<String, Object> model = new HashMap<String, Object>();
         String description = request.queryParams("description");
         Task newTask = new Task(description);

         model.put("tasks", Task.all());

         model.put("template", "templates/tasks.vtl");
         return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());

       get("/tasks/:id", (request, response) -> {
         HashMap<String, Object> model = new HashMap<String, Object>();

         Task task = Task.find(Integer.parseInt(request.params(":id")));
         model.put("task", task);
         model.put("template", "templates/task.vtl");
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());


        //ROUTES: Identification of Resources

        //ROUTES: Changing Resources

    }
}
