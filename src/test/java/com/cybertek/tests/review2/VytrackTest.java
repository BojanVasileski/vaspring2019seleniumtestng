package com.cybertek.tests.review2;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class VytrackTest extends TestBase {

    @Test
    public void changeMenu() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        String username = ConfigurationReader.get("sales_username");
        String password = ConfigurationReader.get("password");
        VyTrackUtils.login(driver, username, password);

        Assert.assertTrue(driver.getTitle().contains("Dashboard"),"Title was wrong");

        VyTrackUtils.selectMenuOption(driver,"Activities","Calendar");

        Assert.assertTrue(driver.getTitle().contains("Calendar Events"), "Title is wrong");

    }

    @Test
    public void verifyRepeatOptions() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        String username = ConfigurationReader.get("sales_username");
        String password = ConfigurationReader.get("password");
        VyTrackUtils.login(driver, username, password);
        VyTrackUtils.selectMenuOption(driver, "Activities", "Calendar Events");

        VyTrackUtils.waitForUIOverlay();
        BrowserUtils.waitForClickablility(By.cssSelector("a[title='Create Calendar event']"),5).click();
        VyTrackUtils.waitForUIOverlay();
        BrowserUtils.waitForClickablility(By.cssSelector("input[id^=‘recurrence-repeat-view’]"),5).click();

        WebElement el = driver.findElement(By.cssSelector("select[id^='recurrence-repeats-view']"));

        Select repeatOptionsDropdownLise = new Select(el);

        List<String> Expected = Arrays.asList("Daily",
                "Weekly",
                "Monthly",
                "Yearly");



        List<WebElement> options = repeatOptionsDropdownLise.getOptions();

        List<String> Actual = BrowserUtils.getElementsText(options);


        assertEquals(Actual, Expected, "Repeat, Options did not match");


    }


}
