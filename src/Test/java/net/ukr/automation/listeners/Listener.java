package net.ukr.automation.listeners;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.File;
import java.io.IOException;

public class Listener extends AbstractWebDriverEventListener {
    private String currentDir = System.getProperty("user.dir");

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        new File(currentDir + "/screenshots").mkdirs();
        System.out.println("[Shit Happened:] "+throwable.getMessage().split(":")[0]);


        File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tempFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + "screen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("[Screenshot captured]");
    }
}
