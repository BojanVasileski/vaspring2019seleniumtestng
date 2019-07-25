package com.cybertek.tests.dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DropdownDefaultValuesTest {

    WebDriver driver;

    @Test
    public void dropdownTest(){


        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        String expected = "Please selecto an option";
        //get the string value of selected option in a dropdown
        String actual =  dropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actual,expected);


    }

    @Test
    public void dropdownt2Test(){
        Select dropdown = new Select(driver.findElement(By.id("year")));
        String expected = "2019";
        String actual = dropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actual,expected);

    }
    @Ignore
    @Test
    public void dropdown3Test(){
        Select select = new Select(driver.findElement(By.id("state")));
        String expected = "Select a state";
        String actual = select.getFirstSelectedOption().getText();

        Assert.assertEquals(actual,expected);
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
