package practice.intervals;

import java.util.*;

record Intervals(int start, int end){}

public class ScheduleMeetingRooms {
    public static int meetingRoomsRequired(List<Intervals> intervals){
        List<int[]> time = new ArrayList<>();
        for (Intervals i : intervals) {
            time.add(new int[] { i.start(), 1 });
            time.add(new int[] { i.end(), -1 });
        }

        /*List<List<Integer>> timeList = new ArrayList<>();
        for(Intervals i : intervals){
            *//*timeList.add(new ArrayList<>(){{
                add(i.start());
                add(1);
            }});*//*
            timeList.add(new ArrayList<>(List.of(i.start(), 1)));
            timeList.add(new ArrayList<>(List.of(i.end(), -1)));
        }*/

        time.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        //Collections.sort(timeList, (a, b) -> a.get(0) == b.get(0) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));

        int res = 0, count = 0;
        for (int[] t : time) {
            count += t[1];
            res = Math.max(res, count);
        }
        /*for (List<Integer> t : timeList) {
            count += t.get(1);
            res = Math.max(res, count);
        }*/
        return res;
    }

    public static void main(String[] args){
        List<Intervals> inputList = List.of(
                new Intervals(0,30),
                new Intervals(15,20),
                new Intervals(5,10)
        );
        List<Intervals> mutableList = new ArrayList<>(inputList);
        System.out.println("1. Overlapping Meeting : "+meetingRoomsRequired(mutableList)); //2

        List<Intervals> inputList2 = List.of(
                new Intervals(0,30),
                new Intervals(15,20),
                new Intervals(5,10),
                new Intervals(20,30)
        );
        List<Intervals> mutableList2 = new ArrayList<>(inputList2);
        System.out.println("2. Overlapping Case : "+meetingRoomsRequired(mutableList2)); //2
    }
}
