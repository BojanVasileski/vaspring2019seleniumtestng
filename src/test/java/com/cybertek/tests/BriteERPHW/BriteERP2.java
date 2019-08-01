package com.cybertek.tests.BriteERPHW;


import com.cybertek.utilities.BriteERPUtils;
import com.cybertek.utilities.ConfigurationReader;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class BriteERP2 {
    WebDriver driver;
    @BeforeMethod
    public void setUpTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://54.148.96.210/web/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void navigateToModuleCRM() throws InterruptedException {
        String username= ConfigurationReader.get("Manager5_username");
        String password= ConfigurationReader.get("Manager5_password");
        BriteERPUtils.login(driver, username, password);
        Thread.sleep(3000);
        driver.findElement(By.linkText("CRM")).click();
    }
    @Test
    public void create () throws InterruptedException {
        String username = ConfigurationReader.get("Manager5_username");
        String password = ConfigurationReader.get("Manager5_password");
        BriteERPUtils.login(driver, username, password);
        //
        driver.findElement(By.linkText("CRM")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-primary btn-sm o-kanban-button-new']")).click();
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Gap");
        driver.findElement(By.xpath("//*[@type='object']")).click();
        Thread.sleep(3000);
        WebElement add = driver.findElement(By.xpath("(//*[@class='o_kanban_quick_add'])[2]"));
        add.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='o_input']")).sendKeys("tables" + Keys.ENTER);
    }
    @Test
    public void deleteList() throws InterruptedException {
        String username = ConfigurationReader.get("Manager5_username");
        String password = ConfigurationReader.get("Manager5_password");
        BriteERPUtils.login(driver, username, password);
        //
        driver.findElement(By.linkText("CRM")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-primary btn-sm o-kanban-button-new']")).click();
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Gap");
        driver.findElement(By.xpath("(//*[@class='o_input_dropdown'])[1]")).click();
        WebElement select= driver.findElement(By.linkText("AAA, John"));
        select.click();
        driver.findElement(By.xpath("(//*[@type='text'])[7]")).clear();//sendKeys("1");
        driver.findElement(By.xpath("(//*[@type='text'])[7]")).sendKeys("100");
        // driver.findElement(By.xpath("//*[@type='object']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@name='close_dialog']")).click();
        Thread.sleep(6000);
        WebElement add = driver.findElement(By.xpath("(//*[@class='o_kanban_quick_add'])[2]"));
        add.click();
        driver.findElement(By.xpath("//*[@class='o_input']")).sendKeys("tables" + Keys.ENTER);
        driver.findElement(By.xpath("(//*[@type='button'])[17]")).click();
        // driver.findElement(By.xpath("(//*[@class='o_data_row'])[3]")).click();
        WebElement select1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[6] "));
        WebElement select2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[7] "));
        select1.click();
        select2.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle']) [2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-index='3']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click();
        Thread.sleep(2000);
    }
}