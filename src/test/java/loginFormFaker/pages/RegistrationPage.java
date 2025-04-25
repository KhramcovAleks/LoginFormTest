package loginFormFaker.pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegisrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 *Класс со странийкей с формой с методами и селекторами
 */
public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private final String IMG_FOLDER = "img/";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegisrationResultModal regisrationResultModal = new RegisrationResultModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            genderChoice = $("#genterWrapper"),
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
        genderChoice.$(byText(value)).click();
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

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(IMG_FOLDER + value);
        return this;
    }

    public RegistrationPage SetCurrentAddress(String value) {
        currentAddress.sendKeys(value);
        return this;
    }

    public RegistrationPage SetState(String value) {
        state.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage SetCity(String value) {
        city.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submit() {
        submit.scrollIntoView(true).click();
        return this;
    }

    /**
     * Проверка, что оокно с результатами открылось
     * @return
     */
    public RegistrationPage verifyModalAppear() {
        regisrationResultModal.verifyModalAppear();
        return this;
    }

    /**
     * Проверка результатов
     * @param key
     * @param value
     * @return
     */
    public RegistrationPage verifyResult(String key, String value) {
        regisrationResultModal.verifyResult(key, value);
        return this;
    }

    /**
     * Метод закрытия окна
     * @return
     */
    public RegistrationPage closeResult(){
        $("#closeLargeModal").click();
        return this;
    }
}
