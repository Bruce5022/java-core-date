package com.sky.date.step04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDateTimeFomatter {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        String format = now.format(dtf);
        System.out.println(format);


        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(now);
        String format2 = now.format(dtf2);
        System.out.println(format2);

    }
}
