package org.example.pages;

import com.github.javafaker.Faker;
import org.example.user.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistrPageTest extends ExecTest {
    String email;
    String password;
    String name;
    Faker faker = new Faker();
    private String loginPage = "https://stellarburgers.nomoreparties.site/login";

    @Test
    public void registrationSuccessTest() throws InterruptedException{
        User user = new User(
                faker.internet().emailAddress(),
                faker.internet().password(),
                faker.name().name()
        );

        goToLoginPage();

        RegistrPage registrPage = new RegistrPage(super.driver);
        registrPage.setEmailField(user.mail);
        registrPage.setPasswordField(user.pass);
        registrPage.setNameField(user.name);
        registrPage.clickRegisterButton();
        assertTrue(registrPage.isSuccess(loginPage));
        //assertNull(registrPage.getErrorText());
    }
   @Test
    public void registrationUnsuccessfulTest() throws InterruptedException{

       User user = new User(
               faker.internet().emailAddress(),
               faker.internet().password(1,6),
               faker.name().name()
       );
        goToLoginPage();

        RegistrPage registrPage = new RegistrPage(super.driver);
        registrPage.setEmailField(user.mail);
        registrPage.setPasswordField(user.pass);
        registrPage.setNameField(user.name);
        registrPage.clickRegisterButton();

        String expectedErrorText = "Некорректный пароль";
        String actualErrorTextResult = registrPage.getErrorText();
        assertEquals(expectedErrorText, actualErrorTextResult);
    }

    private void goToLoginPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(super.driver);
        loginPage.clickAccountButton();
        loginPage.clickRegisterButton();
    }
}