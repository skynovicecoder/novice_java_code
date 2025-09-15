package practice.listarrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicatesInArray {
    public static boolean isDuplicatesPresent(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) return false;

        /*long count = Arrays.stream(inputArray)
                .distinct()
                .count();
        int size = inputArray.length;
        if (count != size) {
            return true;
        }
        return false;*/

        Set<Integer> seen = new HashSet<>();
        for (int num : inputArray) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[]{};
        System.out.println("\nIs there any Duplicates in the list: " + Arrays.toString(input));
        System.out.println("After checking: " + isDuplicatesPresent(input)); //false

        int[] input1 = new int[]{10, 3, 12, 34, 11, 24, 3, 45, 55};
        System.out.println("\nIs there any Duplicates in the list: " + Arrays.toString(input1));
        System.out.println("After checking: " + isDuplicatesPresent(input1)); //true

        int[] input2 = new int[]{1, 12, 16, 11, 14, 3, 4, 5};
        System.out.println("\nIs there any Duplicates in the list: " + Arrays.toString(input2));
        System.out.println("After checking: " + isDuplicatesPresent(input2)); //false
    }
}
