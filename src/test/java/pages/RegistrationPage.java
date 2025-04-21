package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegisrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegisrationResultModal regisrationResultModal = new RegisrationResultModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            dateOfBerthDay = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            city = $("#city"),
            submit = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        //удаляем мешающие элементы
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click(); // todo move to Selenide elements
        return this;
    }

    public RegistrationPage setPhone(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage setBerthDate(String day, String month, String year) {
        dateOfBerthDay.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage subjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage hobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath("img/" + value);
        return this;
    }

    public RegistrationPage currentAddress(String value) {
        currentAddress.sendKeys(value);
        return this;
    }

    public RegistrationPage state(String value) {
        state.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage city(String value) {
        city.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submit() {
        submit.scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage verifyModalAppear() {
        regisrationResultModal.verifyModalAppear();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        regisrationResultModal.verifyResult(key, value);
        return this;
    }

    public RegistrationPage closeResult(){
        $("#closeLargeModal").click();
        return this;
    }
}
