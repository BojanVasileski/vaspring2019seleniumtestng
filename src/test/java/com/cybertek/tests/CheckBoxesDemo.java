package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement one = driver.findElement(By.xpath("//input[1]"));
        WebElement two = driver.findElement(By.xpath("//input[2]"));

        System.out.println("One " + one.isSelected());
        System.out.println("Two " + two.isSelected());
        System.out.println("Verifying default");

        VerificationUtils.verifySelected(one, false);
        VerificationUtils.verifySelected(two,true);

        System.out.println("Clicking on one");
        one.click();

        VerificationUtils.verifySelected(one, false);
        VerificationUtils.verifySelected(two,true);

        //how to see if element is selected using arguments
        System.out.println(one.getAttribute("type"));
        System.out.println(one.getAttribute("checked"));
        System.out.println(two.getAttribute("checked"));
        driver.quit();

    }
}
