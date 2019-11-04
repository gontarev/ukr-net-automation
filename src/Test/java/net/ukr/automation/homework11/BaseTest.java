package net.ukr.automation.homework11;

import net.ukr.automation.homework11.app.RegistrationApplication;
import net.ukr.automation.utils.TestRules;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

import java.net.MalformedURLException;

public class BaseTest {
    public static RegistrationApplication app;

    @Rule
    public TestRules testRules = new TestRules(app.getDriver());

    @BeforeClass
    public static void startApp() throws MalformedURLException {
        app = new RegistrationApplication();
        app.openRegistrationPage();
    }

    @AfterClass
    public static void stopApp()
    {
        app.quit();
    }
}
