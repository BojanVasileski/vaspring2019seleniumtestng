package com.cybertek.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNGDemo {

    @Test
    public void test(){
        System.out.println("setting path");
        System.out.println("opening browser");
        System.out.println("testing test case 1");

    }
    @Test
    public void test2(){
        System.out.println("setting path");
        System.out.println("opening browser");
        System.out.println("testing test case 2");

    }

    @AfterMethod    //always executes even if @Test method fails to finish execution
    public void tearDown(){
        System.out.println("\tclosing browser");
    }
}
