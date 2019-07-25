package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        Thread.sleep(1500);
        WebElement emailInput = driver.findElement(By.name("email"));
        //sendKeys() --> enters text on the webelement
        emailInput.sendKeys("randomemail@gmail.com"+ Keys.ENTER);

        //submit() --> submits the current form
        emailInput.submit();



        String expected = "http://practice.cybertekschool.com/forgot_password";
        String actual = driver.getCurrentUrl();
        VerificationUtils.verifyEquals(expected,actual);




    }
}
