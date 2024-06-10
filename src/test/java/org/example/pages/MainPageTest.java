package org.example.pages;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class MainPageTest extends ExecTest {

    @Test
    public void tabsChooseBunTest() {
        String expected;
        String actual;
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFilling();
        mainPage.clickBuns();
        expected = "Булки";
        actual = mainPage.getChosenTab().getText();
        assertEquals(expected, actual);
    }

    @Test
    public void tabsChooseSauceTest() {
        String expected;
        String actual;
        MainPage mainPage = new MainPage(super.driver);
        mainPage.clickSauces();
        expected = "Соусы";
        actual = mainPage.getChosenTab().getText();
        assertEquals(expected, actual);
    }

    @Test
    public void tabsChooseFillingTest() {
        String expected;
        String actual;
        MainPage mainPage = new MainPage(super.driver);
        mainPage.clickFilling();
        expected = "Начинки";
        actual = mainPage.getChosenTab().getText();
        assertEquals(expected, actual);
    }


}