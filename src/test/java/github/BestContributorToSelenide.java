package github;

import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
  @Test
  void andreiSolntsevShouldBeTheFirstContributor(){
    // открыть страницу репозитория селенида
    open("https://github.com/selenide/selenide");
    //Подвести мышку к первому аватару
    $("div.Layout-sidebar").$(byText("Contributors"))
      .closest(".BorderGrid-cell").$$("ul li").first().hover();
    //Убедимся, что первый это Андрей Солнцев
    $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
    sleep(5000);
  }
}
