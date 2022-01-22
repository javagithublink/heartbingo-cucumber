package uk.co.heartbingo.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uk.co.heartbingo.drivermanager.ManageDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility extends ManageDriver {

    /**
     * This method will click on element
     *
     * @ param WebElement
     */

    public void pmClickOnElement(WebElement element) {
        element.click();
    }

    /**
     * This method will get text from element
     */

    public String pmGetTextFromElement(WebElement element) {

        return element.getText();
    }

    /**
     * This method will send text on element
     */
    public void pmSendTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * This method take screenshots when test fails, using 'getScreenShotAs' method of 'TakeScreenshot' interface
     * @param driver
     * @param screenshotName
     * @return
     */

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/main/java/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);

        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }


    /**
     * Wait method mainly used for POC projects
     * @param seconds
     */

    public void pmWaitWithThreadSleep(int seconds){
        seconds = 10*100;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
