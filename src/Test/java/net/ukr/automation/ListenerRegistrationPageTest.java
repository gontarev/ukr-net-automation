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

        // test for Privacy agreement Ua
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(1) > .header__lang-long-name")));
        edr.findElement(By.cssSelector("button:nth-of-type(1) > .header__lang-long-name")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form [data-tooltip]")));
        edr.findElement(By.cssSelector("form [data-tooltip]")).click(); // click some link that opens a new window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(edr.getWindowHandles());
        System.out.println(tabs.toString());
        edr.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img")));
        String agreementPrivacyUrlUa = edr.getCurrentUrl();
        String logoUa = edr.findElement(By.cssSelector("img")).getAttribute("src");
        String h2Ua = edr.findElement(By.cssSelector("h2")).getText();
        edr.close();
        edr.switchTo().window(parentHandle);

        // test for Privacy agreement Ru
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(2) > .header__lang-long-name")));
        edr.findElement(By.cssSelector("button:nth-of-type(2) > .header__lang-long-name")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form [data-tooltip]")));
        edr.findElement(By.cssSelector("form [data-tooltip]")).click(); // click some link that opens a new window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        tabs = new ArrayList<>(edr.getWindowHandles());
        edr.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img")));
        String agreementPrivacyUrlRu = edr.getCurrentUrl();
        String logoRu = edr.findElement(By.cssSelector("img")).getAttribute("src");
        String h2Ru = edr.findElement(By.cssSelector("h2")).getText();
        edr.close();
        edr.switchTo().window(parentHandle);

        // test for Privacy agreement En
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(3) > .header__lang-long-name")));
        edr.findElement(By.cssSelector("button:nth-of-type(3) > .header__lang-long-name")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form [data-tooltip]")));
        edr.findElement(By.cssSelector("form [data-tooltip]")).click(); // click some link that opens a new window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        tabs = new ArrayList<>(edr.getWindowHandles());
        edr.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img")));
        String agreementPrivacyUrlEn = edr.getCurrentUrl();
        String logoEn = edr.findElement(By.cssSelector("img")).getAttribute("src");
        String h2En = edr.findElement(By.cssSelector("h2")).getText();
        edr.close();
        edr.switchTo().window(parentHandle);


        // test for Terms of service Uk
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(1) > .header__lang-long-name")));
        edr.findElement(By.cssSelector("button:nth-of-type(1) > .header__lang-long-name")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".confirm-terms [data-tooltip]")));
        edr.findElement(By.cssSelector(".confirm-terms [data-tooltip]")).click(); // click some link that opens a new window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        tabs = new ArrayList<>(edr.getWindowHandles());
        edr.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));
        String TermsOfServiceUrlUa = edr.getCurrentUrl();
        String h3Ua = edr.findElement(By.cssSelector("h3")).getText();
        edr.close();
        edr.switchTo().window(parentHandle);

        // test for Terms of service Ru
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(2) > .header__lang-long-name")));
        edr.findElement(By.cssSelector("button:nth-of-type(2) > .header__lang-long-name")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".confirm-terms [data-tooltip]")));
        edr.findElement(By.cssSelector(".confirm-terms [data-tooltip]")).click(); // click some link that opens a new window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        tabs = new ArrayList<>(edr.getWindowHandles());
        edr.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));
        String TermsOfServiceUrlRu = edr.getCurrentUrl();
        String h3Ru = edr.findElement(By.cssSelector("h3")).getText();
        edr.close();
        edr.switchTo().window(parentHandle);

        // test for Terms of service En
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(3) > .header__lang-long-name")));
        edr.findElement(By.cssSelector("button:nth-of-type(3) > .header__lang-long-name")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".confirm-terms [data-tooltip]")));
        edr.findElement(By.cssSelector(".confirm-terms [data-tooltip]")).click(); // click some link that opens a new window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        tabs = new ArrayList<>(edr.getWindowHandles());
        edr.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));
        String TermsOfServiceUrlEn = edr.getCurrentUrl();
        String h3En = edr.findElement(By.cssSelector("h3")).getText();
        edr.close();
        edr.switchTo().window(parentHandle);


        Assert.assertEquals("https://www.ukr.net/terms/", agreementPrivacyUrlUa);
        Assert.assertThat(logoUa, containsString("/img/terms-logo-ua.gif"));
        Assert.assertEquals("Угода про конфіденційність", h2Ua);
        Assert.assertEquals("https://www.ukr.net/ru/terms/", agreementPrivacyUrlRu);
        Assert.assertThat(logoRu, containsString("/img/terms-logo-ru.gif"));
        Assert.assertEquals("Соглашение о конфиденциальности", h2Ru);
        Assert.assertEquals("https://www.ukr.net/terms/", agreementPrivacyUrlEn);
        Assert.assertThat(logoEn, containsString("/img/terms-logo-ua.gif"));
        Assert.assertEquals("Угода про конфіденційність", h2En);

        Assert.assertEquals("https://mail.ukr.net/terms_uk.html", TermsOfServiceUrlUa);
        Assert.assertEquals("Угода про використання електронної пошти FREEMAIL (mail.ukr.net)", h3Ua);
        Assert.assertEquals("https://mail.ukr.net/terms_ru.html", TermsOfServiceUrlRu);
        Assert.assertEquals("Соглашение об использовании электронной почты FREEMAIL (mail.ukr.net)", h3Ru);
        Assert.assertEquals("https://mail.ukr.net/terms_en.html", TermsOfServiceUrlEn);
        Assert.assertEquals("Угода про використання електронної пошти FREEMAIL (mail.ukr.net)", h3En);
    }
}
