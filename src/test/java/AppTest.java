



import java.time.LocalDateTime;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.ArrayList;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;




public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
    public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("");
    }

  @Test
    public void taskIsCreatedTest() {
      goTo("http://localhost:4567/");
      //submit(".btn");
    //fill("#description").with("Mow the lawn");
      submit(".btn");
      assertThat(pageSource()).contains("Your task has been saved.");
    }

    @Test
     public void taskIsDisplayedTest() {
       goTo("http://localhost:4567/tasks/new");
       fill("#description").with("Mow the lawn");
       submit(".btn");
       //click("a", withText("View tasks"));
       assertThat(pageSource()).contains("Mow the lawn");
     }

     @Test
     public void multpleTasksAreDisplayedTest() {
       goTo("http://localhost:4567/tasks/new");
       fill("#description").with("Mow the lawn");
       submit(".btn");
       goTo("http://localhost:4567/tasks/new");
       fill("#description").with("Buy groceries");
       submit(".btn");
       //click("a", withText("View tasks"));
       assertThat(pageSource()).contains("Mow the lawn");
       assertThat(pageSource()).contains("Buy groceries");
     }
     @Test
     public void taskShowPageDisplaysDescription() {
    goTo("http://localhost:4567/tasks/new");
    fill("#description").with("Do the dishes");
    submit(".btn");
    //click("a", withText("View tasks"));
    click("a", withText("Do the dishes"));
    assertThat(pageSource()).contains("Do the dishes");
}

}
