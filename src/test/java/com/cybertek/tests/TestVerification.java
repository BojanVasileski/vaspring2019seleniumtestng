package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestVerification {

    public static void main(String[] args) throws InterruptedException {
        test004();
    }

    public static void test004() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        Thread.sleep(1500);
        WebElement emailInput = driver.findElement(By.name("email"));
        String exp = "randomemail@gmail.com";
        emailInput.sendKeys(exp);

        Thread.sleep(1500);
        //getAttribute() -- > returns the value of the given attribute of an element
        System.out.println(emailInput.getAttribute("name"));
        System.out.println(emailInput.getAttribute("type"));

        //getAttribute(value) -- > use this to get text from the input box
        String acc = emailInput.getAttribute("value");
        System.out.println("act = " + acc);

        VerificationUtils.verifyEquals(exp,acc);

        // if getAttribut() doesnt work, use this one:
        System.out.println(emailInput.getAttribute("innerHTML"));
        System.out.println(emailInput.getAttribute("outerHTML"));

    }


    public static void test003() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        Thread.sleep(1500);
        WebElement emailInput = driver.findElement(By.name("email"));
        //sendKeys() --> enters text on the webelement
        emailInput.sendKeys("randomemail@gmail.com");

        WebElement retreivePassword = driver.findElement(By.id("form_submit"));
        retreivePassword.click();

        WebElement message = driver.findElement(By.name("confirmation_message"));
        System.out.println(message.getText());

        String exp = "Your e-mail's been sent!";
        String acc = message.getText();
        VerificationUtils.verifyEquals(exp,acc);



    }
}
