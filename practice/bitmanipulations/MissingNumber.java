package practice.bitmanipulations;

import java.util.Arrays;

public class MissingNumber {
    public static int findMissingNumber(int[] inputArray) {
        int inputLength = inputArray.length;
        int missingNumber = -1;

        // 1. Time complexity is O(nlogn) due to sorting
        /*
        Arrays.sort(inputArray);
        for (int i = 0; i < inputLength; i++) {
            if (i != inputArray[i]) {
                missingNumber = i;
                break;
            }
        }
         */

        // 2. Using addition and substraction (time complexity is O(n))
        /*int totalExpectedSum = (inputLength * (inputLength + 1)) / 2;
        int actualSum = Arrays.stream(inputArray).sum();
        missingNumber = totalExpectedSum - actualSum;
        missingNumber = (missingNumber == inputLength) ? -1 : missingNumber;*/

        //3. Using Exclusive OR
        int xor = inputLength;
        for (int i = 0; i < inputLength; i++) {
            xor = xor ^ i ^ inputArray[i];
        }
        missingNumber = (xor == inputLength) ? -1 : xor;
        return missingNumber;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 2};
        System.out.println("\nNumber Missing from give array:: " + Arrays.toString(input) + " :is: " + findMissingNumber(input));

        int[] input1 = new int[]{0, 2};
        System.out.println("\nNumber Missing from give array:: " + Arrays.toString(input1) + " :is: " + findMissingNumber(input1));

        int[] input2 = new int[]{0, 2, 1, 5, 4, 3};
        System.out.println("\nNumber Missing from give array:: " + Arrays.toString(input2) + " :is: " + findMissingNumber(input2));
    }
}
