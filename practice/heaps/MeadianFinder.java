package practice.heaps;

import java.util.*;

class MeadianFinderUsingArrayList {
    //Using Single List
    List<Integer> numList;

    public MeadianFinderUsingArrayList() {
        numList = new ArrayList<>();
    }

    public void addNum(int num) {
        numList.add(num);
    }

    public double findMedian() {
        Collections.sort(numList);
        int n = numList.size();
        if ((n & 1) == 1) {
            return numList.get(n / 2);
        } else {
            return (double) (numList.get(n / 2) + numList.get(n / 2 - 1)) / 2;
        }
    }

}

public class MeadianFinder {
    //Using Heap

    Queue<Integer> smallerHeap; //will be used to calculate Max Heap
    Queue<Integer> largerHeap; //will be used to calculate Min Heap

    public MeadianFinder() {
        smallerHeap = new PriorityQueue<>((a, b) -> b - a);

        //largerHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        largerHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNumber(int num) {
        smallerHeap.add(num);

        if (smallerHeap.size() - largerHeap.size() > 1
                || (!largerHeap.isEmpty() && smallerHeap.peek() > largerHeap.peek())) {
            largerHeap.add(smallerHeap.poll());
        }

        if (largerHeap.size() - smallerHeap.size() > 1) {
            smallerHeap.add(largerHeap.poll());
        }
    }

    public double getMedian() {
        if (smallerHeap == null || smallerHeap.isEmpty()) return 0;
        if (largerHeap.size() == smallerHeap.size()) {
            return (double) (largerHeap.peek() + smallerHeap.peek()) / 2;
        } else if (smallerHeap.size() > largerHeap.size()) {
            return (double) smallerHeap.peek();
        } else {
            return (double) largerHeap.peek();
        }
    }

    public static void main(String[] args) {
        MeadianFinder mdFinder = new MeadianFinder();
        mdFinder.addNumber(3);
        System.out.println("Median is: " + mdFinder.getMedian() + " :: for current list : " + mdFinder.smallerHeap + mdFinder.largerHeap);

        mdFinder.addNumber(2);
        System.out.println("Median is: " + mdFinder.getMedian() + " :: for current list : " + mdFinder.smallerHeap + mdFinder.largerHeap);

        mdFinder.addNumber(1);
        System.out.println("Median is: " + mdFinder.getMedian() + " :: for current list : " + mdFinder.smallerHeap + mdFinder.largerHeap);

        mdFinder.addNumber(4);
        System.out.println("Median is: " + mdFinder.getMedian() + " :: for current list : " + mdFinder.smallerHeap + mdFinder.largerHeap);

        mdFinder.addNumber(5);
        System.out.println("Median is: " + mdFinder.getMedian() + " :: for current list : " + mdFinder.smallerHeap + mdFinder.largerHeap);


        //Using Single List
        MeadianFinderUsingArrayList mfList = new MeadianFinderUsingArrayList();
        mfList.addNum(3);
        System.out.println("Median is: " + mfList.findMedian() + " :: for current list : " + mfList.numList);

        mfList.addNum(2);
        System.out.println("Median is: " + mfList.findMedian() + " :: for current list : " + mfList.numList);

        mfList.addNum(1);
        System.out.println("Median is: " + mfList.findMedian() + " :: for current list : " + mfList.numList);

        mfList.addNum(4);
        System.out.println("Median is: " + mfList.findMedian() + " :: for current list : " + mfList.numList);

        mfList.addNum(5);
        System.out.println("Median is: " + mdFinder.getMedian() + " :: for current list : " + mfList.numList);

    }
}
