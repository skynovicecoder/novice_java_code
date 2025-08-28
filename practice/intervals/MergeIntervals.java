package practice.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals){

        System.out.println("Before Sort: "+ Arrays.deepToString(intervals));
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        System.out.println("After Sort: "+ Arrays.deepToString(intervals));

        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            int lastEnd = output.get(output.size()-1)[1];

            if(start<=lastEnd){
                output.get(output.size()-1)[1] = Math.max(end, lastEnd);
            }else{
                output.add(new int[]{start, end});
            }

        }

        return output.toArray(new int[output.size()][]);
    }
    public static void main(String[] args){
        int[][] inputIntervals = new int[][]{
                {1,3},
                {1,5},
                {6,7}
        };
        System.out.println(Arrays.deepToString(merge(inputIntervals)));

        int[][] inputIntervals1 = new int[][]{
                {1,2},
                {2,3}
        };
        System.out.println(Arrays.deepToString(merge(inputIntervals1)));

        int[][] inputIntervals2 = new int[][]{
                {1,3},
                {8,10},
                {15,18},
                {2,6}
        };
        System.out.println(Arrays.deepToString(merge(inputIntervals2)));
    }
}
