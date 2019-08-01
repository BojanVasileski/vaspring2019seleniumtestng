package com.cybertek.tests.page_object_model_tests;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;

public class PositiveLoginTests extends TestBase {
    @BeforeMethod
    public void setUpMethod2(){
        driver.get(ConfigurationReader.get("vy_url"));

    }


    @Test
    public void loginDriverTest(){
        //give name to the test
        extentLogger = report.createTest("Positive Login as Driver");
        //prints the passed string to the report, used to capture test steps....
        extentLogger.info("Getting user credentials");
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Entering username and password");
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.submit.click();
        extentLogger.info("Clicking on Submit");

        extentLogger.info("Verifying that title contains Dashboard");
        Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Title did not contain Dashboard");
        extentLogger.pass("PASSED: Positive Loagin as Driver");

    }

    @Test
    public void loginSalesManager(){
        extentLogger = report.createTest("Positive Login as SalesManager");
        //prints the passed string to the report, used to capture test steps....
        extentLogger.info("Getting user credentials");
        String username = ConfigurationReader.get("sales_username");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Entering username and password");
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.submit.click();
        extentLogger.info("Clicking on Submit");

        extentLogger.info("Verifying that title contains Dashboard");
        Assert.assertTrue(driver.getTitle().contains("Dashboard"),"Title did not contain dashboard");
        extentLogger.pass("PASSED: Positive Login as SalesManager");
    }


}
