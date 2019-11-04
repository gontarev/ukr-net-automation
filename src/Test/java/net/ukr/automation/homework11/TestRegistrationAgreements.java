package net.ukr.automation.homework11;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import net.ukr.automation.homework11.data.LanguageData;
import net.ukr.automation.homework11.data.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class TestRegistrationAgreements extends BaseTest {

    @Test
    @UseDataProvider(value = "localizationData", location = TestData.class)
    public void Test (LanguageData lang) {
        app.selectRegistrationPageLanguageShort(lang.getLang());
        app.openPrivacyAgreementPage();
        app.comparePrivacyAgreementUrl(lang.getPrivacyAgreementUrl());
        app.comparePrivacyAgreementLogoImgSource(lang.getPrivacyAgreementLogoSource());
        app.comparePrivacyAgreementHeadlineText(lang.getPrivacyAgreementHeadlineText());
        app.closeTab();

        app.switchToFirstTab();
        app.openTermsPage();
        app.compareTermsUrl(lang.getTermsUrl());
        app.compareTermsHeadlineText(lang.getTermsHeadlineText());
        app.closeTab();
        app.switchToFirstTab();
    }
}