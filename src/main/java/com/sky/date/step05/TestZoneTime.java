package com.sky.date.step05;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class TestZoneTime {

    public static void main(String[] args) {
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Pacific/Saipan"));
        System.out.println(now);


        now = LocalDateTime.now();
        System.out.println(now);
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Pacific/Saipan"));
        System.out.println(zonedDateTime);
    }
}
