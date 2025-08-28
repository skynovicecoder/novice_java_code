package practice.pcthreads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerViaBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                //queue.add(i); //Not serve the purpose of using BlockingQueue
                try {
                    queue.put(i); // Note : put works as wait and notify by itself for BlockingQueue
                    System.out.println(Thread.currentThread().getName() + " : Produced : " + i);

                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                //queue.poll(); //Not serve the purpose of using BlockingQueue

                try {
                    int output = queue.take(); // take care of wait and notify itself by BlockingQueue
                    Thread.sleep(150);
                    System.out.println(Thread.currentThread().getName() + " : Consumed data : " + output);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
