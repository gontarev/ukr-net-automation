package net.ukr.automation.homework11.app;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Step;
import net.ukr.automation.homework11.pages.Page;
import net.ukr.automation.homework11.pages.PrivacyAgreementPage;
import net.ukr.automation.homework11.pages.RegistrationPage;
import net.ukr.automation.homework11.pages.TermsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class RegistrationApplication {
    private static WebDriverWait wait;
    private static AndroidDriver<WebElement> driver;
    private RegistrationPage registrationPage;
    private PrivacyAgreementPage privacyAgreementPage;
    private TermsPage termsPage;
    private Page page;

    public RegistrationApplication() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        dc.setCapability(MobileCapabilityType.BROWSER_VERSION, "69");

        URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<>(serverURL, dc);
        wait = new WebDriverWait(driver, 20);

        registrationPage = new RegistrationPage(driver);
        privacyAgreementPage = new PrivacyAgreementPage(driver);
        termsPage = new TermsPage(driver);
        page = new Page(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quit() {
        driver.closeApp();
    }

    @Step
    public void openRegistrationPage() {
        registrationPage.openRegistrationPage();
    }

    @Step
    public void selectRegistrationPageLanguage(String lang) {
        registrationPage.selectLanguage(lang);
    }

    @Step
    public void clickPrivacyAgreementLink() {
        registrationPage.clickPrivacyAgreementLink();
    }

    @Step
    public void clickTermsLink() {
        registrationPage.clickTermsLink();
    }

    @Step
    public void switchToFirstTab() {
        page.switchToFirstTab();
    }

    @Step
    public void switchToSecondTab() {
        page.switchToSecondTab();
    }

    @Step
    public void closeTab() {
        page.closeTab();
    }

    @Step
    public String getPrivacyAgreementUrl() {
        return privacyAgreementPage.getPrivacyAgreementUrl();
    }

    @Step
    public String getPrivacyAgreementLogoImgSource() {
        return privacyAgreementPage.getPrivacyAgreementLogoImgSource();
    }

    @Step
    public String getPrivacyAgreementHeadlineText() {
        return privacyAgreementPage.getHeadlinePrivacyAgreementText();
    }

    @Step
    public void comparePrivacyAgreementUrl(String privacyAgreementUrl) {
        privacyAgreementPage.comparePrivacyAgreementUrl(privacyAgreementUrl);
    }

    @Step
    public void comparePrivacyAgreementLogoImgSource(String logoImgSource) {
        privacyAgreementPage.comparePrivacyAgreementLogoImgSource(logoImgSource);
    }

    @Step
    public void comparePrivacyAgreementHeadlineText(String headlinePrivacyAgreementText) {
        privacyAgreementPage.compareHeadlinePrivacyAgreementText(headlinePrivacyAgreementText);
    }

    @Step
    public String getTermsUrl() {
        return termsPage.getTermsUrl();
    }

    @Step
    public String getTermsHeadlineText() {
        return termsPage.getHeadlineTermsText();
    }

    @Step
    public void compareTermsUrl(String termsUrl) {
        termsPage.compareTermsUrl(termsUrl);
    }

    @Step
    public void compareTermsHeadlineText(String headlineTermsText) {
        termsPage.compareHeadlineTermsText(headlineTermsText);
    }

    @Step
    public void openPrivacyAgreementPage() {
//        Integer startX = wait.until(ExpectedConditions.visibilityOf(header)).getLocation().getX();
//        Integer startY = wait.until(ExpectedConditions.visibilityOf(header)).getLocation().getY();
//        Integer endX = wait.until(ExpectedConditions.visibilityOf(privacyAgreementLink)).getLocation().getX();
//        Integer endY = wait.until(ExpectedConditions.visibilityOf(privacyAgreementLink)).getLocation().getY();
//        System.out.println(startX + " ::::::: " + startY + " ::::::: " + endX +  " ::::::: " +	endY);
//        new TouchAction(driver).press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(115, 350)).release().perform();
        registrationPage.clickPrivacyAgreementLink();
        registrationPage.switchToSecondTab();
    }

    @Step
    public void openTermsPage() {
        registrationPage.clickTermsLink();
        registrationPage.switchToSecondTab();
    }
}
