package com.cybertek.tests.Synchronization;

import com.cybertek.utilities.VyTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void waitForVisable() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.tagName("button")).click();

        //create a webdriverwait object and pass a driver and wait duration
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //start waiting for certain element to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("bojanvasileski");

    }


    @Test
    public void waitForClickable(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.cssSelector("#input-example>button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //start waiting for certain element to be visible
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#input-example>button"))));
        driver.findElement(By.cssSelector("#input-example>button")).sendKeys("hello world");

    }

    @Test
    public void explicitNotHelpingUsingTreadSleepTest(){
        driver.get("http://qa3.vytrack.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        VyTrackUtils.login(driver, "storemanager51", "UserUser123");
        driver.findElements(By.linkText("My Calendar"));

    }


    }
