package practice.java.atomic;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderExample {
    //Note:
    //A high-performance counter alternative to AtomicLong.
    //Faster under contention (many threads).
    //Doesn’t support compareAndSet() — use when you only need counters.
    //Used internally by ConcurrentHashMap and metrics systems.

    public static void main(String[] args) throws InterruptedException {
        LongAdder longAdder = new LongAdder();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                longAdder.increment(); //atomic and highly scalable
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

        System.out.println("Long Adder Example :" + longAdder.sum());
    }
}
