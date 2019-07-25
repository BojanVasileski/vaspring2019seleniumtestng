package com.cybertek.tests.dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class DropdownMenu {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement selectElement = driver.findElement(By.id("dropdown"));
        Select dropdownList = new Select(selectElement);

        //read the selected option --> returns selected option

        WebElement selectedOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());

        //get all avaliable options

        List<WebElement> allOptions = dropdownList.getOptions();

        System.out.println("Number of options: "+allOptions.size());

        for (WebElement option : allOptions) {
            System.out.println(option.getText());

        }
        Thread.sleep(2000);
        //how to select using visible text

        dropdownList.selectByVisibleText("Option 1");
        selectedOption =  dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());

        Thread.sleep(2000);

        dropdownList.selectByVisibleText("Option 2");
        selectedOption =  dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());

        //how to select using index
        //index starts from 0
        Thread.sleep(2000);
        dropdownList.selectByIndex(1);
        selectedOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());

        //how to select using the value attribute
        dropdownList.selectByValue("2");
        selectedOption =  dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());




    }
}
