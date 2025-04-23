package tests;

import org.junit.jupiter.api.Test;

import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;

/**
 * Класс с тестами с PageObject
 */
public class TextPracticeFormRandomUtils extends TestBase {

    @Test
    void PracticeFormTest() {
        //переменные  вводимых данных
        String userName = getRandomString(10),
                userLastName = getRandomString(10),
                userEmail = getRandomEmail(),
                userGender = "Other",
                userNumber = "1234567890",
                day = "30",
                month = "July",
                year = "2008",
                userSubjects1 = "English",
                userSubjects2 = "Arts",
                subjects = userSubjects1 + ", " + userSubjects2,
                userHobby1 = "Reading",
                userHobby2 = "Music",
                hobbies = userHobby1 + ", " + userHobby2,
                userPicture = "sample.png",
                userAddress = "Some address 1",
                userState = "Uttar Pradesh",
                userCity = "Agra";

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
