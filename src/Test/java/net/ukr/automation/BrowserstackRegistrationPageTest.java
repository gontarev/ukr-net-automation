package net.ukr.automation;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;

public class BrowserstackRegistrationPageTest {
    WebDriver driver;

    public static final String USERNAME = "dmytro99";
    public static final String AUTOMATE_KEY = "yB4FqVDuNFDwA8h7nQzC";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

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
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.navigate().to("https://accounts.ukr.net/registration");
        String parentHandle = driver.getWindowHandle(); // get the registration page handle

        // test for Privacy agreement Ua
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(1) > .header__lang-long-name")));
        driver.findElement(By.cssSelector("button:nth-of-type(1) > .header__lang-long-name")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form [data-tooltip]")));
        driver.findElement(By.cssSelector("form [data-tooltip]")).click(); // click some link that opens a new window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(tabs.toString());
        driver.switchTo().window(tabs.get(1));
        wait.equals(js.executeScript("return document.readyState").equals("complete"));
        String agreementPrivacyUrlUa = driver.getCurrentUrl();
        String logoUa = driver.findElement(By.cssSelector("img")).getAttribute("src");
        String h2Ua = driver.findElement(By.cssSelector("h2")).getText();
        driver.close();
        driver.switchTo().window(parentHandle);

        // test for Privacy agreement Ru
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(2) > .header__lang-long-name")));
        driver.findElement(By.cssSelector("button:nth-of-type(2) > .header__lang-long-name")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form [data-tooltip]")));
        driver.findElement(By.cssSelector("form [data-tooltip]")).click(); // click some link that opens a new window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait.equals(js.executeScript("return document.readyState").equals("complete"));
        String agreementPrivacyUrlRu = driver.getCurrentUrl();
        String logoRu = driver.findElement(By.cssSelector("img")).getAttribute("src");
        String h2Ru = driver.findElement(By.cssSelector("h2")).getText();
        driver.close();
        driver.switchTo().window(parentHandle);

        // test for Privacy agreement En
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(3) > .header__lang-long-name")));
        driver.findElement(By.cssSelector("button:nth-of-type(3) > .header__lang-long-name")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form [data-tooltip]")));
        driver.findElement(By.cssSelector("form [data-tooltip]")).click(); // click some link that opens a new window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait.equals(js.executeScript("return document.readyState").equals("complete"));
        String agreementPrivacyUrlEn = driver.getCurrentUrl();
        String logoEn = driver.findElement(By.cssSelector("img")).getAttribute("src");
        String h2En = driver.findElement(By.cssSelector("h2")).getText();
        driver.close();
        driver.switchTo().window(parentHandle);


        // test for Terms of service Uk
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(1) > .header__lang-long-name")));
        driver.findElement(By.cssSelector("button:nth-of-type(1) > .header__lang-long-name")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".confirm-terms [data-tooltip]")));
        driver.findElement(By.cssSelector(".confirm-terms [data-tooltip]")).click(); // click some link that opens a new window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait.equals(js.executeScript("return document.readyState").equals("complete"));
        String TermsOfServiceUrlUa = driver.getCurrentUrl();
        String h3Ua = driver.findElement(By.cssSelector("h3")).getText();
        driver.close();
        driver.switchTo().window(parentHandle);

        // test for Terms of service Ru
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(2) > .header__lang-long-name")));
        driver.findElement(By.cssSelector("button:nth-of-type(2) > .header__lang-long-name")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".confirm-terms [data-tooltip]")));
        driver.findElement(By.cssSelector(".confirm-terms [data-tooltip]")).click(); // click some link that opens a new window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait.equals(js.executeScript("return document.readyState").equals("complete"));
        String TermsOfServiceUrlRu = driver.getCurrentUrl();
        String h3Ru = driver.findElement(By.cssSelector("h3")).getText();
        driver.close();
        driver.switchTo().window(parentHandle);

        // test for Terms of service En
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(3) > .header__lang-long-name")));
        driver.findElement(By.cssSelector("button:nth-of-type(3) > .header__lang-long-name")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".confirm-terms [data-tooltip]")));
        driver.findElement(By.cssSelector(".confirm-terms [data-tooltip]")).click(); // click some link that opens a new window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait.equals(js.executeScript("return document.readyState").equals("complete"));
        String TermsOfServiceUrlEn = driver.getCurrentUrl();
        String h3En = driver.findElement(By.cssSelector("h3")).getText();
        driver.close();
        driver.switchTo().window(parentHandle);


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
