package practice.java.pcthreads;

import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numThreads,
                () -> System.out.println("All threads reached barrier, proceeding together..."));

        Runnable worker = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " reached barrier");
                barrier.await(); // waits until all threads arrive
                System.out.println(Thread.currentThread().getName() + " continues work");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        for (int i = 0; i < numThreads; i++) executor.submit(worker);
        executor.shutdown();
    }
}
