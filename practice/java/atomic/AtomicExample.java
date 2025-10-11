package practice.java.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    //public static volatile int counter = 0;
    public static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                //counter++;  //Non-Atomic Operation
                counter.incrementAndGet();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Thread Counters :" + counter); // Note: Output may vary for non-atomic operations
    }
}
