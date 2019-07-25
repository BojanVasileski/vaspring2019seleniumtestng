package com.cybertek.tests.properties_driver_class_test_base;

import com.cybertek.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test(){
        String str1 = Singleton.getInstance();
        String str2 = Singleton.getInstance();

        Singleton.getInstance();
        Singleton.getInstance();
        Singleton.getInstance();

        System.out.println("set1 = " +
                str1);


    }

    @Test
    public void test1(){
        Driver.get().get("https://amazon.com");
        System.out.println(Driver.get().getTitle());
    }

}
