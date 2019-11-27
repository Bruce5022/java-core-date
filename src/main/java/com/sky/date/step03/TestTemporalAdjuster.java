package com.sky.date.step03;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class TestTemporalAdjuster {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime ldt10 = now.withDayOfMonth(10);
        System.out.println(ldt10);

        LocalDate nextSunday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(nextSunday);

        LocalDateTime nextSundayTime = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(nextSundayTime);

        // 自定义:TemporalAdjuster
        LocalDateTime nextDateTime = now.with((l) -> {

            LocalDateTime ld = (LocalDateTime) l;
            DayOfWeek dayOfWeek = ld.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.MONDAY)) {
                ld = ld.plusDays(7);
            } else if (dayOfWeek.equals(DayOfWeek.TUESDAY)) {
                ld = ld.plusDays(6);
            } else if (dayOfWeek.equals(DayOfWeek.WEDNESDAY)) {
                ld = ld.plusDays(5);
            } else if (dayOfWeek.equals(DayOfWeek.THURSDAY)) {
                ld = ld.plusDays(4);
            } else if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                ld = ld.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                ld = ld.plusDays(2);
            } else if (dayOfWeek.equals(DayOfWeek.SUNDAY)) {
                ld = ld.plusDays(1);
            }

            return ld;
        });

        System.out.println("--->"+nextDateTime);
    }
}
