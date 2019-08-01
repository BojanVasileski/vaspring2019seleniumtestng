package com.cybertek.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BriteERPUtils {

    public static void login(WebDriver driver, String username, String password) {
        driver.findElement(By.id("login")).
                sendKeys(username);
        driver.findElement(By.id("password")).
                sendKeys(password + Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void selectModule(String module) {
        Driver.get().findElement(By.xpath("//span[@class='oe_menu_text'][contains(text(),'"+module+"')]")).click();
    }


}
