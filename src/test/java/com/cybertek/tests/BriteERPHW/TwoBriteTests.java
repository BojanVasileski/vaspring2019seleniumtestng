package com.cybertek.tests.BriteERPHW;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.security.Key;

public class TwoBriteTests extends TestBase {


    @Test (priority = 1)
    public void LogInTest() throws InterruptedException {

        driver.get(ConfigurationReader.get("brite_url"));
        driver.findElement(By.id("login")).sendKeys(ConfigurationReader.get("brite_username"));
        driver.findElement(By.id("password")).sendKeys(ConfigurationReader.get("brite_password") + Keys.ENTER);

        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        String axtual = driver.getTitle();
        String expected = "#Inbox - Odoo";

        Assert.assertEquals(expected,axtual);
    }

    @Test (priority = 2)
    public void POSSearchBarTest() throws InterruptedException {

        driver.get(ConfigurationReader.get("brite_url"));
        driver.findElement(By.id("login")).sendKeys(ConfigurationReader.get("brite_username"));
        driver.findElement(By.id("password")).sendKeys(ConfigurationReader.get("brite_password")+ Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//nav/div/ul/li/a/span[@class='oe_menu_text'])[8]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@class='o_searchview_input'][@type='text']")).sendKeys("tj" + Keys.ENTER);

        Thread.sleep(2000);

        String actual=driver.findElement(By.xpath("//div/div/div[@class='o_primary']")).getText();
        String expected = "TJ";

        Assert.assertEquals(actual,expected);
//        SoftAssert sa = new SoftAssert();
//
//        sa.assertAll();
//        sa.assertEquals();

    }

}

