package com.cybertek.tests.page_object_model_tests;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginNegativeTests extends TestBase {
    @BeforeMethod
    public void setUpMethod2(){
        driver.get(ConfigurationReader.get("vy_url"));

    }

    @Test
    public void blankUsernameAndPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage.submit.click();

        Assert.assertEquals(driver.getCurrentUrl(),"http://qa3.vytrack.com/user/login");
    }

    @Test
    public void wrongCredentialsTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys("dajisdia");
        loginPage.password.sendKeys("hello");
        loginPage.submit.click();

        Assert.assertEquals(driver.getCurrentUrl(),"http://qa3.vytrack.com/user/login");
    }

}
