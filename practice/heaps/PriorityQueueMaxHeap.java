package practice.heaps;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueMaxHeap {
    public static void maxHeapUsingPriorityQueue(List<Integer> inputList){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //Note : By default in java Priority Queue is min heap, hence we have reversed the order to get max heap
        maxHeap.addAll(inputList);
        while(!maxHeap.isEmpty()){
            int highest = maxHeap.poll();
            System.out.println("Highest marks now: " + highest);
        }
    }

    public static void main(String[] args){
        List<Integer> inputList = List.of(10, 30, 20, 50, 40); //better when we want immutable list
        //List<Integer> inputList = Arrays.asList(10, 30, 20, 50, 40); //better to use when we want to change values, but can't change the array size
        //inputList.set(0,99);
        maxHeapUsingPriorityQueue(inputList);
    }
}
