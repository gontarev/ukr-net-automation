package net.ukr.automation.homework10.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://accounts.ukr.net/registration";

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 4);
    }

    @Step
    public void switchToSecondTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    @Step
    public void switchToFirstTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    @Step
    public void closeTab() {
        driver.close();
    }
}
