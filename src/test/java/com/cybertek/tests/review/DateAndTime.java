package com.cybertek.tests.review;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        //DateTimeFormatter --. use to format the display of date, time
        //July 13, 2019
        String date = dateTime.format(DateTimeFormatter.ofPattern("MMM d, yyyy"));
        System.out.println(date);

        String time = dateTime.format(DateTimeFormatter.ofPattern("hh:mm a"));
        System.out.println(time);


    }


}
