package practice.java.pcthreads;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {
    int capacity;
    Queue<Integer> queue = new LinkedList<>();

    public ProducerConsumerProblem(int capacity){
        this.capacity = capacity;
    }

    public synchronized void produce(int data) throws InterruptedException {
        if(queue.size()==capacity){
            wait();
        }
        queue.add(data);
        notifyAll();
        System.out.println(Thread.currentThread().getName()+" : Produced: "+data);
    }

    public synchronized int consume() throws InterruptedException{
        if(queue.isEmpty()){
            wait();
        }
        int output = queue.poll();
        notifyAll();
        System.out.println(Thread.currentThread().getName()+" : Consumed value: "+output);
        return output;
    }

    public static void main(String[] args){
        ProducerConsumerProblem obj = new ProducerConsumerProblem(5);

        Thread producerThread = new Thread(()->{
            for(int i = 0; i<10; i++){
                try {
                    obj.produce(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerThread = new Thread(()->{
            for(int i =0; i<10;i++){
                try {
                    obj.consume();
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
