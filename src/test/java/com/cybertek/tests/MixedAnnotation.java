package com.cybertek.tests;

import org.testng.annotations.*;

public class MixedAnnotation {

    @BeforeClass
    public void setupClass(){
        System.out.println("setting path");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("reporting everything");
    }


    @BeforeMethod
    public void setup(){

        System.out.println("opening browser");
    }
    @AfterMethod    //always executes even if @Test method fails to finish execution
    public void tearDown(){
        System.out.println("closing browser\n");
    }

    @Test(priority = 1)
    public void test2(){

        System.out.println("\ttesting test case 2");

    }
    @Test (priority = 2)
    public void test3(){

        System.out.println("\ttesting test case 3");

    }
}
