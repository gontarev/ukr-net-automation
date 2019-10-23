package net.ukr.automation.homework10;

import net.ukr.automation.homework10.app.RegistrationApplication;
import net.ukr.automation.utils.TestRules;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

public class BaseTest {
    static RegistrationApplication app;

    @Rule
    public TestRules testRules = new TestRules(app.getDriver());

    @BeforeClass
    public static void startApp() {
        app = new RegistrationApplication();
        app.openRegistrationPage();
    }

    @AfterClass
    public static void stopApp()
    {
        app.quit();
    }
}
