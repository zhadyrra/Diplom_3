package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrPage extends HeaderPage{

    public RegistrPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    By nameField= By.xpath(".//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    By emailField = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    By passwordField = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[3]/div/div/input");
    By registerButton = By.xpath(".//button[contains(text(),'Зарегистрироваться')]");
    By errorText = By.xpath("//p[@class=\"input__error text_type_main-default\"]");
    By loginButton = By.linkText("Войти");
    public final void setNameField(String text) {
        WebElement element = driver.findElement(nameField);
        element.sendKeys(text);
    }

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
    public String getErrorText(){
        WebElement element = driver.findElement(errorText);
        return element.getText();
    }
    public final void clickLoginButton() {
        WebElement element = driver.findElement(loginButton);
        element.click();
    }

    public boolean isSuccess (String loginPage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(loginPage));
        return true;
    }
}
