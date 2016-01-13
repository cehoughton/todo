import java.util.Map;
import java.util.HashMap;
import javax.swing.JOptionPane;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class Task {
  private static ArrayList<Task> instances = new ArrayList<Task>();

  private String mDescription;
  private LocalDateTime mCreatedAt;
  private boolean mCompleted;
  private int mId;

  public Task(String description) {
    mDescription = description;
    mCreatedAt = LocalDateTime.now();
    mCompleted = false;
    instances.add(this);
    mId = instances.size();
  }

  public String getDescription() {
    return mDescription;
  }
