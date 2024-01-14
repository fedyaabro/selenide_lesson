package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DrugAndDropTest {
  
  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://the-internet.herokuapp.com";
    Configuration.holdBrowserOpen = false;
  }
  
  @AfterEach
  void afterEach() {
    Selenide.closeWebDriver();
  }
  
  @Test
  void drugAndDropWithActionsTest(){
    open("/drag_and_drop");
    $("#column-a").$("header").shouldHave(text("A"));
    $("#column-b").$("header").shouldHave(text("B"));
    Selenide.actions().dragAndDrop($("#column-a"), $("#column-b")).perform();
    $("#column-a").$("header").shouldHave(text("B"));
    $("#column-b").$("header").shouldHave(text("A"));
  }
  
  @Test
  void drugAndDropWithoutActionsTest(){
    $("#column-a").$("header").shouldHave(text("A"));
    $("#column-b").$("header").shouldHave(text("B"));
    open("/drag_and_drop");
    $("#column-a").dragAndDrop(to("#column-b"));
    $("#column-a").$("header").shouldHave(text("B"));
    $("#column-b").$("header").shouldHave(text("A"));
  }

}
