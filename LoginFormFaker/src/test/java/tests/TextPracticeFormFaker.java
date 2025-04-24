package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static tests.TestDataFaker.*;
import static utils.RandomUtils.*;

public class TextPracticeFormFaker extends TestBase {

    @Test
    void PracticeFormTest() {
        //Faker faker = new Faker();
        Faker faker = new Faker(new Locale("en"));

        //переменные  вводимых данных
                String userName = faker.name().firstName(),
                userLastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = getRandomItemFromArray(genders),
                userNumber = faker.phoneNumber().subscriberNumber(10),//"1234567890",
                day = getRandomIntString(),//"30",
                month = getRandomItemFromArray(months),
                year = getRandomYearString(),//"2008",
                userSubjects1 = getRandomItemFromArray(subject),
                userSubjects2 = getRandomItemFromArray(subject),
                subjects = userSubjects1 + ", " + userSubjects2,
                userHobby1 = getRandomItemFromArray(hobbie),
                userHobby2 = getRandomItemFromArray(hobbie),
                hobbies = userHobby1 + ", " + userHobby2,
                userPicture = "sample.png",
                userAddress = faker.address().fullAddress(),//"Some address 1",
                userState = getRandomItemFromArray(state),
                userCity = getRandomCity(userState);

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
