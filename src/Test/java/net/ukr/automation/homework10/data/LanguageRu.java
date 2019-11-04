package net.ukr.automation.homework10.data;

public class LanguageRu implements LanguageData {
    @Override
    public String getLang() {
        return "ru";
    }

    @Override
    public String getPrivacyAgreementUrl() {
        return "https://www.ukr.net/ru/terms/";
    }

    @Override
    public String getPrivacyAgreementLogoSource() {
        return "/img/terms-logo-ru.gif";
    }

    @Override
    public String getPrivacyAgreementHeadlineText() {
        return "Соглашение о конфиденциальности";
    }

    @Override
    public String getTermsUrl() {
        return "https://mail.ukr.net/terms_ru.html";
    }

    @Override
    public String getTermsHeadlineText() {
        return "Соглашение об использовании электронной почты FREEMAIL (mail.ukr.net)";
    }
}
