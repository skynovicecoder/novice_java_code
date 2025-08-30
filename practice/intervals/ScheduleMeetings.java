package practice.intervals;

import java.util.Arrays;

public class ScheduleMeetings {
    public static boolean checkSchedulingPossiblity(int[][] inputList) {
        System.out.println("Before sorting:: " + Arrays.deepToString(inputList));
        Arrays.sort(inputList, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println("After sorting:: " + Arrays.deepToString(inputList));

        int prevLast = inputList[0][1];

        for (int i =1; i<inputList.length; i++) {
            if (!(inputList[i][0] >= prevLast)) {
                return false;
            }
            prevLast = inputList[i][1];
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] inputDurations = new int[][]{
                new int[]{0, 30},
                new int[]{15, 20},
                new int[]{5, 10}

        };

        System.out.println(checkSchedulingPossiblity(inputDurations));

        int[][] inputDurations1 = new int[][]{
                new int[]{5, 8},
                new int[]{9, 15}
        };

        System.out.println(checkSchedulingPossiblity(inputDurations1));
    }
}
