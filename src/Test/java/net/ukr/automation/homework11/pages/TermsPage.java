package net.ukr.automation.homework11.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TermsPage extends Page {
    @FindBy(css = "h3")
    private WebElement headlineTerms;

    public TermsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public String getTermsUrl() {
        return driver.getCurrentUrl();
    }

    @Step
    public String getHeadlineTermsText() {
        return wait.until(ExpectedConditions.visibilityOf(headlineTerms)).getText();
    }

    @Step
    public void compareTermsUrl(String termsUrl) {
        Assert.assertEquals(termsUrl, getTermsUrl());
    }

    @Step
    public void compareHeadlineTermsText(String headlineTermsText) {
        Assert.assertEquals(headlineTermsText, getHeadlineTermsText());
    }
}
