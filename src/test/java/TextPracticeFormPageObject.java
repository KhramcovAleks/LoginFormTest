import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextPracticeFormPageObject extends TestBase {

    @Test
    void PracticeFormTest() {
        String userName = "Alex";
        String userLastName = "Egorov";
        String userEmail = "alex@egorov.com";
        String userGender = "Other";
        String userNumber = "1234567890";

        String day = "30";
        String month ="July";
        String year = "2008";

        String StudentName = "Student Name";
        String StudentEmail = "Student Email";
        String Gender = "Gender";
        String Mobile = "Mobile";
        String DateOfBirth = "Date of Birth";
        String Subjects = "Subjects";
        String Hobbies = "Hobbies";
        String Picture = "Picture";
        String Address = "Address";
        String StateAndCity = "State and City";


        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userNumber)
                .setBerthDate(day, month, year);

        $("#subjectsInput").setValue("English").pressEnter();
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
        registrationPage.verifyModalAppear()
                .verifyResult(StudentName, userName + " " + userLastName)
                .verifyResult(StudentEmail, userEmail)
                .verifyResult(Gender, userGender)
                .verifyResult(Mobile, userNumber)
                .verifyResult(DateOfBirth, day + " " + month +","+ year);

        $(".modal-body").shouldHave(text("Alex Egorov"));
        $(".modal-body").shouldHave(text("alex@egorov.com"));

        String pngFileName = screenshot("my_file_name");

        $("#closeLargeModal").click();

    }


    @Test
    void PracticeFormTestLast() {
        String userName = "Alex";
        String userLastName = "Egorov";
        String userEmail = "alex@egorov.com";
        String userGender = "Other";
        String userNumber = "1234567890";

        registrationPage.openPage();

        registrationPage.setFirstName(userName);
        registrationPage.setLastName(userLastName);
        registrationPage.setEmail(userEmail);
        registrationPage.setGender(userGender);
        registrationPage.setPhone(userNumber);

        //$("#gender-radio-3").sendKeys(" ");
        //$("label[for='gender-radio-1']").click();
        //$("#gender-radio-3").parent().click();


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
