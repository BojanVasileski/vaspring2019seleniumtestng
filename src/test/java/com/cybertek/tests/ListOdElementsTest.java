package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverCommandExecutor;


import java.util.List;
import java.util.Random;

public class ListOdElementsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        List<WebElement> buttons = driver.findElements(By.name("sport"));


        for (WebElement button : buttons) {
            VerificationUtils.verifySelected(button, false);
        }

        //select ant radio button

        Random rand = new Random();
        int number = rand.nextInt(4);
        System.out.println(number);

        buttons.get(number).click();

        //verify that only that button is selected and others are not

        for (int i = 0; i < buttons.size(); i++) {
            if (i == number) {
                VerificationUtils.verifySelected(buttons.get(i), true);

            } else {
                VerificationUtils.verifySelected(buttons.get(i), false);
            }

        }
        //select any other radio button
        int number2;
        do {
            number2 = rand.nextInt(4);
        } while (number == number2);

        System.out.println(number);
        System.out.println(number2);

        buttons.get(number2).click();

        //verify that only that other buttons is selected and others are not
        for (int i = 0; i < buttons.size(); i++) {
            if (i == number2) {
                VerificationUtils.verifySelected(buttons.get(i), true);

            } else {
                VerificationUtils.verifySelected(buttons.get(i), false);
                Thread.sleep(3000);

                driver.close();
            }
        }
    }
}
