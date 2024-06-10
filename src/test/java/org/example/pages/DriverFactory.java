package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    private static WebDriver createBrowser() {
        String browser = System.getProperty("browser");
        if(browser == null) {
            browser = "chrome";
        }

        if (browser.equals("yandex")) {
            return createYandexDriver();
        } else if (browser.equals("chrome")) {
            return createChromeDriver();
        }

        return createChromeDriver();
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createYandexDriver() {
        WebDriverManager.chromedriver().driverVersion("122.0.6261.128").setup();
        var options = new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        return new ChromeDriver(options);
    }
    public WebDriver getDriver(){
        return createBrowser();
    }
}
