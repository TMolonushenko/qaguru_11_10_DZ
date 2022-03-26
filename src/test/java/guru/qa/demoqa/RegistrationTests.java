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

        //open("automation-practice-form");
        //$(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Bond");
        $("#userEmail").setValue("alex@compani.com");
        $("#genterWrapper").$(byText("Other")).click();
        // $(byText("Other")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--024").click();
        //   $(".react-datepicker__day--024:not(react-datepicker__day--outside-month)").click();
        //$("[aria-label$='May 24th, 1984']").click();
        // $(byText("24")).click();
        // $("react-datepicker__day--024").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Music")).click();
        // $("#uploadPicture").uploadFile(new File("./src/test/resources/mem1.jpg"));
        // $("#uploadPicture").uploadFromClasspath(new File("mem1.jpg"));
        //   File imgfile = new File("./src/test/resources/mem1.jpg");
        $("#currentAddress").setValue("Rome");
        $("#state").scrollTo().click();
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        // $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        //   $("#react-select-4-input").setValue("Agra").pressEnter();
        $("#city").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        // $(byText("Agra")).click();

        $("#submit").click();

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
        //  $(".table-responsive").$(byText("Picture"))
        // .parent().shouldHave(text("mem1.jpg"));
        $(".table-responsive").$(byText("Address"))
                .parent().shouldHave(text("Rome"));
        $(".table-responsive").$(byText("State and City"))
                .parent().shouldHave(text("Uttar Pradesh Agra"));

        $("#closeLargeModal").click();


    }
}

