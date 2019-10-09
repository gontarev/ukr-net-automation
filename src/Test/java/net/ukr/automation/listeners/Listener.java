package net.ukr.automation.listeners;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.File;
import java.io.IOException;

public class Listener extends AbstractWebDriverEventListener {
    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.println("[Shit Happened:] "+throwable.getMessage().split(":")[0]);


        File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tempFile, new File(System.currentTimeMillis() + "screen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("[Screenshot captured]");
    }
}
