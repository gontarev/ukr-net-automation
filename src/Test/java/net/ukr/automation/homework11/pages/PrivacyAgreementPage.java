package net.ukr.automation.homework11.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.CoreMatchers.containsString;

public class PrivacyAgreementPage extends Page {
    @FindBy(css = "img")
    private WebElement logoImg;

    @FindBy(css = "h2")
    private WebElement headlinePrivacyAgreement;

    public PrivacyAgreementPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public String getPrivacyAgreementUrl() {
        return driver.getCurrentUrl();
    }

    @Step
    public String getPrivacyAgreementLogoImgSource() {
        return wait.until(ExpectedConditions.visibilityOf(logoImg)).getAttribute("src");
    }

    @Step
    public String getHeadlinePrivacyAgreementText() {
        return wait.until(ExpectedConditions.visibilityOf(headlinePrivacyAgreement)).getText();
    }

    @Step
    public void comparePrivacyAgreementUrl(String privacyAgreementUrl) {
        Assert.assertEquals(privacyAgreementUrl, getPrivacyAgreementUrl());
    }

    @Step
    public void comparePrivacyAgreementLogoImgSource(String logoImgSource) {
        Assert.assertThat(getPrivacyAgreementLogoImgSource(), containsString(logoImgSource));
    }

    @Step
    public void compareHeadlinePrivacyAgreementText(String headlinePrivacyAgreementText) {
        Assert.assertEquals(headlinePrivacyAgreementText, getHeadlinePrivacyAgreementText());
    }

}
