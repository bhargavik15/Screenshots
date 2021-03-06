package screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utility {
    public static void captureScreenshot(WebDriver driver,String screenshotName) throws IOException {
        try {


            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("user.dir" + screenshotName + ".png"));
            System.out.println("Screenshot taken");
        }
        catch (Exception e){
            System.out.println("exception while taking screenshot"+e.getMessage());
        }
    }
}
