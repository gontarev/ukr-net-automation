package net.ukr.automation.selenium;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

    public static WebDriver getDriver(Browser browser, String arguments) {
        WebDriver driver;

        switch (browser) {
            case CHROME:
                ChromeDriverManager.chromedriver().setup();
                ChromeOptions optChrome = new ChromeOptions();
                optChrome.addArguments(arguments);
                driver = new ChromeDriver(optChrome);
                break;
            case FIREFOX:
                FirefoxDriverManager.firefoxdriver().setup();
                FirefoxOptions optFirefox = new FirefoxOptions();
                optFirefox.addArguments(arguments);
                driver = new FirefoxDriver(optFirefox);
                break;
            case EDGE:
                EdgeDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case IE:
                InternetExplorerDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
        return driver;
    }
}
