package net.ukr.automation.homework10.data;

public class LanguageUk implements LanguageData {
    @Override
    public String getLang() {
        return "uk";
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
        return "https://mail.ukr.net/terms_uk.html";
    }

    @Override
    public String getTermsHeadlineText() {
        return "Угода про використання електронної пошти FREEMAIL (mail.ukr.net)";
    }
}
