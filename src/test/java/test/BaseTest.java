package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    public WebDriver driver;


    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }


    public String getScreenshot(String screenshotName) throws IOException {
        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());
        File srcFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("user.dir") + "\\Reports\\screenshots\\" + screenshotName + date + ".png";
        File file = new File(destination);
        FileUtils.copyFileToDirectory(srcFile, file);
        return destination;
    }
}
