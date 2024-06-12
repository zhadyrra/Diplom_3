package org.example.pages;

import com.github.javafaker.Faker;
import org.example.user.User;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PersonAccountPageTest extends ExecTest{
Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    String name = faker.name().name();
    MainPage mainPage;
    PersonAccountPage personAccountPage;
    User user = new User(email,password,name);

    @Test
    public void goToAccountPageByPersonalAccountButtonTest() throws InterruptedException {
        user.createUser();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem('accessToken', '" + user.accessToken + "');");

        Thread.sleep(100);
        String profilePage = "https://stellarburgers.nomoreparties.site/account/profile";
        mainPage=new MainPage(driver);
        mainPage.clickAccountButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe(profilePage));

    }
    @Test
    public void goToMainPageByConstructorButtonTest() throws InterruptedException {
        user.createUser();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem('accessToken', '" + user.accessToken + "');");

        Thread.sleep(100);
        mainPage = new MainPage(driver);
        mainPage.clickAccountButton();
        personAccountPage=new PersonAccountPage(driver);
        personAccountPage.clickConstructorButton();

        String constructorPage = "https://stellarburgers.nomoreparties.site/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(constructorPage));
    }
    @Test
    public void goToMainPageByLogoButtonTest() throws InterruptedException {
        user.createUser();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem('accessToken', '" + user.accessToken + "');");

        Thread.sleep(100);
        mainPage = new MainPage(driver);
        mainPage.clickAccountButton();
        personAccountPage=new PersonAccountPage(driver);
        personAccountPage.clickLogoButton();

        String constructorPage = "https://stellarburgers.nomoreparties.site/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(constructorPage));
    }
    @Test
    public void LogoutTest() throws InterruptedException {
        user.createUser();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem('accessToken', '" + user.accessToken + "');");
        mainPage = new MainPage(driver);
        mainPage.clickAccountButton();
        personAccountPage=new PersonAccountPage(driver);
        personAccountPage.waitForProfileLoad();
        personAccountPage.clickLogoutButton();
        Thread.sleep(100);
        LoginPage loginPage = new LoginPage(driver);
       // loginPage.waitForLoginPageLoad();

    }

}