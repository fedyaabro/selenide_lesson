package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class JunitExampleInWikiSearch {
  
  String exampleText =
    """
      @ExtendWith({SoftAssertsExtension.class})
      class Tests {
        @Test
        void test() {
          Configuration.assertionMode = SOFT;
          open("page.html");
          
          $("#first").should(visible).click();
          $("#second").should(visible).click();
        }
      }
    """;
  
  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://github.com/";
//    Configuration.holdBrowserOpen = true;
  }
  
  @AfterEach
  void afterEach() {
    Selenide.closeWebDriver();
  }
  
  @Test
  void wikiShouldHaveSoftAssertionsOnPages() {
    
    // - Откроваем страницу Selenide в Github
    open("selenide/selenide");
    // - Переходим в раздел Wiki проекта
    $("#wiki-tab")
      .shouldBe(visible)
      .click();
    // - в списке страниц (Pages) есть страница SoftAssertions
    $("#wiki-pages-box").$(byText("Show 3 more pages…"))
      .click();
    $("#wiki-pages-box").$(byText("SoftAssertions"))
      .shouldBe(visible);
  }
  
    @Test
    void softAssertionsShouldHaveJunitExampleWithText(){
      // - внутри SoftAssertions есть пример кода для JUnit5
      open("selenide/selenide/wiki/SoftAssertions");
      $("#wiki-body").shouldHave(text(exampleText));
    }
   
  }



