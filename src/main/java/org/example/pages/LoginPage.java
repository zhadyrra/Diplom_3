package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends HeaderPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By loginText = By.xpath(".//main/div/h2[contains(text(),'Вход')]");
    By emailField = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    By passwordField = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    By loginButton = By.xpath(".//button[text()='Войти']");
    By registerButton = By.xpath(".//div/div/p/a[contains(text(),'Зарегистрироваться')]");
    By recoverPassButton = By.linkText("Восстановить пароль");
            //By.xpath("./div/main/div/div/p[2]/a[contains(text(),'Восстановить пароль')]");

    public final void setEmailField(String text) {
        WebElement element = driver.findElement(emailField);
        element.sendKeys(text);
    }
    public final void setPasswordField(String text) {
        WebElement element = driver.findElement(passwordField);
        element.sendKeys(text);
    }
    public final void clickRegisterButton() {
        WebElement element = driver.findElement(registerButton);
        element.click();
    }

    public final void clickLoginButton() {
        WebElement element = driver.findElement(loginButton);
        element.click();
    }
    public final void clickRecoverPasswordButton() {
        WebElement element = driver.findElement(recoverPassButton);
        element.click();
    }
    public String getTextFromLoginPage(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(loginText));
        System.out.println();
        return driver.findElement(loginText).getText();
    }
    public void waitForLoginPageLoad(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginText));
    }

}
