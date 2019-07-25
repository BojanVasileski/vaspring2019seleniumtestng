package com.cybertek.tests.properties_driver_class_test_base;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VyTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VytrackTestProperties {
    @Test
    public void loginTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String url = ConfigurationReader.get("url");
        driver.get(url);

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("password");

        VyTrackUtils.login(driver,username,password);



    }
}
