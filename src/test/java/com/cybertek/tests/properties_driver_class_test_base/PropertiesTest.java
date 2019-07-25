package com.cybertek.tests.properties_driver_class_test_base;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    @Test
    public void systemPropertiesTest(){

        String os = System.getProperty("os.name");
        System.out.println("Operating System is: " +
                os);

        String user = System.getProperty("user.name");
        System.out.println("User is: " +
                user);

        String javaVersion = System.getProperty("java.specification.version");
        System.out.println("Java Version: " +
                javaVersion);
    }

    @Test
    public void systemPropertiesTest2(){
        Properties properties = System.getProperties();
        String os = properties.getProperty("os.name");
        System.out.println("Operating System is: " +
                os);

        properties.forEach((k,v) -> System.out.println(k+":"+v));

        System.setProperty("webdriver.chrome.driver", "ASfasdAsd");
        System.out.println(properties.getProperty("webdriver.chrome.driver"));
    }

    @Test
    public void readPropertiesFileTest() throws IOException {
        //get the file path (location)
        String path = "configuration.properties";

        //open the file
        FileInputStream fileInputStream = new FileInputStream(path);

        //load into the local object
        Properties properties = new Properties();
        properties.load(fileInputStream);

        //read properties from that object
        String url = properties.getProperty("url");
        System.out.println("url is: "+url);
        System.out.println(properties.getProperty("username"));
    }

    @Test
    public void systemPropertiesTest02() {
        String url = ConfigurationReader.get("url");

        String username = ConfigurationReader.get("username");

        String password = ConfigurationReader.get("password");

        System.out.println(url + " | "+username+" | "+password);
    }


}
