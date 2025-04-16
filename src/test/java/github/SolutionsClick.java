package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class SolutionsClick {
    @BeforeAll
    static void beforeTest(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false; // чтобы видеть браузер
      //  Configuration.baseUrl = "https://github.com/";
      //  Configuration.reportsFolder = "target/selenide-reports";
    }

    @Test
    void shouldFindSelenidRepositiry(){
//На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.
// Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
        open("https://github.com/");
        $(byText("Solutions")).hover();
        $(byText("Enterprises")).click();
        $("[data-testid='Grid-:R2hb:']").shouldHave(text("To build, scale, and deliver secure software."));
        sleep(5000);
        screenshot("1 test");

    }
}
