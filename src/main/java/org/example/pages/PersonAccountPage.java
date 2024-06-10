package org.example.pages;

import groovy.json.JsonOutput;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.ls.LSOutput;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PersonAccountPage extends HeaderPage{
    public PersonAccountPage(WebDriver driver){
        super(driver);
    }
    By constructorButton = By.xpath(".//*[@id='root']/div/header/nav/ul/li[1]/a/p");
    By logoutButton = By.xpath("//button[contains(text(),\"Выход\")]/..");
    By logoButton = By.xpath(".//*[@id='root']/div/header/nav/div/a");
    By personalAccountButton = By.xpath(".//a[contains(@class, 'AppHeader')]/p[contains(text(), 'Личный Кабинет')]");


    public final void clickConstructorButton() {
        WebElement element = driver.findElement(constructorButton);
        element.click();
    }
    public final void clickLogoButton() {
        WebElement element = driver.findElement(logoButton);
        element.click();
    }
    public final void clickLogoutButton() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(logoutButton);
        element.click();
    }
    public void waitForProfileLoad(){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/main/div/nav/p")));
    }

}
