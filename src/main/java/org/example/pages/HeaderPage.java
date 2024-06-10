package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage {
    protected WebDriver driver;
    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }
    By constructorButton = By.xpath("//nav//*[contains(text(),\"Конструктор\")]");
    By logoButton = By.xpath("//nav/div");
    By personalAccountButton = By.xpath("//nav//*[contains(text(),\"Личный Кабинет\")]");
    public void waitingTheAccountButton(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(personalAccountButton));
    }
    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }
    public void clickAccountButton(){
        driver.findElement(personalAccountButton).click();
    }
    public void clickLogoButton(){
        driver.findElement(logoButton).click();
    }
}
