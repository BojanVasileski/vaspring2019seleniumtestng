package com.cybertek.tests.JavaScriptExecutor;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void shutDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void hover() throws InterruptedException {
        //Actions is a class that enables advanced interactions
        Actions actions = new Actions(driver);
        driver.get("http://practice.cybertekschool.com/hovers");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.tagName("img"));
        //moves the mouse to a given target
        //perform() -- triggers the action
        actions.moveToElement(element).perform();


    }

    @Test
    public void hover2() throws InterruptedException {
        //Actions is a class that enables advanced interactions
        Actions actions = new Actions(driver);
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Thread.sleep(2000);

        WebElement firstOne = driver.findElement(By.id("ui-id-3"));
        WebElement secondOne = driver.findElement(By.id("ui-id-4"));

        actions.moveToElement(firstOne).perform();
        Thread.sleep(1000);
        actions.moveToElement(secondOne).perform();


    }

    @Test
    public void chainingActions() throws InterruptedException {
        //Actions is a class that enables advanced interactions
        Actions actions = new Actions(driver);
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Thread.sleep(2000);
        WebElement firstOne = driver.findElement(By.id("ui-id-3"));
        WebElement secondOne = driver.findElement(By.id("ui-id-4"));

        actions.moveToElement(firstOne).pause(1000).moveToElement(secondOne).build().perform();

    }

    @Test
    public void dragDrop() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        actions.dragAndDrop(source, target).perform();
        Thread.sleep(2000);

    }

    @Test
    public void dragDropChain() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        //click and hold on source
        //move
        //let it go

        actions.clickAndHold(source).pause(1000).moveToElement(target).pause(1000).release().build().perform();



    }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        Thread.sleep(1000);

        Actions actions = new Actions(driver);

        //arrow down
        actions.sendKeys(Keys.ARROW_DOWN).pause(1000).
                sendKeys(Keys.ARROW_DOWN).pause(1000).
                sendKeys(Keys.ARROW_DOWN).pause(1000).build().perform();
        //arrow up
        actions.sendKeys(Keys.ARROW_UP).pause(1000).
                sendKeys(Keys.ARROW_UP).pause(1000).
                sendKeys(Keys.ARROW_UP).pause(1000).build().perform();
        //page down
        actions.sendKeys(Keys.PAGE_DOWN).pause(1000).
                sendKeys(Keys.PAGE_DOWN).pause(1000).
                sendKeys(Keys.PAGE_DOWN).pause(1000).build().perform();
        //page up
        actions.sendKeys(Keys.PAGE_UP).pause(1000).
                sendKeys(Keys.PAGE_UP).pause(1000).
                sendKeys(Keys.PAGE_UP).pause(1000).build().perform();


    }

}