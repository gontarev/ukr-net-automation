package net.ukr.automation.selenium;

import org.openqa.selenium.WebDriver;

public class FirstTest {
    public static void main(String[] args) {
        String baseURL = "https://www.ukr.net/ua/";

        for (Browser browser : Browser.values()) {
            System.out.println(browser.toString());
            WebDriver driver = Driver.getDriver(browser, "--start-fullscreen");
            driver.get(baseURL);
            driver.quit();
        }
    }
}
