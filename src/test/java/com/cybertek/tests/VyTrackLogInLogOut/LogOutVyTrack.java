package com.cybertek.tests.VyTrackLogInLogOut;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LogOutVyTrack {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String username = "storemanager71";
        String password = "UserUser123";

        driver.get("http://qa2.vytrack.com/user/login");

        Thread.sleep(3000);

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        Thread.sleep(3000);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        Thread.sleep(3000);

        driver.findElement(By.name("_submit")).click();

        Thread.sleep(3000);

        driver.findElement(By.className("dropdown-toggle")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(2000);
        String act = driver.getCurrentUrl();
        String exp = "http://qa2.vytrack.com/user/login";
        VerificationUtils.verifyEquals(act,exp);

        driver.quit();
    }

}
