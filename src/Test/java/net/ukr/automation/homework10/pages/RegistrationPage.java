package net.ukr.automation.homework10.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends Page {

    @FindBy(css = "form [data-tooltip]")
    private WebElement privacyAgreementLink;

    @FindBy(css = ".confirm-terms [data-tooltip]")
    private WebElement termsLink;


    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public void openRegistrationPage() {
        driver.get(baseUrl);
    }

    @Step
    public void selectLanguage (String lang) {
        switch (lang) {
            case ("uk"):
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(1) > .header__lang-long-name"))).click();
                break;
            case ("ru"):
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(2) > .header__lang-long-name"))).click();
                break;
            case ("en"):
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(3) > .header__lang-long-name"))).click();
                break;
            default:
                System.out.println("Invalid language code.");
                break;
        }
    }

    @Step
    public void clickPrivacyAgreementLink() {
        wait.until(ExpectedConditions.visibilityOf(privacyAgreementLink)).click();
    }

    @Step
    public void clickTermsLink() {
        wait.until(ExpectedConditions.visibilityOf(termsLink)).click();
    }
}
