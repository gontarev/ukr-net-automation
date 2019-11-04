package net.ukr.automation.homework10.data;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class TestData {

    @DataProvider
    public static Object[][] localizationData() {
        return new Object[][]{
                {new LanguageUk()}
                , {new LanguageRu()}
                , {new LanguageEn()}
        };
    }
}
