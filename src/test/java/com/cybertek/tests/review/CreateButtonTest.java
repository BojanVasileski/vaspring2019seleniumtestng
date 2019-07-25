package com.cybertek.tests.review;

import com.cybertek.utilities.VerificationUtils;
import com.cybertek.utilities.VyTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateButtonTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qa3.vytrack.com/user/login");
    }
    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void storeManagerTest(){
        String username = "storemanager71";
        String password = "UserUser123";
        VyTrackUtils.login(driver,username,password);

        //click on activities
        WebElement activ = driver.findElement(By.xpath("//span[@class = 'title title-level-1' and contains(text(),'Activities')]"));
        //click on calls
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        activ.click();
        WebElement calls = driver.findElement(By.xpath("//span[@class = 'title title-level-2' and contains(text(),'Calls')]"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        calls.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String css = "a[title='Log call']";

        System.out.println(driver.findElement(By.cssSelector(css)).isDisplayed());


        //click on activities
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        activ.click();

        //lick on calendar event
        WebElement calendar = driver.findElement(By.xpath("//span[@class = 'title title-level-2' and contains(text(),'Calendar Events')]"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        calendar.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        css = "a[title='Create Calendar event']";
        Assert.assertTrue(driver.findElement(By.cssSelector(css)).isDisplayed());

    }

    @Test
    public void salesManagerTest() throws InterruptedException {
        VyTrackUtils.login(driver, "salesmanager123","UserUser123");
        VyTrackUtils.selectMenuOption(driver, "Activities", "Calls");
        String css = "a[title='Log call']";
        Assert.assertTrue(VyTrackUtils.isElementDisplayed(driver,By.cssSelector(css)));

        VyTrackUtils.selectMenuOption(driver, "Activities", "Calendar Events");
        css = "a[title='Create Calendar event']";
        Assert.assertTrue(VyTrackUtils.isElementDisplayed(driver,By.cssSelector(css)));


    }


}
