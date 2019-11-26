package com.sky.date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestSimpleDateFormat {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception {
        Callable<Date> task = () -> sdf.parse("1990-04-18");


        List<Future<Date>> result = new ArrayList<Future<Date>>();
        for (int i = 0; i < 10; i++) {
            result.add(threadPool.submit(task));
        }
        for (Future<Date> temp : result) {
            System.out.println(temp.get());
        }
    }
}
//控制台输出:
//Exception in thread "main" Wed Apr 18 00:00:00 GMT+08:00 1990
//java.util.concurrent.ExecutionException: java.lang.NumberFormatException: multiple points
//at java.util.concurrent.FutureTask.report(FutureTask.java:122)
//at java.util.concurrent.FutureTask.get(FutureTask.java:192)
//at com.sky.date.TestSimpleDateFormat.main(TestSimpleDateFormat.java:25)
//Caused by: java.lang.NumberFormatException: multiple points
//at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1890)
//at sun.misc.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
//at java.lang.Double.parseDouble(Double.java:538)
//at java.text.DigitList.getDouble(DigitList.java:169)
//at java.text.DecimalFormat.parse(DecimalFormat.java:2089)
//at java.text.SimpleDateFormat.subParse(SimpleDateFormat.java:2162)
//at java.text.SimpleDateFormat.parse(SimpleDateFormat.java:1514)
//at java.text.DateFormat.parse(DateFormat.java:364)
//at com.sky.date.TestSimpleDateFormat.lambda$main$0(TestSimpleDateFormat.java:17)
//at java.util.concurrent.FutureTask.run(FutureTask.java:266)
//at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
//at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
//at java.lang.Thread.run(Thread.java:748)
