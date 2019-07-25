package com.cybertek.tests.VyTrackLogInLogOut;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NegativeData
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String userName = "user00";
        String Password = "UserUser";
        driver.get("http://qa3.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("prependedInput")).sendKeys(userName);
        Thread.sleep(2000);
        driver.findElement(By.id("prependedInput2")).sendKeys(Password);
        Thread.sleep(2000);
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(2000);

        String actual= driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/div")).getText();
        String exp="Invalid user name or password.";
        VerificationUtils.verifyEquals(actual,exp);
        driver.quit();
    }
}

