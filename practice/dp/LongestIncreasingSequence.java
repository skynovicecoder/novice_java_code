package practice.dp;

import java.util.Arrays;

public class LongestIncreasingSequence {
    public static int findLISLength(int[] inputArray) {
        /*int[] LIS = new int[inputArray.length];
        LIS[inputArray.length-1]=1;

        for(int i=inputArray.length-2; i>=0;i--){
            LIS[i] = Math.max(LIS[i+1], inputArray[i]<inputArray[i+1] ? 1+LIS[i+1]:0);
        }

        return LIS[0];*/

        int[] LIS = new int[inputArray.length];
        Arrays.fill(LIS, 1);

        for (int i = inputArray.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] < inputArray[j]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }
        return Arrays.stream(LIS).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] inputArray = {9, 1, 4, 2, 3, 3, 7};
        System.out.println(findLISLength(inputArray)); //4

        int[] inputArray1 = {0, 3, 1, 3, 2, 3};
        System.out.println(findLISLength(inputArray1)); //4

        int[] inputArray2 = {1, 2, 4, 3};
        System.out.println(findLISLength(inputArray2)); //3

        int[] inputArray4 = {50, 3, 10, 7, 40, 80};
        System.out.println(findLISLength(inputArray4)); //4
    }
}
