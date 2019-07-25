package com.cybertek.tests;

import com.github.javafaker.Faker;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Faker fuk = new Faker();
        System.out.println(fuk.name().fullName());
        System.out.println(fuk.color().name());
        System.out.println(fuk.harryPotter().character());
        System.out.println(fuk.chuckNorris().fact());


        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");





    }
}
