package tests;

import org.junit.jupiter.api.Test;

/**
 * Класс с тестами с PageObject
 */
public class TextPracticeFormPageObject extends TestBase {

    @Test
    void PracticeFormTest() {
        //переменные  вводимых данных
        String userName = "Alex";
        String userLastName = "Egorov";
        String userEmail = "alex@egorov.com";
        String userGender = "Other";
        String userNumber = "1234567890";
        String day = "30";
        String month = "July";
        String year = "2008";
        String userSubjects1 = "English";
        String userSubjects2 = "Arts";
        String subjects = userSubjects1 + ", " + userSubjects2;
        String userHobby1 = "Reading";
        String userHobby2 = "Music";
        String hobbies = userHobby1 + ", " + userHobby2;
        String userPicture = "sample.png";
        String userAddress = "Some address 1";
        String userState = "Uttar Pradesh";
        String userCity = "Agra";

        //Переменные с названием полей в окне с результатами
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
                .setBerthDate(day, month, year)
                .setSubjects(userSubjects1)
                .setSubjects(userSubjects2)
                .setHobbies(userHobby1)
                .setHobbies(userHobby2)
                .uploadPicture(userPicture)
                .SetCurrentAddress(userAddress)
                .SetState(userState)
                .SetCity(userCity)
                .submit();

        registrationPage.verifyModalAppear()
                .verifyResult(StudentName, userName + " " + userLastName)
                .verifyResult(StudentEmail, userEmail)
                .verifyResult(Gender, userGender)
                .verifyResult(Mobile, userNumber)
                .verifyResult(DateOfBirth, day + " " + month + "," + year)
                .verifyResult(Subjects, subjects)
                .verifyResult(Hobbies, hobbies)
                .verifyResult(Picture, userPicture)
                .verifyResult(Address, userAddress)
                .verifyResult(StateAndCity, userState + " " + userCity);

        // registrationPage.closeResult();
    }
}
