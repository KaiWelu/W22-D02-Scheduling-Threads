package org.dci;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        // Task1
        Runnable task1 = () -> {
            System.out.println("Local Time is: " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        };

        ScheduledExecutorService service1 = Executors.newScheduledThreadPool(1);
        service1.scheduleAtFixedRate(task1, 0, 1, TimeUnit.SECONDS);


        if(!service1.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Shutting down after 5 Seconds");
            service1.shutdownNow();
        }

        //Task2
        Runnable task2 = () -> {
            System.out.println("Probing Service at " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        };

        ScheduledExecutorService service2 = Executors.newScheduledThreadPool(1);
        service2.scheduleAtFixedRate(task2, 1, 3, TimeUnit.SECONDS);

        if(!service2.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Shutting down after 5 Seconds");
            service2.shutdownNow();
        }

        //Task3
        Runnable test1 = () -> {
            System.out.println("This is the test1 task");
        };
        Runnable test2 = () -> {
            System.out.println("This is the test2 task");
        };
        Runnable test3 = () -> {
            System.out.println("This is the test3 task");
        };

        ScheduledExecutorService service3 = Executors.newScheduledThreadPool(1);
        service3.schedule(test1, 2, TimeUnit.SECONDS);
        service3.schedule(test2, 1, TimeUnit.SECONDS);
        service3.schedule(test3, 7, TimeUnit.SECONDS);

        service3.shutdown();
        if(!service3.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Forced shutdown after 5 seconds");
            service3.shutdownNow();
        }

        //Task4

        Callable<Double> task4 = () -> {
            System.out.println("Calculating random sum...");
            return (Math.random() + Math.random());
        };

        ExecutorService service4 = Executors.newFixedThreadPool(1);
        Future<Double> sumFuture = service4.submit(task4);
        System.out.println(sumFuture.get());
        service4.shutdown();
    }
}