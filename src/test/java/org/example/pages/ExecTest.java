package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.user.User;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExecTest {
    WebDriver driver;
    private DriverFactory driverFactory = new DriverFactory();

    @Before
    public void ExecTest() {

        driver = driverFactory.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @After
    public void tearDown() {
        driverFactory.getDriver().quit();
    }
}
