package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {
  
  @BeforeAll
 static void beforeAll(){
    //Configuration.pageLoadStrategy = " eager";
  }
  
  
  @Test
  void shouldFindSelenideRepositoryAtTheTop(){
    
    //открыть главную страницу
    open("https://github.com");
    $("[placeholder='Search or jump to...']").click();
    //ввести в поле поиска selenide
    $("#query-builder-test").setValue("selenide").pressEnter();
    //кликнуть на первый репозиторий
    $$("[data-testid='results-list']").first().$("a").click();
    
    $("#repository-container-header").shouldHave(text("selenide / selenide"));
    
    
    sleep(5000);
  }
}
