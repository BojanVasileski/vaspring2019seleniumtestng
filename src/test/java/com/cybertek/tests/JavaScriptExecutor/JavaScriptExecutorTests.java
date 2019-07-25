package com.cybertek.tests.JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void shutDown(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void jse01() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(2000);
        //JavascriptExecutor object is created

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("alert('Welcome to Cybertek');");  //pop up using executeSctipt()
    }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        Thread.sleep(2000);
        //JavascriptExecutor object is created

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 5; i++) {
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(1000);
        }

    }
    @Test
    public void scrollToElement() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(2000);
        //JavascriptExecutor object is created

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        //executeScript() is an overloaded method and can take string and webelement params
        jse.executeScript("arguments[0].scrollIntoView(true)",link);
        Thread.sleep(2000);
    }
    @Test
    public void type() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        Thread.sleep(2000);
        //JavascriptExecutor object is created

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement input = driver.findElement(By.cssSelector("#input-example>input"));
        jse.executeScript("arguments[0].setAttribute('value','blah blah blah')");
    }



}
