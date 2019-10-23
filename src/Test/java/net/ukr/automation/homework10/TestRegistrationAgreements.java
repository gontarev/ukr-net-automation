package net.ukr.automation.homework10;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import net.ukr.automation.homework10.data.TestData;
import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class TestRegistrationAgreements extends BaseTest {

    @Test
    @UseDataProvider(value = "localizationData", location = TestData.class)
    public void Test (String lang, String privacyAgreementUrl, String privacyAgreementLogoSource, String privacyAgreementHeadlineText, String termsUrl, String termsHeadlineText) {
        app.selectRegistrationPageLanguage(lang);
        app.openPrivacyAgreementPage();
        app.comparePrivacyAgreementUrl(privacyAgreementUrl);
        app.comparePrivacyAgreementLogoImgSource(privacyAgreementLogoSource);
        app.comparePrivacyAgreementHeadlineText(privacyAgreementHeadlineText);
        app.closeTab();

        app.switchToFirstTab();
        app.openTermsPage();
        app.compareTermsUrl(termsUrl);
        app.compareTermsHeadlineText(termsHeadlineText);
        app.closeTab();
        app.switchToFirstTab();
    }
}