package net.ukr.automation.homework10.data;

import com.tngtech.java.junit.dataprovider.DataProvider;
import net.ukr.automation.homework10.data.LanguageEn;
import net.ukr.automation.homework10.data.LanguageRu;
import net.ukr.automation.homework10.data.LanguageUk;

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