package net.ukr.automation;

import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;

public class BrowserstackRegistrationPageTest {
    private WebDriver driver;

    private static final String USERNAME = "dmytro99";
    private static final String AUTOMATE_KEY = "yB4FqVDuNFDwA8h7nQzC";
    private static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Before
    public void start() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Edge");
        caps.setCapability("browser_version", "18.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("name", "Bstack-[Java] Sample Test");

        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @After
    public void stop() {
        driver.quit();
    }

    @Test
    public void testPrivacyAgreementAndTerms() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.navigate().to("https://accounts.ukr.net/registration");
        String parentHandle = driver.getWindowHandle(); // get the registration page handle
        ArrayList<String> agreementPrivacyUrl = new ArrayList<>();
        ArrayList<String> agreementPrivacyUrlToBe = new ArrayList<>(Arrays.asList("https://www.ukr.net/terms/", "https://www.ukr.net/ru/terms/", "https://www.ukr.net/terms/"));
        ArrayList<String> logo = new ArrayList<>();
        ArrayList<String> logoToBe = new ArrayList<>(Arrays.asList("/img/terms-logo-ua.gif", "/img/terms-logo-ru.gif", "/img/terms-logo-ua.gif"));
        ArrayList<String> h2 = new ArrayList<>();
        ArrayList<String> h2ToBe = new ArrayList<>(Arrays.asList("Угода про конфіденційність", "Соглашение о конфиденциальности", "Угода про конфіденційність"));
        ArrayList<String> TermsOfServiceUrl = new ArrayList<>();
        ArrayList<String> TermsOfServiceUrlToBe = new ArrayList<>(Arrays.asList("https://mail.ukr.net/terms_uk.html",
                "https://mail.ukr.net/terms_ru.html",
                "https://mail.ukr.net/terms_en.html"));
        ArrayList<String> h3 = new ArrayList<>();
        ArrayList<String> h3ToBe = new ArrayList<>(Arrays.asList("Угода про використання електронної пошти FREEMAIL (mail.ukr.net)",
                "Соглашение об использовании электронной почты FREEMAIL (mail.ukr.net)",
                "Угода про використання електронної пошти FREEMAIL (mail.ukr.net)"));
        ArrayList<String> tabs;

        for (int i = 0; i < 3; i++ ) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(" + (i + 1) + ") > .header__lang-long-name")));
            driver.findElement(By.cssSelector("button:nth-of-type(" + (i + 1) + ") > .header__lang-long-name")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form [data-tooltip]")));
            driver.findElement(By.cssSelector("form [data-tooltip]")).click(); // click some link that opens a new window
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img")));
            agreementPrivacyUrl.add(driver.getCurrentUrl());
            logo.add(driver.findElement(By.cssSelector("img")).getAttribute("src"));
            h2.add(driver.findElement(By.cssSelector("h2")).getText());
            driver.close();
            driver.switchTo().window(parentHandle);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".confirm-terms [data-tooltip]")));
            driver.findElement(By.cssSelector(".confirm-terms [data-tooltip]")).click(); // click some link that opens a new window
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));
            TermsOfServiceUrl.add(driver.getCurrentUrl());
            h3.add(driver.findElement(By.cssSelector("h3")).getText());
            driver.close();
            driver.switchTo().window(parentHandle);

            Assert.assertEquals(agreementPrivacyUrlToBe.get(i), agreementPrivacyUrl.get(i));
            Assert.assertThat(logo.get(i), containsString(logoToBe.get(i)));
            Assert.assertEquals(h2ToBe.get(i), h2.get(i));
            Assert.assertEquals(TermsOfServiceUrlToBe.get(i), TermsOfServiceUrl.get(i));
            Assert.assertEquals(h3ToBe.get(i), h3.get(i));
        }
    }
}
