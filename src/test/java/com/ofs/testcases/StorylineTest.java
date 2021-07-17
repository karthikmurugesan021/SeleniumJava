package test.java.com.ofs.testcases;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class StorylineTest {
    WebDriver driver = null;

    @BeforeClass
    public void openBrowser()
    {
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://iniapro.objectfrontier.com/login");
        driver.findElement(By.name("username")).sendKeys("karthikmurugesan");
        driver.findElement(By.name("password")).sendKeys("Quality@ofs12345");
        driver.findElement(By.name("login")).click();
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        driver.findElement(By.className("logout")).click();
        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    public void testIniaProHome() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,50);
        driver.findElement(By.className("home")).click();
        String eTitle="iNiaPro";
        wait.until(ExpectedConditions.titleContains(eTitle));
        String aTitle = driver.getTitle();
        Assert.assertEquals(aTitle, eTitle);
        Thread.sleep(3000);
        Reporter.log("executed IniProLoginTEst", true);
    }

    @Test
    public void testMyPage() throws InterruptedException
    {
        Thread.sleep(3000);
        driver.findElement(By.className("my-page")).click();
        Thread.sleep(3000);
        Reporter.log("executed testMuPage", true);
        WebDriverWait wait=new WebDriverWait(driver,50);
        String eTitle="My page - iNiaPro";
        wait.until(ExpectedConditions.titleContains(eTitle));
        String aTitle = driver.getTitle();
        Assert.assertEquals(aTitle, eTitle);
        Thread.sleep(3000);
        Reporter.log("Verified testMyPage Title", true);
    }

    @Test
    public void testProjects() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.className("projects")).click();
        Thread.sleep(1000);
        Reporter.log("executed testMuPage", true);
        WebDriverWait wait=new WebDriverWait(driver,50);
        String eTitle="Projects - iNiaPro";
        wait.until(ExpectedConditions.titleContains(eTitle));
        String aTitle = driver.getTitle();
        Assert.assertEquals(aTitle, eTitle);
        Thread.sleep(3000);
        Reporter.log("Verified Projects Title", true);
    }


    @Test
    public void testTimeSheet() throws InterruptedException
    {
        Thread.sleep(3000);
        driver.findElement(By.className("wkTime")).click();
        Thread.sleep(3000);
        Reporter.log("executed testTimeSheetClick", true);
    }
}
