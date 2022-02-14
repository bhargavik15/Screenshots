package screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class FacebookScreenshot {
    WebDriver driver;
    @Test
    public void captureScreenshot() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("honey");

    }
    @AfterMethod
    public  void close(ITestResult result) throws IOException {
        if(ITestResult.FAILURE==result.getStatus()){
            Utility.captureScreenshot(driver,"screenshotName");

        }
    }
    @AfterTest
    public void tearDown(){

    }

}

