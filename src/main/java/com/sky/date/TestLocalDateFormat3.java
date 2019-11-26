package com.sky.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestLocalDateFormat3 {
    private static DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception {
        Callable<LocalDate> task = () -> LocalDate.parse("19900418", sdf);
        List<Future<LocalDate>> result = new ArrayList<Future<LocalDate>>();
        for (int i = 0; i < 10; i++) {
            result.add(threadPool.submit(task));
        }
        for (Future<LocalDate> temp : result) {
            System.out.println(temp.get());
        }
        threadPool.shutdown();
    }
}