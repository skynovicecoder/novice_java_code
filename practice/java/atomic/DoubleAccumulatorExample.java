package practice.java.atomic;

import java.util.concurrent.atomic.DoubleAccumulator;

public class DoubleAccumulatorExample {
    //A reduction accumulator for double values
    // — performs an operation (like sum, max, min, etc.) atomically across threads.
    public static void main(String[] args) throws InterruptedException {
        DoubleAccumulator doubleAccumulator = new DoubleAccumulator(Double::max, Double.NEGATIVE_INFINITY);
        Runnable task = () -> {
            double temp = Math.random() * 100;
            doubleAccumulator.accumulate(temp);
            System.out.println(Thread.currentThread().getName() + " reported temp: " + temp);
        };

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread t : threads) t.join();

        System.out.println("Highest Temperature Recorded: " + doubleAccumulator.get());
    }
}
