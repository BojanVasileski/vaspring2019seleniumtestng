package com.cybertek.tests.review;

import com.cybertek.tests.AssertTrueTest;
import com.cybertek.utilities.VyTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCalendarEventTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qa3.vytrack.com/user/login");
        VyTrackUtils.login(driver, "salesmanager123", "UserUser123");
        VyTrackUtils.selectMenuOption(driver, "Activities", "Calendar Events");

    }
    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void saveAndCancelOptionsTest() throws InterruptedException {

        driver.findElement(By.cssSelector("a[title='CreateCalendar event']")).click();
        Thread.sleep(2000);
        String cancelCss = "a[title='Cancel']";
        Assert.assertTrue(VyTrackUtils.isElementDisplayed(driver,By.cssSelector(cancelCss)));

        String saveAndCloseBtn = "(//div[contains(@class, 'btn-group pull-right')]//button)[1]";
        Assert.assertTrue(VyTrackUtils.isElementDisplayed(driver,By.xpath(saveAndCloseBtn)));

        driver.findElement(By.className("caret")).click();
        Thread.sleep(1500);

        String saveCloseOptionOpt = "(//div[contains(@class, 'btn-group pull-right')]//button)[2]";
        String saveNewOption = "(//div[contains(@class, 'btn-group pull-right')]//button)[3]";
        String saveOption = "(//div[contains(@class, 'btn-group pull-right')]//button)[4]";

        Assert.assertTrue(VyTrackUtils.isElementDisplayed(driver,By.xpath(saveCloseOptionOpt)));
        Assert.assertTrue(VyTrackUtils.isElementDisplayed(driver,By.xpath(saveNewOption)));
        Assert.assertTrue(VyTrackUtils.isElementDisplayed(driver,By.xpath(saveOption)));

        driver.findElement(By.className("caret")).click();
        Assert.assertTrue(VyTrackUtils.isElementDisplayed(driver,By.xpath(saveCloseOptionOpt)));
    }

    @Test
    public void defaultOptions(){
        String exp = driver.findElement(By.cssSelector("#user-menu>a")).getText().trim();
        String act = driver.findElement(By.className("select2-chosen")).getText().trim();
        Assert.assertEquals(act,exp);

        String actualValue = driver.findElement(By.cssSelector("[data-ftid='oro_calendar_event_form_title']")).getAttribute("value");
    }



}
