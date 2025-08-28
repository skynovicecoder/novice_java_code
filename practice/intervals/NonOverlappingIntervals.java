package practice.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonOverlappingIntervals {
    public static int removeCount(int[][] intervals){
        System.out.println("Before Sort: "+ Arrays.deepToString(intervals));
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        System.out.println("After Sort: "+ Arrays.deepToString(intervals));

        int count=0;
        int prevEnd = intervals[0][1];

        for(int i=1; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(start>=prevEnd){
                prevEnd=end;
            }else{
                count++;
                prevEnd = Math.min(prevEnd, end);
            }
        }

        return count;
    }

    public static void main(String[] args){
        int[][] inputIntervals = new int[][]{
                {1,2},
                {2,4},
                {1,4}
        };
        System.out.println(removeCount(inputIntervals));

        int[][] inputIntervals1 = new int[][]{
                {1,2},
                {2,4}
        };
        System.out.println(removeCount(inputIntervals1));

        int[][] inputIntervals2 = new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };
        System.out.println(removeCount(inputIntervals2));
    }
}
