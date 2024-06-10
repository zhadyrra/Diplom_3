package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;

public class MainPage extends HeaderPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }
    By loginAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    By bunButton = By.xpath(".//*[@id='root']/div/main/section[1]/div[1]/div[1]");
    By sauceButton = By.xpath(".//*[@id='root']/div/main/section[1]/div[1]/div[2]");
    By fillingButton = By.xpath(".//*[@id='root']/div/main/section[1]/div[1]/div[3]");
    By activeTab = By.xpath("//section[contains(@class, \"BurgerIngredients_ingredients\")]//div[contains(@class, \"tab_tab_type_current\")]");

    public void waitingTheLoginAccountButton(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(loginAccountButton));
    }
    public void clickLoginAccountButton() {
        waitingTheLoginAccountButton();
        driver.findElement(loginAccountButton).click();
    }

    public void clickBuns() {
        driver.findElement(bunButton).click();
    }

    public void clickSauces() {
        driver.findElement(sauceButton).click();
    }


    public void clickFilling() {
        driver.findElement(fillingButton).click();
    }

    public WebElement getChosenTab() {
        return driver.findElement(activeTab);
    }
}

