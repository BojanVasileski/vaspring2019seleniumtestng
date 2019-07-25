package com.cybertek.tests.CssTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssTests {
    @Test
    public void byAttributeAndValue() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //certain element with attr and value combo
        System.out.println(driver.findElement(By.cssSelector("button[name='button6']")).getText());

        //any element with attr and value combo
        System.out.println(driver.findElement(By.cssSelector("[name='button6']")).getText());

        //multiple attribute and value

        System.out.println(driver.findElement(By.cssSelector("button[class='btn btn-primary'][name='button2']")));
        driver.quit();
    }

    @Test
    public void dynamicElements() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //starts with
        System.out.println(driver.findElement(By.cssSelector("button[id^='button_']")).getText());

        //ends with
        System.out.println(driver.findElement(By.cssSelector("button[id$='_button']")).getText());

        //contains
        System.out.println(driver.findElement(By.cssSelector("button[id*='disappear']")).getText());


    }

    @Test
    public void IdAndClass() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //ID

        System.out.println(driver.findElement(By.cssSelector("#disappearing_button")).getText());

        //Class just one class
        System.out.println(driver.findElement(By.cssSelector(".nav-link")).getText());

        //Two Classes
        System.out.println(driver.findElement(By.cssSelector(".btn.btn-primary")).getText());

        //certain element with class
        System.out.println(driver.findElement(By.cssSelector("a.nav-link")));


    }

    @Test
    public void parentToChild() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        System.out.println(driver.findElement(By.cssSelector("a.nav-link")));


    }
}