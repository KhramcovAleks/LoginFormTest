package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @BeforeAll
    static void beforeTest(){
    Configuration.browser = "chrome";
    Configuration.browserSize = "1920x1080";
    Configuration.headless = false; // чтобы видеть браузер
    Configuration.reportsFolder = "target/selenide-reports";
    //System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");

    }

    @Test
    void shouldFindSelenidRepositiry(){
        //открыть главную страницу
        //ввести selenid и нажать enter
        //уликнуть на первый репозиторий
        //проверка заголовок selenid/selenid
//        open("https://github.com"); //[placeholder='Search or jump to...']
//        $("[data-target='qbsearch-input.inputButtonText']")
//                .shouldBe(visible) // Ждем, пока элемент станет видимым
//                .setValue("Selenide")
//                .pressEnter();
        open("https://github.com/search?q=Selenid&type=repositories");
        $$("[data-testid='results-list'] div").first().$("a").click(); //[data-testid='results-list']
        sleep(5000);

        $("#repository-container-header").shouldHave(text("selenide / selenide"));
       // $("[alt='@asolntsev']").hover();;
        $("div .Layout-sidebar").$(byText("Contributors"))
                //.closest("div .BorderGrid-cell").$$("ul li").first().hover();
        .closest("h2").sibling(0).$$("li").first().hover();
       // $$(".Popover").findBy(visible).shouldHave(text("Andrei Solntsev"));
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));
       sleep(5000);
       screenshot("1 test");

        //ARRANGE(подготовка)
        //ACT(действие)
        //ASSERT(проверка)
    }
}
