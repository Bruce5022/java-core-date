package com.sky.date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestSimpleDateFormat2 {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception {
        Callable<Date> task = () -> TestDateFormatThreadLocal.convert("1990-04-18");


        List<Future<Date>> result = new ArrayList<Future<Date>>();
        for (int i = 0; i < 10; i++) {
            result.add(threadPool.submit(task));
        }
        for (Future<Date> temp : result) {
            System.out.println(temp.get());
        }
        threadPool.shutdown();
    }
}
