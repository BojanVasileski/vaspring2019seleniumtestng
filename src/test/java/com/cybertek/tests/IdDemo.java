package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdDemo {
    public static void main(String[] args) throws InterruptedException {

    iD();
    }

    public static void iD() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);
        WebElement btn6=driver.findElement(By.id("disappearing_button"));
        btn6.click();
        Thread.sleep(2000);
        driver.close();

    }
}
