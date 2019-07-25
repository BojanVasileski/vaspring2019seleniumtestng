package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsDemo {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //verify blue is selected

        WebElement blueBtn = driver.findElement(By.id("blue"));
        WebElement redBtn = driver.findElement(By.id("red"));


        Thread.sleep(1000);
        System.out.println("Blue: "+blueBtn.isSelected());
        System.out.println("Red: "+redBtn.isSelected());

        System.out.println("Selecting red");
        // redBtn.click();

        Thread.sleep(1000);
        System.out.println("Blue: "+blueBtn.isSelected());
        System.out.println("Red: "+redBtn.isSelected());

        VerificationUtils.verifySelected(blueBtn,false);
        VerificationUtils.verifySelected(redBtn,true);

        //see if element is disabled or enabled

        WebElement greenBtn = driver.findElement(By.id("green"));

        System.out.println("Is green enabled " + greenBtn.isEnabled());
        System.out.println("Is red enabled "+ redBtn.isEnabled());

        greenBtn.click();

        VerificationUtils.verifySelected(greenBtn,false);


        driver.quit();
    }
}
