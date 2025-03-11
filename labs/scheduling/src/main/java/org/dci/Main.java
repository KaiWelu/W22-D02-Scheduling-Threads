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
        service2.scheduleAtFixedRate(task2, 2, 3, TimeUnit.SECONDS);

        if(!service2.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("Shutting down after 10 Seconds");
            service2.shutdownNow();
        }
    }
}