package com.sky.date.step02;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 1.LocalDate
 * 2.LocalTime
 * 3.LocalDateTime
 * 4.Instant:时间戳(以Unix元年:1970年1月1日0时0分0秒到某个时间的毫秒值)
 */
public class TestLocalDateTime {


    public static void main(String[] args) throws Exception {
        test02();
    }

    public static void test01() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime ldt = LocalDateTime.of(2015,10,19,13,22,22,333);
       // 不管怎么变,都是新的实例
        ldt = ldt.plusYears(5);
        System.out.println(ldt);
        System.out.println(ldt.getDayOfMonth());

    }
    public static void test02() throws Exception {
        Instant now = Instant.now();// 默认获取的是UTC时区,格林尼治时间
        System.out.println(now);
        System.out.println(now.toEpochMilli());
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);


    }




}
