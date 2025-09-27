package practice.listarrays;

import java.util.Arrays;

public class SortZerosAndOnes {

    public static int[] usingJavaInBuiltSortMethod(int[] inputArray) {
        System.out.println("Before Array:: " + Arrays.toString(inputArray));
        Arrays.sort(inputArray);
        return inputArray;
    }

    public static int[] sortingUsingCounting(int[] inputArray) {
        System.out.println("\nBefore sortingUsingCounting Array::       " + Arrays.toString(inputArray));
        int zeroCount = 0;
        for (int input : inputArray) {
            if (input == 0) {
                zeroCount++;
            }
        }

        for (int i = 0; i < inputArray.length; i++) {
            if (i < zeroCount) {
                inputArray[i] = 0;
            } else {
                inputArray[i] = 1;
            }
        }
        return inputArray;
    }

    public static int[] sortingUsingTwoPointers(int[] inputArray) {
        System.out.println("\nBefore sortingUsingTwoPointers Array::    " + Arrays.toString(inputArray));
        int left = 0;
        int right = inputArray.length - 1;

        while (left < right) {
            if (inputArray[left] == 1 && inputArray[right] == 0) {
                int temp = inputArray[right];
                inputArray[right] = inputArray[left];
                inputArray[left] = temp;
                left++;
                right--;
            } else {
                if (inputArray[left] == 0) left++;
                if (inputArray[right] == 1) right--;
            }
        }

        return inputArray;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 0, 1, 1, 0, 0, 1, 0, 1};

        System.out.println("Sorted Array:: " + Arrays.toString(usingJavaInBuiltSortMethod(inputArray)));

        int[] inputArray1 = new int[]{1, 0, 1, 1, 0, 0, 1, 0, 1, 0};
        System.out.println("Sorted Array after sortingUsingCounting:: " + Arrays.toString(sortingUsingCounting(inputArray1)));

        int[] inputArray2 = new int[]{1, 0, 1, 1, 0, 0, 1, 0, 1, 0};
        System.out.println("Sorted Array after sortingUsingCounting:: " + Arrays.toString(sortingUsingTwoPointers(inputArray2)));
    }
}
