package com.cybertek.tests.xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathTests {

    @Test
    public void abosulteXpath(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        String exp = "http://practice.cybertekschool.com/signup_confirmation";
        driver.get(exp);

        System.out.println("Printing on the first link");
        System.out.println(driver.findElement(By.xpath("/html/body/nav/ul/li/a")).getText());

        System.out.println("Printing on the second link");
        System.out.println(driver.findElement(By.xpath("html/body/div/div/div/div/a/i")).getText());


        driver.quit();
    }

    @Test
    public void relativeCPathUsingParentChild(){
         WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        String exp = "http://practice.cybertekschool.com/signup_confirmation";
        driver.get(exp);

        System.out.println("Printing the first link");

        System.out.println(driver.findElement(By.xpath("//body/nav/ul/li/a")).getText());

        System.out.println("Printing the first link again");

        System.out.println(driver.findElement(By.xpath("//body/nav//li/a")).getText());


    }

    @Test
    public void relativeXPathUsingAttributeValue(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        System.out.println("Click on button: Don't click!");
        driver.findElement(By.xpath("//button[@id='disappearing_button]")).click();

        //Any tag xpath
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@id='disappearing_button]"));

        //Contains
        System.out.println(driver.findElement(By.xpath("//button[contains(@id,'button')]")).getText());

    }
    @Test
    public void relativeXPathText() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //using exact text

        System.out.println(driver.findElement(By.xpath("//button[.='Button 3']")).getText());

        //using partial text

        System.out.println(driver.findElement(By.xpath("//button[contains(text(),'click')]")).getText());




    }
    @Test
    public void relativeXPathIndex() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //NTH child
        System.out.println(driver.findElement(By.xpath("//button[2]")).getText());
        System.out.println(driver.findElement(By.xpath("//button[6]")).getText());

    }

    }
