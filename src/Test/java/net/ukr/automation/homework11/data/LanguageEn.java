package net.ukr.automation.homework11.data;

public class LanguageEn implements LanguageData {
    @Override
    public String getLang() {
        return "en";
    }

    @Override
    public String getPrivacyAgreementUrl() {
        return "https://www.ukr.net/terms/";
    }

    @Override
    public String getPrivacyAgreementLogoSource() {
        return "/img/terms-logo-ua.gif";
    }

    @Override
    public String getPrivacyAgreementHeadlineText() {
        return "Угода про конфіденційність";
    }

    @Override
    public String getTermsUrl() {
        return "https://mail.ukr.net/terms_en.html";
    }

    @Override
    public String getTermsHeadlineText() {
        return "Угода про використання електронної пошти FREEMAIL (mail.ukr.net)";
    }
}
