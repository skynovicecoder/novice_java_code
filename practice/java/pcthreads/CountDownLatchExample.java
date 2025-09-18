package practice.java.pcthreads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Runnable worker = () -> {
            System.out.println(Thread.currentThread().getName() + " finished work");
            latch.countDown();
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);
        //executor.submit(worker);
        for (int i = 0; i < 3; i++) executor.submit(worker);

        latch.await(); // main thread waits until count=0
        System.out.println("All workers finished, proceeding...");
        executor.shutdown();
    }
}
