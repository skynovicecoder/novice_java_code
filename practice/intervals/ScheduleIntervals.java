package practice.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

record Interval(int start, int end){}

/*class Interval{
    int start;
    int end;
    public Interval(int start, int end){
        this.start=start;
        this.end=end;
    }
}*/

public class ScheduleIntervals {
    public static boolean checkSchedule(List<Interval> inputList){
        System.out.println("\nBefore Sorting Interval List"+inputList);
        //Collections.sort(inputList, Comparator.comparingInt(i-> i.start()));
        Collections.sort(inputList, Comparator.comparingInt(Interval::start));
        System.out.println("After Sorting Interval List"+inputList);

        if(inputList.isEmpty()) return true;

        int lastEnd = inputList.getFirst().end();

        for(int i=1; i<inputList.size(); i++){
            if(!(inputList.get(i).start()>=lastEnd)){
                return false;
            }
            lastEnd=inputList.get(i).end();
        }

        return true;
    }

    public static void main(String[] args){
        //1. Overlapping
        List<Interval> inputList = List.of(
                new Interval(0,30),
                new Interval(15,20),
                new Interval(5,10)
        );
        List<Interval> mutableList = new ArrayList<>(inputList);
        System.out.println("1. Overlapping Expected false : "+checkSchedule(mutableList)); //false

        //2. Non Overlapping
        List<Interval> inputList1 = List.of(
                new Interval(5,8),
                new Interval(9,15)
        );
        List<Interval> mutableList1 = new ArrayList<>(inputList1);
        System.out.println("2. Non Overlapping expected true : "+checkSchedule(mutableList1)); //true

        //3. Empty // so expected true
        List<Interval> inputList2 = List.of();
        List<Interval> mutableList2 = new ArrayList<>(inputList2);
        System.out.println("3. Empty, so expected true : "+checkSchedule(mutableList2)); //true

        //4. Single Interval // so expected true
        List<Interval> inputList3 = List.of(
                new Interval(2,7)
        );
        List<Interval> mutableList3 = new ArrayList<>(inputList3);
        System.out.println("4. Single Interval, so expected true : "+checkSchedule(mutableList3)); //true

        //5. Back-to-back intervals (touching but not overlapping → should return true)
        List<Interval> inputList4 = List.of(
                new Interval(1,3),
                new Interval(3,5),
                new Interval(5,8)
        );
        List<Interval> mutableList4 = new ArrayList<>(inputList4);
        System.out.println("5. Back-to-back intervals (touching but not overlapping → should return true) : "+checkSchedule(mutableList4)); //true

        //6. Complex overlapping case (should return false)
        List<Interval> inputList5 = List.of(
                new Interval(1,4),
                new Interval(2,6),
                new Interval(8,10),
                new Interval(9,12)
        );
        List<Interval> mutableList5 = new ArrayList<>(inputList5);
        System.out.println("6. Complex overlapping case(should return false) : "+checkSchedule(mutableList5)); //true
    }
}
