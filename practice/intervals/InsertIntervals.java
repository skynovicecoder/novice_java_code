package practice.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {

    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                res.add(interval);
            } else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] inputList = new int[][] {
                {1, 3},
                {4, 6}
        };
        int[] intervalList = new int[]{2, 5};

        System.out.println("First:: \n" + Arrays.deepToString(insertInterval(inputList, intervalList)));

        int[][] inputList1 = new int[][] {
                {1, 2},
                {3, 5},
                {9,10}
        };
        int[] intervalList1 = new int[]{6, 7};

        System.out.println("Second:: \n" + Arrays.deepToString(insertInterval(inputList1, intervalList1)));

        int[][] inputList2 = new int[][] {
                {1, 3},
                {5, 7}
        };
        int[] intervalList2 =  new int[]{12, 14};

        System.out.println("Third:: \n" + Arrays.deepToString(insertInterval(inputList2, intervalList2)));

        int[][] inputList3 = new int[][] {
                {1, 2},
                {3, 5},
                {6, 7},
                {8,10},
                {12, 16}
        };
        int[] intervalList3 = new int[]{4, 9};

        System.out.println("Fourth:: \n" + Arrays.deepToString(insertInterval(inputList3, intervalList3)));
    }
}
