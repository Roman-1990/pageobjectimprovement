package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPages {
    //открытие сайта и проверка элемента страницы
    public void openWebsitePage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text("Student Registration Form"));
    }

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail");

    public void typeFirstName(String value) {
        firstNameInput.val(value);
    }

    public void typeLastName(String value) {
        lastNameInput.val(value);
    }

    public void typeEmail(String value) {
        emailInput.val(value);
    }

    public void chooseGender(String value) {
        $(byText(value)).click();
    }

    public void typePhoneNumber(String value) {
        $("#userNumber").setValue(value);
    }

    public void chooseDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        ElementsCollection daySelector = $$(".react-datepicker__day");
        daySelector.find(exactText(day)).click();

    }

    public void typeSubject(String subjectsInput) {
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
    }

    public void chooseHobby(String value) {
        $(byText(value)).click();
    }

    public void uploadImage(String value) {
        $("#uploadPicture").uploadFromClasspath("img/" + value);
    }

    public void typeAddress(String value) {
        $("#currentAddress").setValue(value).scrollTo();
    }

    public void chooseStateAndCity(String state, String city) {
        $(byText("Select State")).click();
        $(byText(state)).click();
        $(byText("Select City")).click();
        $(byText(city)).click();
    }

    public void pressSubmit() {
        $("#submit").click();
    }
}
