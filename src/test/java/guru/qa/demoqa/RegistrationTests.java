package guru.qa.demoqa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegistrationTests extends TestBase {

    @Test
    void successFillTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("automation-practice-form");
            $(".main-header").shouldHave(text("Practice Form"));
        });

        step("Вводим имя", () -> {
            $("#firstName").setValue("Alex");
        });

        step("Вводим фамилию", () -> {
            $("#lastName").setValue("Bond");
        });

        step("Вводим email", () -> {
            $("#userEmail").setValue("alex@compani.com");
        });

        step("выбираем пол", () -> {
            $("#genterWrapper").$(byText("Other")).click();
        });

        step("Вводим номер телефона", () -> {
            $("#userNumber").setValue("1234567890");
        });

        step("Выбираем дату рождения", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOption("1984");
            $(".react-datepicker__month-select").selectOption("May");
            $(".react-datepicker__day--024").click();
        });

        step("Выбираем предмет и хобби", () -> {
            $("#subjectsInput").setValue("English").pressEnter();
            $(byText("Music")).click();
        });

        step("Вводим адрес", () -> {
            $("#currentAddress").setValue("Rome");
        });

        step("Выбираем штат", () -> {
            $("#state").scrollTo().click();
            $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        });

        step("Выбираем город", () -> {
            $("#city").scrollTo().click();
            $("#stateCity-wrapper").$(byText("Agra")).click();
            $("#submit").click();
        });
        step("проверяем заполнение формы регистрации", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").$(byText("Student Name"))
                    .parent().shouldHave(text("Alex Bond"));
            $(".table-responsive").$(byText("Student Email"))
                    .parent().shouldHave(text("alex@compani.com"));
            $(".table-responsive").$(byText("Gender"))
                    .parent().shouldHave(text("Other"));
            $(".table-responsive").$(byText("Mobile"))
                    .parent().shouldHave(text("1234567890"));
            $(".table-responsive").$(byText("Date of Birth"))
                    .parent().shouldHave(text("24 May,1984"));
            $(".table-responsive").$(byText("Subjects"))
                    .parent().shouldHave(text("English"));
            $(".table-responsive").$(byText("Hobbies"))
                    .parent().shouldHave(text("Music"));
            $(".table-responsive").$(byText("Address"))
                    .parent().shouldHave(text("Rome"));
            $(".table-responsive").$(byText("State and City"))
                    .parent().shouldHave(text("Uttar Pradesh Agra"));

            $("#closeLargeModal").click();
        });

    }
}

