package net.ukr.automation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountLogin {
    private WebDriver driver = new ChromeDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 10);
    private static Cookie freemail;
    private static Cookie sid;
    private static Cookie as;

    @Before
    public void start() {
        ChromeDriverManager.chromedriver().setup();
    }

    @After
    public void stop() {
        driver.quit();
    }

    @Test
    public void testLoginWithCredentials() throws InterruptedException {
        // Opening mail url
        driver.get("https://mail.ukr.net");
        // Make login with credentials
        driver.findElement(By.id("id-l")).sendKeys("***");
        driver.findElement(By.id("id-p")).sendKeys("***");
        driver.findElement(By.cssSelector(".button")).click();
        wait.until(ExpectedConditions.urlContains("mail.ukr.net"));
        // Print mail cookies to console
        System.out.println("Mail cookies: " + driver.manage().getCookies());
        // Read and set desired mail cookies to variables
        freemail = driver.manage().getCookieNamed("freemail");
        sid = driver.manage().getCookieNamed("sid");
        // Going to auth domain
        driver.get("https://accounts.ukr.net/recovery");
        wait.until(ExpectedConditions.urlContains("accounts.ukr.net"));
        // Print auth cookies to console
        System.out.println("Auth cookies: " + driver.manage().getCookies());
        // Read and set desires auth cookies to variables
        as = driver.manage().getCookieNamed("as");
        // Making weird 3 times auth cookies deletion to be sure that they're not recovered
        driver.manage().deleteAllCookies();
        driver.manage().deleteAllCookies();
        driver.manage().deleteAllCookies();
        System.out.println("No cookies for auth domain: " + driver.manage().getCookies());
        // Opening mail domain and making weird 3 times mail cookies deletion to be sure that they're not recovered
        driver.get("https://mail.ukr.net");
        driver.manage().deleteAllCookies();
        driver.manage().deleteAllCookies();
        driver.manage().deleteAllCookies();
        System.out.println("No cookies for mail domain: " + driver.manage().getCookies());
        // Now opening mail domain hopefully without any previous cookies
        driver.get("https://mail.ukr.net");
        // Waiting to be sure that we're not logged in
        Thread.sleep(3000);
        // Necessary cookies creation from variables: mail and auth(?)
        driver.manage().addCookie(freemail);
        driver.manage().addCookie(sid);
        driver.manage().addCookie(as);
        System.out.println("Cookies present: " + driver.manage().getCookies());
        // Going to mail ukr to get logged in with cookies created from variables
        driver.get("https://mail.ukr.net");
        // Time to check visually that login was successful
        Thread.sleep(5000);
    }
}
