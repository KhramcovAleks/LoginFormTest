package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class DragAndDrop {
    @BeforeAll
    static void beforeTest(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false; // чтобы видеть браузер
    }

    @Test
    void moveAinBdragAndDropTo(){
//Откройте https://the-internet.herokuapp.com/drag_and_drop
//Перенесите прямоугольник А на место В
//роверьте, что прямоугольники действительно поменялись
//В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");

        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
        sleep(5000);
        screenshot("1 test");

    }

    @Test
    void moveAinBActions(){
//Откройте https://the-internet.herokuapp.com/drag_and_drop
//Перенесите прямоугольник А на место В
//роверьте, что прямоугольники действительно поменялись
//В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().clickAndHold($("#column-a")).moveByOffset(250, 0).release().build().perform();

        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
        sleep(5000);
        screenshot("1 test");

    }
}
