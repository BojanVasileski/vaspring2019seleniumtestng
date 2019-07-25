package com.cybertek.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MixedAnnotationTest {

    @BeforeMethod
    public void setup(){

        System.out.println("opening browser");
    }
    @AfterMethod    //always executes even if @Test method fails to finish execution
    public void tearDown(){
        System.out.println("closing browser\n");
    }

    @Test (priority = 1)
    public void test2(){

        System.out.println("\ttesting test case 2");

    }
    @Test (priority = 2)
    public void test3(){

    System.out.println("\ttesting test case 3");

}
    @Test (priority = 3)
    public void test(){

        System.out.println("\ttesting test case 1");

    }

}
