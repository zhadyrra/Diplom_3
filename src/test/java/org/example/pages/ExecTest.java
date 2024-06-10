package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.user.User;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ExecTest {
    protected WebDriver driver;
    User user = new User();

    @Before
    public void ExecTest() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @After
    public void tearDown() {

        driver.quit();
    }
}
