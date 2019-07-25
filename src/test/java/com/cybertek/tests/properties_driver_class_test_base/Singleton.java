package com.cybertek.tests.properties_driver_class_test_base;

public class Singleton {
    private static String string;

    public static String getInstance(){
        if (string == null) {
            System.out.println("GIVEN VALUE NOW");
            string = "i have a value now";
        } else {
            System.out.println("ALREADY HAS A VALUE");

        }
        return string   ;
    }
}
