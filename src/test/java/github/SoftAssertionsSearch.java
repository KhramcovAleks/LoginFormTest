package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class SoftAssertionsSearch {
    @BeforeAll
    static void beforeTest(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false; // чтобы видеть браузер
        Configuration.reportsFolder = "target/selenide-reports";
    }

    @Test
    void shouldFindSelenidRepositiry(){
//  - Откройте страницу Selenide в Github
// - Перейдите в раздел Wiki проекта
// - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
// - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
//        open("https://github.com"); //[placeholder='Search or jump to...']
//        $("[data-target='qbsearch-input.inputButtonText']")
//                .shouldBe(visible) // Ждем, пока элемент станет видимым
//                .setValue("Selenide")
//                .pressEnter();
        open("https://github.com/search?q=Selenid&type=repositories");
        $$("[data-testid='results-list'] div").first().$("a").click(); //[data-testid='results-list']
        $("#wiki-tab").click();
        $(".markdown-body").shouldHave(text("Soft assertions"));
        $(".markdown-body ul").$(byText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class:"));
        sleep(5000);
        screenshot("1 test");
    }
}
