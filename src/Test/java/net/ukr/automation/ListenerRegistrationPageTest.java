package net.ukr.automation;

import io.github.bonigarcia.wdm.*;
import net.ukr.automation.listeners.Listener;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;

public class ListenerRegistrationPageTest {
    private EventFiringWebDriver edr;
    private WebDriverWait wait;

    @Before
    public void start() {
        ChromeDriverManager.chromedriver().setup();
        FirefoxDriverManager.firefoxdriver().setup();
        EdgeDriverManager.edgedriver().setup();
        OperaDriverManager.operadriver().setup();
        InternetExplorerDriverManager.iedriver().setup();

        edr = new EventFiringWebDriver(new ChromeDriver());
        edr.register(new Listener());
        wait = new WebDriverWait(edr, 5);
    }

    @After
    public void stop() {
        edr.quit();
    }

    @Test
    public void testPrivacyAgreementAndTerms() {
        edr.navigate().to("https://accounts.ukr.net/registration");
        String parentHandle = edr.getWindowHandle(); // get the registration page handle
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
            edr.findElement(By.cssSelector("button:nth-of-type(" + (i + 1) + ") > .header__lang-long-name")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form [data-tooltip]")));
            edr.findElement(By.cssSelector("form [data-tooltip]")).click(); // click some link that opens a new window
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            tabs = new ArrayList<>(edr.getWindowHandles());
            edr.switchTo().window(tabs.get(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img")));
            agreementPrivacyUrl.add(edr.getCurrentUrl());
            logo.add(edr.findElement(By.cssSelector("img")).getAttribute("src"));
            h2.add(edr.findElement(By.cssSelector("h2")).getText());
            edr.close();
            edr.switchTo().window(parentHandle);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".confirm-terms [data-tooltip]")));
            edr.findElement(By.cssSelector(".confirm-terms [data-tooltip]")).click(); // click some link that opens a new window
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            tabs = new ArrayList<>(edr.getWindowHandles());
            edr.switchTo().window(tabs.get(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));
            TermsOfServiceUrl.add(edr.getCurrentUrl());
            h3.add(edr.findElement(By.cssSelector("h3")).getText());
            edr.close();
            edr.switchTo().window(parentHandle);

            Assert.assertEquals(agreementPrivacyUrlToBe.get(i), agreementPrivacyUrl.get(i));
            Assert.assertThat(logo.get(i), containsString(logoToBe.get(i)));
            Assert.assertEquals(h2ToBe.get(i), h2.get(i));
            Assert.assertEquals(TermsOfServiceUrlToBe.get(i), TermsOfServiceUrl.get(i));
            Assert.assertEquals(h3ToBe.get(i), h3.get(i));
        }
    }
}
