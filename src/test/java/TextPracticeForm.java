import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextPracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

        Configuration.headless = false; // чтобы видеть браузер
        Configuration.reportsFolder = "target/selenide-reports";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").sendKeys("alex@egorov.com");
        $("#gender-radio-3").sendKeys(" ");
        //$("label[for='gender-radio-1']").click();
        $("#userNumber").sendKeys("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("March")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1980")).click();
        $(".react-datepicker__month-container").$(byText("13")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbies-checkbox-1").scrollIntoView(true).sendKeys(" ");
        $("label[for='hobbies-checkbox-2']").scrollIntoView(true).click();  //Hobbies - Reading
        $("#uploadPicture").uploadFile(new File("src/test/data/sample.png"));
        $("#currentAddress").sendKeys("Some address 1");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();

         $("#submit").scrollIntoView(true).click();
        //$("#submit").sendKeys(Keys.ENTER);

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".modal-body").shouldHave(text("Alex Egorov"));
        $(".modal-body").shouldHave(text("alex@egorov.com"));

        String pngFileName = screenshot("my_file_name");

        $("#closeLargeModal").click();

    }
}
