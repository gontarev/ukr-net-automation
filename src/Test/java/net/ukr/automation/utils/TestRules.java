package net.ukr.automation.utils;

import io.qameta.allure.Attachment;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestRules implements MethodRule {

    private WebDriver driver;

    public TestRules(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public Statement apply(Statement base, FrameworkMethod method, Object target) {

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    base.evaluate();
                } catch (Throwable t) {
                    saveAllureScreenshot();
                    throw t;
                }
            }

            @Attachment(value = "Page screenshot", type = "image/png")
            byte[] saveAllureScreenshot() {
                return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            }
        };
    }
}
