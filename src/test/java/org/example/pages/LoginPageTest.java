package org.example.pages;

import com.github.javafaker.Faker;
import org.example.user.User;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.*;

public class LoginPageTest extends ExecTest {
    User user;
    String email;
    String password;
    String name;
    Faker faker = new Faker();
    MainPage mainPage;
    RegistrPage registrPage;
    PasswordRecoverPage passwordRecoverPage;

    @Test
    public void loginByPersonalAccountButtonTest() throws InterruptedException{
        User user = new User(
            faker.internet().emailAddress(),
            faker.internet().password(),
            faker.name().name()
        );

        LoginPage loginPage = new LoginPage(driver);

        user.createUser();
        loginPage.waitingTheAccountButton();
        loginPage.clickAccountButton();

        loginPage.waitForLoginPageLoad();

        loginPage.setEmailField(user.mail);
        loginPage.setPasswordField(user.pass);

        loginPage.clickLoginButton();
        Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String accessToken = (String) js.executeScript("return localStorage.getItem('accessToken');");
        boolean accessTokenExists = (boolean) js.executeScript("return localStorage.getItem('accessToken') !== null;");

        assertTrue(accessTokenExists);
        user.deleteUser(accessToken);
    }
    @Test
    public void loginByButtonInMainPageTest() throws InterruptedException{
        User user = new User(
                faker.internet().emailAddress(),
                faker.internet().password(),
                faker.name().name()
        );
        user.createUser();
        mainPage = new MainPage(super.driver);
        mainPage.waitingTheLoginAccountButton();
        mainPage.clickLoginAccountButton();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.waitForLoginPageLoad();
        loginPage.setEmailField(user.mail);
        loginPage.setPasswordField(user.pass);

        loginPage.clickLoginButton();
        Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String accessToken = (String) js.executeScript("return localStorage.getItem('accessToken');");
        boolean accessTokenExists = (boolean) js.executeScript("return localStorage.getItem('accessToken') !== null;");

        assertTrue(accessTokenExists);
        user.deleteUser(accessToken);
    }
    @Test
    public void loginByButtonInRegisterPageTest() throws InterruptedException{
        User user = new User(
                faker.internet().emailAddress(),
                faker.internet().password(),
                faker.name().name()
        );
        user.createUser();

        LoginPage loginPage = new LoginPage(super.driver);
        loginPage.waitingTheAccountButton();
        loginPage.clickAccountButton();
        loginPage.waitForLoginPageLoad();
        loginPage.clickRegisterButton();
        registrPage = new RegistrPage(driver);
        registrPage.clickLoginButton();

        loginPage.waitForLoginPageLoad();

        loginPage.setEmailField(user.mail);
        loginPage.setPasswordField(user.pass);

        loginPage.clickLoginButton();
        Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String accessToken = (String) js.executeScript("return localStorage.getItem('accessToken');");

        boolean accessTokenExists = (boolean) js.executeScript("return localStorage.getItem('accessToken') !== null;");

        assertTrue(accessTokenExists);
        user.deleteUser(accessToken);
    }
    @Test
    public void loginByButtonInRecoverPasswordPageTest() throws InterruptedException{
        User user = new User(
                faker.internet().emailAddress(),
                faker.internet().password(),
                faker.name().name()
        );
        user.createUser();
        LoginPage loginPage = new LoginPage(super.driver);
        loginPage.clickAccountButton();
        loginPage.waitForLoginPageLoad();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        loginPage.clickRecoverPasswordButton();

        passwordRecoverPage = new PasswordRecoverPage(driver);
        passwordRecoverPage.clickLoginButton();
        loginPage.waitForLoginPageLoad();

        loginPage.setEmailField(user.mail);
        loginPage.setPasswordField(user.pass);

        loginPage.clickLoginButton();
        Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String accessToken = (String) js.executeScript("return localStorage.getItem('accessToken');");
        boolean accessTokenExists = (boolean) js.executeScript("return localStorage.getItem('accessToken') !== null;");

        assertTrue(accessTokenExists);
        user.deleteUser(accessToken);
    }

}