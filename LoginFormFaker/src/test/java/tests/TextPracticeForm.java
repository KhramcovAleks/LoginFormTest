package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextPracticeForm extends TestBase{

    @Test
    void PracticeFormTest() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        //удаляем мешающие элементы
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").sendKeys("alex@egorov.com");
        //$("#gender-radio-3").sendKeys(" ");
        //$("label[for='gender-radio-1']").click();
        //$("#gender-radio-3").parent().click();
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").sendKeys("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1980");
        $(".react-datepicker__day--012:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("English").pressEnter();
        //$("#hobbies-checkbox-1").scrollIntoView(true).sendKeys(" ");
        //$("label[for='hobbies-checkbox-2']").scrollIntoView(true).click();  //Hobbies - Reading
        $("#hobbiesWrapper").$(byText("Reading")).scrollIntoView(true).click();

        //$("#uploadPicture").uploadFile(new File("src/test/resources/img/sample.png"));
        //метод предполагает что файл уже лежит в папке ресурсы
        $("#uploadPicture").uploadFromClasspath("img/sample.png");
        $("#currentAddress").sendKeys("Some address 1");


        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        //$("#react-select-3-option-0").click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();

         $("#submit").scrollIntoView(true).click();
        //$("#submit").sendKeys(Keys.ENTER);

        //проверка что появилось модальное окно
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".modal-body").shouldHave(text("Alex Egorov"));
        $(".modal-body").shouldHave(text("alex@egorov.com"));

        String pngFileName = screenshot("my_file_name");

        $("#closeLargeModal").click();

    }
}
