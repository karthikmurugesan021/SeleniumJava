package test.java.com.ofs.testcases;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestLinks {
    WebDriver driver =null;
    @BeforeClass
    public void openBrowser()
    {
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
    }
    @AfterClass
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void getAllLinks() throws InterruptedException {
        Thread.sleep(2000);

        List<WebElement> links = driver.findElements(By.xpath("//a"));
        int size = links.size();

        Reporter.log("Total number of link in this webpage   =   " +size, true);
        for(int i=0; i<size; i++) {
            String name = links.get(i).getText();
            Reporter.log(i+1+ "    :   " + name, true);

        }
    }
    @Test
    public void allScreens() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//a[@href='/abtest']")).click();
        Thread.sleep(1000);
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("C:\\screenshots\\1.jpg");
        FileUtils.copyFile(SrcFile, DestFile);

    }


}


