package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertEqualsTest {

    @Test
    public void test(){
        String expected = "Google";
        String actual = "Googlessss";

        Assert.assertEquals(actual,expected);
    }
}
