package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickExample {
    public static void main(String[] args) throws InterruptedException {
        //WebDriverManager dependancy for automating the driver management in Selenium
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String expectedUrl = "http://practice.cybertekschool.com/forgot_password";
        driver.get(expectedUrl);

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement retreiveButtion = driver.findElement(By.id("form_submit"));

        Thread.sleep(3000);
        retreiveButtion.click();

        String url = driver.getCurrentUrl();

        VerificationUtils.verifyEquals(expectedUrl,url);
    }
}
