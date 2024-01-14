package github;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class EnterprisePageTest {
  
  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    //Configuration.baseUrl = "https://github.com/";
    //Configuration.holdBrowserOpen = true;
  }
  
  @Test
  void openEnterprisePageByHoverTest(){
    //открываем главную
    open("https://github.com/");
    //Наводим мышкой на нужное место
    $(".header-menu-wrapper").$(byText("Solutions")).hover();
    $("a[href='/enterprise']").shouldBe(visible);
    //переходим на страницу enterprise
    $("a[href='/enterprise']").click();
    //проверяем
    $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));
    sleep(5000);
    
  }
  
}
