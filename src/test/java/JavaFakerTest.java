import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static utils.RandomUtils.*;

public class JavaFakerTest {

    @BeforeAll
    static void setStartConfig() {
        Configuration.startMaximized = true;

    }

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomGender(),
            mobile = faker.number().digits(10),
            monthOfBirth = getRandomMonth(),
            yearOfBirth = getRandomYear(),
            dayOfBirth = getRandomDay(),
            subject1 = getRandomSubject(),
            hobby1 = getRandomHobby(),
            picture = "1.png",
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Merrut";

    RegistrationPages registrationPage = new RegistrationPages();

    @Test
    void TeachingSubmitTest() {

        registrationPage.openWebsitePage();
        //Data entry
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(email);
        registrationPage.chooseGender(gender);
        registrationPage.typePhoneNumber(mobile);
        //ввод даты в календаре
        registrationPage.chooseDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        registrationPage.typeSubject(subject1);
        registrationPage.chooseHobby(hobby1);
        //загрузка картинки
        registrationPage.uploadImage(picture);

        registrationPage.typeAddress(currentAddress);
        registrationPage.chooseStateAndCity(state, city);
        registrationPage.pressSubmit();

        // Result

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject1));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
    }
}
