package net.ukr.automation.homework10.data;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class TestData {

    @DataProvider
    public static Object[][] localizationData() {
        return new Object[][]{
                {"uk", "https://www.ukr.net/terms/", "/img/terms-logo-ua.gif", "Угода про конфіденційність", "https://mail.ukr.net/terms_uk.html", "Угода про використання електронної пошти FREEMAIL (mail.ukr.net)"}
                , {"ru", "https://www.ukr.net/ru/terms/", "/img/terms-logo-ru.gif", "Соглашение о конфиденциальности", "https://mail.ukr.net/terms_ru.html", "Соглашение об использовании электронной почты FREEMAIL (mail.ukr.net)"}
                , {"en", "https://www.ukr.net/terms/", "/img/terms-logo-ua.gif", "Угода про конфіденційність", "https://mail.ukr.net/terms_en.html", "Угода про використання електронної пошти FREEMAIL (mail.ukr.net)"}
        };
    }
}
