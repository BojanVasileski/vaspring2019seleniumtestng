package com.cybertek.tests.dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class StatesDropdownPractise {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement stateDropdown = driver.findElement(By.id("state"));

        Select states = new Select(stateDropdown);

        List<WebElement> options= states.getOptions();
        System.out.println(options.size());


        //iterate through the options and compare one option to the next one

        for (int i = 1; i < options.size()-1; i++) {
            String currnet = options.get(i).getText();
            String next = options.get(i+1).getText();

            System.out.println("Comparing " +
                    currnet + " to " + next );
            if (currnet.compareTo(next) < 0) {
                System.out.println("PASS");

            } else {
                System.out.println("FAIL");

            }


        }


    }
}
