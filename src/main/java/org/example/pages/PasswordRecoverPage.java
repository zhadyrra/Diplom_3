package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordRecoverPage extends HeaderPage{

    public PasswordRecoverPage(WebDriver driver) {
        super(driver);
    }

    By loginButton = By.linkText("Войти");

    public final void clickLoginButton() {
        WebElement element = driver.findElement(loginButton);
        element.click();
    }

}
