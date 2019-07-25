package com.cybertek.tests.review;

import com.cybertek.utilities.VyTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SalesMenuOptionTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qa3.vytrack.com/user/login");

    }
    @Test
    public void storeManagerTest() throws InterruptedException{

        String username = "storemanager71";
        String password = "UserUser123";



        driver.findElement(By.id("prependedInput")).sendKeys(username);
        Thread.sleep(3000);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        Thread.sleep(3000);

        driver.findElement(By.name("_submit")).click();

        WebElement salesOption = driver.findElement(By.xpath("//a/span[contains(text(),'Sales')]"));

        Assert.assertTrue(salesOption.isDisplayed());  //Assert that is true that salesOption is displayed
        driver.quit();
    }

    @Test(priority = 1)
    public void driverTest() throws InterruptedException{

        String username = "user31";
        String password = "UserUser123";

        VyTrackUtils.login(driver,username,password);
        Thread.sleep(3000);

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        Thread.sleep(3000);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        Thread.sleep(3000);

        driver.findElement(By.name("_submit")).click();

        WebElement salesOption = driver.findElement(By.xpath("//a/span[contains(text(),'Sales')]"));

        try {
            Assert.assertFalse(salesOption.isDisplayed());  //Assert that is true that salesOption is displayed
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("PASS");
        }
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }

}