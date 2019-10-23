package net.ukr.automation.homework10.app;

import io.qameta.allure.Step;
import net.ukr.automation.homework10.pages.Page;
import net.ukr.automation.homework10.pages.PrivacyAgreementPage;
import net.ukr.automation.homework10.pages.RegistrationPage;
import net.ukr.automation.homework10.pages.TermsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationApplication {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private PrivacyAgreementPage privacyAgreementPage;
    private TermsPage termsPage;
    private Page page;

    public RegistrationApplication() {
        driver = new ChromeDriver();
        registrationPage = new RegistrationPage(driver);
        privacyAgreementPage = new PrivacyAgreementPage(driver);
        termsPage = new TermsPage(driver);
        page = new Page(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quit() {
        driver.quit();
    }

    @Step
    public void openRegistrationPage() {
        registrationPage.openRegistrationPage();
    }

    @Step
    public void selectRegistrationPageLanguage (String lang) {
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
        registrationPage.clickPrivacyAgreementLink();
        registrationPage.switchToSecondTab();
    }

    @Step
    public void openTermsPage() {
        registrationPage.clickTermsLink();
        registrationPage.switchToSecondTab();
    }
}
